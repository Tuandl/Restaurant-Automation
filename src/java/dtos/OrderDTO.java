/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dtos;

import daos.OrderDAO;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author justdoit
 */
public class OrderDTO implements Serializable {
    private String id, tableId, waiterId, status;
    private Timestamp startTime, endTime;
    private List<OrderDetailDTO> listDetail;

    public OrderDTO() {
        listDetail = new ArrayList<>();
    }

    public OrderDTO(String id, String tableId, String waiterId, String status, Timestamp startTime) {
        listDetail = new ArrayList<>();
        this.id = id;
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.status = status;
        this.startTime = startTime;
    }
    
    public OrderDTO(String id, String tableId, String waiterId, String status, Timestamp startTime, Timestamp endTime) {
        listDetail = new ArrayList<>();
        this.id = id;
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public OrderDTO(String id, String tableId, String waiterId, String status, List<OrderDetailDTO> listDetail) {
        this.id = id;
        this.tableId = tableId;
        this.waiterId = waiterId;
        this.status = status;
        this.listDetail = listDetail;
    }
    
    public void addOrderDetail(OrderDetailDTO od) {
        listDetail.add(od);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public String getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetailDTO> getListDetail() {
        return listDetail;
    }

    public void setListDetail(List<OrderDetailDTO> listDetail) {
        this.listDetail = listDetail;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }
    
    public String regenCode() {
        int t = new OrderDAO().count();
        String res = "" + (t+1);
        while (res.length()<3) res = "0" + res;
        res = "OR" + res;
        return res;
    }
}