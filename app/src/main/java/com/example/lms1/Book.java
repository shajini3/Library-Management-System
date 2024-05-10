package com.example.lms1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageButton;


public class Book extends AppCompatActivity {

    private Button btnAddBook, btnUpdateBook, btnDeleteBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        btnAddBook = findViewById(R.id.btnAddBook);
        btnUpdateBook = findViewById(R.id.btnUpdateBook);
        btnDeleteBook = findViewById(R.id.btnDeleteBook);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Book.this, "Back to home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Book.this, HomePage.class);
                startActivity(intent);
            }
        });

        // Set click listeners for each button
        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Book.this, "Add Book clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Book.this, AddBook.class);
                startActivity(intent);
            }
        });



        btnUpdateBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Book.this, "Update Book clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Book.this, UpdateBook.class);
                startActivity(intent);
            }
        });

        btnDeleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Book.this, "Delete Book clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Book.this, DeleteBook.class);
                startActivity(intent);
            }
        });

    }

}