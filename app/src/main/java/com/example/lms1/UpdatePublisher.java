package com.example.lms1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePublisher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_publisher);

        // Set the "Update Publisher" button click listener
        findViewById(R.id.buttonUpdatePublisher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the publisher details from the user
                EditText editTextPublisherName = findViewById(R.id.editTextPublisherName);
                EditText editTextPublisherAddress = findViewById(R.id.editTextPublisherAddress);
                EditText editTextPublisherPhone = findViewById(R.id.editTextPublisherPhone);

                String name = editTextPublisherName.getText().toString();
                String address = editTextPublisherAddress.getText().toString();
                String phone = editTextPublisherPhone.getText().toString();

                // Update the publisher in the database
                DBHandler dbHandler = new DBHandler(UpdatePublisher.this);
                int rowsAffected = dbHandler.updatePublisher(name, address, phone);

                // Show a success message to the user
                if (rowsAffected > 0) {
                    Toast.makeText(UpdatePublisher.this, "Updated publisher: " + name, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdatePublisher.this, "No publisher found with name: " + name, Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(UpdatePublisher.this, Publisher.class);
                startActivity(intent);
            }
        });
    }
}