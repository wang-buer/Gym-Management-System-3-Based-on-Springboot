package com.milotnt.pojo;

import lombok.Data;

//@Data
public class EqOrder {

    private Integer eqOrderId;
    private Integer eqId;//场所或设备预约id
    private String eqName;//名称
    private String coach;//费用
    private String memberName;//预约人姓名
    private Integer memberAccount;//预约人账号
    private String eqBegin;//状态
    private String eqdate;//时段
    private String status;//操作

    public Integer getEqOrderId() {
		return eqOrderId;
	}


	public void setEqOrderId(Integer eqOrderId) {
		this.eqOrderId = eqOrderId;
	}


	public Integer getEqId() {
		return eqId;
	}


	public void setEqId(Integer eqId) {
		this.eqId = eqId;
	}


	public String getEqName() {
		return eqName;
	}


	public void setEqName(String eqName) {
		this.eqName = eqName;
	}


	public String getEqBegin() {
		return eqBegin;
	}


	public void setEqBegin(String eqBegin) {
		this.eqBegin = eqBegin;
	}


	public EqOrder() {
    }


    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(Integer memberAccount) {
        this.memberAccount = memberAccount;
    }


	public String getEqdate() {
		return eqdate;
	}


	public void setEqdate(String eqdate) {
		this.eqdate = eqdate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


}
