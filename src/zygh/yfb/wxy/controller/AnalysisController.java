package zygh.yfb.wxy.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import util.ResultVoUtil;
import zygh.yfb.wxy.service.AnalysisService;
import zygh.yfb.wxy.service.ReasonsTypeService;
import zygh.yfb.wxy.vo.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 
 * @author 王喜亚
 *
 */
@Controller
public class AnalysisController {
	@Autowired
	private AnalysisService analysisService;

	@Autowired
	private ReasonsTypeService reasonsTypeService;
	
	//查询部门信息
	@RequestMapping("/querywxywxy")
	public void querywxywxy(HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<Analysis> sectorsList = analysisService.findAnalysis();
			JSONArray jsay=JSONArray.fromObject(sectorsList);
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
			msg="失败";
			response.getWriter().print(msg);
		}
	}

	//查询信息
	@RequestMapping("/findAnalysisAndType")
	public void findAnalysisAndType(HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<ReasonsTj> reasonsTjList = analysisService.findAnalysisAndType();

			Set<String> setlist=new HashSet<String>();
			for (int i = 0; i < reasonsTjList.size(); i++) {
				setlist.add(reasonsTjList.get(i).getRiqi());
			}
			JSONArray jsonArray222 = new JSONArray();
			for (String set : setlist){
				JSONObject jsonObject2 = new JSONObject();
				JSONArray jsonArray = new JSONArray();
				for (int j = 0; j < reasonsTjList.size(); j++) {
					if (set.equals(reasonsTjList.get(j).getRiqi())){
						JSONObject jsonObject1 = JSONObject.fromObject(reasonsTjList.get(j));
						jsonArray.add(jsonObject1);
					}
				}
				jsonObject2.put("rq", set);
				jsonObject2.put("data", jsonArray);
				jsonArray222.add(jsonObject2);
			}
			JSONArray jsay=JSONArray.fromObject(reasonsTjList);
			PrintWriter p=null;
			try {
				p=response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(jsonArray222!=null){
				p.print(jsonArray222);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="失败";
			response.getWriter().print(msg);
		}
	}


	//查询信息-----------------------------
	@RequestMapping("/fndtest")
	public void fndtest(Analysis analysis,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");

			ReasonsType reasonsType = new ReasonsType();
			reasonsType.setWFDM(analysis.getWFDM());
			//先通过WFDM查出所有的原因分类
			List<ReasonsType> reasonsTypeList = reasonsTypeService.findReasonsType(reasonsType);
			System.out.println("1208的原因分类:"+reasonsTypeList);

			JSONArray jsonArrayall = new JSONArray();
			for (int i = 0; i < reasonsTypeList.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				analysis.setReasonsTypeId(reasonsTypeList.get(i).getReasonsTypeId());
				List<ReasonsTj> reasonsTjList = analysisService.findtest(analysis);
				JSONArray jsonArray = JSONArray.fromObject(reasonsTjList);
				if (jsonArray == null || jsonArray.size() == 0){
					continue;
				}
				jsonObject.put("fl", reasonsTypeList.get(i).getReasonType());
				jsonObject.put("data", jsonArray);
				jsonArrayall.add(jsonObject);
			}
			PrintWriter p=null;
			try {
				p=response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(jsonArrayall!=null){
				p.print(jsonArrayall);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="失败";
			response.getWriter().print(msg);
		}
	}

	//查询部门信息
	@RequestMapping("/findifadd")
	@ResponseBody
	public RestultVo findifadd(Analysis analysis, HttpServletResponse response)throws Exception{
		RestultVo restultVo = new RestultVo();
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<Analysis> analysis1 = analysisService.findifadd(analysis);
			System.out.println(analysis1);
			if (analysis1.isEmpty() && analysis1.size() == 0) {
				restultVo.setCode(1);
				restultVo.setMsg("未分析");
				return restultVo;
			}else{
				restultVo.setCode(0);
				restultVo.setMsg("已分析");
				restultVo.setData(analysis1);
				return restultVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
			restultVo.setCode(2);
			restultVo.setMsg("失败");
			return restultVo;
		}
	}

	//添加路口
	@RequestMapping("/insertAnalysis")
	public void insertAnalysis(Analysis analysis, HttpServletResponse response) throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			/*analysis.setReasonsId(1);
			analysis.setReasonsTypeId(1);
			analysis.setCJSJ("2019-04-09 04:06:09");
			analysis.setSysid(165879);
			analysis.setScreening("1");
			analysis.setWFDM("1208");*/
			analysisService.insertAnalysis(analysis);
			String msg = "";
			msg="成功";
			response.getWriter().print(msg);
		}catch (Exception e){
			String msg = "";
			msg="失败";
			response.getWriter().print(msg);
		}
	}

	//修改
	@RequestMapping("/updateAnalysis")
	public void updateAnalysis(Analysis analysis, HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			analysisService.updateAnalysis(analysis);
			String msg = "";
			msg="成功";
			response.getWriter().print(msg);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
	}

}
