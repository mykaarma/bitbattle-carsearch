package com.mk.bitbattle.api.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.bitbattle.api.db.DealerDBImpl;

/**
 * 
 * Use this class to write logic
 *
 */
@Service
public class DealerServiceImpl {
	
	private final static Logger LOGGER=Logger.getLogger(DealerServiceImpl.class);
	
	@Autowired
	DealerDBImpl dealerDBImpl;

	public List<String> getDealerListByName(String makeName) throws Exception{
		
		if(makeName!=null && !makeName.isEmpty()){
			
			try{
				
				return dealerDBImpl.getDealerListByName(makeName);
				
			}catch (Exception e) {
				LOGGER.error("Exception in fetching list of dealers by make", e);
				return null;
			}
		}else{
			
			throw new Exception("Invalid request");
		}
		
		
	}

}
