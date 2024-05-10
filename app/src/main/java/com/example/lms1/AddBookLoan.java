package com.example.lms1;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lms1.DBHandler; // replace with your package name
public class AddBookLoan extends AppCompatActivity {

    private EditText mAccessNoEditText;
    private EditText mBranchIdEditText;
    private EditText mCardNoEditText;
    private EditText mDateOutEditText;
    private EditText mDateDueEditText;
    private EditText mDateReturnedEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_loan);

        mAccessNoEditText = findViewById(R.id.access_no_edit_text);
        mBranchIdEditText = findViewById(R.id.branch_id_edit_text);
        mCardNoEditText = findViewById(R.id.card_no_edit_text);
        mDateOutEditText = findViewById(R.id.date_out_edit_text);
        mDateDueEditText = findViewById(R.id.date_due_edit_text);
        mDateReturnedEditText = findViewById(R.id.date_returned_edit_text);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accessNo = mAccessNoEditText.getText().toString();
                String branchId = mBranchIdEditText.getText().toString();
                String cardNo = mCardNoEditText.getText().toString();
                String dateOut = mDateOutEditText.getText().toString();
                String dateDue = mDateDueEditText.getText().toString();
                String dateReturned = mDateReturnedEditText.getText().toString();
                DBHandler dbHandler = new DBHandler(AddBookLoan.this);
                dbHandler.addBookLoan(accessNo, branchId, cardNo, dateOut, dateDue, dateReturned);
                Toast.makeText(AddBookLoan.this, "Book loan added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}