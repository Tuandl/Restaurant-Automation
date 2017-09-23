/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import daos.TableStatusChangeDAO;
import java.sql.Timestamp;

/**
 *
 * @author justdoit
 */
public class TableStatusChangeDTO {

    private String id, staffID, tableID, status;
    Timestamp time;

    public TableStatusChangeDTO(String staffID, String tableID, String status, Timestamp time) {
        regenID();
        this.staffID = staffID;
        this.tableID = tableID;
        this.status = status;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getTableID() {
        return tableID;
    }

    public void setTableID(String tableID) {
        this.tableID = tableID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    private void regenID() {
        id = "" + (new TableStatusChangeDAO().count() + 1);
        while (id.length() < 3)
            id = "0" + id;
        id = "SC" + id;
    }
}
