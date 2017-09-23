/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dtos;

import java.io.Serializable;

/**
 *
 * @author justdoit
 */
public class StaffDTO implements Serializable{
    
    public static final String BUS_BOY_ROLE = "Bus Boy";
    public static final String CHEF_ROLE = "Chef";
    public static final String WAITER_ROLE = "Waiter";
    public static final String MALE_GENDER = "Male";
    public static final String FEMALE_GENDER = "Female";
    public static final String HOST_ROLE = "Host";
    public static final String MANAGER_ROLE = "Manager";
    
    private String id, name, gender, role;

    public StaffDTO() {
    }

    public StaffDTO(String id, String name, String gender, String role) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.role = role;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
}