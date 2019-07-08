package com.glabs.dmaic.dmaic_app;

import java.io.Serializable;
//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.glabs.dmaic.user.User;


@Entity
@Table(name = "dmaic")
public class Dmaic implements Serializable

{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DmaicID")
	private Long id;
	private String define;
	//private Measure measure;
	private String analyse;
	private String implement;
	private String control;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
    @JoinColumn(name = "UserID")	
   	private User user;
	
	public Dmaic() 
	{
		
	}
	
		
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDefine() {
		return define;
	}

	public void setDefine(String define) {
		this.define = define;
	}

	public String getAnalyse() {
		return analyse;
	}
	public void setAnalyse(String analyse) {
		this.analyse = analyse;
	}

	//@ManyToMany(targetEntity=Measure.class, mappedBy="dmaic", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	//@Column(name="dmaic")
	//public Measure getMeasure() {
		//return measure;
	//}


	//public void setMeasure(Measure measure) {
		//this.measure = measure;
	//}


	
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
		return "Dmaic [id=" + id + ", define=" + define + ",analyse=" + analyse
				+ ", implement=" + implement + ", control=" + control + ", user=" + user + "]";
	}


	

}