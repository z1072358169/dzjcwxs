package zygh.yfb.wxy.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import zygh.yfb.wxy.service.SblukouService;
import zygh.yfb.wxy.vo.Sblukou;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 
 * @author 王喜亚
 *
 */
@Controller
public class SblukouController {
	@Autowired
	private SblukouService sblukouService;
	
	//查询路口信息
		@RequestMapping("/querySblukou")
		public void querySblukou(Sblukou sblukou,HttpServletResponse response)throws Exception{
			try {
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setContentType("text/html;charset=utf-8");
				List<Sblukou> sblukouList = sblukouService.findSblukou(sblukou);
				JSONArray jsay=JSONArray.fromObject(sblukouList);
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
				msg="失败";
				response.getWriter().print(msg);
			}
		}
		
		//添加路口
		@RequestMapping("/addSblukouSubmit")
		public void addSblukouSubmit(Sblukou sblukou,HttpServletResponse response) throws Exception{
			try {
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setContentType("text/html;charset=utf-8");
				sblukouService.addSblukou(sblukou);
				String msg = "";
				msg="成功";
				response.getWriter().print(msg);
			}catch (Exception e){
				String msg = "";
				msg="失败";
				response.getWriter().print(msg);
			}

		}
		
		//删除路口
		@RequestMapping("/deleteSblukouList")
		public void deleteSblukouList(Integer[] SBBHs,HttpServletResponse response)throws Exception{
			try {
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setContentType("text/html;charset=utf-8");
				sblukouService.deleteSblukou(SBBHs);
				String msg = "";
				msg="成功";
				response.getWriter().print(msg);
			}catch (Exception e){
				String msg = "";
				msg="失败";
				response.getWriter().print(msg);
			}
		}

		//修改路口
		@RequestMapping("/updateSblukouSubmit")
		public void updateSblukouSubmit(Sblukou sblukou,HttpServletResponse response)throws Exception{
			try {
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setContentType("text/html;charset=utf-8");
				sblukouService.updateSblukou(sblukou);
				String msg = "";
				msg="成功";
				response.getWriter().print(msg);
			}catch (Exception e){
				String msg = "";
				msg="失败";
				response.getWriter().print(msg);
			}
			
		}
}
