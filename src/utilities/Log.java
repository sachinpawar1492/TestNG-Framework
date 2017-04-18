package utilities;

import org.apache.log4j.Logger;

public class Log {
	//Initialize Log4j Logs
	private static Logger Log = Logger.getLogger(Log.class.getName());
	
	// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite
	public static void startTestCase(String sTestCaseName){
		Log.info("############################### START ###############################");
		Log.info("########################" + sTestCaseName + "########################");
		Log.info("#####################################################################");
	}

	//This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName){
		Log.info("#####################################################################");
		Log.info("########################" + sTestCaseName + "########################");
		Log.info("################################ END ################################");		
	}

	// Need to create these methods, so that they can be called  

	public static void info(String sMessage) {
		Log.info(sMessage);
	}
	 
	public static void warn(String sMessage) {
	    Log.warn(sMessage);
	}
	 
	public static void error(String sMessage) { 
	    Log.error(sMessage);
	}
	 
	public static void fatal(String sMessage) { 
		Log.fatal(sMessage);
	}
	 
	public static void debug(String sMessage) {
		Log.debug(sMessage);
	}	

}
