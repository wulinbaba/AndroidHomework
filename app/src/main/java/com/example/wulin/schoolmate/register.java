package com.example.wulin.schoolmate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button registerBtn=(Button)findViewById(R.id.register_btn);
        final EditText accountText=(EditText)findViewById(R.id.account_text);
        final EditText passwordText=(EditText)findViewById(R.id.password_text);
        final EditText passwordAgain=(EditText)findViewById(R.id.password_check);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountValue=accountText.getText().toString();
                String passwordValue=passwordText.getText().toString();
                String passwordCheck=passwordAgain.getText().toString();
                if(!passwordCheck.equals(passwordValue)){
                    Toast.makeText(register.this,"两次输入密码不一致,重新输入",Toast.LENGTH_SHORT).show();
                    passwordAgain.setText(null);
                    passwordText.setText(null);
                    passwordText.requestFocus();
                }else {
                    Account account=new Account();
                    account.setAccount(accountValue);
                    account.setPassword(passwordValue);
                    account.save();
                    Toast.makeText(register.this,"创建成功！",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(register.this,LoginActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
}
