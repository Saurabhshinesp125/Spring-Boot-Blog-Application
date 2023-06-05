package in.saurabh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saurabh.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
