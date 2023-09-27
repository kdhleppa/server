package edu.kh.todo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Todo {
	
	private int todoNo;
	private String todoTitle;
	private String todoMemo;
	private String todoDate;
	private String todoDelflag;
	private int memberNo;
	

}
