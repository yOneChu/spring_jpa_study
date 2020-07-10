package com.kyhslam.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "go_company")
public class Company {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;
    
    private String name; // 회사명

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<RelatedSubject> subjectList;

    @CreationTimestamp
    private Timestamp regdate; // 생성일

    @UpdateTimestamp
    private Timestamp updateDate; // 수정일
    
    private Timestamp deletedate; // 삭제일

    private Integer user_all; //사용자 총 계정수
    
    private Integer deleted_user; // 삭제 계정 수
    
    private Integer use_count; //사용 계정 수
    
    private String serviceFlag; // 서비스 사용 유무
    
    private String connectedFlag; //타시스템 연동 여부
    
    private String connectedSystem; // 연동시스템 종류
    
    private String connectedId; // 연동ID
	/*
	 * 
	 {
		"name" : "키움",
		"user_all" : 200,
		"deleted_user" : "20",
		"use_count" : 180
		"serviceFlag" : "FALSE",
		"connectedFlag" : "TRUE"
		"connectedSystem" : "ERP",
		"connectedId" : "1000"
	}
	 */
    
    
    
	public Integer getUser_all() {
		return user_all;
	}

	public Timestamp getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(Timestamp deletedate) {
		this.deletedate = deletedate;
	}

	public void setUser_all(Integer user_all) {
		this.user_all = user_all;
	}

	public Integer getDeleted_user() {
		return deleted_user;
	}

	public void setDeleted_user(Integer deleted_user) {
		this.deleted_user = deleted_user;
	}

	public Integer getUse_count() {
		return use_count;
	}

	public void setUse_count(Integer use_count) {
		this.use_count = use_count;
	}

	public String getServiceFlag() {
		return serviceFlag;
	}

	public void setServiceFlag(String serviceFlag) {
		this.serviceFlag = serviceFlag;
	}

	public String getConnectedFlag() {
		return connectedFlag;
	}

	public void setConnectedFlag(String connectedFlag) {
		this.connectedFlag = connectedFlag;
	}

	public String getConnectedSystem() {
		return connectedSystem;
	}

	public void setConnectedSystem(String connectedSystem) {
		this.connectedSystem = connectedSystem;
	}

	public String getConnectedId() {
		return connectedId;
	}

	public void setConnectedId(String connectedId) {
		this.connectedId = connectedId;
	}

	public Long getBno() {
		return bno;
	}

	public void setBno(Long bno) {
		this.bno = bno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RelatedSubject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<RelatedSubject> subjectList) {
		this.subjectList = subjectList;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}
    
    
	
}
