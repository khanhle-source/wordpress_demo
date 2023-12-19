package common;

import java.io.File;

public class GlobalConstants {

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");


    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final long RETRY_TEST_FAIL = 3;

    public static final String REPORTING_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGScreenShots" + File.separator;
    public static final String JAVA_VERSION = System.getProperty("java.version");
    //note: bien static la bien co the truy cap tai bat cu cho nao trong project

}
