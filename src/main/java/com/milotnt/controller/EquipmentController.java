package com.milotnt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milotnt.pojo.Equipment;
import com.milotnt.service.EquipmentService;



@Controller
@RequestMapping("/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    //查询器材
    @RequestMapping("/selEquipment")
    public String selectEquipment(Model model, HttpSession session) {
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipment";
    }
    
    //查询器材
    @RequestMapping("/selEquipmentForUser")
    public String selEquipmentForUser(Model model, HttpSession session) {
    	Map<String,String> params=new HashMap<String,String>();
    	params.put("equipmentStatus", "正常");
        List<Equipment> equipmentList = equipmentService.findAll();
        session.setAttribute("equipmentList", equipmentList);
        model.addAttribute("equipmentList", equipmentList);
        return "selectEquipmentForUser";
    }


    //删除器材
    @RequestMapping("/delEquipment")
    public String deleteEquipment(Integer equipmentId) {
        equipmentService.deleteByEquipmentId(equipmentId);
        return "redirect:selEquipment";
    }

    //跳转修改器材页面
    @RequestMapping("/toUpdateEquipment")
    public String toUpdateEquipment(Integer equipmentId, Model model) {
        List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
        model.addAttribute("equipmentList", equipmentList);
        return "updateEquipment";
    }

    //跳转修改器材页面
    @RequestMapping("/toYuyueEquipment")
    public String toYuyueEquipment(Integer equipmentId, Model model) {
    	List<Equipment> equipmentList = equipmentService.selectByEquipmentId(equipmentId);
    	model.addAttribute("equipmentList", equipmentList);
    	return "yuyueEquipment";
    }


    //修改器材
    @RequestMapping("/updateEquipment")
    public String updateEquipment(Equipment equipment) {
        equipmentService.updateEquipmentByEquipmentId(equipment);
        return "redirect:selEquipment";
    }

    //跳转新增器材页面
    @RequestMapping("/toAddEquipment")
    public String toAddEquipment() {
        return "addEquipment";
    }

    //新增器材
    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment) {
    	equipment.setEquipmentStatus("正常");
        equipmentService.insertEquipment(equipment);
        return "redirect:selEquipment";
    }

}
