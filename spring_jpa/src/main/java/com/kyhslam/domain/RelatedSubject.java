package com.kyhslam.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="go_account_subject")
public class RelatedSubject {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;

    private String accountName; // 계정체계

    private Integer accountCode; // 계정코드
    
    private String subjectName; // 과목명(세목)
    
    private String subject; // 과목명(목)
    
    private String type; // 분류
    
    private Integer relatedCode; // 관계코드
    
    private String relatedName; // 관계계정과목
    
    //불필요하게 양쪽 테이블을 조회하지 않도록 양쪽 모두 '지연로딩' 방식으로 설정 (fetch = FetchType.LAZY)
    @JsonIgnore
    @ManyToOne
    private Company company; // 회사코드

    @CreationTimestamp
    private Timestamp regdate; // 생성일

    @UpdateTimestamp
    private Timestamp updatedate; // 수정일

    private Timestamp deletedate; // 삭제일
    
	public Timestamp getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(Timestamp deletedate) {
		this.deletedate = deletedate;
	}

	public Long getBno() {
		return bno;
	}

	public void setBno(Long bno) {
		this.bno = bno;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	public Integer getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(Integer accountCode) {
		this.accountCode = accountCode;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public Integer getRelatedCode() {
		return relatedCode;
	}

	public void setRelatedCode(Integer relatedCode) {
		this.relatedCode = relatedCode;
	}

	public String getRelatedName() {
		return relatedName;
	}

	public void setRelatedName(String relatedName) {
		this.relatedName = relatedName;
	}
	
	
    
}
