package com.vampa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vampa.mapper.AdminMapper;
import com.vampa.model.BookVO;
import com.vampa.model.CateVO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;	
	
	/* 상품 등록 */
	@Override
	public void bookEnroll(BookVO book) {
		adminMapper.bookEnroll(book);
	}
	
	/* 카테고리 리스트 */
	@Override
	public List<CateVO> cateList() {
		return adminMapper.cateList();
	}


}
