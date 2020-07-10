package org.kyhslam.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;

import com.kyhslam.domain.Company;
import com.kyhslam.persistence.CompanyRepository;
import com.opencsv.CSVReader;

public class FileReadService {
	
	
	@Autowired
	CompanyRepository comRepo;
	
	
	public void fileRead(String isDir) throws Exception {
		
		
		String line = "";
		for (File info : new File(isDir).listFiles()) {
			
			if (info.isFile()) { // 파일일 경우
				String fileName = info.getName();
				
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(info.getAbsolutePath()), "euc-kr"));
				CSVReader reader = new CSVReader(br);
				
				String[] nextLine;

				while ((nextLine = reader.readNext()) != null) {
					System.out.println("0 == " + nextLine[0]);
					System.out.println("1 == " + nextLine[1]);
					System.out.println("2 == " + nextLine[2]);
					System.out.println("3 == " + nextLine[3]);
					System.out.println("4 == " + nextLine[4]);
					System.out.println("5 == " + nextLine[5]);

					System.out.println("6 == " + nextLine[6]);
					System.out.println("7 == " + nextLine[7]);
					System.out.println("8 == " + nextLine[8]);
					System.out.println("9 == " + nextLine[9]);
					System.out.println("10 == " + nextLine[10]);
					System.out.println("11 == " + nextLine[11]);
					System.out.println(" -------------------------- ");
					
					
					
				}
			}
			
			
		}
		
		
	}
	

}
