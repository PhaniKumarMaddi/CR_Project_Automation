package CSAT_Survey;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import Pages.CSAT_Survey_Page;
import Utility.CSAT_TestInitializer;
import Utility.GenerateReports;
import Utility.TestDataKeys;
import Utility.ValidatingAssertions;

public class CSAT_SurveyTest extends CSAT_TestInitializer{

	private static final Logger logger= LogManager.getLogger(CSAT_SurveyTest.class);
	GenerateReports grep;
	CSAT_Survey_Page csatPage;
	TestDataKeys dataKeys = new TestDataKeys();
	ValidatingAssertions validAssert = new ValidatingAssertions();
	
	@Test
	public void csat_Ui_Test() throws Exception {

				System.out.println("Inside Test class ");
				logger.info("Inside Test class ");
				csatPage = new CSAT_Survey_Page();
				grep = new GenerateReports();

				grep.testCreate("CR Chat Bot Page UI Validation Test", "CR Chat Bot Page UI");
				waitTime(driver);
	}
}
