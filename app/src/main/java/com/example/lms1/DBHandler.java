package com.example.lms1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;


public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "LibraryManager.db";
    private static final int DATABASE_VERSION = 1;

    // User Table
    private static final String TABLE_USERS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_EMAIL = "email";

    // Book Table
    private static final String TABLE_BOOK = "Book";
    private static final String BOOK_ID = "BOOK_ID";
    private static final String TITLE = "TITLE";
    private static final String BOOK_PUBLISHER_NAME = "PUBLISHER_NAME";

    // Publisher Table
    private static final String TABLE_PUBLISHER = "Publisher";
    private static final String PUBLISHER_NAME = "NAME";
    private static final String PUBLISHER_ADDRESS = "ADDRESS";
    private static final String PUBLISHER_PHONE = "PHONE";

    // Branch Table
    private static final String TABLE_BRANCH = "Branch";
    private static final String BRANCH_ID = "BRANCH_ID";
    private static final String BRANCH_NAME = "BRANCH_NAME";
    private static final String BRANCH_ADDRESS = "ADDRESS";

    // Member Table
    private static final String TABLE_MEMBER = "Member";
    private static final String MEMBER_CARD_NO = "CARD_NO";
    private static final String MEMBER_NAME = "NAME";
    private static final String MEMBER_ADDRESS = "ADDRESS";
    private static final String MEMBER_PHONE = "PHONE";
    private static final String MEMBER_UNPAID_DUES = "UNPAID_DUES";

    // Book Author Table
    private static final String TABLE_BOOK_AUTHOR = "Book_Author";
    private static final String AUTHOR_NAME = "AUTHOR_NAME";

    // Book Copy Table
    private static final String TABLE_BOOK_COPY = "Book_Copy";
    private static final String ACCESS_NO = "ACCESS_NO";

    // Book Loan Table
    private static final String TABLE_BOOK_LOAN = "Book_Loan";
    private static final String DATE_OUT = "DATE_OUT";
    private static final String DATE_DUE = "DATE_DUE";
    private static final String DATE_RETURNED = "DATE_RETURNED";



    // SQL Statement to create the "Users" table
    private static final String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_USERNAME + " TEXT,"
            + KEY_PASSWORD + " TEXT,"
            + KEY_EMAIL + " TEXT" + ");";

    // SQL Statement to create the "Book" table
    private static final String CREATE_TABLE_BOOK = "CREATE TABLE " + TABLE_BOOK + "("
            + BOOK_ID + " VARCHAR(13),"
            + TITLE + " VARCHAR(30),"
            + BOOK_PUBLISHER_NAME + " VARCHAR(20),"
            + "PRIMARY KEY (" + BOOK_ID + "));";

    private static final String CREATE_TABLE_PUBLISHER = "CREATE TABLE " + TABLE_PUBLISHER + "("
            + PUBLISHER_NAME + " VARCHAR(20),"
            + PUBLISHER_ADDRESS + " VARCHAR(30),"
            + PUBLISHER_PHONE + " VARCHAR(10),"
            + "PRIMARY KEY (" + PUBLISHER_NAME + "));";

    private static final String CREATE_TABLE_BRANCH = "CREATE TABLE " + TABLE_BRANCH + "("
            + BRANCH_ID + " VARCHAR(5),"
            + BRANCH_NAME + " VARCHAR(20),"
            + BRANCH_ADDRESS + " VARCHAR(30),"
            + "PRIMARY KEY (" + BRANCH_ID + "));";

    private static final String CREATE_TABLE_MEMBER = "CREATE TABLE " + TABLE_MEMBER + "("
            + MEMBER_CARD_NO + " VARCHAR(10),"
            + MEMBER_NAME + " VARCHAR(20),"
            + MEMBER_ADDRESS + " VARCHAR(30),"
            + MEMBER_PHONE + " VARCHAR(10),"
            + MEMBER_UNPAID_DUES + " NUMBER(5,2),"
            + "PRIMARY KEY (" + MEMBER_CARD_NO + "));";

    private static final String CREATE_TABLE_BOOK_AUTHOR = "CREATE TABLE " + TABLE_BOOK_AUTHOR + "("
            + BOOK_ID + " VARCHAR(13),"
            + AUTHOR_NAME + " VARCHAR(20),"
            + "PRIMARY KEY (" + BOOK_ID + ", " + AUTHOR_NAME + "),"
            + "FOREIGN KEY (" + BOOK_ID + ") REFERENCES " + TABLE_BOOK + "(" + BOOK_ID + "));";

    private static final String CREATE_TABLE_BOOK_COPY = "CREATE TABLE " + TABLE_BOOK_COPY + "("
            + BOOK_ID + " VARCHAR(13),"
            + BRANCH_ID + " VARCHAR(5),"
            + ACCESS_NO + " VARCHAR(5),"
            + "PRIMARY KEY (" + ACCESS_NO + ", " + BRANCH_ID + "),"
            + "FOREIGN KEY (" + BOOK_ID + ") REFERENCES " + TABLE_BOOK + "(" + BOOK_ID + "),"
            + "FOREIGN KEY (" + BRANCH_ID + ") REFERENCES " + TABLE_BRANCH + "(" + BRANCH_ID + "));";

    private static final String CREATE_TABLE_BOOK_LOAN = "CREATE TABLE " + TABLE_BOOK_LOAN + "("
            + ACCESS_NO + " VARCHAR(5),"
            + BRANCH_ID + " VARCHAR(5),"
            + MEMBER_CARD_NO + " VARCHAR(5),"
            + DATE_OUT + " DATE,"
            + DATE_DUE + " DATE,"
            + DATE_RETURNED + " DATE,"
            + "PRIMARY KEY (" + ACCESS_NO + ", " + BRANCH_ID + ", " + MEMBER_CARD_NO + ", " + DATE_OUT + "),"
            + "FOREIGN KEY (" + ACCESS_NO + ", " + BRANCH_ID + ") REFERENCES " + TABLE_BOOK_COPY + "(" + ACCESS_NO + ", " + BRANCH_ID + "),"
            + "FOREIGN KEY (" + MEMBER_CARD_NO + ") REFERENCES " + TABLE_MEMBER + "(" + MEMBER_CARD_NO + "),"
            + "FOREIGN KEY (" + BRANCH_ID + ") REFERENCES " + TABLE_BRANCH + "(" + BRANCH_ID + "));";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create Users table
        db.execSQL(CREATE_USERS_TABLE);

        // Create Book table
        db.execSQL(CREATE_TABLE_BOOK);

        // Create Publisher table
        db.execSQL(CREATE_TABLE_PUBLISHER);

        // Create Branch table
        db.execSQL(CREATE_TABLE_BRANCH);

        // Create Member table
        db.execSQL(CREATE_TABLE_MEMBER);

        // Create Book Author table
        db.execSQL(CREATE_TABLE_BOOK_AUTHOR);

        // Create Book Copy table
        db.execSQL(CREATE_TABLE_BOOK_COPY);

        // Create Book Loan table
        db.execSQL(CREATE_TABLE_BOOK_LOAN);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop all tables in the reverse order of their creation dependencies
        db.execSQL("DROP TABLE IF EXISTS Book_Loan");
        db.execSQL("DROP TABLE IF EXISTS Book_Copy");
        db.execSQL("DROP TABLE IF EXISTS Book_Author");
        db.execSQL("DROP TABLE IF EXISTS Member");
        db.execSQL("DROP TABLE IF EXISTS Branch");
        db.execSQL("DROP TABLE IF EXISTS Publisher");
        db.execSQL("DROP TABLE IF EXISTS Book");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        // Call onCreate to recreate the database with the updated schema
        onCreate(db);
    }

    // CRUD methods for Users

    public void addUser(String username, String password, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_EMAIL, email);
        db.insert(TABLE_USERS, null, values);

        long result = db.insert("users", null, values);
        if (result == -1) {
            Log.e("DB_ERROR", "Failed to insert data");
        } else {
            Log.d("DB_SUCCESS", "Data inserted successfully");
        }
        db.close();
    }

    public Cursor getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_ID, KEY_USERNAME, KEY_EMAIL},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    public int updateUser(int id, String username, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_EMAIL, email);
        return db.update(TABLE_USERS, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USERS, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_USERS, new String[]{KEY_ID},
                KEY_USERNAME + "=? AND " + KEY_PASSWORD + "=?",
                new String[]{username, password}, null, null, null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        return cursorCount > 0;
    }

    // Books CRUD Operations
    public void addBook(String bookId, String title, String publisherName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOK_ID, bookId);
        values.put(TITLE, title);
        values.put(BOOK_PUBLISHER_NAME, publisherName);
        db.insert(TABLE_BOOK, null, values);
        db.close();
    }



    public int updateBook(String bookId, String title, String publisherName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TITLE, title);
        values.put(BOOK_PUBLISHER_NAME, publisherName);
        return db.update(TABLE_BOOK, values, BOOK_ID + " = ?", new String[]{bookId});
    }

    public void deleteBook(String bookId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOK, BOOK_ID + " = ?", new String[]{bookId});
        db.close();
    }

    // Add a new publisher to the database
    public void addPublisher(String name, String address, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PUBLISHER_NAME, name);
        values.put(PUBLISHER_ADDRESS, address);
        values.put(PUBLISHER_PHONE, phone);
        db.insert(TABLE_PUBLISHER, null, values);
        db.close();
    }

    // Update a publisher's details in the database
    public int updatePublisher(String name, String address, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PUBLISHER_ADDRESS, address);
        values.put(PUBLISHER_PHONE, phone);
        return db.update(TABLE_PUBLISHER, values, PUBLISHER_NAME + " = ?", new String[]{name});
    }

    // Delete a publisher from the database
    public int deletePublisher(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = "name=?";
        String[] whereArgs = new String[] { name };
        int rowsAffected = db.delete(TABLE_PUBLISHER, whereClause, whereArgs);
        db.close();
        return rowsAffected;
    }

    // Add a new branch to the database
    public void addBranch(String branchId, String branchName, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BRANCH_ID, branchId);
        values.put(BRANCH_NAME, branchName);
        values.put(BRANCH_ADDRESS, address);
        db.insert(TABLE_BRANCH, null, values);
        db.close();
    }

    // Update a branch's details in the database
    public int updateBranch(String branchId, String branchName, String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BRANCH_NAME, branchName);
        values.put(BRANCH_ADDRESS, address);
        return db.update(TABLE_BRANCH, values, BRANCH_ID + " = ?", new String[]{branchId});
    }

    // Delete a branch from the database
    public void deleteBranch(String branchId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BRANCH, BRANCH_ID + " = ?", new String[]{branchId});
        db.close();
    }

    // Add a new member to the database
    public void addMember(String cardNo, String name, String address, String phone, double unpaidDues) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MEMBER_CARD_NO, cardNo);
        values.put(MEMBER_NAME, name);
        values.put(MEMBER_ADDRESS, address);
        values.put(MEMBER_PHONE, phone);
        values.put(MEMBER_UNPAID_DUES, unpaidDues);
        db.insert(TABLE_MEMBER, null, values);
        db.close();
    }

    // Update a member's details in the database
    public int updateMember(String cardNo, String name, String address, String phone, double unpaidDues) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MEMBER_NAME, name);
        values.put(MEMBER_ADDRESS, address);
        values.put(MEMBER_PHONE, phone);
        values.put(MEMBER_UNPAID_DUES, unpaidDues);
        return db.update(TABLE_MEMBER, values, MEMBER_CARD_NO + " = ?", new String[] { cardNo });
    }

    // Delete a member from the database
    public void deleteMember(String cardNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MEMBER, MEMBER_CARD_NO + " = ?", new String[] { cardNo });
        db.close();
    }

    // Add a new book author relationship to the database
    public void addBookAuthor(String bookId, String authorName) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOK_ID, bookId);
        values.put(AUTHOR_NAME, authorName);
        db.insert(TABLE_BOOK_AUTHOR, null, values);
        db.close();
    }


    // Delete a book author relationship
    public void deleteBookAuthor(String authorName) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOK_AUTHOR,  AUTHOR_NAME + " = ?", new String[] { authorName });
        db.close();
    }

    // Add a new book copy to the database
    public void addBookCopy(String bookId, String branchId, String accessNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOK_ID, bookId);
        values.put(BRANCH_ID, branchId);
        values.put(ACCESS_NO, accessNo);
        db.insert(TABLE_BOOK_COPY, null, values);
        db.close();
    }

    // Delete a book copy
    public void deleteBookCopy(String accessNo, String branchId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BOOK_COPY, ACCESS_NO + " = ? AND " + BRANCH_ID + " = ?", new String[] { accessNo, branchId });
        db.close();
    }

    // Add a new book loan to the database
    public void addBookLoan(String accessNo, String branchId, String cardNo, String dateOut, String dateDue, String dateReturned) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ACCESS_NO, accessNo);
        values.put(BRANCH_ID, branchId);
        values.put(MEMBER_CARD_NO, cardNo);
        values.put(DATE_OUT, dateOut);
        values.put(DATE_DUE, dateDue);
        values.put(DATE_RETURNED, dateReturned);
        db.insert(TABLE_BOOK_LOAN, null, values);
        db.close();
    }

    // Update a book loan record
    public int updateBookLoan(String accessNo, String branchId, String cardNo, String dateDue, String dateReturned) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DATE_DUE, dateDue);
        values.put(DATE_RETURNED, dateReturned);
        return db.update(TABLE_BOOK_LOAN, values, ACCESS_NO + " = ? AND " + BRANCH_ID + " = ? AND " + MEMBER_CARD_NO + " = ?", new String[] { accessNo, branchId, cardNo });
    }

    // Delete a book loan
    public int deleteBookLoan(String accessNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsAffected = db.delete(TABLE_BOOK_LOAN, ACCESS_NO + " = ? ", new String[] { accessNo });
        db.close();
        return rowsAffected;
    }

}
