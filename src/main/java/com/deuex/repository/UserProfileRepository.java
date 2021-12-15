package com.deuex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.deuex.model.UserProfile;    
//repository that extends CrudRepository  

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer>  
{  

}  