package com.neo.model;


import java.sql.Date;

import javax.persistence.*;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name="POC2")
@SQLDelete(sql="update poc2 det deleted=true where id=?")

public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	private long id;
	private	String firstname;
	private String lastname;
	private int pincode;
	
	
	private  Date DOB;
	

	private Date DOJ;
	  private boolean deleted = Boolean.FALSE;//false=deleted

	public User(String first_name, String last_name, int pin_Code, Date DOB,Date DOJ) {
		super();
		firstname = first_name;
		lastname = last_name;
		pincode = pin_Code;
		DOB =DOB;
		DOJ = DOJ;
	}
	public User(String firstname, String lastname, int pincode, Date dOB, Date dOJ, boolean deleted) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.pincode = pincode;
		DOB = dOB;
		DOJ = dOJ;
		this.deleted = deleted;
	}




	public User(long id, String firstname, String lastname, int pincode, Date dOB, Date dOJ, boolean deleted) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.pincode = pincode;
		DOB = dOB;
		DOJ = dOJ;
		this.deleted = deleted;
	}



	public User(long id, String first_name, String last_name, int pin_Code,Date dOB,Date dOJ) {
		super();
		this.id = id;
		firstname = first_name;
		lastname = last_name;
		pincode = pin_Code;
		DOB = dOB;
		DOJ = dOJ;
	}

	

	
	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}





	public User() {
		super();
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getfirstname() {
		return firstname;
	}


	public void setfirstname(String first_name) {
		firstname = first_name;
	}


	public String getlastname() {
		return lastname;
	}


	public void setlastname(String last_name) {
		lastname = last_name;
	}


	public int getpincode() {
		return pincode;
	}


	public void setpincode(int pin_Code) {
		pincode = pin_Code;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	public Date getDOJ() {
		return DOJ;
	}


	public void setDOJ(Date dOJ) {
		DOJ = dOJ;
	}
	
	
	
	

}
