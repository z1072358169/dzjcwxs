package zygh.yfb.wxy.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zygh.yfb.wxy.mapper.RoleMapper;
import zygh.yfb.wxy.service.RoleService;
import zygh.yfb.wxy.vo.Role;


public class RoleServiceimpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	public List<Role> findRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.findRole(role);
	}

	public void addRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		roleMapper.addRole(role);
	}

	public void deleteRole(Integer[] roleNums) throws Exception {
		// TODO Auto-generated method stub
		roleMapper.deleteRole(roleNums);
	}

	public Role findRoleByNum(Integer roleNum) throws Exception {
		// TODO Auto-generated method stub
		return roleMapper.findRoleByNum(roleNum);
	}

	public void updateRole(Role role) throws Exception {
		// TODO Auto-generated method stub
		roleMapper.updateRole(role);
	}

}
