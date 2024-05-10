package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPublisher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_publisher);

        // Set the "Add Publisher" button click listener
        findViewById(R.id.buttonAddPublisher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the publisher details from the user
                EditText editTextPublisherName = findViewById(R.id.editTextPublisherName);
                EditText editTextPublisherAddress = findViewById(R.id.editTextPublisherAddress);
                EditText editTextPublisherPhone = findViewById(R.id.editTextPublisherPhone);

                String name = editTextPublisherName.getText().toString();
                String address = editTextPublisherAddress.getText().toString();
                String phone = editTextPublisherPhone.getText().toString();

                // Add the publisher to the database
                DBHandler dbHandler = new DBHandler(AddPublisher.this);
                dbHandler.addPublisher(name, address, phone);

                // Show a success message to the user
                Toast.makeText(AddPublisher.this, "Added publisher: " + name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddPublisher.this, Publisher.class);
                startActivity(intent);
            }
        });
    }
}