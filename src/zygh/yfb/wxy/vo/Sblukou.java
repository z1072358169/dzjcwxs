package zygh.yfb.wxy.vo;

public class Sblukou {

	private String SBBH;
	
	private String lukouname;
	
	private int sfxs;

	private String beizhu;

	private String muban;

	public String getSBBH() {
		return SBBH;
	}

	public void setSBBH(String SBBH) {
		this.SBBH = SBBH;
	}

	public String getLukouname() {
		return lukouname;
	}

	public void setLukouname(String lukouname) {
		this.lukouname = lukouname;
	}

	public int getSfxs() {
		return sfxs;
	}

	public void setSfxs(int sfxs) {
		this.sfxs = sfxs;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public String getMuban() {
		return muban;
	}

	public void setMuban(String muban) {
		this.muban = muban;
	}

	@Override
	public String toString() {
		return "Sblukou{" +
				"SBBH='" + SBBH + '\'' +
				", lukouname='" + lukouname + '\'' +
				", sfxs=" + sfxs +
				", beizhu='" + beizhu + '\'' +
				", muban='" + muban + '\'' +
				'}';
	}
}
