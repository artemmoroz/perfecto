package com.quantum;

import com.qmetry.qaf.automation.step.QAFTestStepAdapter;
import com.qmetry.qaf.automation.step.StepExecutionTracker;
import com.quantum.utils.ConfigurationUtils;

import java.util.Arrays;

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
        ConfigurationUtils.getBaseBundle().addProperty("isHybrid",
                Arrays.stream(stepExecutionTracker.getScenario().getGroups()).anyMatch(g -> g.equalsIgnoreCase("@hybrid")));
    }


}
