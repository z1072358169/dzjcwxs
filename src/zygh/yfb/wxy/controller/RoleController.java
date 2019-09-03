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

import zygh.yfb.wxy.service.RoleService;
import zygh.yfb.wxy.vo.Role;

/**
 * 角色控住曾
 * @author 王喜亚
 *
 */
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	//查询角色
	@RequestMapping("/queryRole")
	public void queryRole(Role role,HttpServletResponse response)throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		List<Role> roleList = roleService.findRole(role);
		JSONArray jsay=JSONArray.fromObject(roleList);
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
	}
	
	//添加角色
	@RequestMapping("/addRoleSubmit")
	public void addRoleSubmit(Role role,HttpServletResponse response) throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		roleService.addRole(role);
		String msg = "";
		msg="1";
		response.getWriter().print(msg);
	}
	
	//删除角色
	@RequestMapping("/deleteRoleList")
	public void deleteRoleList(Integer[] roleNums,HttpServletResponse response)throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		roleService.deleteRole(roleNums);
		String msg = "";
		msg="1";
		response.getWriter().print(msg);
	}
	//预修改
	@RequestMapping("/preUpdateRole")
	public void preUpdateRole(Integer roleNum,HttpServletResponse response)throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		Role role = roleService.findRoleByNum(roleNum);
		JSONObject role1 = JSONObject.fromObject(role); 
		  PrintWriter p=null;
          try {
			 p=response.getWriter();
			 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  if(role1!=null){
			  p.print(role1);
			  System.out.println(role1);
		  }
		  
	}
	//修改
	@RequestMapping("/updateRoleSubmit")
	public void updateRoleSubmit(Role role,HttpServletResponse response)throws Exception{
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		roleService.updateRole(role);
		String msg = "";
		msg="1";
		response.getWriter().print(msg);
		
	}
}
