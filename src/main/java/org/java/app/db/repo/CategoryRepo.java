package org.java.app.db.repo;

import java.util.List;

import org.java.app.db.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
	public List<Category> findByTitleContaining(String title);

}
