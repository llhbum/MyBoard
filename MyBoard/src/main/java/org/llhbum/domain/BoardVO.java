package org.llhbum.domain;

import java.util.Date;

import lombok.Data;

// 1. DB의 컬럼과 맞게 작성해준다.
// Lombok을 사용해서 getter,setter를 처리해준다.

@Data
public class BoardVO {
	
	private Long bno;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	
}
