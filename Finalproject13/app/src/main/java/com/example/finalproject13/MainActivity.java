package com.example.finalproject13;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextInputEditText user,pass;
    DatabaseReference reference;
    List<User> lst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.username);
        pass=findViewById(R.id.password1);
        reference=FirebaseDatabase.getInstance().getReference();
        lst=new ArrayList<>();
        lst.clear();
        reference.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap:snapshot.getChildren()) {
                    User u = snap.getValue(User.class);
                    lst.add(u);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
int k=0;
    public void forgot(View view) {

    }

    public void newuser(View view) {
        Intent i=new Intent(MainActivity.this,activity_page3.class);
        startActivity(i);
    }

    public void login(View view) {
        final String username=user.getText().toString();
        final String password=pass.getText().toString();
        for (int i=0;i<lst.size();i++){
            Log.i("user", ""+lst.get(i).getName());
            if(username.equals(lst.get(i).getName()) &&password.equals(lst.get(i).getPass1())){
                Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
                k=1;
                break;
            }
            else {
                k=0;
            }
        }
        if(k==0){
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
        }
    }
}