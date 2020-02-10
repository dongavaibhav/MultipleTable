package com.example.multipledemo;

import android.widget.EditText;
import android.widget.Toast;

public class ValidationEditText {

    public void validEdittext(EditText etName, EditText etHobby, EditText etCity, DatabaseHelper databaseHelper) {
        boolean invalidInput = false;

        if (etName.getText().toString().length() == 0) {
            invalidInput = true;
            etName.setError("Enter your name");
        } else if (!etName.getText().toString().matches("[a-zA-Z ]+")) {
            etName.setError("Accept Alphabets Only.");
        } else if (etHobby.getText().toString().length() == 0) {
            invalidInput = true;
            etHobby.setError("Enter your Hobby");
        } else if (!etHobby.getText().toString().matches("[a-zA-Z ]+")) {
            etHobby.setError("Accept Alphabets Only.");
        } else if (etCity.getText().toString().length() == 0) {
            invalidInput = true;
            etCity.setError("Enter your City");
        } else if (!etCity.getText().toString().matches("[a-zA-Z ]+")) {
            etCity.setError("Accept Alphabets Only.");
        } else if (invalidInput == false) {
            databaseHelper.addUser(etName.getText().toString(), etHobby.getText().toString(), etCity.getText().toString());
            etName.setText("");
            etHobby.setText("");
            etCity.setText("");
        }
    }
}
