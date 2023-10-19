package org.java.app.db.service;

import java.util.List;
import java.util.Optional;

import org.java.app.db.Category;
import org.java.app.db.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CategoryService {
@Autowired
private CategoryRepo categoriRepo;

public Category save(Category category) {
	return categoriRepo.save(category);
}

public List<Category> findByall() {
	return categoriRepo.findAll();
}
public Optional<Category> findById(int id) {
	return categoriRepo.findById(id);
}
public List<Category> findByTitle(String title) {
	return categoriRepo.findByTitleContaining(title);
}
public void delete(Category category) {
	categoriRepo.delete(category);
}


}
