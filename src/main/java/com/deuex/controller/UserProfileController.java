package com.deuex.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deuex.model.UserProfile;
import com.deuex.repository.UserProfileRepository;



//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserProfileController {

  @Autowired
  UserProfileRepository userProfileRepository;

  @GetMapping("/users")
  public ResponseEntity<List<UserProfile>> getAllUserProfiles() {
    try {
		List<UserProfile> users = new ArrayList<UserProfile>();  
		userProfileRepository.findAll().forEach(user -> users.add(user));
      if (users.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(users, HttpStatus.OK);
    } 
    catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<UserProfile> getUserProfileById(@PathVariable("id") int id) {
    Optional<UserProfile> userProfileData = userProfileRepository.findById(id);

    if (userProfileData.isPresent()) {
      return new ResponseEntity<>(userProfileData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/user")
  public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
    try {
      UserProfile _userProfile = userProfileRepository
          .save(new UserProfile(userProfile.getName(), userProfile.getCity(), userProfile.getAge(),userProfile.getEmail(),userProfile.getMobile()));
      return new ResponseEntity<>(_userProfile, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<UserProfile> updateUserProfile(@PathVariable("id") int id, @RequestBody UserProfile userProfile) {
    Optional<UserProfile> userProfileData = userProfileRepository.findById(id);

    if (userProfileData.isPresent()) {
      UserProfile _userProfile = userProfileData.get();
      _userProfile.setAge(userProfile.getAge());
      _userProfile.setName(userProfile.getName());
      _userProfile.setEmail(userProfile.getEmail());
      _userProfile.setMobile(userProfile.getMobile());
      _userProfile.setCity(userProfile.getCity());
      return new ResponseEntity<>(userProfileRepository.save(_userProfile), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/user/{id}")
  public ResponseEntity<HttpStatus> deleteUserProfile(@PathVariable("id") int id) {
    try {
      userProfileRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/users")
  public ResponseEntity<HttpStatus> deleteAllUserProfiles() {
    try {
      userProfileRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}