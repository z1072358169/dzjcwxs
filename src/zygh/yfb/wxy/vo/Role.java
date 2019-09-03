package zygh.yfb.wxy.vo;
/**
 * 角色表
 * role
 * @author 王喜亚
 *
 */
public class Role {

	private Integer roleNum;		//角色编号
	private String roleName;		//角色名称
	private String roleMs;			//角色描述
	private String permissions;     //角色权限
	private String roleRemarks;		//角色备注
	
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public Integer getRoleNum() {
		return roleNum;
	}
	public void setRoleNum(Integer roleNum) {
		this.roleNum = roleNum;
	}
	public String getRoleMs() {
		return roleMs;
	}
	public void setRoleMs(String roleMs) {
		this.roleMs = roleMs;
	}
	public String getRoleRemarks() {
		return roleRemarks;
	}
	public void setRoleRemarks(String roleRemarks) {
		this.roleRemarks = roleRemarks;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "Role [roleNum=" + roleNum + ", roleName=" + roleName
				+ ", roleMs=" + roleMs + ", roleRemarks=" + roleRemarks + "]";
	}
	
	
}
