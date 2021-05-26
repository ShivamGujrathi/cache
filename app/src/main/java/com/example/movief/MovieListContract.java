package com.example.movief;

import java.util.List;

public interface MovieListContract {
    interface Model
    {
        interface OnFinishedListener
        {
            void onfinished(List<ResultsItem> movieArrayList);
            void onFailure(Throwable t);

        }
        void getMovieList(OnFinishedListener onFinishedListener);

    }
    interface View{
       void showProgress();
       void hideProgress();
        void setDataToRecycerview(List<ResultsItem>movieListArray);
        void onResponseFailure(Throwable throwable);
    }
    interface Presenter{
        void onDestroy();
        void getMoreData();
        void requestDataFromServer();

    }
}
