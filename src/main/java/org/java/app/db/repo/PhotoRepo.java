package org.java.app.db.repo;

import java.util.List;

import org.java.app.db.Photo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface PhotoRepo  extends JpaRepository<Photo, Integer>{
	public List<Photo> findByTitle(String title);
	public List<Photo> findByTitleContaining(String title);
	public List<Photo> findByUserId(int userId);
	public Photo findByUserIdAndId(int userId,int id);

}
