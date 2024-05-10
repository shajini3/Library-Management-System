package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddBook extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        // Set the "Add Book" button click listener
        findViewById(R.id.btnAddBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the book ID, title, and publisher name from the user
                EditText editTextBookId = findViewById(R.id.editTextBookId);
                EditText editTextBookTitle = findViewById(R.id.editTextBookTitle);
                EditText editTextBookPublisher = findViewById(R.id.editTextBookPublisher);

                String bookId = editTextBookId.getText().toString();
                String title = editTextBookTitle.getText().toString();
                String publisherName = editTextBookPublisher.getText().toString();

                // Add the book to the database
                DBHandler dbHandler = new DBHandler(AddBook.this);
                dbHandler.addBook(bookId, title, publisherName);

                // Show a success message to the user
                Toast.makeText(AddBook.this, "Added book: " + title + " by " + publisherName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddBook.this, Book.class);
                startActivity(intent);
            }
        });
    }
}
