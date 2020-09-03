package com.jigoo.service;

import com.jigoo.domain.BoardVO;
import com.jigoo.domain.Criteria;

import java.util.List;

public interface BoardService {

    public void register(BoardVO board);

    public BoardVO get(Long bno);

    public boolean modify(BoardVO board);

    public boolean remove(Long bno);

    public List<BoardVO> getList(Criteria cri);

    public int getTotal(Criteria cri);
}
