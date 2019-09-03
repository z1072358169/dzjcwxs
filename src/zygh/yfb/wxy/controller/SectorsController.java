package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.SectorsService;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.Sectors;

/**
 * 
 * @author 王喜亚
 *
 */
@Controller
public class SectorsController {
	@Autowired
	private SectorsService sectorsService;
	
	//查询部门信息
		@RequestMapping("/querysectors")
		public void querysectors(Sectors sectors,HttpServletResponse response)throws Exception{
			try {
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setContentType("text/html;charset=utf-8");
				List<Sectors> sectorsList = sectorsService.findSectors(sectors);
				JSONArray jsay=JSONArray.fromObject(sectorsList);
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
		
		//添加部门
		@RequestMapping("/addSectorsSubmit")
		public void addSectorsSubmit(Sectors sectors,HttpServletResponse response) throws Exception{
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			/*String time=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			int random=(int) (Math.random()*10000);
			Sectors.setApplyNum(time+random);
			Sectors.setDhDate(time);
			Sectors.setPurchaseDate(time);*/
			sectorsService.addSectors(sectors);
			String msg = "";
			msg="1";
			response.getWriter().print(msg);
		}
		
		//删除部门
		@RequestMapping("/deleteSectorsList")
		public void deleteSectorsList(Integer[] sectorsNums,HttpServletResponse response)throws Exception{
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			sectorsService.deleteSectors(sectorsNums);
			String msg = "";
			msg="1";
			response.getWriter().print(msg);
		}
		//与修改部门
		@RequestMapping("/preUpdateSectors")
		public void preUpdateSectors(Integer sectorsNum,HttpServletResponse response)throws Exception{
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			Sectors sectors = sectorsService.findSectorsByNum(sectorsNum);
			JSONObject sectors1 = JSONObject.fromObject(sectors); 
			response.setContentType("text/html;charset=UTF-8");
			  PrintWriter p=null;
	          try {
				 p=response.getWriter();
				 

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  if(sectors1!=null){
				  p.print(sectors1);
				  System.out.println(sectors1);
			  }
			  
		}
		//修改部门
		@RequestMapping("/updateSectorsSubmit")
		public void updateSectorsSubmit(Sectors sectors,HttpServletResponse response)throws Exception{
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			sectorsService.updateSectors(sectors);
			String msg = "";
			msg="1";
			response.getWriter().print(msg);
			
		}
}
