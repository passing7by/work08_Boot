package com.web.spring.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.spring.dto.BoardReq;
import com.web.spring.dto.BoardRes;
import com.web.spring.entity.Board;
import com.web.spring.exception.BoardSearchNotException;
import com.web.spring.exception.DMLException;
import com.web.spring.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	final BoardRepository boardRepository;
	
	//addBoard()
	@Transactional
	public BoardRes addBoard(BoardReq boardReq) {
		System.out.println("BoardReq==>"+ boardReq);
		Board entity = boardReq.toBoard(boardReq);//DTO-->Entity로 변경
		System.out.println("toBoard==>"+ entity);
		Board bo = boardRepository.save(entity);
		
		return new BoardRes(bo);
		
	}
	//findBoard(Long id)
	//하나의 게시글 못 찾으면 예외 처리
	//찾으면 Board를 바로 반환
	//최종적으로 리턴 하기 전에 BoardRes로 변환해서 반환 
	@Transactional(readOnly = true)
	public BoardRes findBoard(Long id)throws BoardSearchNotException  {
		
		Board bo= boardRepository.findById(id)
				.orElseThrow(()->new BoardSearchNotException("게시물 번호를 확인하세요", "Not Found BoardSearch~~"));
	
		 return new BoardRes(bo);
	}
	//getBoard(String memberId)
	/*
	 * 특정한 회윈이 작성한 게시글을 못찾으면 예외처리
	 * 찾으면 List<Board>를 바로 반환
	 * */
	@Transactional(readOnly = true)
	public List<BoardRes> getBoard(String memberId) throws BoardSearchNotException{
	
		List<Board> list=boardRepository.getBoard(memberId);
		
		if(list==null || list.isEmpty())
			throw new BoardSearchNotException("특정 회원이 작성한 글이 없습니다.", "Not Found BoardAll~~");
			
		return list.stream().map(BoardRes::new).collect(Collectors.toList());
		
	}
	//findAll..성능상 안 좋다...BoardList()로 가야함
	@Transactional(readOnly = true)
	public List<BoardRes> BoardList() throws BoardSearchNotException{
		List<Board> list=boardRepository.boardList();
		
		if(list==null || list.isEmpty())
			throw new BoardSearchNotException("전체 게시글이 없습니다.", "Not Found BoardAll~~");
			
		return list.stream().map(BoardRes::new).collect(Collectors.toList());
		
	}
	//updateBoard(Long id, BoardReq board)...하나의 게시물 받아와서... 필드 변경..Entity|Snapshot이 달라짐
	@Transactional
	public BoardRes updateBoard(Long id, BoardReq board) throws DMLException{
		Board boardEntity = boardRepository.findById(id)
							.orElseThrow(()->new DMLException("글번호 오류로 수정에 실패헀습니다.", "Not Update"));
		
		boardEntity.setTitle(board.getTitle());
		boardEntity.setContent(board.getContent());
		return new BoardRes(boardEntity);
	}
	
	//deleteaBoard(Long id)
	@Transactional
	public String deleteaBoard(Long id) throws DMLException{
		Board boardEntity = boardRepository.findById(id)
							.orElseThrow(()->new DMLException("글번호 오류로 삭제에 실패헀습니다.", "Not Delete",HttpStatus.BAD_REQUEST));
		
		boardRepository.delete(boardEntity);
		
		return "삭제성공";
	}
	
	
	
}
