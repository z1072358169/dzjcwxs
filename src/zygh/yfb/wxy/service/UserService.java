package zygh.yfb.wxy.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import zygh.yfb.wxy.vo.User;


public interface UserService {

	//查询所有用户信息
	public List<User> findUser(User user)throws Exception;
	//查询密码
	public String findpasswd(Integer userNum)throws Exception;
	//分页查询用户测试
	public List<User> selectByPage(User user) throws Exception;
	//添加用户
	public void addUser(User user)throws Exception;
	//批量删除用户
	public void deleteUser(Integer[] userNums) throws Exception;
	//修改用户信息
	public void updateUser(User user)throws Exception;
	//初始化密码
	public void initPassword(Integer[] userNums)throws Exception;
	
	public void updPassWord(User user)throws Exception;
	//登录
	public User login(User user)throws Exception;
	
	public List secUAndR(User u)throws Exception;

}
