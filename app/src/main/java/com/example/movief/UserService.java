package com.example.movief;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {
    @GET("films")
    Call<UserResponse>getAllUsers();
    @GET("people/{id}")
    Call<CharecterDetails>moviedetailModel(@Path("id") String stringId);
}
