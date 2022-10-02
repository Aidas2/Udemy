package com.timbuchalka.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.timbuchalka.springdemo.dao.OrganizationDao;
import com.timbuchalka.springdemo.domain.Organization;

@Service
public class DaoUtils {

	private static Logger LOGGER = LoggerFactory.getLogger("Logging Tester");
	
	public final String createOperation = "CREATE";
	public final String readOperation = "READ";
	public final String updateOperation = "UPDATE";
	public final String deleteOperation = "DELETE";
	public final String cleanupOperation = "TRUNCATE";

	public void printOrganizations(List<Organization> orgs, String operation){
	    LOGGER.info("\n********* printing organizations after " + operation + " operation *********");
	    for (Organization org : orgs) {
	        LOGGER.info(org.toString());
	    }
	}
	
	public void printOrganization(Organization org, String operation) {
		LOGGER.info("\n**********Printing organization after invoking "+ operation + " *********\n"+ org);
	}

	public void printSuccessFailure(String operation, boolean param){
	    if(param)
	        LOGGER.info("\nOperation " + operation + " successful");
	    else
	        LOGGER.info("\nOperation " + operation + " failed");
	}
	
	public void createSeedData(OrganizationDao dao){
	    Organization org1 = new Organization("Amazon", 1994, "65656", 8765, "Work hard, have fun, make history");
	    Organization org2 = new Organization("BMW", 1929, "45454", 5501, "We build ultimate Driving machines");;
	    Organization org3 = new Organization("Google", 1996, "57575", 4567, "Don't be evil");
	     
	    List<Organization> orgs = new ArrayList<Organization>();
	    orgs.add(0, org1); orgs.add(1, org2); orgs.add(2, org3);
	    //int orgCount = orgs.size();
	    int createCount = 0;
	    for(Organization org : orgs){
	        boolean isCreated  = dao.create(org);
	        if(isCreated)
	            createCount += 1;
	    }
	             
	    LOGGER.info("Created "+ createCount + " organizations");
	}
	
	public void printOrganizationCount(List<Organization> orgs, String operation){
	    LOGGER.info("\n*********Currently we have " + orgs.size()+ " organizations after " + operation + " operation" + "   *********");
	     
	}
}
