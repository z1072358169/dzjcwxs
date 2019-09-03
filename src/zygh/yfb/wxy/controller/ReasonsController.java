package zygh.yfb.wxy.controller;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zygh.yfb.wxy.service.ReasonsService;
import zygh.yfb.wxy.vo.Reasons;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * 电警数据作废原因
 * @author 王喜亚
 *
 */

@Controller
public class ReasonsController {
	
	@Autowired
	private ReasonsService reasonsService;
	
	//查询
	@RequestMapping("/findReasons")
	public void findReasons(Reasons reasons,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<Reasons> reasonsList = reasonsService.findReasons(reasons);
			JSONArray jsay=JSONArray.fromObject(reasonsList);
			  PrintWriter p=null;
	          try {
				 p=response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  if(jsay!=null){
				  p.print(jsay);
			  }
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="查询失败";
			response.getWriter().print(msg);
		}
	}
	
	//添加
	@RequestMapping("/insertReasons")
	public void insertReasons(Reasons reasons,HttpServletResponse response) throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			reasonsService.insertReasons(reasons);
			String msg = "";
			msg="添加成功";
			response.getWriter().print(msg);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
			
	}
	
	//删除
	@RequestMapping("/deleteReasons")
	public void deleteReasons(Integer[] ReasonsIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			reasonsService.deleteReasons(ReasonsIds);
			String msg = "";
			msg="1";
			response.getWriter().print(msg);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="删除失败";
			response.getWriter().print(msg);
		}
	}
	
	//修改
	@RequestMapping("/updateReasons")
	public void updateReasons(Reasons reasons,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			reasonsService.updateReasons(reasons);
			String msg = "";
			msg="修改成功";
			response.getWriter().print(msg);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
	}
	
}
