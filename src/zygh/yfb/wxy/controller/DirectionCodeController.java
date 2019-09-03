package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.DirectionCodeService;
import zygh.yfb.wxy.vo.DirectionCode;


/**
 * 方向编码表
 * @author 王喜亚
 *
 */

@Controller
public class DirectionCodeController {
	
	@Autowired
	private DirectionCodeService directionCodeService;
	
	//查询
	@RequestMapping("/queryDirectionCode")
	public void queryDirectionCode(DirectionCode directionCode,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<DirectionCode> directionCodeList = directionCodeService.findDirectionCode(directionCode);
			JSONArray jsay=JSONArray.fromObject(directionCodeList);
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
	@RequestMapping("/addDirectionCode")
	public void addDirectionCode(DirectionCode directionCode,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = directionCode.getDirectionNum();
			String dm = daima.replace(" ", "");
			String shuoming = directionCode.getdExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				directionCodeService.addDirectionCode(directionCode);
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
	@RequestMapping("/deleteDirectionCode")
	public void deleteDirectionCode(Integer[] sysIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			directionCodeService.deleteDirectionCode(sysIds);
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
	@RequestMapping("/updateDirectionCode")
	public void updateDirectionCode(DirectionCode directionCode,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = directionCode.getDirectionNum();
			String dm = daima.replace(" ", "");
			String shuoming = directionCode.getdExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				directionCodeService.updateDirectionCode(directionCode);
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
