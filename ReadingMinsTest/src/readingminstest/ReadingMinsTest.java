/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readingminstest;

import ui.main.MainFrame;

/**
 *
 * @author renhongxiang
 */
public class ReadingMinsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        initOperation();
        MainFrame frame= new MainFrame();
        frame.setVisible(true);
    }
    
    private static boolean initOperation(){        
        RM_AppInitTest ini = new RM_AppInitTest();
        ini.doInit();
        return true;
    }
    
}
