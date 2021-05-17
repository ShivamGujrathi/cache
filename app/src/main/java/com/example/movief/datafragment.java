package com.example.movief;

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
public class datafragment extends Fragment implements MovieListContract.View,UserAdapter.ClickedItem {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ResultsItem movieList;
    private MoviePresenter moviePresenter;
    private static String TAG="MovieListModel";
    public datafragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment datafragment.
     */
    // TODO: Rename and change types and number of parameters
    public static datafragment newInstance(String param1, String param2) {
        datafragment fragment = new datafragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
    public void ClickedUser(ResultsItem userResponse) {
    }
//    @Override
//    public void showProgress() {
//    }
//
//    @Override
//    public void hideProgress() {
//    }

   @Override
 public void setDataToRecycerview(List<ResultsItem> movieListArray) {
     userAdapter.setData(movieListArray);
     recyclerView.setAdapter(userAdapter);
   }
    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e("failure",throwable.getLocalizedMessage());
        Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
    }
}