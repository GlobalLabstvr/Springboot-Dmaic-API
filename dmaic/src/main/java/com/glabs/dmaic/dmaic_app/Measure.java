package com.glabs.dmaic.dmaic_app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Measure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer current;
	private Integer target;
	private Dmaic dmaic;
	
	public Measure() {
		
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
	
	@ManyToOne
	@JoinColumn(name="dmaic_id")
	public Dmaic getDmaic() {
		return dmaic;
	}
	public void setDmaic(Dmaic dmaic) {
		this.dmaic = dmaic;
	}
	
	
	
}
