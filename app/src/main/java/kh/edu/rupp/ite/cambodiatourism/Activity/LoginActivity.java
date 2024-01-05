package kh.edu.rupp.ite.cambodiatourism.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import kh.edu.rupp.ite.cambodiatourism.R;
import kh.edu.rupp.ite.cambodiatourism.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    int attempt_counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonLogin.setOnClickListener(v -> navigateToMain());
        ;
    }

    private void navigateToMain() {
        if (binding.editTextTextEmailAddress.getText().toString().equals("team") &&
                binding.editTextPassword.getText().toString().equals("123")) {
            Toast.makeText(this, "User and Password is correct", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,"Username and Password is not correct", Toast.LENGTH_SHORT).show();
            attempt_counter--;
            if (attempt_counter == 0){
                binding.buttonLogin.setEnabled(false);
            }
        }
    }
}