package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.PlateColorService;
import zygh.yfb.wxy.vo.PlateColor;


/**
 * 号牌颜色表
 * @author 王喜亚
 *
 */

@Controller
public class PlateColorController {
	
	@Autowired
	private PlateColorService plateColorService;
	
	//查询
	@RequestMapping("/queryPlateColor")
	public void queryPlateColor(PlateColor plateColor,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<PlateColor> plateColorList = plateColorService.findPlateColor(plateColor);
			JSONArray jsay=JSONArray.fromObject(plateColorList);
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
	@RequestMapping("/addPlateColor")
	public void addPlateColor(PlateColor plateColor,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = plateColor.getLicensePlateColor();
			String dm = daima.replace(" ", "");
			String shuoming = plateColor.getpExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				plateColorService.addPlateColor(plateColor);
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
	@RequestMapping("/deletePlateColor")
	public void deletePlateColor(Integer[] sysIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			plateColorService.deletePlateColor(sysIds);
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
	@RequestMapping("/updatePlateColor")
	public void updatePlateColor(PlateColor plateColor,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = plateColor.getLicensePlateColor();
			String dm = daima.replace(" ", "");
			String shuoming = plateColor.getpExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				plateColorService.updatePlateColor(plateColor);
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
