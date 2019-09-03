package zygh.yfb.wxy.vo;

/**
 * evidence_type
 * 证据类型表
 * @author 王喜亚
 *
 */
public class EvidenceType {
	
	private int sysId;
	
	//证据类型
	private String eCode;
	
	//说明
	private String eExplain;

	public int getSysId() {
		return sysId;
	}

	public void setSysId(int sysId) {
		this.sysId = sysId;
	}

	public String geteCode() {
		return eCode;
	}

	public void seteCode(String eCode) {
		this.eCode = eCode;
	}

	public String geteExplain() {
		return eExplain;
	}

	public void seteExplain(String eExplain) {
		this.eExplain = eExplain;
	}

	@Override
	public String toString() {
		return "EvidenceType [sysId=" + sysId + ", eCode=" + eCode
				+ ", eExplain=" + eExplain + "]";
	}
	
	
	
}
