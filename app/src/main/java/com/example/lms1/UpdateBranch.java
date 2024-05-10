package com.example.lms1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class UpdateBranch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_branch);

        // Get the branch details from the intent
        Intent intent = getIntent();
        String branchId = intent.getStringExtra("branchId");
        String branchName = intent.getStringExtra("branchName");
        String address = intent.getStringExtra("address");

        // Set the branch details in the EditText widgets
        EditText editTextBranchId = findViewById(R.id.editTextBranchId);
        EditText editTextBranchName = findViewById(R.id.editTextBranchName);
        EditText editTextBranchAddress = findViewById(R.id.editTextBranchAddress);

        editTextBranchId.setText(branchId);
        editTextBranchName.setText(branchName);
        editTextBranchAddress.setText(address);

        // Set the "Update Branch" button click listener
        findViewById(R.id.buttonUpdateBranch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the updated branch details from the user
                EditText editTextBranchId = findViewById(R.id.editTextBranchId);
                EditText editTextBranchName = findViewById(R.id.editTextBranchName);
                EditText editTextBranchAddress = findViewById(R.id.editTextBranchAddress);

                String updatedBranchId = editTextBranchId.getText().toString();
                String updatedBranchName = editTextBranchName.getText().toString();
                String updatedAddress = editTextBranchAddress.getText().toString();

                // Update the branch in the database
                DBHandler dbHandler = new DBHandler(UpdateBranch.this);
                int rowsAffected = dbHandler.updateBranch(updatedBranchId, updatedBranchName, updatedAddress);

                // Show a success message to the user
                if (rowsAffected > 0) {
                    Toast.makeText(UpdateBranch.this, "Updated branch: " + updatedBranchName, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UpdateBranch.this, "Failed to update branch", Toast.LENGTH_SHORT).show();
                }

                // Go back to the previous activity
                finish();
            }
        });
    }
}
