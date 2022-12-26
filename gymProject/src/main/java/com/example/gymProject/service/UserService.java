package com.example.gymProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.gymProject.dto.LoginUser;
import com.example.gymProject.dto.NewUserDto;
import com.example.gymProject.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserMapper loginMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println(username);
		System.out.println("login");		
		LoginUser loginUser = loginMapper.login(username);
		if(loginUser == null) {
			throw new UsernameNotFoundException(username);
		}
		System.out.println(loginUser);
		return loginUser;

//		
		
//		LoginUser loginUser = loginMapper.login(username);
//		return loginUser;
	}
	
	
	
	
	public void save(NewUserDto infoDto) {
		    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		    infoDto.setPassword(encoder.encode(infoDto.getPassword()));
		    loginMapper.save(NewUserDto.builder()
			        .username(infoDto.getUsername())
			        .name(infoDto.getName())
			        .gender(infoDto.getGender())
			        .area(infoDto.getArea())
			        .phone(infoDto.getPhone())
			        .role(infoDto.getRole())
			        .password(infoDto.getPassword()).build());
	}
	
	
}
