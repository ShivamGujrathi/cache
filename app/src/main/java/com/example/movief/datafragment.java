package com.example.movief;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link datafragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class datafragment extends Fragment implements MovieListContract.View {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    //initialization of recyclerview
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ResultsItem movieList;
    private MoviePresenter moviePresenter;
    private ProgressDialog progressDialog;
    private static String TAG="MovieListModel";
    public datafragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_datafragment, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        moviePresenter=new MoviePresenter(this);
        moviePresenter.requestDataFromServer();
        movieList= new ResultsItem();
        userAdapter=new UserAdapter(new UserAdapter.ClickedItem() {
            @Override
            //After clicked
            public void ClickedUser(ResultsItem userResponse) {

                Log.e("clicked user",userResponse.getCharacters().toString());
//                Intent myIntent = new Intent(getContext(), UserDetailsActivity.class).putExtra("data",userResponse);
//                startActivity(myIntent);
                Bundle bundle=new Bundle();
                bundle.putParcelable("data", userResponse);
             datafragment22 f2=new datafragment22();
             f2.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,f2).commit();

            }
        });
        return view;
    }
   // public void ClickedUser(ResultsItem userResponse) {
   // }
    @Override
    //to show the progress bar while API being called
    public void showProgress() {
        progressDialog= new ProgressDialog(getContext());
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(
                android.R.color.transparent
        );
    }

    @Override
    //hide progress bar when api get called
    public void hideProgress() {
        progressDialog.dismiss();
    }

   @Override
   //show data to recyclerview
 public void setDataToRecycerview(List<ResultsItem> movieListArray) {
     userAdapter.setData(movieListArray);
     recyclerView.setAdapter(userAdapter);
   }
    @Override
    //if fail show toast
    public void onResponseFailure(Throwable throwable) {
        Log.e("failure",throwable.getLocalizedMessage());
        Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
    }
}