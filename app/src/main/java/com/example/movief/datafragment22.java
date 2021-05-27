package com.example.movief;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class datafragment22 extends Fragment implements  MovieListContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
   private ResultsItem resultsItem;
    private RecyclerView recyclerView1;
    private MoviePresenter moviePresenter;
    private ProgressDialog progressDialog;
   private UserAdapter2 userAdapter2;
    public datafragment22() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            resultsItem=getArguments().getParcelable("data");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_datafragment22, container, false);
        List<String> usename = resultsItem.getCharacters();
        recyclerView1=view.findViewById(R.id.recyclerview);
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView1.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        moviePresenter=new MoviePresenter(this);
        resultsItem=new ResultsItem();
        moviePresenter.requestDataFromServer();
        userAdapter2=new UserAdapter2(new UserAdapter2.ClickedItem1() {
            @Override
            public void clickedUser(CharecterDetails charecterDetails) {

                Bundle bundle=new Bundle();
                bundle.putParcelable("data",charecterDetails);
                datafragment33 f3=new datafragment33();
                f3.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,f3).commit();
            }
        });
        return view;
    }
    @Override
    //to show the progress bar while API being called
    public void showProgress() {
        progressDialog= new ProgressDialog(getContext());
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent);
    }
    @Override
    //hide the progress
    public void hideProgress() {
        progressDialog.dismiss();
    }
    @Override
    //show the data in recyclerview
    public void setDataToRecycerview(List<ResultsItem> movieListArray) {
        userAdapter2.setData(movieListArray);
                    recyclerView1.setAdapter(userAdapter2);
    }
    @Override
    //if fail
    public void onResponseFailure(Throwable throwable) {
        Log.e("failure",throwable.getLocalizedMessage());
        Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();

    }

}