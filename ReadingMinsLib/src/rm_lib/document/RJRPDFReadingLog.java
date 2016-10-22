/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.document;

import rcommon.utils.file.RFileIOUtils;
import rjasper.RJRPDFXMLDSBase;

/**
 *
 * @author renhongxiang
 */
public class RJRPDFReadingLog extends RJRPDFXMLDSBase{

    private static final String fileName = "\\Documents\\ReadingLog.jasper";
    
    private String tempFolderPath = null;

    public String getTempFolderPath() {
        return tempFolderPath;
    }

    public void setTempFolderPath(String tempFolderPath) {
        this.tempFolderPath = tempFolderPath;
    }

    @Override
    protected String getTempFilePath(){
        return RFileIOUtils.getPathInFolder(getTempFolderPath(), fileName);
    }
    
    
}
