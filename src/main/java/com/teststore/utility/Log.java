/**
 * 
 */
package com.teststore.utility;

import org.apache.log4j.Logger;

/**
 * @author Dinesh
 *
 */
public class Log {
	
	public static Logger log=Logger.getLogger(Log.class.getName());
	
	public static void startTestCase(String sTestCaseName) {
		log.info("========="+sTestCaseName+   "TEST START"+"=========");
	}
	public static void endTestCase(String sTestCaseName) {
		log.info("========="+sTestCaseName+   "TEST END"+"=======");
	}
	
	public static void info(String message) {
		log.info(message);
	}
	
	public static void error(String message) {
		log.info(message);
	}
	
	public static void warn(String meaage) {
		log.info(meaage);
	}
	
	public static void fatal(String message) {
		log.info(message);
	}
	
	public static void debug(String message) {
		log.info(message);
	}

}
