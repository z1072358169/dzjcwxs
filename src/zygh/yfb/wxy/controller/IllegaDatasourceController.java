package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.IllegaDatasourceService;
import zygh.yfb.wxy.vo.IllegaDatasource;


/**
 * 违法数据来源表
 * @author 王喜亚
 *
 */

@Controller
public class IllegaDatasourceController {
	
	@Autowired
	private IllegaDatasourceService illegaDatasourceService;
	
	//查询
	@RequestMapping("/queryIllegaDatasource")
	public void queryIllegaDatasource(IllegaDatasource illegaDatasource,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<IllegaDatasource> illegaDatasourceList = illegaDatasourceService.findIllegaDatasource(illegaDatasource);
			JSONArray jsay=JSONArray.fromObject(illegaDatasourceList);
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
	@RequestMapping("/addIllegaDatasource")
	public void addIllegaDatasource(IllegaDatasource illegaDatasource,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = illegaDatasource.getIllegal_D_D();
			String dm = daima.replace(" ", "");
			String shuoming = illegaDatasource.getiExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				illegaDatasourceService.addIllegaDatasource(illegaDatasource);
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
	@RequestMapping("/deleteIllegaDatasource")
	public void deleteIllegaDatasource(Integer[] sysIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			illegaDatasourceService.deleteIllegaDatasource(sysIds);
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
	@RequestMapping("/updateIllegaDatasource")
	public void updateIllegaDatasource(IllegaDatasource illegaDatasource,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = illegaDatasource.getIllegal_D_D();
			String dm = daima.replace(" ", "");
			String shuoming = illegaDatasource.getiExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				illegaDatasourceService.updateIllegaDatasource(illegaDatasource);
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
