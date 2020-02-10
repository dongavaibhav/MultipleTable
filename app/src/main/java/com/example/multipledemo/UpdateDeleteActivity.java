package com.example.multipledemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDeleteActivity extends AppCompatActivity {

    //declare the varible
    private UserModel userModel;
    private EditText etName, etHobby, etCity;
    private Button btnUpdate, btnDelete;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        Intent intent = getIntent();
        userModel = (UserModel) intent.getSerializableExtra("user");

        databaseHelper = new DatabaseHelper(this);

        findId();
        clickListner();
    }

    private void findId() {
        etName = (EditText) findViewById(R.id.etname);
        etHobby = (EditText) findViewById(R.id.ethobby);
        etCity = (EditText) findViewById(R.id.etcity);
        btnDelete = (Button) findViewById(R.id.btndelete);
        btnUpdate = (Button) findViewById(R.id.btnupdate);

        etName.setText(userModel.getName());
        etHobby.setText(userModel.getHobby());
        etCity.setText(userModel.getCity());
    }

    private void clickListner() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateUser(userModel.getId(), etName.getText().toString(), etHobby.getText().toString(), etCity.getText().toString());
                Toast.makeText(UpdateDeleteActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UpdateDeleteActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteDialog();
            }
        });
    }

    // Alert dialog delete
    public void deleteDialog() {
        AlertDialog deleteDialogBox = new AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do you want to Delete?")
                .setIcon(R.drawable.bin)
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        boolean isDataDelete = databaseHelper.deleteUser(userModel.getId());
                        if (isDataDelete) {
                            Toast.makeText(UpdateDeleteActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UpdateDeleteActivity.this, GetAllUsersActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        } else {
                            Toast.makeText(UpdateDeleteActivity.this, "Deleted Not Successfully!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UpdateDeleteActivity.this, GetAllUsersActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                            dialog.dismiss();
                        }
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        deleteDialogBox.show();
    }

}