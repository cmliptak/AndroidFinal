package com.adam.christina.androidfinal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GpaScreen extends ActionBarActivity {


    public TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpa_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gpa_screen, menu);
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


    public void calculate(View view){

        int a, b , c, d, f;

        temp = (TextView) findViewById(R.id.A);
        if (temp.getText().toString().equals("") ) {
            a =  0;
        }
        else {
            a = Integer.parseInt(temp.getText().toString());
        }

        temp = (TextView) findViewById(R.id.B);
        if (temp.getText().toString().equals("") ) {
            b =  0;
        }
        else {
            b = Integer.parseInt(temp.getText().toString());
        }

        temp = (TextView) findViewById(R.id.C);
        if (temp.getText().toString().equals("") ) {
            c =  0;
        }
        else {
            c = Integer.parseInt(temp.getText().toString());
        }

        temp = (TextView) findViewById(R.id.D);
        if (temp.getText().toString().equals("") ) {
            d =  0;
        }
        else {
            d = Integer.parseInt(temp.getText().toString());
        }

        temp = (TextView) findViewById(R.id.F);
        if (temp.getText().toString().equals("") ) {
            f =  0;
        }
        else {
            f = Integer.parseInt(temp.getText().toString());
        }


        int totalCredits = a + b + c + d + f;

        double gpa;

        if (totalCredits >= 0) {
            gpa = ((a * 4) + (b * 3) + (c * 2) + (d * 1)) / totalCredits;
        }
        else{
            gpa = 0;
        }
        TextView info = (TextView)findViewById(R.id.textView7);
        String gpa1 = "" + gpa;
        info.setText(gpa1);



    }

    public void backHome(View view) {

        Intent backHome = new Intent(this, Home.class);
        startActivity(backHome);
    }

}
