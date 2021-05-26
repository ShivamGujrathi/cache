package com.example.movief;
import android.util.Log;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MovieListModel implements MovieListContract.Model {
    private static String TAG="MovieListModel";
    @Override
    public void getMovieList(final OnFinishedListener onFinishedListener) {
        UserService apiService=ApiClient.getUserService();
        Call<UserResponse> call=apiService.getAllMovie();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                List<ResultsItem> movies=response.body().getResults();
                // Log.e(TAG,"onResponse: "+movies.size() );
                onFinishedListener.onfinished(movies);
            }
            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e(TAG,t.toString() );
                onFinishedListener.onFailure(t);
            }
        });
    }
}
