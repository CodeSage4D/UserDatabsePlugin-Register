// package cordova.plugin.user.database;

// import android.content.ContentValues;
// import android.content.Context;
// import android.database.Cursor;
// import android.database.sqlite.SQLiteDatabase;
// import android.database.sqlite.SQLiteOpenHelper;

// public class DatabaseHelper extends SQLiteOpenHelper {

//     // Database name and version
//     private static final String DATABASE_NAME = "UserData.db";
//     private static final int DATABASE_VERSION = 1;

//     // Table name and column names
//     public static final String TABLE_NAME = "RegisterUsers";
//     public static final String COLUMN_USERNAME = "username";
//     public static final String COLUMN_NAME = "name";
//     public static final String COLUMN_EMAIL = "email";
//     public static final String COLUMN_PASSWORD = "password";

//     // SQL statement to create the table
//     private static final String SQL_CREATE_REGISTER_USERS_TABLE =
//             "CREATE TABLE " + TABLE_NAME + " (" +
//                     COLUMN_USERNAME + " TEXT PRIMARY KEY," +
//                     COLUMN_NAME + " TEXT," +
//                     COLUMN_EMAIL + " TEXT," +
//                     COLUMN_PASSWORD + " TEXT)";

//     public DatabaseHelper(Context context) {
//         super(context, DATABASE_NAME, null, DATABASE_VERSION);
//         // Create the database if it doesn't exist
//         getReadableDatabase();  // code added by me
//     }


//     @Override
//     public void onCreate(SQLiteDatabase db) {
//         // Create the RegisterUsers table
//         db.execSQL(SQL_CREATE_REGISTER_USERS_TABLE);
//     }

//     @Override
//     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//         // Drop the old table if it exists
//         db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
//         // Create the new table
//         onCreate(db);
//     }

//     // Method to insert user data into the database
//     public boolean insertUserData(String username, String name, String email, String password) {
//         SQLiteDatabase db = this.getWritableDatabase();
//         ContentValues contentValues = new ContentValues();
//         contentValues.put(COLUMN_USERNAME, username);
//         contentValues.put(COLUMN_NAME, name);
//         contentValues.put(COLUMN_EMAIL, email);
//         contentValues.put(COLUMN_PASSWORD, password);
//         long result = db.insert(TABLE_NAME, null, contentValues);
//         return result != -1;
//     }

//     // Method to fetch user data from the database and return as a JSONObject
//     public Cursor getUserData(String username) {
//         SQLiteDatabase db = this.getReadableDatabase();
//         String[] projection = {COLUMN_NAME, COLUMN_EMAIL, COLUMN_PASSWORD};
//         String selection = COLUMN_USERNAME + " = ?";
//         String[] selectionArgs = {username};
//         return db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null);
//     }

//     // Method to update user data in the database
//     public boolean updateUserData(String username, String name, String email, String password) {
//         SQLiteDatabase db = this.getWritableDatabase();
//         ContentValues contentValues = new ContentValues();
//         contentValues.put(COLUMN_NAME, name);
//         contentValues.put(COLUMN_EMAIL, email);
//         contentValues.put(COLUMN_PASSWORD, password);
//         String selection = COLUMN_USERNAME + " = ?";
//         String[] selectionArgs = {username};
//         int rowsAffected = db.update(TABLE_NAME, contentValues, selection, selectionArgs);
//         return rowsAffected > 0;
//     }

//     // Method to delete user data from the database
//     public boolean deleteUserData(String username) {
//         SQLiteDatabase db = this.getWritableDatabase();
//         String selection = COLUMN_USERNAME + " = ?";
//         String[] selectionArgs = {username};
//         int rowsAffected = db.delete(TABLE_NAME, selection, selectionArgs);
//         return rowsAffected > 0;
//     }

//     public DatabaseHelper(Context context) {
//         super(context, DATABASE_NAME, null, DATABASE_VERSION);
//         // Create the database if it doesn't exist
//         getReadableDatabase();  // This line ensures that the database is created
//     }
//     public Cursor getUserData(String username) {
//         SQLiteDatabase db = this.getReadableDatabase();
//         String[] projection = {COLUMN_NAME, COLUMN_EMAIL, COLUMN_PASSWORD};
//         String selection = COLUMN_USERNAME + " = ?";
//         String[] selectionArgs = {username};
//         return db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null);
//     }
    

// }
//=======================================================


package cordova.plugin.user.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database name and version
    private static final String DATABASE_NAME = "UserData.db";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    public static final String TABLE_NAME = "RegisterUsers";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASSWORD = "password";

    // SQL statement to create the table
    private static final String SQL_CREATE_REGISTER_USERS_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_USERNAME + " TEXT PRIMARY KEY," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_PASSWORD + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // Create the database if it doesn't exist
        getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the RegisterUsers table
        db.execSQL(SQL_CREATE_REGISTER_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table if it exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // Create the new table
        onCreate(db);
    }

    // Method to insert user data into the database
    public boolean insertUserData(String username, String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USERNAME, username);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        return result != -1;
    }

    // Method to fetch user data from the database and return as a Cursor
    public Cursor getUserData(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {COLUMN_NAME, COLUMN_EMAIL, COLUMN_PASSWORD};
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};
        return db.query(TABLE_NAME, projection, selection, selectionArgs, null, null, null);
    }

    // Method to update user data in the database
    public boolean updateUserData(String username, String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_PASSWORD, password);
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};
        int rowsAffected = db.update(TABLE_NAME, contentValues, selection, selectionArgs);
        return rowsAffected > 0;
    }

    // Method to delete user data from the database
    public boolean deleteUserData(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USERNAME + " = ?";
        String[] selectionArgs = {username};
        int rowsAffected = db.delete(TABLE_NAME, selection, selectionArgs);
        return rowsAffected > 0;
    }
}
