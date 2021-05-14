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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link datafragment22#newInstance} factory method to
 * create an instance of this fragment.
 */
public class datafragment22 extends Fragment implements  MovieListContract.View, UserAdapter2.ClickedItem1  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ResultsItem resultsItem;
    RecyclerView recyclerView1;

    private MoviePresenter moviePresenter;
    UserAdapter2 userAdapter2;



    public datafragment22() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment datafragment22.
     */
    // TODO: Rename and change types and number of parameters
    public static datafragment22 newInstance(String param1, String param2) {
        datafragment22 fragment = new datafragment22();
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
            resultsItem= (ResultsItem) getArguments().getSerializable("data");
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
                bundle.putSerializable("data", charecterDetails);
                datafragment33 f3=new datafragment33();
                f3.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.maincontainer,f3).commit();

            }
        });
        return view;
    }
    @Override
    public void clickedUser(CharecterDetails charecterDetails) {
    }
    @Override
    public void showProgress() {
    }
    @Override
    public void hideProgress() {
    }
    @Override
    public void setDataToRecycerview(List<ResultsItem> movieListArray) {
        userAdapter2.setData(movieListArray);
                    recyclerView1.setAdapter(userAdapter2);
    }
    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e("failure",throwable.getLocalizedMessage());
        Toast.makeText(getContext(), "fail", Toast.LENGTH_SHORT).show();
    }
}