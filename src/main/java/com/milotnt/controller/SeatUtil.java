package com.milotnt.controller;


import java.awt.Choice;
// 两个定时器
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.milotnt.pojo.EqOrder;
import com.milotnt.pojo.Equipment;
import com.milotnt.service.EqOrderService;
import com.milotnt.service.EquipmentService;


//@Component
@Controller
public class SeatUtil {
	@Autowired
	private EqOrderService eEqOrderService;
    @Autowired
    private EquipmentService equipmentService;

	//每天晚上11点生成后天的所有座位信息
	
	@Scheduled(cron = "0 0 13 * * ?")  //每天晚上23点运行一次  生成所有新的座位
	public void generateNextDay(){
		addNewSeat(1);
	}
	
	public void addNewSeat(int offset){
		try {
			String times[] = {"08点-12点","14点-18点","18点-22点"};   //三个时间段
			Date today = new Date();  //今天日期Date类型
			Date dayAfterTomorrow = getNextNextDay(today,offset); //后面的参数表示与今天的间隔，如1表示明天，2表示后天
			String date = new SimpleDateFormat("yyyy-MM-dd").format(dayAfterTomorrow);  //后天日期yyy-MM-dd string类型
			Map<String,String> params=new HashMap<String,String>();
	    	params.put("equipmentStatus", "正常");
	        List<Equipment> equipmentList = equipmentService.findAllForUser(params);
			for(int i=0;i<times.length;i++){               // 三个时间段
				String time = times[i];
				for(int j=0;j<equipmentList.size();j++){         //所有的房间
					Equipment room = equipmentList.get(j);
					int roomid = room.getEquipmentId();
					EqOrder eqOrder=new EqOrder();
					eqOrder.setEqId(roomid);
					eqOrder.setEqName(room.getEquipmentName());
					eqOrder.setCoach(room.getEquipmentTime());
					eqOrder.setEqBegin(time);
					eqOrder.setEqdate(date);
					eqOrder.setStatus("未预约");
					eEqOrderService.insertEqOrder(eqOrder);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 在浏览器输入http://127.0.0.1:8080/LibrarySeats/newSeat.htm即可手动生成座位数
	@RequestMapping("newSeat")
	@ResponseBody
	public String today(){
		//线程  点击-开启一个线程-new Runnable 方法重写两种方式    让你一天只走一个线程
		//new Task()  第一是自定义时间杀死进程   第二关闭服务杀死进程
		Thread thread = new Thread(new Task());
		thread.start();
		return "开始创建当日可预约信息，请不要重复运行，观察控制台运行，停止后可以登录后台查看可预约信息！";
	}
	
	// 获取后天日期
	public static Date getNextNextDay(Date date,int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		date = calendar.getTime();
		return date;
	}
	
	
	
	
	
	
	// 每天的08，14，18即三个时间段的开始时间 运行一次，将之前的占座取消
//	@Scheduled(cron = "0 0 8,14,18 * * ?") 
//	public void updateChoice(){
//		try {
//			String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//			Choice choice = new Choice();
//			choice.setTime(now);
//			choiceService.modifyChoice(choice);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//	}
	
	public class Task implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			addNewSeat(0);
		}
		
	}

	
}
