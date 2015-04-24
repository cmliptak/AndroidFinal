package com.adam.christina.androidfinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.adam.christina.androidfinal.R;

import java.io.Serializable;

/**
 * Created by Christina on 4/19/2015.
 */
public class User extends Activity implements Serializable {

    private String userId;
    private String userPass;
    private String firstName;
    private String lastName;
    private String address;
    private String demog;
    private String semester;
    UserDatabase thisUser =  new UserDatabase(getBaseContext());

//Constructors
    public User(){

    }

    public User(String userId, String userPass, String firstName, String lastName, String address, String demog, String semester) {
        this.setUserId(userId);
        this.setUserPass(userPass);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setDemog(demog);
        this.setSemester(semester);

    }

    //Setters
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPass(String password) {
        this.userPass = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDemog(String demog) {
        this.demog = demog;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }


    @Override
    public String toString(){
        return "Username: " + this.userId + "\n" + "\n"
                +"First Name: " + this.firstName + "\n" + "\n"
                +"Last Name: " + this.lastName + "\n" + "\n"
                +"Demographic: " + this.demog + "\n" + "\n"
                +"Semester: " + this.semester;

    }

    //Getters

    public String getUserId() {
        return userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSemester() {
        return semester;
    }

    public String getDemog() {
        return demog;
    }

    public String getAddress() {
        return address;
    }

    public String getLastName() {
        return lastName;
    }


}
