package com.kyhslam;

import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyhslam.domain.Board;
import com.kyhslam.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class boot3ApplicationTest {

	@Autowired
	private BoardRepository repo;
	
	//@Test
	public void testInsert200() {
		
		for(int i=1; i <= 200; i++) {
			Board board = new Board();
			board.setTitle("제목.." + i);
			board.setContent("내용...." +  i + " 채우기 ");
			board.setWriter("user0" + (i%10) );
			repo.save(board);
		}
	}
	
	
	//@Test
	public void testByTitle() {
		
		// before java 8
		/*
		 * List<Board> list = repo.findBoardByTitle("제목..177");
		 * 
		 * for(int i=0; i < list.size(); i++) { System.out.println(list.get(i)); }
		 */
		
		
		// java 8
		repo.findBoardByTitle("제목..177").forEach(board -> System.out.println(board));
	}
	

	//@Test
	public void testByWriter() {
		Collection<Board> results = repo.findByWriter("user00");
		
		results.forEach(board -> System.out.println(board));
	}
	
	//@Test
	public void testByWriterContaining() {
		Collection<Board>  results = repo.findByWriterContaining("05");
		
		results.forEach(board -> System.out.println(board.getBno()));
	}
	
	
	//@Test
	public void testByTitleAndBno() {
		Collection<Board> results = repo.findByTitleContainingAndBnoGreaterThan("5", 50L);
		
		results.forEach(board -> System.out.println(board.toString()));
	}
	
	@Test
	public void testBnoOrderBy() {
		Collection<Board> results = repo.findByBnoGreaterThanOrderByBnoDesc(90L);
		
		results.forEach(board -> System.out.println(board.toString()));
	}
	
}
