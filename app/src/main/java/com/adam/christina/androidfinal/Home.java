package com.adam.christina.androidfinal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class Home extends ActionBarActivity {
    User thisUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        thisUser = new User();
        TextView info = (TextView)findViewById(R.id.studentInfo);

        info.setText(thisUser.toString());
//comments

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void goToSchedule(View view){
        Intent scheduleBtn = new Intent(this, ScheduleScreen.class );
        startActivity(scheduleBtn);

    }

    public void goToTuition(View view){
        Intent tuitionBtn = new Intent(this, TuitionCalc.class);
        startActivity(tuitionBtn);
    }

    public void goToGpa(View view){
        Intent gpaScreenBtn = new Intent(this, GpaScreen.class );
        startActivity(gpaScreenBtn);

    }

    public void goToBookstore(View view){
        Intent bookBtn = new Intent(this, BookStore.class);
        startActivity(bookBtn);
    }
}
