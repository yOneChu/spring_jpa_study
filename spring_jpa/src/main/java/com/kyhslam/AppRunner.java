package com.kyhslam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.kyhslam.domain.Company;
import com.kyhslam.domain.RelatedSubject;
import com.kyhslam.persistence.CompanyRepository;
import com.kyhslam.persistence.SubjectRepository;

//@Component
public class AppRunner implements ApplicationRunner {

	private Logger logger = LoggerFactory.getLogger(AppRunner.class);
	
	@Autowired
	CompanyRepository comRepo;
	
	@Autowired
	SubjectRepository subRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		logger.info("APP Runner start =========== ");
		
		Company company = new Company();
		company.setName("다우기술");
		company.setUser_all(1000);//사용자 총 계정수
		company.setDeleted_user(150);//삭제 계정 수
		company.setUse_count(850); //사용 계정수
		company.setServiceFlag("TRUE"); // 서비스 사용유부
		company.setConnectedFlag("TRUE"); //타시스템 연동 여부
		company.setConnectedSystem("GW"); //연동시스템 종류
		company.setConnectedId("1000"); // 연동아이디
		comRepo.save(company);
		
		Company company2 = new Company();
		company2.setName("키움증권");
		company2.setUser_all(2000);//사용자 총 계정수
		company2.setDeleted_user(100);//삭제 계정 수
		company2.setUse_count(1900); //사용 계정수
		company2.setServiceFlag("TRUE"); // 서비스 사용유부
		company2.setConnectedFlag("FALSE"); //타시스템 연동 여부
		company2.setConnectedSystem("ERP"); //연동시스템 종류
		company2.setConnectedId("1001"); // 연동아이디
		comRepo.save(company2);
		
		Company company3 = new Company();
		company3.setName("사람인");
		company3.setUser_all(500);//사용자 총 계정수
		company3.setDeleted_user(100);//삭제 계정 수
		company3.setUse_count(400); //사용 계정수
		company3.setServiceFlag("TRUE"); // 서비스 사용유부
		company3.setConnectedFlag("TRUE"); //타시스템 연동 여부
		company3.setConnectedSystem("GW"); //연동시스템 종류
		company3.setConnectedId("1000"); // 연동아이디
		comRepo.save(company3);
		
		
		
		RelatedSubject sub1 = new RelatedSubject();
		sub1.setAccountName("매출원가"); // 계정체계
		sub1.setAccountCode(131000); // 계정코드
		sub1.setSubjectName("선급금"); // 과목명(세목)
		sub1.setSubject(""); //과목명(목)
		sub1.setType("일반"); // 분류
		sub1.setRelatedCode(0); //관계코드
		sub1.setRelatedName(""); //관계계정과목명
		sub1.setCompany(company); // 회사코드
		subRepo.save(sub1);
		
		RelatedSubject sub2 = new RelatedSubject();
		sub2.setAccountName("매출원가"); // 계정체계
		sub2.setAccountCode(132000); // 계정코드
		sub2.setSubjectName("대손충당금_선급금"); //과목명(세목)
		sub2.setSubject(""); //과목명(목)
		sub2.setType("일반"); // 분류
		sub2.setRelatedCode(13100); //관계코드
		sub2.setRelatedName("선급금"); //관계계정과목명
		sub2.setCompany(company); // 회사코드
		subRepo.save(sub2);
		
		RelatedSubject sub3 = new RelatedSubject();
		sub3.setAccountName("매출원가"); // 계정체계
		sub3.setAccountCode(133000); // 계정코드
		sub3.setSubjectName("선급비용"); // 과목명(세목)
		sub3.setSubject(""); //과목명(목)
		sub3.setType("일반"); // 분류
		sub3.setRelatedCode(0); //관계코드
		sub3.setRelatedName(""); //관계계정과목명
		sub3.setCompany(company); // 회사코드
		subRepo.save(sub3);
	}
	
	
}
