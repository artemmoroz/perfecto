package com.quantum.actions;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.quantum.utils.AppType;

/**
 * Created 02-Aug-19
 *
 * @author <a href="mailto:ArtemMoroz@coherentsolutions.com">Artem Moroz</a>
 * @version 1.0
 */
public class PerfectoCustomActions {

    private static PerfectoCustomActions instance;
    protected CustomActions customActions;
    protected AppType type;

    private PerfectoCustomActions() {
        String appType = ConfigurationManager.getBundle().getPropertyValue("appType");
        if (appType != null) {
            type = AppType.valueOf(appType.toUpperCase());
            switch (type) {
                case ANDROID: {
                    customActions = new AndroidActions();
                    break;
                }
                case IOS: {
                    customActions = new IOSActions();
                    break;
                }
                case HYBRID_ANDROID: {
                    customActions = new HybridAndroidActions();
                    break;
                }
                case HYBRID_IOS: {
                    customActions = new HybridIOSActions();
                    break;
                }

            }
            System.out.println("----- Selected Platform " + customActions + " ---------------");
        } else {
            throw new IllegalArgumentException("Unable to read appType and init proper steps");
        }
    }


    public static PerfectoCustomActions getInstance() {
        if (instance == null) {
            synchronized (PerfectoCustomActions.class) {
                if (instance == null) {
                    instance = new PerfectoCustomActions();
                }
            }
        }
        return instance;
    }

    public AppType getType() {
        return type;
    }

    public CustomActions getActions() {
        return customActions;
    }
}
