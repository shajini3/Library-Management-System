package com.example.lms1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class AddBranch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_branch);

        // Set the "Add Branch" button click listener
        findViewById(R.id.buttonAddBranch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the branch details from the user
                EditText editTextBranchId = findViewById(R.id.editTextBranchId);
                EditText editTextBranchName = findViewById(R.id.editTextBranchName);
                EditText editTextBranchAddress = findViewById(R.id.editTextBranchAddress);

                String branchId = editTextBranchId.getText().toString();
                String branchName = editTextBranchName.getText().toString();
                String address = editTextBranchAddress.getText().toString();

                // Add the branch to the database
                DBHandler dbHandler = new DBHandler(AddBranch.this);
                dbHandler.addBranch(branchId, branchName, address);

                // Show a success message to the user
                Toast.makeText(AddBranch.this, "Added branch: " + branchName, Toast.LENGTH_SHORT).show();

                // Go back to the previous activity
                finish();
            }
        });
    }
}