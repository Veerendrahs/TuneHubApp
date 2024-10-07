package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entites.Users;
import com.example.demo.service.UsersService;
@Controller
public class UsersController 
{
    @Autowired
    UsersService usev;
    
    @PostMapping("/register")
     public String addUser(@ModelAttribute Users user)
     {
        boolean userstatus=usev.emailExists(user.getEmail());
        if(userstatus==false)
        {
        	 usev.addUser(user);
        	 return "registerSuccess";
        }
        else
        {
        	System.out.println("user is already exist");
        	return "regfail";
        }  
     }
    
    @PostMapping("/login")
    public String validateUser(@RequestParam String email,@RequestParam String password)
    {
	boolean loginstatus=usev.validateUser(email,password);
       if(loginstatus==true)
       {
    	   String role=usev.getRole(email);
    	   if(role.equals("admin"))
    	   {
    		   return "adminhome"; 
    	   }
    	   else
    	   {
    		   return "customerhome";
    	   }
    	   
       }
       else
       {
    	   return "login";
       }
    }
    
}
    

