package com.prac.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.prac.dao.BoardDAO;
import com.prac.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Inject
	BoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(BoardVO boardVO) throws Exception {
		dao.write(boardVO);
	}
	
}
