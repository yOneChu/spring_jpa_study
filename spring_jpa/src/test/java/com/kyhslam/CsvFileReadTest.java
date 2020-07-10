package com.kyhslam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyhslam.domain.Company;
import com.kyhslam.persistence.CompanyRepository;
import com.kyhslam.persistence.SubjectRepository;
import com.opencsv.CSVReader;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CsvFileReadTest {

	@Autowired
	SubjectRepository subrepo;
	
	@Autowired
	CompanyRepository comrepo;
	
	
	@Test
	public void csvRead() {

		String isDir = "C:\\csvFile";
		//String csvFile = "C:\\csvFile\\company.csv";

		try {

			String line = "";

			for (File info : new File(isDir).listFiles()) {
				if (info.isFile()) { // 파일일 경우
					System.out.println(info.getAbsolutePath());
					System.out.println(info.getName());

					BufferedReader br = new BufferedReader(
							new InputStreamReader(new FileInputStream(info.getAbsolutePath()), "euc-kr"));
					CSVReader reader = new CSVReader(br);
					
					
					String[] nextLine;

					while ((nextLine = reader.readNext()) != null) {

						Company c = new Company();
						
						System.out.println("0 == " + nextLine[0]);
						System.out.println("1 == " + nextLine[1]); // 생성일
						System.out.println("2 == " + nextLine[2]); // 수정일
						System.out.println("3 == " + nextLine[3]); // 삭제일
						System.out.println("4 == " + nextLine[4]); // 회사명
						System.out.println("5 == " + nextLine[5]); // 사용자 계정수

						System.out.println("6 == " + nextLine[6]); // 삭제 계정수 
						System.out.println("7 == " + nextLine[7]);// 실제 사용자 수
						System.out.println("8 == " + nextLine[8]); //서비스 사용유무
						System.out.println("9 == " + nextLine[9]); //연동여부
						System.out.println("10 == " + nextLine[10]); // 연동id
						System.out.println("11 == " + nextLine[11]); // 도메인명

						System.out.println(" -------------------------- ");
						
						c.setName(nextLine[4]);
						/*
						 * c.setUser_all( Integer.parseInt(nextLine[5]) ); c.setDeleted_user(
						 * Integer.parseInt(nextLine[6])); c.setUse_count(
						 * Integer.parseInt(nextLine[7]));
						 */
						
						c.setUser_all( (Integer)nextLine[5] );
						c.setDeleted_user( Integer.parseInt(nextLine[6]));
						c.setUse_count( Integer.parseInt(nextLine[7]));
						
						
						c.setServiceFlag(nextLine[8]);
						c.setConnectedFlag(nextLine[9]);
						c.setConnectedSystem(nextLine[10]);
						
						comrepo.save(c);
					}
				}

				System.out.println("===========================================================================");
			}
			
			
			/*
			 * File file = new File(csvFile);
			 * 
			 * BufferedReader br = new BufferedReader(new InputStreamReader(new
			 * FileInputStream(file), "euc-kr"));
			 */

		
			// CSVReader reader = new CSVReader(new FileReader(csvFile));
			// CSVReader reader = null; // new CSVReader(br);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
