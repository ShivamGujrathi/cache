package com.example.movief;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterVH> {
    private List<ResultsItem> userResponseList;
    private Context context;
    private ClickedItem clickedItem;

    public UserAdapter(ClickedItem clickedItem) {
        this.clickedItem=clickedItem;

    }

    public void setData(List<ResultsItem> userResponseList) {
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UserAdapter.UserAdapterVH(LayoutInflater.from(context).inflate(R.layout.raw_user, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull UserAdapterVH holder, int position) {
        final ResultsItem userResponse = userResponseList.get(position);

        holder.userName.setText(userResponse.getTitle());
holder.imagemore.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        clickedItem.ClickedUser(userResponse);
    }
});
    }
public interface ClickedItem{
        public void ClickedUser(ResultsItem userResponse);
}
    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterVH extends RecyclerView.ViewHolder {
        TextView userName;
        TextView imagemore;

        public UserAdapterVH(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.username);
            imagemore=itemView.findViewById(R.id.username);
        }
    }
}
