package com.example.lms1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Member extends AppCompatActivity {

    private Button btnaddMember, btnupdateMember, btndeleteMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        btnaddMember = findViewById(R.id.btnaddMember);
        btnupdateMember = findViewById(R.id.btnupdateMember);
        btndeleteMember = findViewById(R.id.btndeleteMember);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Member.this, "Back to home", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Member.this, HomePage.class);
                startActivity(intent);
            }
        });

        btnaddMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Member.this, "Add member clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Member.this, AddMember.class);
                startActivity(intent);
            }
        });

        btnupdateMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Member.this, "Get member clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Member.this, UpdateMember.class);
                startActivity(intent);
            }
        });

        btndeleteMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Member.this, "Delete member clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Member.this, DeleteMember.class);
                startActivity(intent);
            }
        });
    }
}