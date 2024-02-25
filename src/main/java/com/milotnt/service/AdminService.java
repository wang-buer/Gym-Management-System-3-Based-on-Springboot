package com.milotnt.service;

import com.milotnt.pojo.Admin;

/*管理员登录模块业务层接口*/
public interface AdminService {

    /**
     * 管理员登录方法
     * @param admin
     * @return 当前匹配的数据，如果没有返回null
     */
    Admin adminLogin(Admin admin);

}
