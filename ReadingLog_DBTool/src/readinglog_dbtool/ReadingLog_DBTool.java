/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readinglog_dbtool;

import rm_lib.application.init.RM_AppInit;
import ui.main.MainFrame;

/**
 *
 * @author renhongxiang
 */
public class ReadingLog_DBTool {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initDataBase();
        
        MainFrame frame= new MainFrame();
        frame.setVisible(true);
        // TODO code application logic here
    }
    
    private static boolean initDataBase(){
        RM_AppInit appInit = new RM_DBAppInit();
        appInit.doInit();
        
        return true;
    }
}
