package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddAuthor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_author);

        // Set the "Add Book" button click listener
        findViewById(R.id.btnAddbookauthor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the book ID, title, and publisher name from the user
                EditText editTextBookId = findViewById(R.id.editTextBookId);
                EditText editTextAuthorName = findViewById(R.id.editTextAuthorName);


                String bookId = editTextBookId.getText().toString();
                String AuthorName = editTextAuthorName.getText().toString();


                // Add the book to the database
                DBHandler dbHandler = new DBHandler(AddAuthor.this);
                dbHandler.addBookAuthor(bookId, AuthorName);

                // Show a success message to the user
                Toast.makeText(AddAuthor.this, "Added Author: " + " for " + AuthorName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddAuthor.this, HomePage.class);
                startActivity(intent);
            }
        });
    }
}
