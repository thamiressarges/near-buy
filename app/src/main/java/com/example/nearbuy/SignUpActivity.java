package com.example.nearbuy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignUpActivity extends AppCompatActivity {

    EditText edtName, edtEmail, edtPassword, edtConfirmPassword;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        edtName = findViewById(R.id.edt_sign_up_name);
        edtEmail = findViewById(R.id.edt_sign_up_email);
        edtPassword = findViewById(R.id.edt_sign_up_password);
        edtConfirmPassword = findViewById(R.id.edt_confirm_password);
        btnSignUp = findViewById(R.id.btn_sign_up_page);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateFields()){
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private boolean validateFields() {
        String name = edtName.getText().toString();
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String confirmPassword = edtConfirmPassword.getText().toString();

        if(name.isEmpty()){
            edtName.setError("Preencha esse campo");
            return false;
        }else if(email.isEmpty()){
            edtEmail.setError("Preencha esse campo");
            return false;
        }else if(password.isEmpty()){
            edtPassword.setError("Preencha esse campo");
            return false;
        }else if(confirmPassword.isEmpty()){
            edtConfirmPassword.setError("Preencha esse campo");
            return false;
        }
        return true;

    }
}