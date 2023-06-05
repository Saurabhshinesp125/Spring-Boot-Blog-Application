package in.saurabh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import in.saurabh.entity.User;

public interface  UserRepository extends JpaRepository<User,Integer>{

}
