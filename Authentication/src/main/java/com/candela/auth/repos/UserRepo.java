package com.candela.auth.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.candela.auth.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

	User findByEmail(String email);
}
