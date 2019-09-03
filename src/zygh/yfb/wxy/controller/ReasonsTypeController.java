package zygh.yfb.wxy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zygh.yfb.wxy.service.IllegalBehaviorService;
import zygh.yfb.wxy.service.ReasonsTypeService;
import zygh.yfb.wxy.service.WfcsService;
import zygh.yfb.wxy.service.WffhService;
import zygh.yfb.wxy.vo.*;

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
public class ReasonsTypeController {
	
	@Autowired
	private ReasonsTypeService reasonsTypeService;

	@Autowired
	private IllegalBehaviorService illegalBehaviorService;

	@Autowired
	private WfcsService wfcsService;

	@Autowired
	private WffhService wffhService;
	
	//查询
	@RequestMapping("/findReasonsType")
	public void findReasonsType(ReasonsType reasonsType,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<ReasonsType> reasonsTypeList = reasonsTypeService.findReasonsType(reasonsType);
			JSONArray jsay=JSONArray.fromObject(reasonsTypeList);
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

	//关联原因表查询
	@RequestMapping("/findReasonsAndType")
	public void findReasonsAndType(Reasons reasons, HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<Reasons> reasonsList = reasonsTypeService.findReasonsAndType(reasons);
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

	//关联违法代码表查询
	@RequestMapping("/findReasonsAndWfdm")
	public void findReasonsAndWfdm(HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<IllegalBehavior> illegalBehaviorList = illegalBehaviorService.findIllegalBehavior(null);
			ReasonsType reasonsType = null;
			JSONObject jsonObject = null;
			JSONArray jsonArray = new JSONArray();
			for (int i = 0; i < illegalBehaviorList.size(); i++) {
				jsonObject = new JSONObject();
				reasonsType = new ReasonsType();
				reasonsType.setWFDM(illegalBehaviorList.get(i).getIllegal_number());
				List<ReasonsType> reasonsTypeList = reasonsTypeService.findReasonsType(reasonsType);
				jsonObject.put("sysId", illegalBehaviorList.get(i).getSysId());
				jsonObject.put("illegal_explanation", illegalBehaviorList.get(i).getIllegal_explanation());
				jsonObject.put("illegal_number", illegalBehaviorList.get(i).getIllegal_number());
				jsonObject.put("reasonsType", reasonsTypeList);
				jsonArray.add(jsonObject);
			}
			PrintWriter p=null;
			try {
				p=response.getWriter();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(jsonArray!=null){
				p.print(jsonArray);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="查询失败";
			response.getWriter().print(msg);
		}
	}
	
	//添加
	@RequestMapping("/insertReasonsType")
	public void insertReasonsType(ReasonsType reasonsType,HttpServletResponse response) throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			reasonsTypeService.insertReasonsType(reasonsType);
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
	@RequestMapping("/deleteReasonsType")
	public void deleteReasonsType(Integer[] ReasonsTypeIds,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			reasonsTypeService.deleteReasonsType(ReasonsTypeIds);
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
	@RequestMapping("/updateReasonsType")
	public void updateReasonsType(ReasonsType reasonsType,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			reasonsTypeService.updateReasonsType(reasonsType);
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


	//分页查询违法初筛废片的
    @RequestMapping("/findWfcsoldByPage")
    @ResponseBody
    public PageInfo<Wfcs> findWfcsoldByPage(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
                                            @RequestParam(value="pageSize",defaultValue="10")int pageSize,
                                            Wfcs wfcs,HttpServletResponse response)throws Exception{
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");
        PageInfo<Wfcs> pageInfo = new PageInfo<Wfcs>();
        try {
            PageHelper.startPage(pageNo, pageSize);
            List<Wfcs> wfcsList = wfcsService.findWfcsold(wfcs);
            pageInfo = new PageInfo<Wfcs>(wfcsList);
            return pageInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return pageInfo;
        }
    }

	//查询
	@RequestMapping("/queryWffhByPage")
    @ResponseBody
	public PageInfo<Wffh> queryWffhByPage(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
								@RequestParam(value="pageSize",defaultValue="10")int pageSize,
								Wffh wffh,HttpServletResponse response)throws Exception{
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/html;charset=utf-8");
		PageInfo<Wffh> pageInfo = new PageInfo<Wffh>();
		try {
			PageHelper.startPage(pageNo, pageSize);
			List<Wffh> WffhList = wffhService.findWffh(wffh);
			pageInfo = new PageInfo<Wffh>(WffhList);
			return pageInfo;
		} catch (Exception e) {
			return pageInfo;
		}
	}
	
}
