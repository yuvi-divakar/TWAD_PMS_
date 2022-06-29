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
@Table(name="TBL_CircleOffice")
public class TwadCircleOffice {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="CircleId")
    private int circleID;

	
	@NotNull(message = "CircleName may not be null")
    @Column(name="CircleName")
    private String circleName;

	@Column(name="IsActive")
    private boolean isActive=Boolean.TRUE;
	
	 @NotNull
	@ManyToOne(targetEntity = TwadRegionalOffice.class )
	@JoinColumn(name = "RegionId", referencedColumnName = "RegionId")
    private int regionId;

	 
	 public TwadCircleOffice() {}
	 
	public TwadCircleOffice(int circleID, @NotNull(message = "CircleName may not be null") String circleName,
			boolean isActive, @NotNull int regionId) {
		super();
		this.circleID = circleID;
		this.circleName = circleName;
		this.isActive = isActive;
		this.regionId = regionId;
	}

	public int getCircleID() {
		return circleID;
	}

	public void setCircleID(int circleID) {
		this.circleID = circleID;
	}

	public String getCircleName() {
		return circleName;
	}

	public void setCircleName(String circleName) {
		this.circleName = circleName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	 
	 

}
