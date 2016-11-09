/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rm_lib.document;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import rcommon.utils.datatype.RStringUtils;
import rm_lib.data.RM_ReadingMins;

/**
 *
 * @author renhongxiang
 */
public class RM_ReadingMinsDocData {

    private HashSet<String> titleSet = null;
    private List<String> titleList = null;
    private Integer readMins = 0;

    public void addReadingMins(RM_ReadingMins mins) {
        if (mins != null) {
            HashSet<String> titleSet = this.getTitleSet();
            String title = mins.getBookTitle();
            String upcaseTitle = RStringUtils.upperCase(title);
            if (!titleSet.contains(upcaseTitle)) {
                titleSet.add(upcaseTitle);
                this.addTitleToList(title);
            }
            readMins = readMins + mins.getReadMins();
        }
    }

    public HashSet<String> getTitleSet() {
        if (titleSet == null) {
            titleSet = new HashSet<String>();
        }
        return titleSet;
    }

    public void addTitleToList(String Title) {
        List<String> list = getTitleList();
        list.add(Title);
    }

    public List<String> getTitleList() {
        if (titleList == null) {
            titleList = new ArrayList<String>();
        }
        return titleList;
    }

    public String getReadingTitle() {
        List<String> list = getTitleList();
        if (list != null) {
            StringBuilder builder = new StringBuilder();
            boolean start = true;
            for (String title : list) {
                if (start) {
                    start = false;
                } else {
                    builder.append(", ");
                }
                builder.append(title);
            }
            return builder.toString();
        }
        return "";
    }

    public Integer getReadMins() {
        return readMins;
    }
    
    
}
