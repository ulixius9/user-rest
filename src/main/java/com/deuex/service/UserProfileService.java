package com.deuex.service;

import java.util.ArrayList;  
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.deuex.model.UserProfile;
import com.deuex.repository.UserProfileRepository;  
  
//defining the business logic  
@Service  
public class UserProfileService   
{  
	@Autowired  
	UserProfileRepository userProfileRepository;  
	//getting list of all user profiles by using the method findaAll() of CrudRepository  
	public List<UserProfile> listAllUsers()   
	{  
		List<UserProfile> users = new ArrayList<UserProfile>();  
		userProfileRepository.findAll().forEach(user -> users.add(user));  
		return users;  
	}  
	//getting a specific record by using the method findById() of CrudRepository  
	public UserProfile getUserById(int id)   
	{  
		return userProfileRepository.findById(id).get();  
	}  
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(UserProfile books)   
	{  
		userProfileRepository.save(books);  
	}  
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
		userProfileRepository.deleteById(id);  
	}  
	//updating a record  
	public void update(UserProfile user, int userId)   
	{  
		userProfileRepository.save(user);  
	}  
}  