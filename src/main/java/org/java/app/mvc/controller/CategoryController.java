package org.java.app.mvc.controller;

import java.util.List;

import org.java.app.db.Category;
import org.java.app.db.service.CategoryService;
import org.java.app.mvc.auth.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {
	// category-index-show-edit-create

	@Autowired
	private CategoryService categoryService;

	// ____________INDEX__________________
	@GetMapping
	public String adminCategoryIndex(Model model, Authentication authentication) {

		User user = ((User) authentication.getPrincipal());
		boolean IsAdmin = user.getUsername().equals("utenteAdmin") ? true : false;

		if (IsAdmin) {
			List<Category> Categories = categoryService.findByall();
			System.out.println(Categories);
			model.addAttribute("Categories", Categories);
			return "category-index-show-edit-create";
		}
		return "photo-index";
	}

	// ____________STORE__________________
	@PostMapping("/create")
	public String adminCategoryStore(@Valid @ModelAttribute Category category, BindingResult bindingResult, Model model,
			Authentication authentication) {
		System.out.println("New photo: " + category);
		User user = ((User) authentication.getPrincipal());
		boolean IsAdmin = user.getUsername().equals("utenteAdmin") ? true : false;

		return storeUpdateCategory(category, bindingResult, IsAdmin, model);
	}

	// ____________UPDATE__________________
	@PostMapping("/edit/{id}")
	public String userCategoryUpdate(@Valid @ModelAttribute Category category,@PathVariable int id, BindingResult bindingResult, Model model,
			Authentication authentication) {
		User user = ((User) authentication.getPrincipal());
		boolean IsAdmin = user.getUsername().equals("utenteAdmin") ? true : false;
		category.setId(id);
		System.out.println("Update category:\n" + category);

		return storeUpdateCategory(category, bindingResult, IsAdmin, model);
	}

	// ____________DELETE__________________
	@PostMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {

		Category category = categoryService.findById(id).get();
		categoryService.delete(category);

		return "redirect:/categories";
	}

	
	// ____________FUNCTION__________________
	private String storeUpdateCategory(Category category, BindingResult bindingResult, boolean IsAdmin, Model model) {
		if (IsAdmin) {
			List<Category> categories = categoryService.findByall();

			if (bindingResult.hasErrors()) {

				System.out.println("Error:");
				bindingResult.getAllErrors().stream().map(e -> e.getDefaultMessage()).forEach(System.out::println);

				model.addAttribute("categories", categories);
				
				return "category-index-show-edit-create";
			}

			try {

				categoryService.save(category);
				categories = categoryService.findByall();

			} catch (DataIntegrityViolationException e) {

				System.out.println("Errore constrain: " + e.getClass().getSimpleName());

				return "category-index-show-edit-create";
			}
			model.addAttribute("categories", categories);
			return "redirect:/categories";
		}
		return "photo-index";
	}
}
