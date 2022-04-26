package com.example.orderupload;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener {

    public TextView register, forgotPassword;
    private EditText editEmail, editPassword;
    private Button signIn;
    private Button VendorSignIn;
    public ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        VendorSignIn = (Button) findViewById(R.id.VendorLogin);
        VendorSignIn.setOnClickListener(this);

        forgotPassword = (TextView) findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(this);


        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);
        signIn = (Button) findViewById(R.id.signIN);
        signIn.setOnClickListener(this);
        editEmail = (EditText) findViewById(R.id.email);
        editPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.register)
        {
            Toast.makeText(this, "register user", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()==R.id.signIN)
        {
            userLogin();
        }
        else if(view.getId() == R.id.VendorLogin)
        {
            Toast.makeText(this, "vendor login", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId() == R.id.forgotPassword)
        {
            Toast.makeText(this, "forgot pass", Toast.LENGTH_SHORT).show();
        }
        else
        {

        }


    }
    public void userLogin() {
        String email = "rockswagat77@gmail.com";
        String password = "Swagat12";

        if (email.isEmpty()) {
            editEmail.setError("An email is required");
            editEmail.requestFocus();

        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editEmail.setError("A valid email is required");
            editEmail.requestFocus();
        } else if (password.isEmpty()) {
            editPassword.setError("A password is required");
            editPassword.requestFocus();
        } else {}
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful()) {
                    //go to home page for user

                    Intent intent = new Intent(login.this, vendorProf.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(login.this, "Login Failed ", Toast.LENGTH_SHORT).show();
                    progressBar.setVisibility(View.GONE);



                }

            }
        });
    }
}