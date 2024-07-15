package com.example.hw4_2m;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnGray;
    private Button btnOrange;
    private EditText etEmail;
    private EditText etPassword;
    private View constraint;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        btnGray = findViewById(R.id.btn_log_in);
        btnOrange = findViewById(R.id.btn_log_in_orange);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        constraint = findViewById(R.id.constraint);
        textView = findViewById(R.id.tv_welcome2);

        btnOrange.setVisibility(View.GONE);

        btnGray.setOnClickListener(view -> {
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            if (email.equals("admin") && password.equals("admin")) {
                btnGray.setVisibility(View.GONE);
                btnOrange.setVisibility(View.VISIBLE);
            } else if (email.isEmpty() && password.isEmpty()) {
                btnOrange.setVisibility(View.GONE);
                btnGray.setVisibility(View.VISIBLE);
            } else {
                btnOrange.setVisibility(View.GONE);
                Toast.makeText(this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });

        btnOrange.setOnClickListener(view -> {
            Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
            constraint.setVisibility(View.GONE);
            textView.setVisibility(View.VISIBLE);
        });
    }
}