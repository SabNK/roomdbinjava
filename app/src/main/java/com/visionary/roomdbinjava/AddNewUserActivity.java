package com.visionary.roomdbinjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.visionary.roomdbinjava.base.AppDatabase;
import com.visionary.roomdbinjava.base.Repository;
import com.visionary.roomdbinjava.base.RepositoryDBImpl;
import com.visionary.roomdbinjava.db.DBUser;
import com.visionary.roomdbinjava.db.DBUserUserMapper;
import com.visionary.roomdbinjava.db.User;
import com.visionary.roomdbinjava.db.UserDBUserMapper;

public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        EditText firstNameInput = findViewById(R.id.firstNameInput);
        EditText lastNameInput = findViewById(R.id.lastNameInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(firstNameInput.getText().toString(),
                            lastNameInput.getText().toString());
            }
        });

    }

    private void saveNewUser(String firstName, String lastName){
        AppDatabase db = AppDatabase.getDbInstance((this.getApplicationContext()));
        Repository<User> rep =
                new RepositoryDBImpl<DBUser, User>(db.userDao(),
                                                   new DBUserUserMapper(),
                                                   new UserDBUserMapper());
        User user = new User(new User.Name(firstName, lastName));
        rep.add(user);
        finish();

    }
}