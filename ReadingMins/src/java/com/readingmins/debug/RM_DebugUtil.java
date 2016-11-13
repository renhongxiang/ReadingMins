/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.readingmins.debug;

import com.framework.debug.RSpDebugUtil;
import org.springframework.ui.ModelMap;

/**
 *
 * @author renhongxiang
 */
public class RM_DebugUtil extends RSpDebugUtil{

    @Override
    public void buildPageDebugAtt(ModelMap model){
        if(this.isDebugVersion()){
            model.addAttribute("buildType", "Debug");
        }else{
            model.addAttribute("buildType", "");
        }
    }
    
}
