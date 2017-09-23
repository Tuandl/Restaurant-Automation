/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author justdoit
 */
public class TableDTO implements Serializable{
    
    public static final String READY_STATUS = "1";
    public static final String ORDERING_STATUS = "2";
    public static final String SERVING_STATUS = "3";
    public static final String DIRTY_STATUS = "4"; 
    
    private String id, status, name;

    public TableDTO() {
    }

    public TableDTO(String id, String status) {
        this.id = id;
        this.status = status;
        name = "Table " + Integer.parseInt(id.substring(2, 5));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        name = "Table " + Integer.parseInt(id.substring(2, 5));
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static String getREADY_STATUS() {
        return READY_STATUS;
    }

    public static String getORDERING_STATUS() {
        return ORDERING_STATUS;
    }

    public static String getSERVING_STATUS() {
        return SERVING_STATUS;
    }

    public static String getDIRTY_STATUS() {
        return DIRTY_STATUS;
    }
    
    public static List<TableDTO> sortByPriority(List<TableDTO> input, String p0, String p1, String p2, String p3) {
        List<TableDTO> res = new ArrayList<>(input);
        List<String> pri = new ArrayList<>();
        pri.add(p0);
        pri.add(p1);
        pri.add(p2);
        pri.add(p3);
        res.sort(new Comparator<TableDTO>() {
            @Override
            public int compare(TableDTO o1, TableDTO o2) {
                return Integer.compare(pri.indexOf(o1.getStatus()), pri.indexOf(o2.getStatus()));
            }
        });
        return res;
    }
    
}