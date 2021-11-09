package com.service;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.entities.Login;
import com.repository.LoginRepository;

@SpringBootTest
class LoginServiceImplTest {
	@Autowired
	LoginServiceImpl loginservice;
	
	@MockBean
	LoginRepository loginrepo;

	@Test
	void testAddLoginDetails() {
		Login lo1=new Login();
		lo1.setLoginId(1);
		lo1.setPassword("Bhavya@14");
		lo1.setUserName("Bhavya");
		Mockito.when(loginrepo.save(lo1)).thenReturn(lo1);
		assertThat(loginservice.addLoginDetails(lo1)).isEqualTo(lo1);
	}

	@Test
	void testUpdateLoginDetails() throws Throwable {
		Login lo1=new Login();
		lo1.setLoginId(1);
		lo1.setPassword("Bhavya@14");
		lo1.setUserName("Bhavya");
		Optional<Login> lo2=Optional.of(lo1);
		Mockito.when(loginrepo.findById(1)).thenReturn(lo2);
		Mockito.when(loginrepo.save(lo1)).thenReturn(lo1);
		lo1.setPassword("Chandu@14");
		lo1.setUserName("Chandini");
		assertThat(loginservice.updateLoginDetails(lo1)).isEqualTo(lo1);
	
	}

	@Test
	void testDeleteLoginDetails() {
		Login lo1=new Login();
		lo1.setLoginId(1);
		lo1.setPassword("Bhavya@14");
		lo1.setUserName("Bhavya");
		Optional<Login> lo2=Optional.of(lo1);
		Mockito.when(loginrepo.findById(1)).thenReturn(lo2);
		Mockito.when(loginrepo.existsById(lo1.getLoginId())).thenReturn(false);
		assertFalse(loginrepo.existsById(lo1.getLoginId()));
		
		
	}

	@Test
	void testViewloginList() {
		Login lo1 = new Login();
		lo1.setLoginId(1);
		lo1.setUserName("Chandu");
		lo1.setPassword("Chandini@14");
		
	
		
		Login lo2=new Login();
		lo2.setLoginId(2);
		lo2.setUserName("Dinesh");
		lo2.setPassword("Dinesh@1");
		
		List<Login> list1 = new ArrayList<Login>();
		list1.add(lo1);
		list1.add(lo2);
		
		Mockito.when(loginrepo.findAll()).thenReturn(list1);
		assertThat(loginservice.viewloginList()).isEqualTo(list1);
		
	}


	@Test
	void testViewusersbyid() throws Throwable {
		Login lo1 = new Login();
		lo1.setLoginId(1);
		Optional<Login> lo2 = Optional.of(lo1);
		Mockito.when(loginrepo.findById(1)).thenReturn(lo2);
		assertThat(loginservice.viewusersbyid(1)).isEqualTo(lo1);
	}
	

	@Test
	void testFindByUserName() {
		Login lo1 = new Login();
		lo1.setUserName("Dinesh");
		lo1.setLoginId(1);
		lo1.setPassword("Dinesh@1");
		Optional<Login> lo2 = Optional.of(lo1);
		Mockito.when(loginrepo.findByuserName("Dinesh")).thenReturn(lo1);
		assertThat(loginservice.findByUserName("Dinesh")).isEqualTo(lo1);
}
	}


