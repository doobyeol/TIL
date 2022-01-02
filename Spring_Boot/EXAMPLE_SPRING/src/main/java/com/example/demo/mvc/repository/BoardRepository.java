package com.example.demo.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.mvc.domain.Board;
import com.example.demo.parameter.BoardParameter;
import com.example.demo.parameter.BoardSearchParameter;

/**
 * 게시판 Repository
 * @author 두별
 */
@Repository
public interface BoardRepository {
	
	List<Board> getList(BoardSearchParameter parameter);
	
	Board get(int boardSeq);
	
	void save(BoardParameter board);
	
	void update(BoardParameter board);
	
	void delete(int boardSeq);
	
}
