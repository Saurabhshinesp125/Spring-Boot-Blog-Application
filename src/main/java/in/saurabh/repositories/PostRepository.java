package in.saurabh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saurabh.entity.Category;
import in.saurabh.entity.Post;
import in.saurabh.entity.User;

public interface PostRepository extends JpaRepository<Post,Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
}
