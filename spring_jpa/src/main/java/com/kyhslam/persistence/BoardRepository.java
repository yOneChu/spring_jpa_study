package com.kyhslam.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
	
	// bno > ? ORDER BY bno DESC limit ,?   
	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
	
	// no order 
	//public List<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
	public Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
	//@Query 제목..1
	
	@Query("SELECT b from Board b WHERE b.title LIKE %?1% AND b.bno > 0 order by b.bno DESC")
	public List<Board> findTitle(String title);
	
	@Query("SELECT b from Board b WHERE b.content LIKE %:content% AND b.bno > 0 ORDER BY b.bno DESC ")
	public List<Board> findByContent(@Param("content") String content);
	
}
