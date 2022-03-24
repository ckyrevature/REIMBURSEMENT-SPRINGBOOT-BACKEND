package com.reimbursement.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reimbursement.entities.UserEntity;
import com.reimbursement.exception.UserNotFoundException;
import com.reimbursement.models.User;
import com.reimbursement.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User userLogon(User user) {

		UserEntity userEntity =  userRepo.findByUsernameAndUserPassword(user.getUserName(), user.getUserPassword());
		user = new User();
		try {
		if(userEntity != null) {
			user.setUserID(userEntity.getUserId());
			user.setFirstName(userEntity.getFirstName());
			user.setLastName(userEntity.getLastName());
			user.setEmail(userEntity.getEmail());
			user.setRoleID(userEntity.getRoleID());
			} 
		} catch (UserNotFoundException e) {
			if(userEntity == null) {
				throw new UserNotFoundException("401", "Username or password incorrect");
			}
		}
		return user;
	}

	@Override
	public List<User> searchUsers(Long roleId)  {

		List<User> allUser = new ArrayList<User>();
		List<UserEntity> entities = userRepo.findByRoleID(roleId);	
		for(UserEntity userEntity: entities) {
			User user = new User();
			user.setUserID(userEntity.getUserId());
			user.setUserName(userEntity.getUsername());
			user.setFirstName(userEntity.getFirstName());
			user.setLastName(userEntity.getLastName());
			user.setEmail(userEntity.getEmail());
			user.setRoleID(userEntity.getRoleID());
			allUser.add(user);
		}
		return allUser;
	}


	@Override
	public User getUser(Long userid) {
		Optional<UserEntity> optional = userRepo.findById(userid);
		User user = new User();
		if (optional.isPresent()) {
		UserEntity userEntity = optional.get();
		user.setUserID(userEntity.getUserId());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setEmail(userEntity.getEmail());
		user.setRoleID(userEntity.getRoleID());
		}
		return user;
	}
	

	@Override
	public boolean updateUser(User user)  {
		if(user.getUserID()!=null && userRepo.existsById(user.getUserID())) {
			UserEntity userEntity = userRepo.getById(user.getUserID());
			userEntity.setEmail(user.getEmail());
			userRepo.save(userEntity);
			return true;
			
		}else {
		return false;
		
		
		}	
	}

	
}