/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author justdoit
 */
public class ManageWaiterDTO {

    String id, name;
    int cntOrder, income;

    public ManageWaiterDTO(String id, String name, int cntOrder, int income) {
        this.id = id;
        this.name = name;
        this.cntOrder = cntOrder;
        this.income = income;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCntOrder() {
        return cntOrder;
    }

    public void setCnt(int cntOrder) {
        this.cntOrder = cntOrder;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

}
