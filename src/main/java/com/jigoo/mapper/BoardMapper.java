package com.jigoo.mapper;

import com.jigoo.domain.BoardVO;
import com.jigoo.domain.Criteria;

import java.util.List;

public interface BoardMapper {

    public List<BoardVO> getList();

    public List<BoardVO> getListWithPaging(Criteria cri);

    public void insert(BoardVO board);

    public Integer insertSelectKey(BoardVO board);

    public BoardVO read(Long bno);

    public int delete(Long bno);

    public int update(BoardVO board);
}
