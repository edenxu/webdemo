package cn.com.gxbolian.databank.entity;

import java.io.Serializable;
import java.util.List;

public class ParamsObject  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<XtpzSjzd> selectTables;
	private String whereClause;
	private String groupClause;
	private String havingClause;
	private String groupFlag;
	private String saveFlag;
	private String myTableName;

	public List<XtpzSjzd> getSelectTables() {
		return selectTables;
	}

	public void setSelectTables(List<XtpzSjzd> selectTables) {
		this.selectTables = selectTables;
	}

	public String getWhereClause() {
		return whereClause;
	}

	public void setWhereClause(String whereClause) {
		this.whereClause = whereClause;
	}

	public String getGroupClause() {
		return groupClause;
	}

	public void setGroupClause(String groupClause) {
		this.groupClause = groupClause;
	}

	public String getHavingClause() {
		return havingClause;
	}

	public void setHavingClause(String havingClause) {
		this.havingClause = havingClause;
	}

	public String getGroupFlag() {
		return groupFlag;
	}

	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}

	public String getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	public String getMyTableName() {
		return myTableName;
	}

	public void setMyTableName(String myTableName) {
		this.myTableName = myTableName;
	}

}
