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
@Table(name="TBL_RegionalOffice",schema = "public")
public class TwadRegionalOffice {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RegionId")
    private int regionId;

	
	@NotNull(message = "RegionName may not be null")
    @Column(name="RegionName")
    private String regionName;

	@Column(name="IsActive")
    private boolean isActive=Boolean.TRUE;
	
	 @NotNull
	@ManyToOne(targetEntity = TwadHeadOffice.class )
	@JoinColumn(name = "HeadOfficeId", referencedColumnName = "HeadOfficeId")
    private int headofficeID;

	 public TwadRegionalOffice() {}
	 
	public TwadRegionalOffice(int regionId, @NotNull(message = "RegionName may not be null") String regionName,
			boolean isActive, @NotNull int headOfficeId) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
		this.isActive = isActive;
		this.headofficeID = headOfficeId;
	}

	public int getId() {
		return regionId;
	}

	public void setId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public int getHeadOfficeId() {
		return headofficeID;
	}

	public void setHeadOfficeId(int headOfficeId) {
		headofficeID = headOfficeId;
	}
	 
	 
	 
}
