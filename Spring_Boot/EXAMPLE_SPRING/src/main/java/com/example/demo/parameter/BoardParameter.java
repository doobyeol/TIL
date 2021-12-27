package com.example.demo.parameter;

import java.util.Date;

import lombok.Data;

@Data
public class BoardParameter {
	private int boardSeq;
	private String title;
	private String content;
}
