package com.kyhslam.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.kyhslam.domain.Company;
import com.kyhslam.domain.RelatedSubject;
import com.kyhslam.domain.ResponseAccounMessage;
import com.kyhslam.domain.ResponseMessage;
import com.kyhslam.persistence.CompanyRepository;
import com.kyhslam.persistence.SubjectRepository;

@RestController
@RequestMapping("/account/*")
public class CompanyController {

	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	SubjectRepository subRepo;
	
	@GetMapping("/{bno}/list")
	public ResponseEntity<List<RelatedSubject>> list(@PathVariable("bno") Long bno){
		
		Company company = new Company();
		company.setBno(bno);
		
		
		return new ResponseEntity<>(getListByCompany(company), HttpStatus.ACCEPTED);
	}
	
	
	// 회사 조회 (계정과목 포함)
	@GetMapping("/{bno}/list2")
	public ResponseAccounMessage list2(@PathVariable("bno") Long bno){
		
		Company company = new Company();
		company.setBno(bno);
		
		company.setSubjectList(subRepo.getSubjectOfCompany(company));
		
		HashMap<String, Object> map = new HashMap<>();
		
		ResponseAccounMessage message = new ResponseAccounMessage(HttpStatus.OK);
		message.setCompany(company);
		
		return message;
	}
	
	private List<RelatedSubject> getListByCompany(Company company) throws RuntimeException {
		logger.info("======== " + company);
        return subRepo.getSubjectOfCompany(company);
	}
	
	//회사 수정
	@PutMapping("/{bno}/update")
	public ResponseAccounMessage update(@PathVariable("bno") Long bno, @RequestBody Company company) {
		
		ResponseAccounMessage message = new ResponseAccounMessage(HttpStatus.OK);
		
		
		Company com = companyRepository.findById(bno).get();
		
		com.setConnectedFlag(company.getConnectedFlag()); // 타시스템 연동 여부
		com.setServiceFlag(company.getServiceFlag()); // 서비스 사용 유무
		companyRepository.save(com);
		
		//객체 리프레시해줘야됨
		message.setCompany(company);
		return message;
	}	
	
	//회사 추가
	@PostMapping("/add")
	public ResponseAccounMessage add(@RequestBody Company company) {
		
		ResponseAccounMessage message = new ResponseAccounMessage(HttpStatus.CREATED);
		
		companyRepository.save(company);

		message.setCompany(company);
		
		return message;
	}
	
	
	//삭제
	@DeleteMapping("/{bno}/delete")
	public void delete(@PathVariable("bno") Long bno) {
		
		ResponseAccounMessage message = new ResponseAccounMessage(HttpStatus.OK);
		
		//Company com = new Company();
		//com.setBno(bno);
		
		Company com = companyRepository.findById(bno).get();
		
		companyRepository.delete(com);
		
		return;
	}
	
	
	
	
}
