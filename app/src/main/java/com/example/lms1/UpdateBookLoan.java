package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBookLoan extends AppCompatActivity {

    private EditText mAccessNoEditText;
    private EditText mBranchIdEditText;
    private EditText mCardNoEditText;
    private EditText mDateDueEditText;
    private EditText mDateReturnedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book_loan);

        mAccessNoEditText = findViewById(R.id.access_no_edit_text);
        mBranchIdEditText = findViewById(R.id.branch_id_edit_text);
        mCardNoEditText = findViewById(R.id.card_no_edit_text);
        mDateDueEditText = findViewById(R.id.date_due_edit_text);
        mDateReturnedEditText = findViewById(R.id.date_returned_edit_text);

        findViewById(R.id.update_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accessNo = mAccessNoEditText.getText().toString();
                String branchId = mBranchIdEditText.getText().toString();
                String cardNo = mCardNoEditText.getText().toString();
                String dateDue = mDateDueEditText.getText().toString();
                String dateReturned = mDateReturnedEditText.getText().toString();

                if (accessNo.isEmpty() || branchId.isEmpty() || cardNo.isEmpty() || dateDue.isEmpty() || dateReturned.isEmpty()) {
                    Toast.makeText(UpdateBookLoan.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                DBHandler dbHandler;
                try {
                    dbHandler = new DBHandler(UpdateBookLoan.this);
                    int rowsAffected = dbHandler.updateBookLoan(accessNo, branchId, cardNo, dateDue, dateReturned);
                    Log.d("UpdateBookLoan", "Number of rows affected: " + rowsAffected);
                    if (rowsAffected > 0) {
                        Toast.makeText(UpdateBookLoan.this, "Book loan updated", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateBookLoan.this, "Book loan not found", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Log.e("UpdateBookLoan", "Error creating DBHandler", e);
                }

                finish();
            }
        });
    }
}