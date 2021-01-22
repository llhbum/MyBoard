package org.llhbum.mapper;

import java.util.List;
import java.util.Map;

import org.llhbum.domain.BoardVO;
import org.llhbum.domain.Criteria;

// 2. 영속계층에 맞게 CRUD를 작성해준다.

public interface BoardMapper {
	
	// BoardVO를 볼 수 있는 getList 작성
	List<BoardVO> getList();
	
	// Create를 get에 맞게 작성
	void insert(BoardVO vo);
	
	// 
	void insertSelectKey(BoardVO board);
	
	//bno 값으로 BoardVO 읽기
	BoardVO read(Long bno);
	
	// Delete 구현
	int delete(Long bno);
	
	// Update 구현
	int update(BoardVO board);
	
	// 페이지 처리를 위한 cri를 파라미터로 BoardVO를 리스트로 받아옴
	List<BoardVO> getListWithPaging(Criteria cri);
	
	// 페이징 처리를 위해서 TotalCNT 생성
	int getTotalCount(Criteria cri) ; 
	
	// 검색을 위한 searchTest
	List<BoardVO> searchTest(Map<String, Map<String, String>> map);
	
	// board의 조회수 
	int boardHit(Long bno);
}
