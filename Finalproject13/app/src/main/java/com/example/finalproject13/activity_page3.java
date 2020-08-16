package com.example.finalproject13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class activity_page3 extends AppCompatActivity {
    TextInputEditText et1,et2,et3,et4;
    FirebaseDatabase database;
    DatabaseReference reference;
    List<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        userList=new ArrayList<>();
        et1=findViewById(R.id.fullname);
        et2=findViewById(R.id.mailid);
        et3=findViewById(R.id.password);
        et4=findViewById(R.id.repassword);
        database = FirebaseDatabase.getInstance();
        reference = database.getReference();
    }

    public void signup(View view) {
        final String name=et1.getText().toString();
        final String email=et2.getText().toString();
        final String pass1=et3.getText().toString();
        final String pass2=et4.getText().toString();
        String mainPass = null;
        if(pass1.equals(pass2)){
            mainPass = pass2;
        }

        User u = new User(name,email,mainPass);
        reference.child("USers").push().setValue(u).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(activity_page3.this, "Data inserted", Toast.LENGTH_SHORT).show();
                
            }
        });
    }
}