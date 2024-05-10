package com.example.lms1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lms1.DBHandler; // replace with your package name

public class AddMember extends AppCompatActivity {

    private EditText mCardNoEditText;
    private EditText mNameEditText;
    private EditText mAddressEditText;
    private EditText mPhoneEditText;
    private EditText mUnpaidDuesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);

        mCardNoEditText = findViewById(R.id.card_no_edit_text);
        mNameEditText = findViewById(R.id.name_edit_text);
        mAddressEditText = findViewById(R.id.address_edit_text);
        mPhoneEditText = findViewById(R.id.phone_edit_text);
        mUnpaidDuesEditText = findViewById(R.id.unpaid_dues_edit_text);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cardNo = mCardNoEditText.getText().toString();
                String name = mNameEditText.getText().toString();
                String address = mAddressEditText.getText().toString();
                String phone = mPhoneEditText.getText().toString();
                double unpaidDues = Double.parseDouble(mUnpaidDuesEditText.getText().toString());
                DBHandler dbHandler = new DBHandler(AddMember.this);
                dbHandler.addMember(cardNo, name, address, phone, unpaidDues);
                Toast.makeText(AddMember.this, "Member added", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}