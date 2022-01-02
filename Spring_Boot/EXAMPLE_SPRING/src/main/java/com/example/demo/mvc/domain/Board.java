package com.example.demo.mvc.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board {
	private int boardSeq;
	private BoardType boardType;
	private String title;
	private String content;
	private Date reqDate;
}
