package com.milotnt.service.impl;

import com.milotnt.mapper.EqOrderMapper;
import com.milotnt.mapper.EqOrderMapper;
import com.milotnt.pojo.EqOrder;
import com.milotnt.service.EqOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class EqOrderServiceImpl implements EqOrderService {

    @Autowired
    private EqOrderMapper eqOrderMapper;

    @Override
    public List<EqOrder> findAll(EqOrder eqOrder) {
        return eqOrderMapper.findAll(eqOrder);
    }

    @Override
    public Boolean insertEqOrder(EqOrder classOrder) {
        return eqOrderMapper.insertEqOrder(classOrder);
    }

    @Override
    public List<EqOrder> selectEqOrderByMemberAccount(Integer memberAccount) {
        return eqOrderMapper.selectEqOrderByMemberAccount(memberAccount);
    }

    @Override
    public Boolean deleteByEqOrderId(Integer classOrderId) {
        return eqOrderMapper.deleteByEqOrderId(classOrderId);
    }

    @Override
    public EqOrder selectMemberByClassIdAndMemberAccount(Integer classId, Integer memberAccount) {
        return eqOrderMapper.selectMemberByClassIdAndMemberAccount(classId, memberAccount);
    }

    @Override
    public List<EqOrder> selectMemberOrderList(Integer classId) {
        return eqOrderMapper.selectMemberOrderList(classId);
    }

	public EqOrder selectBYid(Integer eqOrderId) {
		return eqOrderMapper.selectBYid(eqOrderId);
	}

	@Override
	public Boolean updateEqOrder(EqOrder classOrder) {
		return eqOrderMapper.updateEqOrder(classOrder);
	}

	@Override
	public List<EqOrder> TotalBystatus() {
		return eqOrderMapper.TotalBystatus();
	}

	@Override
	public List<EqOrder> TotalByEq() {
		return eqOrderMapper.TotalByEq();
	}

	@Override
	public List<EqOrder> TotalByEqBegin() {
		return eqOrderMapper.TotalByEqBegin();
	}
}
