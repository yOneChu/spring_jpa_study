package com.kyhslam;

import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kyhslam.domain.Board;
import com.kyhslam.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

	
	@Autowired
	private BoardRepository boardRepo;
	
	//@Test
	public void inspect() {
		
		Class<?> clz = boardRepo.getClass();
		
		System.out.println(clz.getName());
		
		Class<?>[] interfaces = clz.getInterfaces();
		
		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));
		
		Class<?> superClasses = clz.getSuperclass();
		
		System.out.println("superClasses.getName() === " + superClasses.getName());
	}
	
	//@Test
	public void testInsert() {
		
		Board board = new Board();
		board.setTitle("제목");
		board.setContent("게시물의 내용");
		board.setWriter("user00");
		
		boardRepo.save(board);
	}
	
	//@Test
	public void testRead() {
		//Optional<Board> boardOptional = boardRepo.findById(1L);
		//Board board = boardOptional.get();
		
		Board board = boardRepo.findById(1L).get();
		
		System.out.println(board);
		System.out.println(board.getContent());
		System.out.println(board.getTitle());
		System.out.println(board.getWriter());
		
	}
	
	//@Test
	public void testUpdate() {
		
		System.out.println("Read First -----------");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("Update Title =----------");
		board.setTitle("update 1 title");
		
		System.out.println("Call Save() ----------- ");
		boardRepo.save(board);
		
	}
	
	//@Test
	public void testDelete() {
		System.out.println("DELETE Entity ====== ");
		boardRepo.deleteById(1L);
	}
	
	
	
}
