package llm.dynamics.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
        private EditText email, password;
        private Button loginButton, registerButton;
        private DatabaseHelper db;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            email = findViewById(R.id.email);
            password = findViewById(R.id.password);
            loginButton = findViewById(R.id.login_button);
            registerButton = findViewById(R.id.register_button);
            db = new DatabaseHelper(this);

            loginButton.setOnClickListener(v -> {
                String userEmail = email.getText().toString();
                String userPassword = password.getText().toString();
                if (db.checkUser(userEmail, userPassword)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            });

            registerButton.setOnClickListener(v -> {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            });
        }
}
