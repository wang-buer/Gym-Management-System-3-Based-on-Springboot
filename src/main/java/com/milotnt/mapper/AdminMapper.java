package com.milotnt.mapper;

import com.milotnt.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


public interface AdminMapper {
    /**
     * 根据账号和密码查询数据
     * @param admin
     * @return 如果找到对应的管理员，返回管理员数据，没有返回null
     */
    Admin selectByAccountAndPassword(Admin admin);

}
