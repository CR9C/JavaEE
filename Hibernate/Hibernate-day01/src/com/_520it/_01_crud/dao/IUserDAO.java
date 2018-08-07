package com._520it._01_crud.dao;

import java.util.List;

import com._520it._01_crud.domain.User;

public interface IUserDAO {
	void save(User u);
	
	void delete(Long id);
	
	void update(User u);
	
	User get(Long id);
	
	List<User> listAll();
}
