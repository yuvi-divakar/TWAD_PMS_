package com.raavan.twad.division.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.raavan.twad.TwadPmsApplication;

@Service
public class DivisionInfoImpl implements Serializable{
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TwadPmsApplication.class);

	
	private static final long serialVersionUID = 1303816167713502216L;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Value("${spring.datasource.url}")
	private String ConUrl;
	
	@Value("${spring.datasource.username}")
	private String userName;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	
	public String getDivisions() {
		
		StringBuilder sqlQuery = new StringBuilder();
		sqlQuery.append("SELECT json_build_object('HeadOffice', json_agg(HO)) HeadOffice ");
		sqlQuery.append("FROM (SELECT CAST(tbl_head_office.head_office_id as varchar)as headofficeid,CAST(tbl_head_office.head_office_name as varchar)as headOfficeName , ");
		sqlQuery.append("(SELECT json_agg(row_to_json(RO)) FROM (SELECT CAST(tbl_regional_office.region_id as varchar) as RegionID, CAST(tbl_regional_office.region_name as varchar) as RegionName, ");
		sqlQuery.append("(SELECT json_agg(row_to_json(CO)) FROM (SELECT CAST(tbl_circle_office.circle_id as varchar) as cricleID,CAST(tbl_circle_office.circle_name as varchar) as CircleName, ");
		sqlQuery.append("(SELECT json_agg(row_to_json(TDO))FROM(SELECT CAST(tbl_divisional_office.division_id as varchar) as DivisionID,CAST(tbl_divisional_office.division_name as varchar) as DivisionName ");
		sqlQuery.append("FROM tbl_divisional_office WHERE tbl_divisional_office.circle_id = tbl_circle_office.circle_id)TDO )DivisionOffice FROM tbl_circle_office ");
		sqlQuery.append("WHERE tbl_circle_office.region_id = tbl_regional_office.region_id) CO ) CircleOffice FROM tbl_regional_office ");
		sqlQuery.append("WHERE tbl_regional_office.head_office_id = tbl_head_office.head_office_id)RO ");
		sqlQuery.append(") AS RegionOffice FROM tbl_head_office) HO ");
				
		Query query= entityManager.createNativeQuery(sqlQuery.toString());
		
		System.out.println(sqlQuery.toString());
	      Connection con;
	      String office = null ;
		try {
			con = DriverManager.getConnection(ConUrl,userName,password);
			PreparedStatement pstmt = con.prepareStatement(sqlQuery.toString());
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			final int columnCount = metaData.getColumnCount();

			 System.out.println(metaData);
			while(rs.next()) {
				  office = rs.getString("HeadOffice");
				Object[] row = new Object[columnCount];
				for (int i = 1; i <= columnCount; ++i) {
				    row[i - 1] = rs.getString(i); // Or even rs.getObject()
				}
			    
			   
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return office;
	}

	


}
