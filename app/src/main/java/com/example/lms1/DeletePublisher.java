package com.example.lms1;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePublisher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_publisher);

        // Set the "Delete Publisher" button click listener
        findViewById(R.id.buttonDeletePublisher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the publisher name from the user
                EditText editTextPublisherName = findViewById(R.id.editTextPublisherName);

                String name = editTextPublisherName.getText().toString();

                // Delete the publisher from the database
                DBHandler dbHandler = new DBHandler(DeletePublisher.this);
                int rowsAffected = dbHandler.deletePublisher(name);

                // Show a success message to the user
                if (rowsAffected > 0) {
                    Toast.makeText(DeletePublisher.this, "Deleted publisher: " + name, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DeletePublisher.this, "No publisher found with name: " + name, Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(DeletePublisher.this, Publisher.class);
                startActivity(intent);
            }
        });
    }
}