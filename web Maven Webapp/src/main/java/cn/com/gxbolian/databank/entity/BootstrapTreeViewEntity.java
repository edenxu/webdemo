package cn.com.gxbolian.databank.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BootstrapTreeViewEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private String tags;
	private XtpzSjzd sjzd;
	private List<BootstrapTreeViewEntity> nodes = new ArrayList<BootstrapTreeViewEntity>();
	// 数据字典中的字段属性
	private String zdbm;
	private String sjybm;
	private String zdmc;
	private String ybmc;
	private String ybzd;
	private String sjlx;
	private String jhbz;
	private String bz;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public XtpzSjzd getSjzd() {
		return sjzd;
	}

	public void setSjzd(XtpzSjzd sjzd) {
		this.sjzd = sjzd;
	}

	public List<BootstrapTreeViewEntity> getNodes() {
		return nodes;
	}

	public void setNodes(List<BootstrapTreeViewEntity> nodes) {
		this.nodes = nodes;
	}

	public String getZdbm() {
		return zdbm;
	}

	public void setZdbm(String zdbm) {
		this.zdbm = zdbm;
	}

	public String getSjybm() {
		return sjybm;
	}

	public void setSjybm(String sjybm) {
		this.sjybm = sjybm;
	}

	public String getZdmc() {
		return zdmc;
	}

	public void setZdmc(String zdmc) {
		this.zdmc = zdmc;
	}

	public String getYbmc() {
		return ybmc;
	}

	public void setYbmc(String ybmc) {
		this.ybmc = ybmc;
	}

	public String getYbzd() {
		return ybzd;
	}

	public void setYbzd(String ybzd) {
		this.ybzd = ybzd;
	}

	public String getSjlx() {
		return sjlx;
	}

	public void setSjlx(String sjlx) {
		this.sjlx = sjlx;
	}

	public String getJhbz() {
		return jhbz;
	}

	public void setJhbz(String jhbz) {
		this.jhbz = jhbz;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
