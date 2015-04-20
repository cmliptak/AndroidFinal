import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Christina on 4/19/2015.
 */
public class UserDatabase {//extends SQLiteOpenHelper {

   /* private static final int DATABASE_VERSION = 1;
    private static final String DBNAME = "UserAcctDB";
    //Table Fields
    private static final String USERFIRST = "first";
    private static final String USERLAST = "last";
    private static final String USERID = "id";
    private static final String USERPASS = "pass";
    private static final String USERADDRESS = "address";
    private static final String USERDEMO = "demo";
    private static final String SEMESTER = "semester";

    //Table Names
    private static final String TABLE_USER = "User";//id, username, password, address,
    //private static final String TABLE_STUDENT = "School";//id, demographic, semester


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create User table if none exists
        String CREATE_USER_TABLE = "CREATE TABLE USER "
                + TABLE_USER + "(" + USERID      + "String Primary ID,"
                + USERPASS    + "TEXT,"
                + USERFIRST   + "TEXT,"
                + USERLAST    + "TEXT,"
                + USERADDRESS + "TEXT,"
                + USERDEMO   + "TEXT,"
                + SEMESTER   + "TEXT,"
                + ")";


        // create User table
        db.execSQL(CREATE_USER_TABLE);

        /*Create Student Table if none
        String CREATE_STUDENT_TABLE = "CREATE TABLE STUDENT "
                + TABLE_STUDENT + "(" + USERID     + "String Primary ID,"

                                + ")";


        // create student table
        db.execSQL(CREATE_STUDENT_TABLE);

    }//end onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //upgrades the tables if new version exists
    }*/


    /*Constructor
    public UserDatabase(Context context) {
        super(context, DBNAME, null, DATABASE_VERSION);
    }
    private static final String[] COLUMNS = {USERID, USERPASS, USERFIRST, USERLAST, USERADDRESS, USERDEMO, SEMESTER};


    // inserts a new user into the database
    public void addUser(User person){
        Log.d("addUser", person.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(USERID, person.getId()); // get id
        values.put(USERPASS, person.getUserPass());//get password
        values.put(USERFIRST, person.getFname()); // get First name
        values.put(USERLAST, person.getLname()); // get Last name
        values.put(USERADDRESS, person.getAddress()); //get address
        values.put(USERDEMO, person.getDemog()); //get demographic
        values.put(SEMESTER, person.getSemester()); //get Semester

        // 3. insert
        db.insert(TABLE_USER, // table
                null, values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public User getUser(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_USER, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build user object
        User person = new User();
        person.setId(Integer.parseInt(cursor.getString(0)));
        person.setPassword(cursor.getString(1));
        person.setFname(cursor.getString(2));
        person.setLname(cursor.getString(3));
        person.setAddress(cursor.getString(4));
        person.setSemester(cursor.getString(5));
        person.setDemog(cursor.getString(6));

        Log.d("getUser("+id+")", person.toString());

        // 5. return book
        return person;
    }

    // Get All Books
    public List<User> getAllPeople() {
        List<User> people = new LinkedList<User>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_USER;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        User person = null;
        if (cursor.moveToFirst()) {
            do {
                person = new User();
                person.setId(Integer.parseInt(cursor.getString(0)));
                person.setPassword(cursor.getString(1));
                person.setFname(cursor.getString(2));
                person.setLname(cursor.getString(3));
                person.setAddress(cursor.getString(4));
                person.setSemester(cursor.getString(5));
                person.setDemog(cursor.getString(6));


                // Add book to books
                people.add(person);
            } while (cursor.moveToNext());
        }

        Log.d("getAllPeople()", people.toString());

        // return books
        return people;
    }

    // Updating single user
    public int updateUser(User person) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("id", person.getId()); // get User ID
        values.put("pass", person.getUserPass());//get password
        values.put("first", person.getFname()); // get First name
        values.put("last", person.getLname()); //get Last name
        values.put("address", person.getAddress()); //getAddress
        values.put("demo", person.getDemog()); //get demo
        values.put("semester", person.getSemester());//getsemester

        // 3. updating row
        int i = db.update(TABLE_USER, //table
                values, // column/value
                USERID+" = ?", // selections
                new String[] { String.valueOf(person.getUserId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    /* Deleting single book
    public void deleteBook(Book book) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_BOOKS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(book.getId()) });

        // 3. close
        db.close();

        Log.d("deleteBook", book.toString());

    }*/
}