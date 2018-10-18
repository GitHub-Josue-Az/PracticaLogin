package com.example.josue.practicalogin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users){

        this.users = users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView fullname;
        public TextView email;
        public ImageButton button;

        public ViewHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture_image);
            fullname = (TextView) itemView.findViewById(R.id.fullname_text);
            email = (TextView) itemView.findViewById(R.id.email_text);
            button = (ImageButton) itemView.findViewById(R.id.delete_button);
        }
    }



    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder viewHolder,final int position) {
       final User user = this.users.get(position);
        viewHolder.fullname.setText(user.getFullname());
        viewHolder.email.setText(user.getEmail());

        viewHolder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserRepository.delete(user.getId());
                users.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, getItemCount());
            }
        });
    }



    @Override
    public int getItemCount() {
        return this.users.size();
    }

}

