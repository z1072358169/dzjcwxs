package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.EvidenceTypeService;
import zygh.yfb.wxy.vo.EvidenceType;


/**
 * 证据类型
 * @author 王喜亚
 *
 */

@Controller
public class EvidenceTypeController {
	
	@Autowired
	private EvidenceTypeService evidenceTypeService;
	
	//查询
	@RequestMapping("/queryEvidenceType")
	public void queryEvidenceType(EvidenceType evidenceType,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<EvidenceType> evidenceTypeList = evidenceTypeService.findEvidenceType(evidenceType);
			JSONArray jsay=JSONArray.fromObject(evidenceTypeList);
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
	@RequestMapping("/addEvidenceType")
	public void addEvidenceType(EvidenceType evidenceType,HttpServletResponse response) throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = evidenceType.geteCode();
			String dm = daima.replace(" ", "");
			String shuoming = evidenceType.geteExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				evidenceTypeService.addEvidenceType(evidenceType);
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
	@RequestMapping("/deleteEvidenceType")
	public void deleteEvidenceType(Integer[] sysIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			evidenceTypeService.deleteEvidenceType(sysIds);
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
	@RequestMapping("/updateEvidenceType")
	public void updateEvidenceType(EvidenceType evidenceType,HttpServletResponse response)throws Exception{
		
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = evidenceType.geteCode();
			String dm = daima.replace(" ", "");
			String shuoming = evidenceType.geteExplain();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				evidenceTypeService.updateEvidenceType(evidenceType);
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
