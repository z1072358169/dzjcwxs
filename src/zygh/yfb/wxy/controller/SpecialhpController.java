package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.SpecialhpService;
import zygh.yfb.wxy.vo.Specialhp;


/**
 * 特殊车辆
 * @author 王喜亚
 *
 */

@Controller
public class SpecialhpController {
	
	@Autowired
	private SpecialhpService specialhpService;
	
	//查询
	@RequestMapping("/querySpecialhp")
	public void querySpecialhp(Specialhp specialhp,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<Specialhp> specialhpList = specialhpService.findAll(specialhp);
			JSONArray jsay=JSONArray.fromObject(specialhpList);
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
	@RequestMapping("/addSpecialhp")
	public void addSpecialhp(Specialhp specialhp,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			specialhpService.addHp(specialhp);
			String msg = "";
			msg="添加成功";
			response.getWriter().print(msg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
			
	}
	
	//删除
	@RequestMapping("/deleteSpecialhp")
	public void deleteSpecialhp(Integer[] ids,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			specialhpService.deleteSpecialhp(ids);
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
	@RequestMapping("/updateSpecialhp")
	public void updateSpecialhp(Specialhp specialhp,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			specialhpService.updateSpecialhp(specialhp);
			String msg = "";
			msg="修改成功";
			response.getWriter().print(msg);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
		
	}
	
}
