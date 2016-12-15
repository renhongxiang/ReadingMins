/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readinglog.app.init;

import rcommon.app.setting.RAppSetting;

/**
 *
 * @author renhongxiang
 */
public class RMAppSetting extends RAppSetting{

    public static boolean developInstance = true;

//    public static boolean autoTestInstance = true;
    
    public static boolean isDevelopInstance() {
        return developInstance;
    }

    public static void setDevelopInstance(boolean developInstance) {
        RMAppSetting.developInstance = developInstance;
    }    
    
    @Override
    public boolean isDebug() {
        return developInstance;
    }

//    @Override
//    public boolean isAutoTest() {
//        return autoTestInstance;
//    }
    
    
}
