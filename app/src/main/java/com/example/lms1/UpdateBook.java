package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_book);

        // Get the book ID from the intent
        String bookId = getIntent().getStringExtra("bookId");

        // Set the "Update Book" button click listener
        findViewById(R.id.buttonupdateBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the updated book details from the user
                EditText editTextBookId = findViewById(R.id.editTextBookId);
                EditText editTextBookTitle = findViewById(R.id.editTextTitle);
                EditText editTextBookPublisher = findViewById(R.id.editTextPublisherName);

                String updatedBookId = editTextBookId.getText().toString();
                String updatedTitle = editTextBookTitle.getText().toString();
                String updatedPublisherName = editTextBookPublisher.getText().toString();

                // Update the book in the database
                DBHandler dbHandler = new DBHandler(UpdateBook.this);
                dbHandler.updateBook(bookId, updatedTitle, updatedPublisherName);

                // Show a success message to the user
                Toast.makeText(UpdateBook.this, "Updated book: " + updatedTitle + " by " + updatedPublisherName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateBook.this, Book.class);
                startActivity(intent);
            }
        });
    }
}