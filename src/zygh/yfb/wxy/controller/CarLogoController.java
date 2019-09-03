package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.CarLogoService;
import zygh.yfb.wxy.vo.CarLogo;


/**
 * 车标表
 * @author 王喜亚
 *
 */

@Controller
public class CarLogoController {
	
	@Autowired
	private CarLogoService carLogoService;
	
	//查询
	@RequestMapping("/queryCarLogo")
	public void queryCarLogo(CarLogo carLogo,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<CarLogo> carLogoList = carLogoService.findCarLogo(carLogo);
			JSONArray jsay=JSONArray.fromObject(carLogoList);
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
	@RequestMapping("/addCarLogo")
	public void addCarLogo(CarLogo carLogo,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = carLogo.getcCode();
			String dm = daima.replace(" ", "");
			String shuoming = carLogo.getcExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				carLogoService.addCarLogo(carLogo);
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
	@RequestMapping("/deleteCarLogo")
	public void deleteCarLogo(Integer[] sysIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			carLogoService.deleteCarLogo(sysIds);
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
	@RequestMapping("/updateCarLogo")
	public void updateCarLogo(CarLogo carLogo,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = carLogo.getcCode();
			String dm = daima.replace(" ", "");
			String shuoming = carLogo.getcExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				carLogoService.updateCarLogo(carLogo);
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
