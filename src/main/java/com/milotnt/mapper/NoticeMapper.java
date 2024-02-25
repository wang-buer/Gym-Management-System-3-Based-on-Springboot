package com.milotnt.mapper;

import com.milotnt.pojo.Notice;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NoticeMapper {

    //查询所有通知公告
    List<Notice> findAll();

    //根据id删除通知公告
//    Boolean deleteByNoticeId(Integer equipmentId);
    Boolean deleteByNoticeId(Integer id);

    //添加通知公告
    Boolean insertNotice(Notice equipment);

    //根据id修改通知公告信息
    Boolean updateNoticeByNoticeId(Notice equipment);

//    Boolean updateNoticeByNoticeId(Notice id);

    //根据id查询通知公告
    List<Notice> selectByNoticeId(Integer equipmentId);

    //查询通知公告总数
    Integer selectTotalCount();

}
