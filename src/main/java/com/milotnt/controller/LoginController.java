package com.milotnt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.milotnt.pojo.Admin;
import com.milotnt.pojo.Employee;
import com.milotnt.pojo.Member;
import com.milotnt.service.AdminService;
import com.milotnt.service.EmployeeService;
import com.milotnt.service.EquipmentService;
import com.milotnt.service.MemberService;


@Controller
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EquipmentService equipmentService;

    //主页、跳转管理员登录页面
    @RequestMapping("/")
    public String toAdminLogin() {
        return "adminLogin";
    }

    //跳转会员登录页面
    @RequestMapping("/toUserLogin")
    public String toUserLogin() {
        return "userLogin";
    }

    //跳转员工登录页面
    @RequestMapping("/toEmployeeLogin")
    public String toEmployeeLogin() {
        return "employeeLogin";
    }

//获取session中的account
    public final String getAccountFromSession(HttpSession session) {
        return session.getAttribute("account").toString();
    }

    //管理员登录
    @RequestMapping("/adminLogin")
    public String adminLogin(Admin admin, Model model, HttpSession session) {
//调用业务对象执行管理员登录功能，并获取返回值
        Admin admin1 = adminService.adminLogin(admin);

        if (admin1 != null) {
//            向session对象中完成数据的绑定（全局的）
//            model.addAttribute("account", admin1.getAdminAccount());

//            在session对象中完成数据的绑定（全局的）
            session.setAttribute("account", admin1.getAdminAccount());
            System.out.println(getAccountFromSession(session));

            //会员人数
            Integer memberTotal = memberService.selectTotalCount();
            model.addAttribute("memberTotal", memberTotal);
            session.setAttribute("memberTotal", memberTotal);

            //员工人数
            Integer employeeTotal = employeeService.selectTotalCount();
            model.addAttribute("employeeTotal", employeeTotal);
            session.setAttribute("employeeTotal", employeeTotal);

            //健身房总人数
            Integer humanTotal = memberTotal + employeeTotal;
            model.addAttribute("humanTotal", humanTotal);
            session.setAttribute("humanTotal", humanTotal);

            //器材数
            Integer equipmentTotal = equipmentService.selectTotalCount();
            model.addAttribute("equipmentTotal", equipmentTotal);
            session.setAttribute("equipmentTotal", equipmentTotal);

            return "adminMain";
//            return "redirect:/adminMain.html";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入!");
        return "adminLogin";
    }

    //会员登录
    @RequestMapping("/userLogin")
    public String userLogin(Member member, Model model, HttpSession session) {
        Member member1 = memberService.userLogin(member);
        if (member1 != null) {
            model.addAttribute("member", member1);
            session.setAttribute("user", member1);
            return "userMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入!");
        return "userLogin";
    }

    //员工登录
    @RequestMapping("/employeeLogin")
    public String employeeLogin(Employee employee, Model model, HttpSession session) {
        Employee member1 = employeeService.selectByAccountAndPassword(employee);
        if (member1 != null) {
            model.addAttribute("employee", member1);
            session.setAttribute("employee", member1);
            return "employeeMain";
        }
        model.addAttribute("msg", "您输入的账号或密码有误，请重新输入!");
        return "employeeLogin";
    }

    //跳转管理员主页
//    @RequestMapping("/toAdminMain")
//    public String toAdminMain(Model model, HttpSession session) {
//        Integer memberTotal = (Integer) session.getAttribute("memberTotal");
//        Integer employeeTotal = (Integer) session.getAttribute("employeeTotal");
//        Integer humanTotal = (Integer) session.getAttribute("humanTotal");
//        Integer equipmentTotal = (Integer) session.getAttribute("equipmentTotal");
//        model.addAttribute("memberTotal", memberTotal);
//        model.addAttribute("employeeTotal", employeeTotal);
//        model.addAttribute("humanTotal", humanTotal);
//        model.addAttribute("equipmentTotal", equipmentTotal);
//        return "adminMain";
//    }

    //跳转会员主页
    @RequestMapping("/toUserMain")
    public String toUserMain(Model model, HttpSession session) {
        Member member = (Member) session.getAttribute("user");
        model.addAttribute("member", member);
        return "userMain";
    }

}
