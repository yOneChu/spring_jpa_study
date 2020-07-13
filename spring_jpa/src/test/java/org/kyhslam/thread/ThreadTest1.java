package org.kyhslam.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.opencsv.CSVReader;


//ACCOUNT
public class ThreadTest1 implements Runnable {

	
	private File fileDir;
	private String type;
	private String isDir;
	
	public ThreadTest1(String fileType, String isDir) {
		this.type = fileType;
		this.isDir = isDir;
	}
	
	@Override
	public void run() {
		
		for(int i=0; i < 100; i++) {
			System.out.println("i == " + i);
		}
		
		try {
			
			for(File file : new File(isDir).listFiles()){
				if(file.isFile()){
					if(file.getName().contains(type)){
						
						ArrayList<String[]> list = new ArrayList<String[]>();
						
						BufferedReader bufferedReader = new BufferedReader(
			                    new InputStreamReader(new FileInputStream(file.getAbsolutePath()), "euc-kr"));

			            CSVReader reader = new CSVReader(bufferedReader);
			            String[] nextLine;

			            while( (nextLine = reader.readNext()) != null ){
			            	String[] data = new String[nextLine.length];
			                data[4] = nextLine[4];
			                data[5] = nextLine[5];
			                data[6] = nextLine[6];
			                data[7] = nextLine[7];
			                data[8] = nextLine[8];
			                data[9] = nextLine[9];
			                data[10] = nextLine[10];
			                data[11] = nextLine[11]; // 도메인명
			                
			                list.add(data);
			            }// end while
			            
			            
			            
			            
			            
					}
				}
				
				
			} // end for
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
