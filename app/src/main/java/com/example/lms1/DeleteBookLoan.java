package com.example.lms1;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteBookLoan extends AppCompatActivity {

    private EditText mAccessNoEditText;


    // ...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book_loan);

        mAccessNoEditText = findViewById(R.id.access_no_edit_text);


        // ...

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String accessNo = mAccessNoEditText.getText().toString();


                DBHandler dbHandler = new DBHandler(DeleteBookLoan.this);
                int rowsAffected = dbHandler.deleteBookLoan(accessNo);
                if (rowsAffected > 0) {
                    Toast.makeText(DeleteBookLoan.this, "Book loan deleted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DeleteBookLoan.this, "Book loan not found", Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });
    }

    // ...

}