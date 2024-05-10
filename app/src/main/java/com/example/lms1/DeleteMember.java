package com.example.lms1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lms1.DBHandler; // replace with your package name
public class DeleteMember extends AppCompatActivity {

    private EditText mCardNoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_member);

        mCardNoEditText = findViewById(R.id.card_no_edit_text);

        findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardNo = mCardNoEditText.getText().toString();
                DBHandler dbHandler = new DBHandler(DeleteMember.this);
                dbHandler.deleteMember(cardNo);
                Toast.makeText(DeleteMember.this, "Member deleted", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}