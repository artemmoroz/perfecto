package com.quantum;

import com.qmetry.qaf.automation.testng.pro.QAFSuiteListener;
import org.testng.ISuite;
import org.testng.ITestContext;

/**
 * Created 29-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class SuiteListener extends QAFSuiteListener {


    @Override
    public void onStart(ISuite suite) {
        super.onStart(suite);
        System.out.println(suite);
    }

    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        System.out.println(testContext);
    }
}
