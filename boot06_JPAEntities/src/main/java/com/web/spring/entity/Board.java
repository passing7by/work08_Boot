package com.web.spring.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
public class Board {
	
	@Id
	@Column(name="board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;
	
	@Column(length = 100)
	private String title;
	
	@Lob
	private String content; //text Type
	
	private int count;
	
	@CreationTimestamp
	@Column(name = "reg_date")
	private LocalDateTime regDate;

	
	
	//추가
	//Custom
	//한 명의 회원이 여러개의 게시물을 작성 ManyToOne | OneToMany? -> ManyToOne임
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custom_id")
	private Custom custom;


	/*
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count
				+ ", regDate=" + regDate + ", custom=" + custom + "]";
	}
	*/
	
	//연관된 객체는 제외
	
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count
				+ ", regDate=" + regDate + "]";
	}
	
	
	
}
