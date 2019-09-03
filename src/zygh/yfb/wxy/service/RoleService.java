package zygh.yfb.wxy.service;

import java.util.List;

import zygh.yfb.wxy.vo.Role;

/**
 * 
 * @author 王喜亚
 *
 */
public interface RoleService {

	//查看所有角色信息
	public List<Role> findRole(Role role)throws Exception;
	//添加角色信息
	public void addRole(Role role)throws Exception;
	//批量删除角色信息
	public void deleteRole(Integer[] roleNums) throws Exception;
	//通过主键查找角色信息
	public Role findRoleByNum(Integer roleNum)throws Exception;
	//修改角色信息
	public void updateRole(Role role)throws Exception;
}
