package com.kyhslam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyhslam.domain.Company;
import com.kyhslam.domain.RelatedSubject;
import com.kyhslam.domain.ResponseMessage;
import com.kyhslam.domain.ResponseSubject;
import com.kyhslam.persistence.CompanyRepository;
import com.kyhslam.persistence.SubjectRepository;

@RestController
@RequestMapping("/subject/*")
public class SubjectController {

	Logger log = LoggerFactory.getLogger(SubjectController.class);
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	CompanyRepository comRepo;
	
	
	// 계정 추가 -> 조회
	@PostMapping("/{bno}")
	public ResponseEntity<List<RelatedSubject>> addSubject(
				@PathVariable("bno") Long bno, @RequestBody RelatedSubject subject){
		
		log.info("bno === " + bno);
		log.info("subject === " + subject);
		
		Company company = comRepo.findById(bno).get();
		
		subject.setCompany(company);
		subjectRepository.save(subject);
		
		return new ResponseEntity<>(getListByCompany(company), HttpStatus.CREATED);
	}
	
	private List<RelatedSubject> getListByCompany(Company company) throws RuntimeException {
		log.info("======== " + company);
        return subjectRepository.getSubjectOfCompany(company);
	}
	
	//수정
	@PutMapping("/{bno}/update")
	public ResponseSubject update(@PathVariable("bno") Long bno, @RequestBody RelatedSubject subject) {
		
		ResponseSubject message = new ResponseSubject(HttpStatus.OK);
		
		RelatedSubject sub =	subjectRepository.findById(bno).get();
		sub.setAccountName(subject.getAccountName());
		sub.setAccountCode(subject.getAccountCode());
		
		subjectRepository.save(sub);
		
		message.setSubject(sub);
		
		return message;
	}
	
	
	//삭제
	@DeleteMapping("/{bno}/delete")
	public void delete(@PathVariable("bno") Long bno) {
		RelatedSubject sub =	subjectRepository.findById(bno).get();
		
		subjectRepository.delete(sub);
		
		return;
	}
	
}
