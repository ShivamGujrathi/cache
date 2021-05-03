package com.example.movief;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserAdapter2 extends RecyclerView.Adapter<UserAdapter2.UserAdapter2VH> {
    private List<ResultsItem> userResponseList1;
    private Context context1;
  //  private CharecterDetails charecterDetails;
    private ClickedItem1 clickedItem1;

    public UserAdapter2(ClickedItem1 clickedItem1) {
        this.clickedItem1 = clickedItem1;

    }

    public void setData(List<ResultsItem> userResponseList1) {
        this.userResponseList1 = userResponseList1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapter2VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context1 = parent.getContext();
        return new UserAdapter2VH(LayoutInflater.from(context1).inflate(R.layout.charecter, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter2VH holder, final int position) {
        ResultsItem userResponse = userResponseList1.get(position);
        final List<String> charecter = userResponse.getCharacters();
     //  holder.charecter.setText(charecter.get(position));
        getAllUsers1(charecter.get(position),holder.charecter);
        holder.charecter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllUsers(charecter.get(position));
            }
        });
    }

    public interface ClickedItem1 {
        public void clickedUser(CharecterDetails charecterDetails);
    }

    @Override
    public int getItemCount() {
        return userResponseList1.size();
    }

    public class UserAdapter2VH extends RecyclerView.ViewHolder {
        TextView charecter;

        public UserAdapter2VH(@NonNull View itemView) {
            super(itemView);
            charecter = itemView.findViewById(R.id.ccharecter);
        }
    }
    public void getAllUsers(String url)
    {
        String[] strings=url.split("/");
        Call<CharecterDetails> call=ApiClient.getUserService().moviedetailModel(strings[strings.length-1]);
        call.enqueue(new Callback<CharecterDetails>() {

            @Override
            public void onResponse(Call<CharecterDetails>call, Response<CharecterDetails> response) {
                if(response.isSuccessful())
                {
                    CharecterDetails userResponses=response.body();
                    clickedItem1.clickedUser(userResponses);
                }
            }

            @Override
            public void onFailure(Call<CharecterDetails> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
                Toast.makeText(context1, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void getAllUsers1(String url, final TextView charecter)
    {
        String[] strings=url.split("/");
        Call<CharecterDetails> call=ApiClient.getUserService().moviedetailModel(strings[strings.length-1]);
        call.enqueue(new Callback<CharecterDetails>() {

            @Override
            public void onResponse(Call<CharecterDetails>call, Response<CharecterDetails> response) {
                if(response.isSuccessful())
                {
                    CharecterDetails userResponses=response.body();
                    charecter.setText(userResponses.getName());

                }
            }
            @Override
            public void onFailure(Call<CharecterDetails> call, Throwable t) {
                Log.e("failure",t.getLocalizedMessage());
                Toast.makeText(context1, "fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
