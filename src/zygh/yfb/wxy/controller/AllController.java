package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zygh.yfb.wxy.service.CarBodyCService;
import zygh.yfb.wxy.service.CarLogoService;
import zygh.yfb.wxy.service.DataSourceService;
import zygh.yfb.wxy.service.DirectionCodeService;
import zygh.yfb.wxy.service.EvidenceTypeService;
import zygh.yfb.wxy.service.IllegaDatasourceService;
import zygh.yfb.wxy.service.IllegalBehaviorService;
import zygh.yfb.wxy.service.IntervalVMService;
import zygh.yfb.wxy.service.ManufacturerNumberService;
import zygh.yfb.wxy.service.PlateColorService;
import zygh.yfb.wxy.service.PlateTypeService;
import zygh.yfb.wxy.service.SbBhService;
import zygh.yfb.wxy.vo.CarBodyC;
import zygh.yfb.wxy.vo.CarLogo;
import zygh.yfb.wxy.vo.DataSource;
import zygh.yfb.wxy.vo.DirectionCode;
import zygh.yfb.wxy.vo.EvidenceType;
import zygh.yfb.wxy.vo.IllegaDatasource;
import zygh.yfb.wxy.vo.IllegalBehavior;
import zygh.yfb.wxy.vo.IntervalVM;
import zygh.yfb.wxy.vo.ManufacturerNumber;
import zygh.yfb.wxy.vo.PlateColor;
import zygh.yfb.wxy.vo.PlateType;
import zygh.yfb.wxy.vo.SbBh;

@Controller
public class AllController {
	
	@Autowired
	private CarBodyCService carBodyCService;
	
	@Autowired
	private CarLogoService carLogoService;
	
	@Autowired
	private DataSourceService dataSourceService;
	
	@Autowired
	private DirectionCodeService directionCodeService;
	
	@Autowired
	private EvidenceTypeService evidenceTypeService;
	
	@Autowired
	private IllegaDatasourceService illegaDatasourceService;
	
	@Autowired
	private IntervalVMService intervalVMService;
	
	@Autowired
	private ManufacturerNumberService manufacturerNumberService;
	
	@Autowired
	private PlateColorService plateColorService;
	
	@Autowired
	private PlateTypeService plateTypeService;
	
	@Autowired
	private IllegalBehaviorService illegalBehaviorService;
	
	@Autowired
	private SbBhService sbbhService;
	
	//查询
	@RequestMapping("/queryAll")
	public void queryAll(HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			//Map<Integer , List<Integer>> map = new HashMap<Integer , List<Integer>>(); 
			Map<String, List<Object>> map = new HashMap<String, List<Object>>();
			JSONObject json = new JSONObject();
			//号牌种类
			List<PlateType> plateTypeList = plateTypeService.findPlateType(null);
			json.put("PlateType", plateTypeList);
			//号牌颜色
			List<PlateColor> plateColorList = plateColorService.findPlateColor(null);
			json.put("PlateColor", plateColorList);
			//厂商编号
			List<ManufacturerNumber> manufacturerNumberList = manufacturerNumberService.findManufacturerNumber(null);
			json.put("ManufacturerNumber", manufacturerNumberList);
			//违法数据来源
			List<IllegaDatasource> illegaDatasourceList = illegaDatasourceService.findIllegaDatasource(null);
			json.put("IllegaDatasource", illegaDatasourceList);
			//数据来源
			List<DataSource> dataSourceList = dataSourceService.findDataSource(null);
			json.put("DataSource", dataSourceList);
			//车身颜色
			List<CarBodyC> carBodyCList = carBodyCService.findCarBodyC(null);
			json.put("CarBodyC", carBodyCList);
			//车标
			List<CarLogo> carLogoList = carLogoService.findCarLogo(null);
			json.put("CarLogo", carLogoList);
			//方向编码
			List<DirectionCode> directionCodeList = directionCodeService.findDirectionCode(null);
			json.put("DirectionCode", directionCodeList);
			//证据类型
			List<EvidenceType> evidenceTypeList = evidenceTypeService.findEvidenceType(null);
			json.put("EvidenceType", evidenceTypeList);
			//违法行为
			List<IllegalBehavior> illegalBehaviorList = illegalBehaviorService.findIllegalBehavior(null);
			json.put("illegalBehavior", illegalBehaviorList);
			//设备编号
			List<SbBh> sbBhL = sbbhService.findarea();
			json.put("sbbh", sbBhL);
			
			JSONArray jsay=JSONArray.fromObject(json);
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

}
