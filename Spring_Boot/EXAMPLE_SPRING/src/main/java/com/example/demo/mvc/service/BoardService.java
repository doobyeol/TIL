package com.example.demo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.framework.data.domain.PageRequestParameter;
import com.example.demo.mvc.domain.Board;
import com.example.demo.mvc.repository.BoardRepository;
import com.example.demo.parameter.BoardParameter;
import com.example.demo.parameter.BoardSearchParameter;

/**
 * 게시판 Service
 * @author 두별
 */
@Service
public class BoardService {
	
	
	@Autowired
	private BoardRepository repository;
	
	/**
	 * 목록 리턴
	 * @param pageRequestParameter
	 * @return
	 */
	public List<Board> getList(PageRequestParameter<BoardSearchParameter> pageRequestParameter) {
		return repository.getList(pageRequestParameter);
	}
	
	
	/**
	 * 상세정보 리턴
	 * @param boardSeq
	 * @return
	 */	
	public Board get(int boardSeq) {
		return repository.get(boardSeq);
	}

	/**
	 * 등록 처리
	 * @param board
	 * @return 
	 */
	public void save(BoardParameter parameter) {
		// 조회하여 리턴된 정보
		Board board = repository.get(parameter.getBoardSeq());
		if (board == null) {
			repository.save(parameter);
		} else {
			repository.update(parameter);
		}
	}

	/**
	 * 업데이트 처리
	 * @param board
	 */
	public void update(BoardParameter board) {
		repository.update(board);
	}

	/**
	 * 삭제 처리
	 * @param boardSeq
	 */
	public boolean delete(int boardSeq) {
		repository.delete(boardSeq);
		return true;
	}
	
}
