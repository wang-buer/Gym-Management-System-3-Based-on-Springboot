package com.milotnt.service;

import com.milotnt.pojo.EqOrder;

import java.util.List;

/**
 * @author ZhangMing [1157038410@qq.com]
 * @date 2021/8/11
 */

public interface EqOrderService {

    //查询所有报名表信息
    List<EqOrder> findAll(EqOrder eqOrder);

    //添加报名信息
    Boolean insertEqOrder(EqOrder classOrder);

    //根据会员账号查询个人报名课表
    List<EqOrder> selectEqOrderByMemberAccount(Integer memberAccount);

    //删除已预约的课程
    Boolean deleteByEqOrderId(Integer classOrderId);

    //查询会员是否报名该课程
    EqOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount);

    //根据课程id查询所有报名的会员
    List<EqOrder> selectMemberOrderList(Integer classId);
    EqOrder selectBYid(Integer eqOrderId);
    Boolean updateEqOrder(EqOrder classOrder);
    
    List<EqOrder> TotalBystatus();

    List<EqOrder> TotalByEq();
    List<EqOrder> TotalByEqBegin();
}
