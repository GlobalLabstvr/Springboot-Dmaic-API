package com.glabs.dmaic.dmaic_app;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "dmaic")
public class Measure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long dmaicid;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinColumn(name = "DmaicID", insertable = false, updatable = false)
	private Dmaic dmaic;
	
	private Long current;

	private Long target;
	
	
	public Measure() {
		
	}
	
	
	public Dmaic getDmaic() {
		return dmaic;
	}


	public void setDmaic(Dmaic dmaic) {
		this.dmaic = dmaic;
	}


	public Long getCurrent() {
		return current;
	}


	public void setCurrent(Long current) {
		this.current = current;
	}


	public Long getTarget() {
		return target;
	}


	public void setTarget(Long target) {
		this.target = target;
	}


	@Override
	public String toString() {
		return "Measure [dmaicid=" + dmaicid + ", dmaic=" + dmaic + ", current=" + current + ", target=" + target + "]";
	}


	
		
}
