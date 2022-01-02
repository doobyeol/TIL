package com.example.demo.parameter;

import java.util.List;

import com.example.demo.mvc.domain.BoardType;

import lombok.Data;

@Data
public class BoardSearchParameter {
	private List<BoardType> boardTypes;
	private String keyword;
	
	public BoardSearchParameter() {
		
	}
	
}
