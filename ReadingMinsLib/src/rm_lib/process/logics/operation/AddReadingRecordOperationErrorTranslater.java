/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.process.logics.operation;

import rcommon.rerror.RErrorCodeTranslater;
import rcommon.rerror.RErrorPair;

/**
 *
 * @author renhongxiang
 */
public class AddReadingRecordOperationErrorTranslater implements RErrorCodeTranslater{

    public static final int ERR_DATE_MISSING = 1;
    public static final int ERR_TITLE_MISSING = 2;
    public static final int ERR_MINS_MISSING = 3;
    
    
    private static AddReadingRecordOperationErrorTranslater translater = null;

    public static AddReadingRecordOperationErrorTranslater getTranslater() {
        if(translater == null){
            translater = new AddReadingRecordOperationErrorTranslater();
        }
        return translater;
    }

    public static void setTranslater(AddReadingRecordOperationErrorTranslater translater) {
        AddReadingRecordOperationErrorTranslater.translater = translater;
    }
    
    
    @Override
    public String translateError(int code, String addMessage) {
        switch(code){
            case ERR_DATE_MISSING:
                return "Date is missing";
            case ERR_TITLE_MISSING:
                return "Reading title cannot be blank";
            case ERR_MINS_MISSING:
                return "Reading minutes must more than 0";
        }
        return null;
    }

    @Override
    public RErrorPair translateErrorToPair(int code, String addMessage) {
        RErrorPair pair = new RErrorPair();
        switch(code){
            case ERR_DATE_MISSING:
                pair.setType("date");
                break;
            case ERR_TITLE_MISSING:
                pair.setType("title");
                break;
            case ERR_MINS_MISSING:
                pair.setType("mins");
                break;
        }
        pair.setMessage(this.translateError(code, addMessage));
        return pair;
    }
    
}
