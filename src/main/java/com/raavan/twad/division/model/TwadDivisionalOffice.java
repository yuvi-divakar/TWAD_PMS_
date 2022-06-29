package com.raavan.twad.division.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="TBL_DivisionalOffice",schema = "public")
public class TwadDivisionalOffice {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DivisionId")
    private int divisionID;

	
	@NotNull(message = "DivisionName may not be null")
    @Column(name="DivisionName")
    private String divisionName;

	@Column(name="IsActive")
    private boolean isActive=Boolean.TRUE;
	
	 @NotNull
	@ManyToOne(targetEntity = TwadCircleOffice.class )
	@JoinColumn(name = "CircleId", referencedColumnName = "CircleId")
    private int circleID;

	 
	 public TwadDivisionalOffice() {}
	 
	 
	public TwadDivisionalOffice(int divisionID, @NotNull(message = "DivisionName may not be null") String divisionName,
			boolean isActive, @NotNull int circleID) {
		super();
		this.divisionID = divisionID;
		this.divisionName = divisionName;
		this.isActive = isActive;
		this.circleID = circleID;
	}

	public int getDivisionID() {
		return divisionID;
	}

	public void setDivisionID(int divisionID) {
		this.divisionID = divisionID;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getCircleID() {
		return circleID;
	}

	public void setCircleID(int circleID) {
		this.circleID = circleID;
	}
	 
	 

}
