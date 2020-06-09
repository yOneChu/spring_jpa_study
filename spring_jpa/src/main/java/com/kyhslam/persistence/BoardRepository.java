package com.kyhslam.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kyhslam.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

	public List<Board> findBoardByTitle(String title);
	
	public Collection<Board> findByWriter(String writer);
	
	// like 
	public Collection<Board> findByWriterContaining(String writer);
	
	// or
	public Collection<Board> findByTitleContainingOrContentContaining(String title, String content);
	
	// select * from tbl_boards where title like '%?%' and bno > ?;
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyword, Long num);
	
	// select * from tbl_boards where bno > ? ORDER BY bno DESC;
	public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);
	
}
