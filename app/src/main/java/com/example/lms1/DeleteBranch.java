package com.example.lms1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lms1.DBHandler; // replace with your package name

public class DeleteBranch extends AppCompatActivity {

    private EditText mBranchIdEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_branch);

        mBranchIdEditText = findViewById(R.id.branch_id_edit_text);

        findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String branchId = mBranchIdEditText.getText().toString();
                DBHandler dbHandler = new DBHandler(DeleteBranch.this);
                dbHandler.deleteBranch(branchId);
                Toast.makeText(DeleteBranch.this, "Branch deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}