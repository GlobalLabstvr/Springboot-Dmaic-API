package com.glabs.dmaic.dmaic_app;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

//import com.glabs.dmaic.dmaic_app.Measure;
import com.glabs.dmaic.user.User;


@Entity
@Table(name = "dmaic")
public class Dmaic implements Serializable

{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dmaicId;
	private String define;
	
	//private List<Measure> measure;
	private String analyse;
	private String implement;
	private String control;
	
	@OneToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    @JoinColumn(name = "UserID")	
    private User user;
	
	public Dmaic() 
	{
		
	}
	
	
	public Long getDmaicId() {
		return dmaicId;
	}


	public void setDmaicId(Long dmaicId) {
		this.dmaicId = dmaicId;
	}


	public String getDefine() {
		return define;
	}

	public void setDefine(String define) {
		this.define = define;
	}

	
	/*@OneToMany(targetEntity=Measure.class, mappedBy="dmaic", cascade= CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Measure> getMeasure() {
		return measure;
	}


	public void setMeasure(List<Measure> measure) {
		this.measure = measure;
	}

*/
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	

}