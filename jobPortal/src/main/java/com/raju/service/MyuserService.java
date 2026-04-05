package com.raju.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.raju.model.Credentials;
import com.raju.model.MyUserDetails;



@Service
public class MyuserService implements UserDetailsService{
  
	@Autowired
	private UserService us;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		  Credentials crd=us.getcredentials(email);
		  if(crd==null) {
			   throw new UsernameNotFoundException("user not found: ");
		  }
		  else {
		return new MyUserDetails(crd);
		}
	}

}
