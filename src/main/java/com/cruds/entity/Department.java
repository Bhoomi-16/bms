package com.cruds.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	@Id
	private int deptId;
	@Column(length=100,nullable=false)
	private String deptName;
@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + "]";
	}
public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
public Department(int deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
	}

}

