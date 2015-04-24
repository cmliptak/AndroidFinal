package com.adam.christina.androidfinal;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;


public class CreateUser extends ActionBarActivity implements Serializable, AdapterView.OnItemSelectedListener {


    //Commented 4/23 00:58 declare fields
    private   String userName ;
    private  String password1 ;
    private String password2 ;
    private  String fName ;
    private  String lName ;
    private String semester ;
    private  String demograph ;
    private String address ;
    private TextView temp;
    private boolean valid = true;
    User thisUser;
    UserDatabase db;
    private boolean passwordMatch;

    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.demographic,android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //next 2 lines commented out 4/23 00:58
        thisUser = new User();
        db = new UserDatabase(getBaseContext());
        //setGui();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    // Commented out 4/23 00:58
    public void newMemberLog(View view){
        //next 6 lines added 4/22 00:39

        valid = true;

        setUser();

        setPassword();
        setName();
        setDemograph();
        setStudentInfo();
        setAdd();



        if (valid ==true) {

            if (passwordMatch==true) {
                db.addUser(thisUser);


                //notify user; login
                Context context = getApplicationContext();

                CharSequence text = thisUser.toString();
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                // make an intent and wrap a class in the intent

                Intent button4 = new Intent(this, MainActivity.class);
                // button4.putExtra("USER",(Serializable) thisUser);
                startActivity(button4);
            }
        }
    }

    public void backBtn(View view){
        Intent backBtn = new Intent(this, MainActivity.class);

        startActivity(backBtn);
    }


    /*private int userId;
    private String userPass;
    private String firstName;
    private String lastName;
    private String address;
    private String demog;
    private String semester;

    public void pullInfo ()  {

       setUser();
       setPassword();
       setName();
       setStudentInfo();
       setAdd();

    }*/


    public void setUser(){

        temp = (TextView) findViewById(R.id.user);
        if (temp.getText().toString().equals("")){

            Context context = getApplicationContext();
            CharSequence text = "enter a user name";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {
            this.userName = temp.getText().toString();
            thisUser.setUserId(this.userName);
        }
    }

    public void setPassword(){
        //password

        temp = (TextView) findViewById(R.id.pass);
        if (temp.getText().toString().equals("")){

            Context context = getApplicationContext();
            CharSequence text = "enter a user password";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {
            temp = (TextView) findViewById(R.id.pass);
            this.password1 = temp.getText().toString();
        }


        temp = (TextView) findViewById(R.id.confirmPass);
        if (temp.getText().toString().equals("")){

            Context context = getApplicationContext();
            CharSequence text = "confirm password";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {
            temp = (TextView) findViewById(R.id.confirmPass);
            this.password2 = temp.getText().toString();
        }
        //confirm password


        if (valid==true) {
            //Check if password confirmation matches
            if (this.password1.equals(this.password2)) {
                thisUser.setUserPass(this.password1);
                passwordMatch =true;
            } else {
                passwordMatch =false;

                Context context = getApplicationContext();
                CharSequence text = "Passwords do not match!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
    }

    public void setName(){

        temp = (TextView) findViewById(R.id.fNameEdit);
        if (temp.getText().toString().equals("")){

            Context context = getApplicationContext();
            CharSequence text = "enter your first name";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {
            this.fName = temp.getText().toString();
            thisUser.setFirstName(this.fName);
        }

        //FirstName


        temp = (TextView) findViewById(R.id.lNameEdit);
        if (temp.getText().toString().equals("")){

            Context context = getApplicationContext();
            CharSequence text = "enter your last name";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {
            this.lName = temp.getText().toString();
            thisUser.setLastName(this.lName);
        }
        //LastName


    }

    public void setStudentInfo(){

        temp = (TextView) findViewById(R.id.semesterCreate);
        if (temp.getText().toString().equals("")){

            Context context = getApplicationContext();
            CharSequence text = "enter your semester";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {
            this.semester = temp.getText().toString();
            thisUser.setSemester(this.semester);
        }

    }


    public void setAdd() {

        temp = (TextView) findViewById(R.id.address);
        if (temp.getText().toString().equals("")){

            Context context = getApplicationContext();
            CharSequence text = "enter your address";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {
            this.address =  temp.getText().toString();
            thisUser.setAddress(this.address);
        }


    }

    public void setDemograph() {
        if (spinner.getSelectedItem().equals("Select your demographic")){

            Context context = getApplicationContext();
            CharSequence text = "enter your demographic";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            valid = false;

        }
        else {

            this.demograph = spinner.getSelectedItem().toString();
            thisUser.setDemog(this.demograph);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
