package com.example.lms1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BookLoan extends AppCompatActivity {

    private Button btnaddBookLoan, btnupdateBookLoan, btndeleteBookLoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_loan);

        btnaddBookLoan = findViewById(R.id.btnaddBookLoan);
        btnupdateBookLoan = findViewById(R.id.btnupdateBookLoan);
        btndeleteBookLoan = findViewById(R.id.btndeleteBookLoan);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookLoan.this, "Back to home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookLoan.this, HomePage.class);
                startActivity(intent);
            }
        });


        btnaddBookLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookLoan.this, "Add Book Loan clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookLoan.this, AddBookLoan.class);
                startActivity(intent);
            }
        });

        btnupdateBookLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookLoan.this, "Get Book Loan clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookLoan.this, UpdateBookLoan.class);
                startActivity(intent);
            }
        });

        btndeleteBookLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookLoan.this, "Delete Book Loan clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookLoan.this, DeleteBookLoan.class);
                startActivity(intent);
            }
        });
    }
}