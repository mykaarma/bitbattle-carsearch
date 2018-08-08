package com.mk.bitbattle.api;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.bitbattle.api.impl.DealerServiceImpl;

/**
 * 
 * Use this class to write Rest service end points
 *
 */

@Controller
@RequestMapping("/dealer")
public class DealerServiceController {

	private final static Logger LOGGER=Logger.getLogger(DealerServiceController.class);
	
	@Autowired
	DealerServiceImpl dealerServiceImpl;
	
	@RequestMapping(value="/getDealerListByMake/{make}",method=RequestMethod.GET)
	public @ResponseBody List<String> getDealerListByMake(@PathVariable("make") String makeName) throws Exception{
		
		LOGGER.info("input make = "+ makeName);
		
		List<String> dealerList = dealerServiceImpl.getDealerListByName(makeName); 
		
		return dealerList;
	}
}
