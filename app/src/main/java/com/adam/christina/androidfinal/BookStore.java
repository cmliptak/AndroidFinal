package com.adam.christina.androidfinal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class BookStore extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_store, menu);
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
    public void searchCheg (View view){
        Intent chegBtn = new Intent(this, MainActivity.class);
        startActivity(chegBtn);

    }

    public void searchBarns (View view){
        Intent barnsBtn = new Intent(this, MainActivity.class);
        startActivity(barnsBtn);

    }

    public void searchInput (View view){

        TextView temp = (TextView) findViewById(R.id.ownSite);
        String site = (String)temp.getText().toString();

        Intent searchBtn = new Intent(this, MainActivity.class);
        startActivity(searchBtn);

    }

    public void backToMain (View view){
        Intent backBtn = new Intent(this, Home.class);
        startActivity(backBtn);

    }
}
