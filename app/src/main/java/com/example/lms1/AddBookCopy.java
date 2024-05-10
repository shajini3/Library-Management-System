package com.example.lms1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddBookCopy extends AppCompatActivity {
    private EditText mBookIdEditText;
    private EditText mBranchIdEditText;
    private EditText mAccessNoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_copy);

        mBookIdEditText = findViewById(R.id.book_id_edit_text);
        mBranchIdEditText = findViewById(R.id.branch_id_edit_text);
        mAccessNoEditText = findViewById(R.id.access_no_edit_text);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bookId = mBookIdEditText.getText().toString();
                String branchId = mBranchIdEditText.getText().toString();
                String accessNo = mAccessNoEditText.getText().toString();

                DBHandler dbHandler = new DBHandler(AddBookCopy.this);
                dbHandler.addBookCopy(bookId, branchId, accessNo);
                Toast.makeText(AddBookCopy.this, "Book copy added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddBookCopy.this, BookCopy.class);
                startActivity(intent);
            }
        });
    }
}