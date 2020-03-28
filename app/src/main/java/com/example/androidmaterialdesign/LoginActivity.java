package com.example.androidmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.imageView2)
    ImageView imageView;

    @BindView(R.id.welcomeTextView)
    TextView welcomeTextView;

    @BindView(R.id.continueTextView)
    TextView continueTextView;

    @BindView(R.id.userNameEditTextId)
    TextInputLayout userNameEditText;

    @BindView(R.id.passwordEditTextId)
    TextInputLayout passwordEditText;

    @BindView(R.id.logInButtonId)
    Button logInButton;

    @BindView(R.id.signUpButtonId)
    Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void regButton(View view) {
        Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
        Pair [] pairs = new Pair[7];
        pairs[0] = new Pair<View,String>(imageView, "logo_image");
        pairs[1] = new Pair<View,String>(welcomeTextView, "logo_title");
        pairs[2] = new Pair<View,String>(continueTextView, "welcome_title");
        pairs[3] = new Pair<View,String>(userNameEditText, "userName_Etx");
        pairs[4] = new Pair<View,String>(passwordEditText, "password_Etx");
        pairs[5] = new Pair<View,String>(logInButton, "go_btn");
        pairs[6] = new Pair<View,String>(signUpButton, "other_btn");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
            startActivity(intent,options.toBundle());
        }else{
            startActivity(intent);
        }

        startActivity(intent);
    }

    public void regButtonClick(View view) {
        Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }

    public void logInGoButtonClick(View view) {
        String password = passwordEditText.getEditText().getText().toString();
        String username = userNameEditText.getEditText().getText().toString();

        password = "dash";
        username = "dash";
        if (username.isEmpty()){
            userNameEditText.setError("Field can not be empty");
        }else if (password.isEmpty()){
            passwordEditText.setError("Field can not be empty");
        }else if(username.equals("dash")){
            Intent intent = new Intent(LoginActivity.this,DashboardActivity.class);
            startActivity(intent);
            passwordEditText.getEditText().setText("");
            userNameEditText.getEditText().setText("");
        }
    }
}
