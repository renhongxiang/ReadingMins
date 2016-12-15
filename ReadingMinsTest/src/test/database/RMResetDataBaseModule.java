/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.database;

import rautotest.system.RAutoTestModule;

/**
 *
 * @author renhongxiang
 */
public class RMResetDataBaseModule extends RAutoTestModule{
    
    @Override
    public void buildModule(){
        this.addTestCase(new RMDataBaseReset());
    }
    
    
}
