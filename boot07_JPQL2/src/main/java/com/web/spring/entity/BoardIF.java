package com.web.spring.entity;

import java.time.LocalDateTime;

/*
 * b.board_id, b.title, b.custom_id, c.name
 * 이 컬럼을 읽어오는 템플릿 기능을 Getter로 만들어 놓는다.
 * 
 * Spring Data JPA 해당 템플릿을 바탕으로 구현 클래스는 생성해준다.
 * */
public interface BoardIF {
	Long getBoardId();
	String getTitle();
	String getContent();
	String getName();
	LocalDateTime getRegDate();
	int getCount();
	Integer getCustomId();
}
