package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page); // Ensure the layout file is named correctly

        Button bookButton = findViewById(R.id.button3);
        Button publisherButton = findViewById(R.id.button4);
        Button branchButton = findViewById(R.id.button5);
        Button memberButton = findViewById(R.id.button6);
        Button authorButton = findViewById(R.id.button7);
        Button bookCopyButton = findViewById(R.id.button8);
        Button bookLoanButton = findViewById(R.id.button9);

        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Book clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, Book.class);
                startActivity(intent);
            }
        });

        publisherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Publisher clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, Publisher.class);
                startActivity(intent);
            }
        });

        branchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Branch clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, Branch.class);
                startActivity(intent);
            }
        });

        memberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Member clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, Member.class);
                startActivity(intent);
            }
        });

        authorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Author clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, Author.class);
                startActivity(intent);
            }
        });

        bookCopyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Book Copy clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, BookCopy.class);
                startActivity(intent);
            }
        });

        bookLoanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "Book Loan clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomePage.this, BookLoan.class);
                startActivity(intent);
            }
        });
    }
}