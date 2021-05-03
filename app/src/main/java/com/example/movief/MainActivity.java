package com.example.movief;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements UserAdapter.ClickedItem{
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
     userAdapter=new UserAdapter(new UserAdapter.ClickedItem() {
         @Override
         public void ClickedUser(ResultsItem userResponse) {

                 Log.e("clicked user",userResponse.getCharacters().toString());
                     Intent myIntent = new Intent(MainActivity.this, UserDetailsActivity.class).putExtra("data",userResponse);
             MainActivity.this.startActivity(myIntent);

         }
     });
        getAllUsers();


    }
    public void getAllUsers()
    {
        Call<UserResponse>call=ApiClient.getUserService().getAllUsers();
        call.enqueue(new Callback<UserResponse>() {

            @Override
            public void onResponse(Call<UserResponse>call, Response<UserResponse> response) {
                if(response.isSuccessful())
                {
                    UserResponse userResponses=response.body();
                    userAdapter.setData(userResponses.getResults());
                    recyclerView.setAdapter(userAdapter);
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void ClickedUser(ResultsItem userResponse) {
    }
}