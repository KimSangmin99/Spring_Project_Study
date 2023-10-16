package com.vampa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vampa.mapper.AdminMapper;
import com.vampa.model.BookVO;
import com.vampa.model.CateVO;
import com.vampa.model.Criteria;

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
	
	/* 상품 리스트 */
	@Override
	public List<BookVO> goodsGetList(Criteria cri) {
		return adminMapper.goodsGetList(cri);
	}

	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri) {
		return adminMapper.goodsGetTotal(cri);
	}
	
	/* 상품 조회 페이지 */
	@Override
	public BookVO goodsGetDetail(int bookId) {
		return adminMapper.goodsGetDetail(bookId);
	}
	
	/* 상품 정보 수정 */
	@Override
	public int goodsModify(BookVO vo) {
		return adminMapper.goodsModify(vo);
	}
	
	/* 상품 정보 삭제 */
	public int goodsDelete(int bookId) {
		return adminMapper.goodsDelete(bookId);
	}


}
