package com.milotnt.service;

import com.milotnt.pojo.Equipment;

import java.util.List;
import java.util.Map;



public interface EquipmentService {

    //查询所有器械
    List<Equipment> findAll();
    List<Equipment> findAllForUser(Map<String,String> params);

    //根据id删除器械
    Boolean deleteByEquipmentId(Integer equipmentId);

    //添加器材
    Boolean insertEquipment(Equipment equipment);

    //修改器械信息
    Boolean updateEquipmentByEquipmentId(Equipment equipment);

    //根据id查询器械
    List<Equipment> selectByEquipmentId(Integer equipmentId);

    //查询器械总数
    Integer selectTotalCount();

}
