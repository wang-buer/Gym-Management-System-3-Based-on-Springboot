package com.milotnt.controller;

import com.milotnt.pojo.Notice;
import com.milotnt.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //查询通知公告
    @RequestMapping("/selNotice")
    public String selectNotice(Model model, HttpSession session) {
        List<Notice> noticeList = noticeService.findAll();
        session.setAttribute("noticeList", noticeList);
        model.addAttribute("noticeList", noticeList);
        return "selectNotice";
    }

    //查询课程
    @RequestMapping("/selNotice3")
    public String selectNotice3(Model model, HttpSession session) {
    	List<Notice> noticeList = noticeService.findAll();
    	session.setAttribute("noticeList", noticeList);
    	model.addAttribute("noticeList", noticeList);
    	return "selectNotice3";
    }
    //查询通知公告
    @RequestMapping("/selNotice2")
    public String selectNotice2(Model model, HttpSession session) {
    	List<Notice> noticeList = noticeService.findAll();
    	session.setAttribute("noticeList", noticeList);
    	model.addAttribute("noticeList", noticeList);
    	return "selectNotice2";
    }

    //删除通知公告
    @RequestMapping("/delNotice2")
    public String deleteNotice2(Integer noticeId) {
        noticeService.deleteByNoticeId(noticeId);
        return "redirect:selNotice3";
    }
//    @RequestMapping("/delNotice2")
//    public String deleteNotice2(Integer id) {
//        noticeService.deleteByNoticeId(id);
//        return "redirect:selNotice3";
//    }

    //跳转修改通知公告
    @RequestMapping("/toUpdateNotice2")
    public String toUpdateNotice2(Integer noticeId, Model model) {
        List<Notice> noticeList = noticeService.selectByNoticeId(noticeId);
        model.addAttribute("noticeList", noticeList);
        return "updateNotice2";
    }

    //修改通知公告
    @RequestMapping("/updateNotice2")
    public String updateNotice2(Notice notice) {
        noticeService.updateNoticeByNoticeId(notice);
        return "redirect:selNotice3";
    }

    //跳转新增通知公告页面
    @RequestMapping("/toAddNotice2")
    public String toAddNotice2() {
        return "addNotice2";
    }

    //新增通知公告
    @RequestMapping("/addNotice2")
    public String addNotice2(Notice notice) {
        noticeService.insertNotice(notice);
        return "redirect:selNotice3";
    }
    //删除通知公告
    @RequestMapping("/delNotice")
    public String deleteNotice(Integer id) {
    	noticeService.deleteByNoticeId(id);
    	return "redirect:selNotice";
    }
    
    //跳转修改公告页面
    @RequestMapping("/toUpdateNotice")
    public String toUpdateNotice(Integer noticeId, Model model) {
    	List<Notice> noticeList = noticeService.selectByNoticeId(noticeId);
    	model.addAttribute( "noticeList", noticeList);
    	return "updateNotice";
    }
    
    //修改通知公告
    @RequestMapping("/updateNotice")
    public String updateNotice(Notice notice) {
    	noticeService.updateNoticeByNoticeId(notice);
    	return "redirect:selNotice";
    }
    
    //跳转新增通知公告页面
    @RequestMapping("/toAddNotice")
    public String toAddNotice() {
    	return "addNotice";
    }
    
    //新增通知公告
    @RequestMapping("/addNotice")
    public String addNotice(Notice notice) {
    	noticeService.insertNotice(notice);
    	return "redirect:selNotice";
    }

}
