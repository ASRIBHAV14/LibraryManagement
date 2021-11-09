package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IDNotFoundException;
import com.entities.Login;
import com.repository.LoginRepository;
import com.repository.UsersRepository;
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepository loginrepo;
	@Autowired
	UsersRepository usersrepo;
	
	@Override
	public Login addLoginDetails(Login login) {
		return loginrepo.save(login);
	}

	@Override
	public Login updateLoginDetails(Login login) throws Throwable {
		int loginid=login.getLoginId();
		Supplier s1=()->new IDNotFoundException("LoginId doesnot exist in the database");
		Login l0=loginrepo.findById(loginid).orElseThrow(s1);
		l0.setLoginId(l0.getLoginId());
		l0.setUserName(l0.getUserName());
		l0.setPassword(l0.getPassword());
		loginrepo.save(login);
		return login;
	}

	@Override
	public String deleteLoginDetails(Login login) {
		loginrepo.delete(login);
		return "deleted";
	}

	@Override
	public List<Login> viewloginList() {
		List<Login> lo1=loginrepo.findAll();
		return lo1;
	}

	@Override
	public Login viewusersbyid(int loginid) throws Throwable {
		Supplier s1=()->new IDNotFoundException("LoginId doesnot exist in the database");
		Login l8= loginrepo.findById(loginid).orElseThrow(s1);
		return l8;
	}

	@Override
	public Login findByUserName(String userName) {
		Login l1=(Login) loginrepo.findByuserName(userName);
		return l1;
	}

	

}