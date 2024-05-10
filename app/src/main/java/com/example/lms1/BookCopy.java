package com.example.lms1;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BookCopy extends AppCompatActivity {

    private Button btnaddBookCopy, btndeleteBookCopy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_copy);

        btnaddBookCopy = findViewById(R.id.btnaddBookCopy);
        btndeleteBookCopy = findViewById(R.id.btndeleteBookCopy);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BookCopy.this, "Back to home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookCopy.this, HomePage.class);
                startActivity(intent);
            }
        });


        btnaddBookCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookCopy.this, "Add Book Copy clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookCopy.this, AddBookCopy.class);
                startActivity(intent);
            }
        });

        btndeleteBookCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BookCopy.this, "Delete Book Copy clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(BookCopy.this, DeleteBookCopy.class);
                startActivity(intent);
            }
        });
    }
}