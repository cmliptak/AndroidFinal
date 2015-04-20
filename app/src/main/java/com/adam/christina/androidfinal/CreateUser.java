package com.adam.christina.androidfinal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class CreateUser extends ActionBarActivity {


    // declare fields
    private   String userName ;
    private  String password1 ;
    private String password2 ;
    private  String fName ;
    private  String lName ;
    private String semester ;
    private  String demograph ;
    private String address ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
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


    public void newMemberLog(View view){

        Context context = getApplicationContext();
        CharSequence text = "Account created. Please log in";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent button4 = new Intent(this, MainActivity.class);
        startActivity(button4);
    }

    public void backBtn(View view){
        Intent backBtn = new Intent(this, MainActivity.class);
        startActivity(backBtn);
    }

    public void writeToDB(){


    }

    public void pullInfo ()  {

        TextView temp = (TextView) findViewById(R.id.user);
        this.userName = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.pass);
        this.password1 = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.confirmPass);
        this.password2 = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.fNameEdit);
        this.fName = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.lNameEdit);
        this.lName = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.semesterCreate);
        this.semester = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.demoEdit);
        this.demograph = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.address);
        this.address = (String)temp.getText().toString();

    }
}
