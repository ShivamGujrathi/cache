package com.example.movief;

import java.util.List;

    public class MoviePresenter implements MovieListContract.Presenter,MovieListContract.Model.OnFinishedListener {
        private MovieListContract.View movieListView;
        private MovieListContract.Model movieListModel;

        public MoviePresenter(MovieListContract.View movieListView) {
            this.movieListView = movieListView;
            movieListModel = new MovieListModel();
        }

        @Override
        public void onDestroy() {
            this.movieListView=null;

        }


        @Override
        public void getMoreData() {
            if (movieListView !=null)
            {
                movieListView.showProgress();
            }
            movieListModel.getMovieList(this);
        }

        @Override
        public void requestDataFromServer() {
            if (movieListView !=null)
            {
                movieListView.showProgress();

            }
            movieListModel.getMovieList(this);

        }

        @Override
        public void onfinished(List<ResultsItem> movieArrayList) {
            movieListView.setDataToRecycerview(movieArrayList);
            if(movieListView != null) {
                movieListView.hideProgress();
            }
        }

        @Override
        public void onFailure(Throwable t) {
            movieListView.onResponseFailure(t);

            if(movieListView != null) {
                movieListView.hideProgress();
            }
        }
    }


