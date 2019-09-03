package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.ManufacturerNumberService;
import zygh.yfb.wxy.vo.ManufacturerNumber;


/**
 * 厂商编号表
 * @author 王喜亚
 *
 */

@Controller
public class ManufacturerNumberController {
	
	@Autowired
	private ManufacturerNumberService manufacturerNumberService;
	
	//查询
	@RequestMapping("/queryManufacturerNumber")
	public void queryManufacturerNumber(ManufacturerNumber manufacturerNumber,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<ManufacturerNumber> manufacturerNumberList = manufacturerNumberService.findManufacturerNumber(manufacturerNumber);
			JSONArray jsay=JSONArray.fromObject(manufacturerNumberList);
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
	@RequestMapping("/addManufacturerNumber")
	public void addManufacturerNumber(ManufacturerNumber manufacturerNumber,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = manufacturerNumber.getManufacturerId();
			String dm = daima.replace(" ", "");
			String shuoming = manufacturerNumber.getmExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				manufacturerNumberService.addManufacturerNumber(manufacturerNumber);
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
	@RequestMapping("/deleteManufacturerNumber")
	public void deleteManufacturerNumber(Integer[] sysIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			manufacturerNumberService.deleteManufacturerNumber(sysIds);
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
	@RequestMapping("/updateManufacturerNumber")
	public void updateManufacturerNumber(ManufacturerNumber manufacturerNumber,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = manufacturerNumber.getManufacturerId();
			String dm = daima.replace(" ", "");
			String shuoming = manufacturerNumber.getmExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				manufacturerNumberService.updateManufacturerNumber(manufacturerNumber);
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
