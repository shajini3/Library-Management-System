package com.example.lms1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Publisher extends AppCompatActivity {

    private Button btnAddPublisher, btnUpdatePublisher, btnDeletePublisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publisher);

        btnAddPublisher = findViewById(R.id.btnAddPublisher);
        btnUpdatePublisher = findViewById(R.id.btnUpdatePublisher);
        btnDeletePublisher = findViewById(R.id.btnDeletePublisher);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Publisher.this, "Back to home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Publisher.this, HomePage.class);
                startActivity(intent);
            }
        });

        btnAddPublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add publisher code here
                Toast.makeText(Publisher.this, "Add publisher clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Publisher.this, AddPublisher.class);
                startActivity(intent);
            }
        });

        btnUpdatePublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Publisher.this, "Update publisher clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Publisher.this, UpdatePublisher.class);
                startActivity(intent);
            }
        });

        btnDeletePublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Delete publisher code here
                Toast.makeText(Publisher.this, "Delete publisher clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Publisher.this, DeletePublisher.class);
                startActivity(intent);
            }
        });
    }
}