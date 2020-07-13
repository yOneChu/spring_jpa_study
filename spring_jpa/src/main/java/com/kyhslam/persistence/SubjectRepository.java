package com.kyhslam.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kyhslam.domain.Company;
import com.kyhslam.domain.RelatedSubject;

public interface SubjectRepository extends CrudRepository<RelatedSubject, Long> {

	 @Query("SELECT r FROM RelatedSubject r WHERE r.company = ?1 " +
	            " AND r.bno > 0 ORDER BY r.bno ASC")
	 public List<RelatedSubject> getSubjectOfCompany(Company company);
	 
	 
	 @Query("SELECT (max(a.accountCode) + 1) FROM RelatedSubject a")
	 public Integer getAccountNextValCode();
	 
}
