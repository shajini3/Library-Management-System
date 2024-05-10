package com.example.lms1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageButton;

public class Author extends AppCompatActivity {

    private Button btnAddAuthor, btnDeleteAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        btnAddAuthor = findViewById(R.id.btnAddAuthor);
        btnDeleteAuthor = findViewById(R.id.btnDeleteAuthor);

        btnAddAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Author.this, "Add author clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Author.this, AddAuthor.class);
                startActivity(intent);
            }
        });

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Author.this, "Back to home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Author.this, HomePage.class);
                startActivity(intent);
            }
        });

        btnDeleteAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Author.this, "Delete author clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Author.this, DeleteAuthor.class);
                startActivity(intent);
            }
        });
    }
}