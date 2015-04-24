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

import java.io.Serializable;





public class MainActivity extends ActionBarActivity implements Serializable {

    private User thisUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       thisUser = (User)getIntent().getSerializableExtra("USER");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    //Button Methods
    public void createScreen(View view){
        Intent applyBtn = new Intent(this, CreateUser.class );
        startActivity(applyBtn);

    }


    public void loginScreen(View view){
        TextView temp = (TextView) findViewById(R.id.userName);
        String userName = (String)temp.getText().toString();

        temp = (TextView) findViewById(R.id.passWord);
        String password = (String)temp.getText().toString();


        //UserDatabase db = new UserDatabase(getBaseContext());

      //added next 8 lines 4/23 01:13
        User user = new User();
        // db.getUser(userName);

        //UserDatabase db =new UserDatabase(getBaseContext());
        //db.getUser(userName);


        boolean salmon = true;

        if  (salmon == true) {

            Intent loginBtn = new Intent(this, Home.class);
            startActivity(loginBtn);

            Context context = getApplicationContext();
            CharSequence text = user.toString();
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        else {
            Context context = getApplicationContext();
            CharSequence text = "Wrong user name or password entered";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }

    public void forgotInfo(View view){
        Intent ForgotBtn = new Intent(this, Forgot.class);
        startActivity(ForgotBtn);
    }
}
