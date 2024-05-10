package com.example.lms1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Branch extends AppCompatActivity {

    private Button btnAddBranch, btnUpdateBranch, btnDeleteBranch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch);

        btnAddBranch = findViewById(R.id.btnAddBranch);
        btnUpdateBranch = findViewById(R.id.btnUpdateBranch);
        btnDeleteBranch = findViewById(R.id.btnDeleteBranch);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Branch.this, "Back to home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Branch.this, HomePage.class);
                startActivity(intent);
            }
        });

        btnAddBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Branch.this, "Add branch clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Branch.this, AddBranch.class);
                startActivity(intent);
            }
        });

        btnUpdateBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Branch.this, "Update branch clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Branch.this, UpdateBranch.class);
                startActivity(intent);
            }
        });

        btnDeleteBranch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Branch.this, "Delete branch clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Branch.this, DeleteBranch.class);
                startActivity(intent);
            }
        });
    }
}