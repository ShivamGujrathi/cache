package com.example.movief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailsActivity extends AppCompatActivity implements UserAdapter2.ClickedItem1 {
ResultsItem resultsItem;
RecyclerView recyclerView1;

UserAdapter2 userAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        Intent intent = getIntent();
        resultsItem = (ResultsItem) intent.getSerializableExtra("data");
        List<String> usename = resultsItem.getCharacters();
        recyclerView1=findViewById(R.id.recyclerview1);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        userAdapter2=new UserAdapter2(new UserAdapter2.ClickedItem1() {
            @Override
            public void clickedUser(CharecterDetails charecterDetails) {
                Log.e("clicked user", String.valueOf(charecterDetails));
                Intent myIntent = new Intent(UserDetailsActivity.this, CharecterssDetailsss.class).putExtra("Data",charecterDetails);
              UserDetailsActivity.this.startActivity(myIntent);
            }
        });

        getAllUsers();
    }
    public void getAllUsers()
    {
        Call<UserResponse> call=ApiClient.getUserService().getAllUsers();
        call.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse>call, Response<UserResponse> response) {
                if(response.isSuccessful())
                {
                    UserResponse userResponses=response.body();
                    userAdapter2.setData(userResponses.getResults());
                    recyclerView1.setAdapter(userAdapter2);


                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
                Toast.makeText(UserDetailsActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void clickedUser(CharecterDetails charecterDetails) {
    }
}