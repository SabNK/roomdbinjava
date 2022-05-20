package com.visionary.roomdbinjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.visionary.roomdbinjava.adapters.db.AppDatabase;
import com.visionary.roomdbinjava.domain.Repository;
import com.visionary.roomdbinjava.adapters.RepositoryDBImpl;
import com.visionary.roomdbinjava.adapters.helpers.DBUser;
import com.visionary.roomdbinjava.adapters.mappers.DBUserUserMapper;
import com.visionary.roomdbinjava.domain.User;
import com.visionary.roomdbinjava.adapters.mappers.UserDBUserMapper;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewUserButton = findViewById(R.id.addNewUserButton);
        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this,
                                                  AddNewUserActivity.class), 100);
            }
        });

        initRecyclerView();
        loadUserList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
    }

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        Repository<User> rep =
                new RepositoryDBImpl<DBUser, User>(db.userDao(),
                                                   new DBUserUserMapper(),
                                                   new UserDBUserMapper());
        List<User> userList = rep.getAll();
        userListAdapter.setUserList(userList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            loadUserList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}