package com.kyhslam.persistence;

import org.springframework.data.repository.CrudRepository;

import com.kyhslam.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

	
}
