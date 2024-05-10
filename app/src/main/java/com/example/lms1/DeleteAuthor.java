package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteAuthor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_author);

        // Set the "Delete Author" button click listener
        findViewById(R.id.buttonDeleteAuthor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the author name from the user
                EditText editTextAuthorName = findViewById(R.id.editTextAuthorName);

                String authorName = editTextAuthorName.getText().toString();

                // Delete the author and their books from the database
                DBHandler dbHandler = new DBHandler(DeleteAuthor.this);
                dbHandler.deleteBookAuthor(authorName);

                // Show a success message to the user
                Toast.makeText(DeleteAuthor.this, "Deleted author: " + authorName, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DeleteAuthor.this, Author.class);
                startActivity(intent);
            }
        });
    }
}