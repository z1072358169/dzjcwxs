package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import enums.UploadStatusEnum;
import zygh.yfb.wxy.service.IllegalBehaviorService;
import zygh.yfb.wxy.vo.IllegalBehavior;


/**
 * 违法行为
 * @author 王喜亚
 *
 */

@Controller
public class IllegalBehaviorController {
	
	@Autowired
	private IllegalBehaviorService illegalBehaviorService;
	
	//查询
	@RequestMapping("/queryIllegalBehavior")
	public void queryIllegalBehavior(IllegalBehavior illegalBehavior,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<IllegalBehavior> illegalBehaviorList = illegalBehaviorService.findIllegalBehavior(illegalBehavior);
			JSONArray jsay=JSONArray.fromObject(illegalBehaviorList);
			response.setContentType("text/html;charset=UTF-8");
			  PrintWriter p=null;
	          try {
				 p=response.getWriter();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  if(jsay!=null){
				  p.print(jsay);
			  }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "";
			msg="查询失败";
			response.getWriter().print(msg);
		}
	}
	
	//添加
	@RequestMapping("/addIllegalBehavior")
	public void addIllegalBehavior(IllegalBehavior illegalBehavior,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = illegalBehavior.getIllegal_number();
			String dm = daima.replace(" ", "");
			String shuoming = illegalBehavior.getIllegal_explanation();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				illegalBehaviorService.addIllegalBehavior(illegalBehavior);
				String msg = "";
				msg="添加成功";
				response.getWriter().print(msg);
			}else {
				String msg = "";
				msg="参数为空格";
				response.getWriter().print(msg);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
			
	}
	
	//删除
	@RequestMapping("/deleteIllegalBehavior")
	public void deleteIllegalBehavior(Integer[] sysIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			illegalBehaviorService.deleteIllegalBehavior(sysIds);
			String msg = "";
			msg="1";
			response.getWriter().print(msg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "";
			msg="删除失败";
			response.getWriter().print(msg);
		}
	}
	
	//修改
	@RequestMapping("/updateIllegalBehavior")
	public void updateIllegalBehavior(IllegalBehavior illegalBehavior,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = illegalBehavior.getIllegal_number();
			String dm = daima.replace(" ", "");
			String shuoming = illegalBehavior.getIllegal_explanation();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				illegalBehaviorService.updateIllegalBehavior(illegalBehavior);
				String msg = "";
				msg="修改成功";
				response.getWriter().print(msg);
			}else {
				String msg = "";
				msg="参数为空格";
				response.getWriter().print(msg);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
		
	}
	
}
