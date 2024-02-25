package com.milotnt.service;

import com.milotnt.pojo.Notice;

import java.util.List;



public interface NoticeService {

    //查询所有通知公告
    List<Notice> findAll();

    //根据id删除通知公告
//    Boolean deleteByNoticeId(Integer noticeId);
    Boolean deleteByNoticeId(Integer id);

    //添加通知公告
    Boolean insertNotice(Notice notice);

    //根据id修改通知公告信息
    Boolean updateNoticeByNoticeId(Notice notice);

    //根据id查询通知公告
    List<Notice> selectByNoticeId(Integer noticeId);

    //查询通知公告总数
    Integer selectTotalCount();

}
