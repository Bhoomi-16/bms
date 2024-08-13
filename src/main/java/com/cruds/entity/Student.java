package com.cruds.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	@Id
	@Column(name="usn",nullable=false)
	public String usn;
	@Column(name="name",length=100,nullable=false)
	public String name;
	@Override
	public String toString() {
		return "Student [usn=" + usn + ", name=" + name + "]";
	}
	public String getUsn() {
		return usn;
	}
	public void setUsn(String usn) {
		this.usn = usn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student() {
		super();
		
	}
	public Student(String usn, String name) {
		super();
		this.usn = usn;
		this.name = name;
	}
}

