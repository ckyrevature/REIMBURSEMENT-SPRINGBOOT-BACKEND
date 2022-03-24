package com.reimbursement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.reimbursement.entities.UserEntity;
import com.reimbursement.models.User;
import com.reimbursement.repositories.UserRepository;

@SpringBootTest
public class UserServicesTest {

	@Mock
    private UserRepository repo;

    @InjectMocks 
    private UserServices userService = new UserServicesImpl();



    @Test
    void test_userLogon() throws Exception {
    	UserEntity entity = new UserEntity();
    	entity.setFirstName("fn");
    	when(repo.findByUsernameAndUserPassword("a","b")).thenReturn(entity);

    	User user = new User();
    	user.setUserName("a");
    	user.setUserPassword("b");
    	
    	User userResolve = userService.userLogon(user);
        assertEquals("fn", userResolve.getFirstName());
        
        user.setUserName("c");
    	user.setUserPassword("b");
    	userResolve = userService.userLogon(user);
    	assertEquals(null, userResolve.getFirstName());
        
    }



	@Test
	public void test_getUser() {
		Long userid = (long) 2;
		when(repo.findByRoleID(userid)).thenReturn(Stream
				.of(new UserEntity(userid, "a" , "1111", "a", "b", "uck@gmail.com", userid))
				.collect(Collectors.toList()));
		
		User user = new User();
    	user.setUserID(1L);
    	user.setFirstName("alex");
    	user.setLastName("yip");
    	user.setEmail("alex@gmail.com");
    	user.setRoleID(1L);
    	User userResolve = userService.getUser(user.getUserID());
    	assertEquals(null , userResolve.getUserID());
    	
	}
	
	@Test
	public void test_searchUsers() {
		UserEntity entity = new UserEntity();
		entity.setUserId(1L);
    	entity.setFirstName("fn");
		List<UserEntity> entityList = new ArrayList<UserEntity>(); entityList.add(entity);
		when(repo.findByRoleID(1L)).thenReturn(entityList);
		
		User user = new User();
    	user.setUserID(1L);
    	user.setFirstName("alex");
    	user.setLastName("yip");
    	user.setEmail("alex@gmail.com");
    	user.setRoleID(1L);
    	List<User> userResolve = userService.searchUsers(user.getUserID());
    	assertNotNull(userResolve);
	}
	

	
	@Test
	public void test_updateUser() {
		UserEntity user = repo.findById(1L).get();
		user.setUserId(1L);
		user.setEmail("yck11214@gmail.com");
		repo.save(user);
		assertEquals("yck11214@gmail.com" , repo.findById(1L).get().getEmail());
	}
	
//	@Test
//	public void shouldChangeUserPasswordWhenAsked() {
//	    User  updatedUser = new User();
//	    updatedUser.setUserName("user");
//	    updatedUser.setPasswordHash("newpassword");
//	    when(userMapper.findByUsername("user")).thenReturn(updatedUser);
//
//	    Boolean updateResult = userService.password(user,"newpassword");
//	    verify(userMapper).update(user);
//	    assertEquals("updatedUserSuccess",userService.getByUsername(user.getUserName()).getPasswordHash(),"newpassword");
//	    assertEquals("updatedSuccess",updateResult,true);
//	}

}
