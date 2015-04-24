package com.adam.christina.androidfinal;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


public class TuitionCalc extends ActionBarActivity {

    private int numberOfCredits;
    private double baseCost = 300.00;
    private double discount;
    private double grants = 00.00;
    private double finAid = 00.00;
    private double bookCost = 00.00;
    private double total = 00.00;
    //gui variables
    TextView a, b, c, d, e, f, g;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuition_calc);

        setFields();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tuition_calc, menu);
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

    public void setBase(){
        numberOfCredits = Integer.parseInt(a.getText().toString());

        //set base tuition
        baseCost *= numberOfCredits;
        b.setText("$" + baseCost);

    }

    public void calculateTuition(View view)
    {
        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        numberOfCredits = Integer.parseInt(a.getText().toString());

        //set base tuition
        baseCost *= numberOfCredits;
        b.setText("$" + baseCost);

        //set discount
        if (checkBox.isChecked()) {
              discount = 800.00;
              c.setText("Instate Discount is $" + discount);
           }
        else{
            discount = 00.00;
        }

        grants = Integer.parseInt(d.getText().toString());
        finAid = Integer.parseInt(e.getText().toString());
        bookCost = Integer.parseInt(f.getText().toString());
        //calculate total
        total = (baseCost - discount - grants - finAid + bookCost);
        g.setText("$" + total);
    }

    public void setFields()
    {
        a = (TextView)findViewById(R.id.editText15); //# of classes
        b = (TextView)findViewById(R.id.editText16);// tuition base
        c = (TextView)findViewById(R.id.textView7);//instate discount
        d = (TextView)findViewById(R.id.editText17);//grants
        e = (TextView)findViewById(R.id.editText18);//financial aid
        f = (TextView)findViewById(R.id.editText19);//book estimation
        g = (TextView)findViewById(R.id.textView8); //total est. cost

    }
}
