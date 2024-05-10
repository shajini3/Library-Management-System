package com.example.lms1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteBookCopy extends AppCompatActivity {
    private DBHandler dbHandler;
    private EditText accessNoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_copy);

        dbHandler = new DBHandler(this);
        accessNoEditText = findViewById(R.id.access_no_edit_text);
    }

    public void deleteBookCopy(View view) {
        String accessNo = accessNoEditText.getText().toString();
        String branchId = "A"; // or get the branch ID from another source

        if (!accessNo.isEmpty()) {
            dbHandler.deleteBookCopy(accessNo, branchId);
            Toast.makeText(this, "Book copy deleted", Toast.LENGTH_SHORT).show();
            accessNoEditText.setText("");
            finish(); // close the activity
        } else {
            Toast.makeText(this, "Please enter an access number", Toast.LENGTH_SHORT).show();
        }
    }
}