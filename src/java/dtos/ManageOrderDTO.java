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
public class ManageOrderDTO {
    int count;
    float avgTime;
    int income;

    public ManageOrderDTO(int count, float avgTime, int income) {
        this.count = count;
        this.avgTime = avgTime;
        this.income = income;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(float avgTime) {
        this.avgTime = avgTime;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
    
    
    
}