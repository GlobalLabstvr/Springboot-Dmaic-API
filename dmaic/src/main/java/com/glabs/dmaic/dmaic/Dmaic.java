package com.glabs.dmaic.dmaic;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.glabs.dmaic.user.User;


@Entity
@Table(name = "dmaic")
public class Dmaic implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "DmaicID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private String userId;
	private String define;
	private String measure;
	private Integer current;
	private Integer target;
	private String analyse;
	private String implement;
	private String control;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name = "UserID")
    private User user;
	
	public Dmaic() {
		
	}
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getDefine() {
		return define;
	}

	public void setDefine(String define) {
		this.define = define;
	}

	public String getMeasure() {
		return measure;
	}

	public void setMeasure(String measure) {
		this.measure = measure;
	}


	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}

	public String getAnalyse() {
		return analyse;
	}

	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}

	public String getImplement() {
		return implement;
	}

	public void setImplement(String implement) {
		this.implement = implement;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}


	@Override
	public String toString() {
		return "Dmaic [userId=" + userId + ", define=" + define + ", measure=" + measure + ", current=" + current
				+ ", target=" + target + ", analyse=" + analyse + ", implement=" + implement + ", control=" + control
				+ "]";
	}


	

	

	
	
}
