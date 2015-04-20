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

/**
 * Created by Christina on 4/19/2015.
 */
public class User extends Activity{

    private int userId;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String demog;
    private String semester;

    /*TextView id = (TextView)findViewById(R.id.user);
    TextView pass = (TextView)findViewById(R.id.passWord);
    TextView fname = (TextView)findViewById(R.id.fName);*/

    public User(){}

    public User(String title, String author) {
        super();

    }
}
