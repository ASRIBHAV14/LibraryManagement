package com.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entities.Login;



public interface LoginRepository extends JpaRepository<Login,Integer>{
	//@Query("Select login from Login login order by loginId")
	Login findByuserName(String userName);
}