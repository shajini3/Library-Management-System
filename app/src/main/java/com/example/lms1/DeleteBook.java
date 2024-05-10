package com.example.lms1;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_book);

        // Set the "Delete Book" button click listener
        findViewById(R.id.buttonDeleteBook).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the book ID from the user
                EditText editTextBookId = findViewById(R.id.editTextBookId);
                String bookId = editTextBookId.getText().toString();

                // Delete the book from the database
                DBHandler dbHandler = new DBHandler(DeleteBook.this);
                dbHandler.deleteBook(bookId);

                // Show a success message to the user
                Toast.makeText(DeleteBook.this, "Deleted book with ID: " + bookId, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DeleteBook.this, Book.class);
                startActivity(intent);
            }
        });
    }
}