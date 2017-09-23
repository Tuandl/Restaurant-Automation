/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dtos;

import daos.OrderDetailDAO;
import java.io.Serializable;

/**
 *
 * @author justdoit
 */
public class OrderDetailDTO implements Serializable{
    
    public static final String WAITING_STATUS = "1";
    public static final String COOKING_STATUS = "2";
    public static final String COOKED_STATUS = "3";
    public static final String SERVED_STATUS = "4";
    
    private String code, orderId, foodId, chefId, status;
    private int waiting,cooking,cooked,quantity;
    

    
    public OrderDetailDTO() {
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    public int getCooking() {
        return cooking;
    }

    public void setCooking(int cooking) {
        this.cooking = cooking;
    }

    public int getCooked() {
        return cooked;
    }

    public void setCooked(int cooked) {
        this.cooked = cooked;
    }

    public OrderDetailDTO(String code, String orderId, String foodId, int quantity, String chefId, String status) {
        this.code = code;
        this.orderId = orderId;
        this.foodId = foodId;
        this.quantity = quantity;
        this.chefId = chefId;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        OrderDetailDAO dao = new OrderDetailDAO();
        dao.update(this);
    }

    public String getChefId() {
        return chefId;
    }

    public void setChefId(String chefId) {
        this.chefId = chefId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String regenCode() {
        int t = new OrderDetailDAO().count();
        String res = "" + (t);
        while (res.length()<3) res = "0" + res;
        res = "OD" + res;
        return res;
    }
    
}