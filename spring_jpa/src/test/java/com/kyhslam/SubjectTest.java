package com.kyhslam;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyhslam.domain.Company;
import com.kyhslam.domain.RelatedSubject;
import com.kyhslam.persistence.CompanyRepository;
import com.kyhslam.persistence.SubjectRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTest {

	@Autowired
	CompanyRepository comRepo;
	
	@Autowired
	SubjectRepository subRepo;
	
	
	//@Test
	public void testInsertCompany() {
		Company company = new Company();
		company.setName("bsnc");
		comRepo.save(company);
	}
	
	
	
	//@Test
	public void testInsertSubject() {

		Company company = new Company();
		company.setBno(1L);
		  
		RelatedSubject subject = new RelatedSubject(); 
		subject.setAccountCode(400);
		subject.setAccountName("test4"); 
		subject.setCompany(company);
		
		//comRepo.save(company);
		subRepo.save(subject);
	}

	//@Test
	public void updateAccount() {
		
		
		Company com = comRepo.findById(1L).get();
		
		
		Timestamp tt = new Timestamp(System.currentTimeMillis());
		com.setDeletedate(tt);
		
		comRepo.save(com);
				
		
	}
	
	//@Test
	public void selectComapny() {
		
		Company com = comRepo.findById(1L).get();

		System.out.println(com.getBno());
		System.out.println(com.getName());
		
		com.setSubjectList(subRepo.getSubjectOfCompany(com));
		
		System.out.println(com.getSubjectList());
	}

	@Test
	public void selectCodeNext() {
		
		Integer code = subRepo.getAccountNextValCode();
		System.out.println(code);
		
		
		
		
	}
	
}
