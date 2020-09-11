package com.jigoo.service;

import com.jigoo.domain.BoardAttachVO;
import com.jigoo.domain.BoardVO;
import com.jigoo.domain.Criteria;
import com.jigoo.mapper.BoardAttachMapper;
import com.jigoo.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j
public class BoardServiceImpl implements BoardService {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Setter(onMethod_ = @Autowired)
    private BoardAttachMapper attachMapper;

    @Transactional
    @Override
    public void register(BoardVO board) {

        log.info("register.............." + board);

        mapper.insertSelectKey(board);

        if(board.getAttachList() == null || board.getAttachList().size() <= 0) {
            return;
        }

        board.getAttachList().forEach(attach -> {
            attach.setBno(board.getBno());
            attachMapper.insert(attach);
        });
    }

    @Override
    public BoardVO get(Long bno) {

        log.info("get..............." + bno);

        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {

        log.info("modify............" + board);

        return mapper.update(board) == 1;
    }

    @Transactional
    @Override
    public boolean remove(Long bno) {

        log.info("remove..............." + bno);

        attachMapper.deleteAll(bno);

        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList(Criteria cri) {

        log.info("get List with criteria : " + cri);

        return mapper.getListWithPaging(cri);
    }

    @Override
    public int getTotal(Criteria cri) {

        log.info("get total count");

        return mapper.getTotalCount(cri);
    }

    @Override
    public List<BoardAttachVO> getAttachList(Long bno) {

        log.info("get Attach list by bno" + bno);

        return attachMapper.findByBno(bno);
    }
}
