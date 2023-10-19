package org.java.app;

//import org.java.app.db.Category;
//import org.java.app.db.Photo;
//import org.java.app.db.service.CategoryService;
//import org.java.app.db.service.PhotoService;
//import org.java.app.mvc.auth.pojo.Role;
//import org.java.app.mvc.auth.pojo.User;
//import org.java.app.mvc.auth.service.RoleService;
//import org.java.app.mvc.auth.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

//	@Autowired
//	private PhotoService photoService;
//	@Autowired
//	private CategoryService categoryService;
//
//	@Autowired
//	private RoleService roleService;
//
//	@Autowired
//	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Role admin = new Role("ADMIN");
//		Role user = new Role("USER");
//
//		roleService.save(admin);
//		roleService.save(user);
//
//		final String pwsAdmin = new BCryptPasswordEncoder().encode("pws");
//		final String pwsUser = new BCryptPasswordEncoder().encode("pws");
//		
//
//
//		User guybrushAdmin = new User("utenteAdmin", pwsAdmin, admin, user);
//		User guybrushUser1 = new User("utenteUser1", pwsUser, user);
//		User guybrushUser2 = new User("utenteUser2", pwsUser, user);
//		User guybrushUser3 = new User("utenteUser3", pwsUser, user);
//
//
//		userService.save(guybrushAdmin);
//		userService.save(guybrushUser1);
//		userService.save(guybrushUser2);
//		userService.save(guybrushUser3);
//
//
//		Category Paesagginaturali = new Category("Paesaggi naturali");
//		Category Ritratti = new Category("Ritratti");
//		Category ArchitetturaECittà = new Category("ArchitetturaECittà");
//		Category NaturaMorta = new Category("PNaturaMorta");
//		Category FotografiaAstratta = new Category("FotografiaAstratta");
//		categoryService.save(Paesagginaturali);
//		categoryService.save(Ritratti);
//		categoryService.save(ArchitetturaECittà);
//		categoryService.save(NaturaMorta);
//		categoryService.save(FotografiaAstratta);
//
//		Photo foto1 = new Photo("foto1", "descrizione1", "https://picsum.photos/200/300",guybrushUser1, Paesagginaturali);
//		Photo foto2 = new Photo("foto2", "descrizione2", "https://picsum.photos/200/300",guybrushUser1, Paesagginaturali, Ritratti);
//		Photo foto3 = new Photo("foto3", "descrizione3", "https://picsum.photos/200/300",guybrushUser1, Ritratti);
//		Photo foto4 = new Photo("foto4", "descrizione4", "https://picsum.photos/200/300",guybrushUser2, Ritratti, ArchitetturaECittà);
//		Photo foto5 = new Photo("foto5", "descrizione5", "https://picsum.photos/200/300",guybrushUser2, ArchitetturaECittà);
//		Photo foto6 = new Photo("foto6", "descrizione6", "https://picsum.photos/200/300",guybrushUser2, NaturaMorta);
//		Photo foto7 = new Photo("foto7", "descrizione7", "https://picsum.photos/200/300",guybrushUser3, NaturaMorta,
//				FotografiaAstratta);
//		Photo foto8 = new Photo("foto8", "descrizione8", "https://picsum.photos/200/300",guybrushUser3, FotografiaAstratta);
//		Photo foto9 = new Photo("foto9", "descrizione9", "https://picsum.photos/200/300",guybrushUser3, FotografiaAstratta,
//				ArchitetturaECittà);
//		Photo foto10 = new Photo("foto10", "descrizione10", "https://picsum.photos/200/300",guybrushUser1, ArchitetturaECittà,
//				Paesagginaturali);
//
//		photoService.save(foto1);
//		photoService.save(foto2);
//		photoService.save(foto3);
//		photoService.save(foto4);
//		photoService.save(foto5);
//		photoService.save(foto6);
//		photoService.save(foto7);
//		photoService.save(foto8);
//		photoService.save(foto9);
//		photoService.save(foto10);

		System.out.println("Insert OK!");

	}
}
