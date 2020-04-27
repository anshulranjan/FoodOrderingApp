package com.example.mainproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {
    Button button;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthLi;
    EditText name,email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.editTextEmail);
        pass = (EditText) findViewById(R.id.editTextPassword);

        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewLogin);

        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>I already have an account. </font><font color='#00b8d4'>Login</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
        button = findViewById(R.id.buttonSignUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUp();

            }
        });

    }


    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
    void startSignUp() {
        String e = email.getText().toString();
        String p = pass.getText().toString();
        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(p)) {
            Toast.makeText(Register.this, "Fields are empty", Toast.LENGTH_SHORT).show();
        } else {
            mAuth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(Register.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Register.this, "Sign Up Success", Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }
}

