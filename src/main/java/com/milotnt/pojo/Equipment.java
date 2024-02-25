package com.milotnt.pojo;

import lombok.Data;

//@Data
public class Equipment {

    private Integer equipmentId;//器材id
    private String equipmentName;//名称
    private String equipmentLocation;//位置
    private String equipmentStatus;//状态
    private String equipmentMessage;//备注信息
    private String equipmentTime;


    public Equipment() {
    }

    public Equipment(Integer equipmentId, String equipmentName, String equipmentLocation, String equipmentStatus, String equipmentMessage) {
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.equipmentLocation = equipmentLocation;
        this.equipmentStatus = equipmentStatus;
        this.equipmentMessage = equipmentMessage;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentLocation() {
        return equipmentLocation;
    }

    public void setEquipmentLocation(String equipmentLocation) {
        this.equipmentLocation = equipmentLocation;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getEquipmentMessage() {
        return equipmentMessage;
    }

    public void setEquipmentMessage(String equipmentMessage) {
        this.equipmentMessage = equipmentMessage;
    }

	public String getEquipmentTime() {
		return equipmentTime;
	}

	public void setEquipmentTime(String equipmentTime) {
		this.equipmentTime = equipmentTime;
	}


}
