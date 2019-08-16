package com.quantum;

import com.qmetry.qaf.automation.step.QAFTestStepAdapter;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.ReportUtils;

import java.util.HashMap;
import java.util.Map;

import static com.quantum.utils.DeviceUtils.getQAFDriver;

/**
 * Created 29-Jul-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class TestListener extends QAFTestStepAdapter {

    @Override
    public void beforExecute(StepExecutionTracker stepExecutionTracker) {
        super.beforExecute(stepExecutionTracker);

        Map<String, Object> params = new HashMap<>();
        params.put("profile", "4g_lte_advanced_good");
        params.put("latency", "70");
        params.put("bandwidth.in", "50000");
        params.put("bandwidth.out", "30000");
        params.put("packetLoss", "0");

        //-----------2g config
//        params.put("profile", "2g_gprs_poor");
//        params.put("latency", "700");
//        params.put("bandwidth.in", "30");
//        params.put("bandwidth.out", "20");
//        params.put("packetLoss", "2");
        //+++++++++++2g config

        getQAFDriver().executeScript("mobile:vnetwork:start", params);
    }

    @Override
    public void afterExecute(StepExecutionTracker stepExecutionTracker) {
        Map<String, Object> params = new HashMap<>();
        getQAFDriver().executeScript("mobile:vnetwork:stop", params);
    }


}
