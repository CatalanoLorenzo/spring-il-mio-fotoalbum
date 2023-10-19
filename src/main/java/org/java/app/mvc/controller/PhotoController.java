package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.Category;
import org.java.app.db.Photo;
import org.java.app.db.service.CategoryService;
import org.java.app.db.service.PhotoService;
import org.java.app.mvc.auth.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/photos")
public class PhotoController {
	@Autowired
	private PhotoService photoService;

	@Autowired
	private CategoryService categoryService;

	// ____________INDEX__________________
	@GetMapping
	public String userPhotoIndex(Model model, Authentication authentication) {

		User user = ((User) authentication.getPrincipal());
		boolean IsAdmin = user.getUsername().equals("utenteAdmin") ? true : false;
		System.out.println("--------------é un Admin? /n");
		System.out.println(IsAdmin);
		List<Photo> photos = user.getUsername().equals("utenteAdmin") ? photoService.findByAll()
				: photoService.getPhotosByUserId(user.getId());

		System.out.println(photos);
		model.addAttribute("photos", photos);
		model.addAttribute("user", user);
		model.addAttribute("isAdmin", IsAdmin);

		return "photo-index";
	}

	// ____________SHOW__________________
	@GetMapping("{id}")
	public String userPhotoShow(@PathVariable int id, Model model, Authentication authentication) {
		User user = ((User) authentication.getPrincipal());

		Photo photo = user.getUsername().equals("utenteAdmin")
				? (photoService.findById(id).isEmpty() ? null : photoService.findById(id).get())
				: photoService.getPhotosByUserIdById(user.getId(), id);
		List<Category> categories = photo.getCategories();

		model.addAttribute("photo", photo);
		model.addAttribute("user", user);
		model.addAttribute("categories", categories);

		return "photo-show";

	}

	// ____________CREATE__________________
	@GetMapping("/create")
	public String userPhotoCreate(Model model, Authentication authentication) {

		List<Category> categories = categoryService.findByall();
		User user = ((User) authentication.getPrincipal());
		model.addAttribute("user", user);
		model.addAttribute("photo", new Photo());
		model.addAttribute("categories", categories);

		return "photo-create";
	}

	// ____________STORE__________________
	@PostMapping("/create")
	public String userPhotoStore(@Valid @ModelAttribute Photo photo, BindingResult bindingResult, Model model,
			Authentication authentication) {
		System.out.println("enter to controller store");
		User user = ((User) authentication.getPrincipal());
		System.out.println("New photo: " + photo);

		return storePhoto(photo, bindingResult, model, user);
	}
	
	// ____________EDIT__________________
	@GetMapping("/edit/{id}")
	public String userPhotoEdit(@PathVariable int id, Model model, Authentication authentication) {
		User user = ((User) authentication.getPrincipal());
		model.addAttribute("user", user);
		List<Category> categories = categoryService.findByall();
		Photo photo = user.getUsername().equals("utenteAdmin")
				? (photoService.findById(id).isEmpty() ? null : photoService.findById(id).get())
				: photoService.getPhotosByUserIdById(user.getId(), id);

		model.addAttribute("user", user);
		model.addAttribute("photo", photo);
		model.addAttribute("categories", categories);

		return "photo-create";
	}
	
	// ____________UPDATE__________________
	@PostMapping("/edit/{id}")
	public String userPhotoUpdate(@Valid @ModelAttribute Photo photo, BindingResult bindingResult, Model model,Authentication authentication) {
		User user = ((User) authentication.getPrincipal());

		System.out.println("Update photo:\n" + photo);
		System.out.println("Categories:\n" + photo.getCategories());

		return storePhoto(photo, bindingResult, model,user);
	}
	
	// ____________DELETE__________________
	@PostMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {

		Photo photo = photoService.findById(id).get();
		photoService.delete(photo);

		return "redirect:/photos";
	}

	
	
	// ____________FUNCTION__________________
	private String storePhoto(Photo photo, BindingResult bindingResult, Model model, User user) {
		if (bindingResult.hasErrors()) {

			System.out.println("Error:");
			bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).forEach(System.out::println);
			List<Category> categories = categoryService.findByall();

			model.addAttribute("user", user);
			model.addAttribute("categories", categories);
			return "photo-create";
		}

		try {
			photo.setUser(user);
			photoService.save(photo);
		} catch (DataIntegrityViolationException e) {

			System.out.println("Errore constrain: " + e.getClass().getSimpleName());

			model.addAttribute("isbn_unique", "isbn deve essere unique");

			return "photo-create";
		}

		return "redirect:/photos";
	}
}
