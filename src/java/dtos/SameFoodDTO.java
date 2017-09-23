/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;

/**
 *
 * @author TUANDASE62310
 */
public class SameFoodDTO implements Serializable{
    private String name, id;
    private int pending, served, price;

    public SameFoodDTO() {
    }

    public SameFoodDTO(String name, String id, int pending, int served, int price) {
        this.name = name;
        this.id = id;
        this.pending = pending;
        this.served = served;
        this.price = price;
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
    }

    public int getPending() {
        return pending;
    }

    public void setPending(int pending) {
        this.pending = pending;
    }

    public int getServed() {
        return served;
    }

    public void setServed(int served) {
        this.served = served;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    
}
