package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.SbBhService;
import zygh.yfb.wxy.vo.SbBh;


/**
 * 设备编号
 * @author 王喜亚
 *
 */

@Controller
public class SbBhController {
	
	@Autowired
	private SbBhService sbbhService;
	
	//查询
	@RequestMapping("/querySbBh")
	public void querySbBh(SbBh sbbh,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<SbBh> sbBhL = sbbhService.findSbBh(sbbh);
			JSONArray jsay=JSONArray.fromObject(sbBhL);
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
	@RequestMapping("/addSbBh")
	public void addSbBh(SbBh sbbh,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = sbbh.getHxsbbh();
			String dm = daima.replace(" ", "");
			String shuoming = sbbh.getArea();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				sbbhService.addSbBh(sbbh);
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
	@RequestMapping("/deleteSbBh")
	public void deleteSbBh(Integer[] sysids,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			sbbhService.deleteSbBh(sysids);
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
	@RequestMapping("/updateSbBh")
	public void updateSbBh(SbBh sbbh,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = sbbh.getHxsbbh();
			String dm = daima.replace(" ", "");
			String shuoming = sbbh.getArea();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				sbbhService.updateSbBh(sbbh);
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
