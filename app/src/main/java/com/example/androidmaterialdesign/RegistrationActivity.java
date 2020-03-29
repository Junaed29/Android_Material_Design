package com.example.androidmaterialdesign;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity implements TextWatcher {
    private static final String TAG = "RegistrationActivity";

    @BindView(R.id.fullNameEditTextIdReg)
    TextInputLayout fullNameEditText;

    @BindView(R.id.userNameEditTextIdReg)
    TextInputLayout userNameEditText;

    @BindView(R.id.emailEditTextIdReg)
    TextInputLayout emailEditText;

    @BindView(R.id.phoneNoEditTextIdReg)
    TextInputLayout phoneNoEditText;

    @BindView(R.id.passwordEditTextIdReg)
    TextInputLayout passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);

        /*****************************On text changed Listener*******************************/
        fullNameEditText.getEditText().addTextChangedListener(this);


    }


    public void logInButtonClick(View view) {
        finish();
    }

    private Boolean validFullName(String val) {

        if (val.isEmpty()) {
            fullNameEditText.setError("Field can not be empty");
            return false;
        } else {
            fullNameEditText.setError(null);
            // app:errorEnabled="true" create a gap below editTextView box to show error which is helping app:counterEnabled="true"
            // For this I comment fullNameEditText.setErrorEnabled(false); to hide the gap

            // fullNameEditText.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validUserName(String val) {
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        Log.d(TAG, "validUserName: " + val.length());


        if (val.isEmpty()) {
            userNameEditText.setError("Field can not be empty");
            return false;
        } else if (val.length() < 5) {
            Log.d(TAG, "validUserName: " + val.length());
            userNameEditText.setError("User Name is too short (At least 5 character)");
            return false;
        } else if (!val.matches(noWhiteSpace)) {
            userNameEditText.setError("White Spaces are not allowed");
            return false;
        } else {
            userNameEditText.setError(null);
            // app:errorEnabled="true" create a gap below editTextView box to show error which is helping app:counterEnabled="true"
            // For this I comment fullNameEditText.setErrorEnabled(false); to hide the gap

            //userNameEditText.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validEmail(String val) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            emailEditText.setError("Field can not be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            emailEditText.setError("Invalid email address");
            return false;
        } else {
            emailEditText.setError(null);
            // app:errorEnabled="true" create a gap below editTextView box to show error which is helping app:counterEnabled="true"
            // For this I comment fullNameEditText.setErrorEnabled(false); to hide the gap

            //emailEditText.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validPhone(String val) {

        if (val.isEmpty()) {
            phoneNoEditText.setError("Field can not be empty");
            return false;
        } else {
            phoneNoEditText.setError(null);
            // app:errorEnabled="true" create a gap below editTextView box to show error which is helping app:counterEnabled="true"
            // For this I comment fullNameEditText.setErrorEnabled(false); to hide the gap

            //phoneNoEditText.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validPassword(String val) {
        String passwordPattern = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";

        String checkDigit = "^" + "(?=.*[0-9])" + "(?=.*[a-zA-Z])" + ".{4,}" + "$";
        String checkWhiteSpace = "^" + "(?=\\S+$)" + "(?=.*[a-zA-Z])" + ".{4,}" + "$";

        if (val.isEmpty()) {
            passwordEditText.setError("Field can not be empty");
            return false;
        } else if (val.length() < 8) {
            passwordEditText.setError("Password is too short (At least 8 character)");
            return false;
        } else if (!val.matches(checkDigit)) {
            passwordEditText.setError("Must have at least one digit");
            return false;
        } else if (!val.matches(checkWhiteSpace)) {
            passwordEditText.setError("White Spaces are not allowed");
            return false;
        } else {
            passwordEditText.setError(null);
            // app:errorEnabled="true" create a gap below editTextView box to show error which is helping app:counterEnabled="true"
            // For this I comment fullNameEditText.setErrorEnabled(false); to hide the gap

            //passwordEditText.setErrorEnabled(false);
            return true;
        }
    }

    public void regButtonClick(View view) {
        String password = passwordEditText.getEditText().getText().toString();
        String fullName = fullNameEditText.getEditText().getText().toString();
        String userName = userNameEditText.getEditText().getText().toString();
        String email = emailEditText.getEditText().getText().toString();
        String phoneNumber = phoneNoEditText.getEditText().getText().toString();

        if (!validFullName(fullName) | !validUserName(userName) | !validEmail(email) | !validPhone(phoneNumber) | !validPassword(password)) {
            return;
        }

        Log.d(TAG, "All Clear");

    }


    /*****************************On text changed Listener Override method *******************************/
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
