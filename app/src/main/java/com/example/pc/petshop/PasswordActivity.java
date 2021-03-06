package com.example.pc.petshop;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PasswordActivity  extends AppCompatActivity {
private EditText passwordEmail;
private Button resetPassword;
private FirebaseAuth firebaseAuth;
    DatabaseReference UDB;
    DatabaseReference myRef;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_password);
        passwordEmail= (EditText)findViewById(R.id.etPasswordEmail);
        resetPassword = (Button)findViewById(R.id.btnPasswordReset);
        firebaseAuth = FirebaseAuth.getInstance();
        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String useremail= passwordEmail.getText().toString().trim();
                if (useremail.equals("")) {
                    Toast.makeText(PasswordActivity.this,"الرجاء ادخال بريد الكتروني مسجل مسبقا", Toast.LENGTH_SHORT).show();

                }else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                              //  Toast.makeText(PasswordActivity.this ,"Please enter reset email sent",Toast.LENGTH_SHORT).show();
                               Intent intent = new Intent(PasswordActivity.this, home.class);
                                Toast.makeText(PasswordActivity.this,"تم الارسال,الرجاء التحقق من البريد الالكتروني", Toast.LENGTH_SHORT).show();
                               startActivity(intent);

                            }
                            else {
                                firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful()){
                                            Toast.makeText(PasswordActivity.this ,"تم إرسال البريد الإلكتروني الخاص بإعادة ضبط كلمة المرور ",Toast.LENGTH_SHORT).show();
                                            finish();
                                            startActivity(new Intent(PasswordActivity.this , welcome.class));

                                        }else {
                                            Toast.makeText(PasswordActivity.this ,"خطأ في إرسال إعادة تعيين كلمة المرور البريد الإلكتروني! ",Toast.LENGTH_LONG).show();

                                        }
                                    }
                                }) ;
                            }
                        }


                    });



                }
            }
        });
    }
}