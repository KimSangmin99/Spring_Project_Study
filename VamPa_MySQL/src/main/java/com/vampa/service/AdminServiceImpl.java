package com.vampa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vampa.mapper.AdminMapper;
import com.vampa.model.AttachImageVO;
import com.vampa.model.BookVO;
import com.vampa.model.CateVO;
import com.vampa.model.Criteria;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminMapper adminMapper;	
	
	/* 상품 등록 */
	@Transactional
	@Override
	public void bookEnroll(BookVO book) {
		
		adminMapper.bookEnroll(book);
		
		if(book.getImageList() == null || book.getImageList().size() <= 0) {
			return;
		}
		
		// 일반적 for문
        for(int i = 0; i < book.getImageList().size(); i++) {
			AttachImageVO vo = book.getImageList().get(i);
			vo.setBookId(book.getBookId());
			adminMapper.imageEnroll(vo);
		}
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
	@Transactional
	@Override
	public int goodsModify(BookVO vo) {
		int result = adminMapper.goodsModify(vo);

		if (result == 1 && vo.getImageList() != null && vo.getImageList().size() > 0) {

			adminMapper.deleteImageAll(vo.getBookId());

			// 일반적 for문
			for (int i = 0; i < vo.getImageList().size(); i++) {
				AttachImageVO avo = vo.getImageList().get(i);
				vo.setBookId(vo.getBookId());
				adminMapper.imageEnroll(avo);
			}

		}

		return result;
	}
	
	/* 상품 정보 삭제 */
	public int goodsDelete(int bookId) {
		return adminMapper.goodsDelete(bookId);
	}


}
