package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.Users;
import com.example.demo.repository.UsersRepository;
@Service
public class UsersServiceImplementation implements UsersService
{
	@Autowired
	UsersRepository repo;
	@Override
	public String addUser(Users user) 
	{
	    repo.save(user);
	    
	    return "user is created and saved";
	}
	@Override
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	@Override
	public boolean validateUser(String email, String password) 
	{
		Users user=repo.findByEmail(email);
		String db_password=user.getPassword();
		if(password.equals(db_password))
		{
			return true;
		}
		else
		{
      	    return false;
		}
			
		
	}
	@Override
	public String getRole(String email) {
		Users user=repo.findByEmail(email);
		String role=user.getRole();
		return role;
	}
	
	
    
}
