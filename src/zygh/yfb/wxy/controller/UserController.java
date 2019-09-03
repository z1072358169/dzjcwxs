package zygh.yfb.wxy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.MD5ToolsTest;
import zygh.yfb.wxy.service.UserService;
import zygh.yfb.wxy.vo.User;


/**
 * 用户表
 * @author 王喜亚
 *
 */

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//查询
	@RequestMapping("/queryUser")
	public void queryUser(User user,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			List<User> userList = userService.findUser(user);
			JSONArray jsay=JSONArray.fromObject(userList);
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


	//查询
	@RequestMapping("/selectByPage")
	@ResponseBody
	public PageInfo<User> selectByPage(@RequestParam(value="pageNo",defaultValue="1")int pageNo,
								 @RequestParam(value="pageSize",defaultValue="10")int pageSize,
								 User user)throws Exception{
		PageInfo<User> pageInfo = new PageInfo<User>();
		try {
			PageHelper.startPage(pageNo, pageSize);
			int a = 0/1;
			List<User> list = userService.selectByPage(user);
			//用PageInfo对结果进行包装
			/*PageInfo<User> */pageInfo = new PageInfo<User>(list);
			return pageInfo;
		} catch (Exception e) {
			return pageInfo;
		}
	}

	//添加
	@RequestMapping("/addUser")
	public void addUser(User user,HttpServletResponse response) throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = user.getUserId();
			String dm = daima.replace(" ", "");
			String shuoming = user.getUserName();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				String pssd = MD5ToolsTest.getMD5Str("888888mlgb");
				user.setPassWord(pssd);
				userService.addUser(user);
				String msg = "";
				msg="添加成功";
				response.getWriter().print(msg);
			}else {
				String msg = "";
				msg="参数为空格";
				response.getWriter().print(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
	}
	
	//删除
	@RequestMapping("/deleteUser")
	public void deleteUser(Integer[] userNums,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			userService.deleteUser(userNums);
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
	@RequestMapping("/updateUser")
	public void updateUser(User user,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");
			String daima = user.getUserId();
			String dm = daima.replace(" ", "");
			String shuoming = user.getUserName();
			String sm = shuoming.replace(" ", "");
			if(!dm.equals("") && !sm.equals("")){
				userService.updateUser(user);
				String msg = "";
				msg="修改成功";
				response.getWriter().print(msg);
			}else {
				String msg = "";
				msg="参数为空格";
				response.getWriter().print(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
	}

	// 用户登录
	@RequestMapping("/login")
	public void login(User user, HttpServletResponse response) throws Exception {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("text/html;charset=utf-8");
		String pd = user.getPassWord();
		String pssd = MD5ToolsTest.getMD5Str(pd+"mlgb");
		user.setPassWord(pssd);
		User user1 = userService.login(user);
		String msg = "";
		if (user1 == null) {
			msg = "1";
			response.getWriter().print(msg);
		} else {
			List list = userService.secUAndR(user);
			JSONArray userInfo = JSONArray.fromObject(list);
			System.out.println(userInfo);
			response.getWriter().print(userInfo);
		}
	}
	
	// 初始化密码
	@RequestMapping("/initPassWord")
	public void initPassWord(Integer[] userNums, HttpServletResponse response)
			throws Exception {
		userService.initPassword(userNums);
		String msg = "";
		msg = "1";
		response.getWriter().print(msg);
	}
	
	
	//修改密码
	@RequestMapping("/updPassWord")
	public void updPassWord(User user,HttpServletResponse response)throws Exception{
		try {
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.setContentType("text/html;charset=utf-8");

			if (!user.getPassWord().equals("")){
				//前端传来的原密码
				String yuanqian = MD5ToolsTest.getMD5Str(user.getOldpasswd()+"mlgb");
				//真实原密码
				String yuanzhenshi = userService.findpasswd(user.getUserNum());
				if (yuanzhenshi.equals(yuanqian)){
					//新密码
					String pssdxin = MD5ToolsTest.getMD5Str(user.getPassWord()+"mlgb");
					user.setPassWord(pssdxin);
					userService.updPassWord(user);
					String msg = "";
					msg="修改成功";
					response.getWriter().print(msg);
				}else {
					String msg = "";
					msg="原密码错误";
					response.getWriter().print(msg);
				}
			}else {
				String msg = "";
				msg="新密码不能为空！";
				response.getWriter().print(msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "";
			msg="参数错误";
			response.getWriter().print(msg);
		}
	}
	
}
