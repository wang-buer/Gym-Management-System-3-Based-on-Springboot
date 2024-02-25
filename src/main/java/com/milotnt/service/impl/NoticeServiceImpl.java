package com.milotnt.service.impl;

import com.milotnt.mapper.NoticeMapper;
import com.milotnt.pojo.Notice;
import com.milotnt.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper equipmentMapper;

    @Override
    public List<Notice> findAll() {
        return equipmentMapper.findAll();
    }

    @Override
    public Boolean deleteByNoticeId(Integer id) {
        return equipmentMapper.deleteByNoticeId(id);
    }

    @Override
    public Boolean insertNotice(Notice equipment) {
        return equipmentMapper.insertNotice(equipment);
    }

    @Override
    public Boolean updateNoticeByNoticeId(Notice equipment) {
        return equipmentMapper.updateNoticeByNoticeId(equipment);
    }

    @Override
    public List<Notice> selectByNoticeId(Integer equipmentId) {
        return equipmentMapper.selectByNoticeId(equipmentId);
    }

    @Override
    public Integer selectTotalCount() {
        return equipmentMapper.selectTotalCount();
    }
}
