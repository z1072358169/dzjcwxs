package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import zygh.yfb.wxy.mapper.UserMapper;
import zygh.yfb.wxy.service.UserService;
import zygh.yfb.wxy.vo.User;

public class UserServiceimpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public List<User> findUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.findUser(user);
	}

	@Override
	public String findpasswd(Integer userNum) throws Exception {
		return userMapper.findpasswd(userNum);
	}

	@Override
	public List<User> selectByPage(User user) throws Exception {
		return userMapper.selectByPage(user);
	}

	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}

	public void deleteUser(Integer[] userNums) throws Exception {
		// TODO Auto-generated method stub
		userMapper.deleteUser(userNums);
	}

	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

	public void initPassword(Integer[] userNums) throws Exception {
		// TODO Auto-generated method stub
		userMapper.initPassword(userNums);
	}

	public void updPassWord(User user) throws Exception {
		// TODO Auto-generated method stub
		userMapper.updPassWord(user);
	}

	public User login(User user) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.login(user);
	}

	public List secUAndR(User u) throws Exception {
		// TODO Auto-generated method stub
		return userMapper.secUAndR(u);
	}



}
