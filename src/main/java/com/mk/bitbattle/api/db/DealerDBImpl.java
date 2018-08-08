package com.mk.bitbattle.api.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * Use this class for interactions with database
 *
 */
@Service
public class DealerDBImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<String> getDealerListByName(String makeName) throws Exception{
		
		String getDealerListByNameSqlQueryStr = "select distinct(DealerName) from VehicleInventoryData where Make = ?";
		List<String> dealerList = jdbcTemplate.queryForList(getDealerListByNameSqlQueryStr, new Object[]{makeName}, String.class);
		
		return dealerList;
	}
}
