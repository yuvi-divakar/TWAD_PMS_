package com.raavan.twad.division.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="TBL_HeadOffice",schema = "public")
public class TwadHeadOffice {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="HeadOfficeId")
    private int headofficeID;

	
	@NotNull(message = "HeadOfficeName may not be null")
    @Column(name="HeadOfficeName")
    private String headofficeName;

	@Column(name="IsActive")
    private boolean isActive=Boolean.TRUE;

	public TwadHeadOffice()
	{}
	
	public TwadHeadOffice(int headofficeID, @NotNull(message = "HeadOfficeName may not be null") String headofficeName,
			boolean isActive) {
		super();
		this.headofficeID = headofficeID;
		this.headofficeName = headofficeName;
		this.isActive = isActive;
	}

	public int getId() {
		return headofficeID;
	}

	public void setId(int headofficeID) {
		this.headofficeID = headofficeID;
	}

	public String getHeadofficeName() {
		return headofficeName;
	}

	public void setHeadofficeName(String headofficeName) {
		this.headofficeName = headofficeName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

}
