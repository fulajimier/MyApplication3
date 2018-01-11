package rab.gosspell.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<SelectPersonEntity> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        list = new ArrayList<>();
        list.add(new SelectPersonEntity("周杰伦", false, ""));
        list.add(new SelectPersonEntity("林俊杰", false, ""));
        list.add(new SelectPersonEntity("啥精神可嘉", false, ""));
        list.add(new SelectPersonEntity("sad", false, ""));
        list.add(new SelectPersonEntity("周杰伦", false, ""));
        list.add(new SelectPersonEntity("林俊杰", false, ""));
        list.add(new SelectPersonEntity("啥精神可嘉", false, ""));
        list.add(new SelectPersonEntity("sad", false, ""));
        list.add(new SelectPersonEntity("周杰伦", false, ""));
        list.add(new SelectPersonEntity("林俊杰", false, ""));
        list.add(new SelectPersonEntity("啥精神可嘉", false, ""));
        list.add(new SelectPersonEntity("sad", false, ""));
        list.add(new SelectPersonEntity("周杰伦", false, ""));
        list.add(new SelectPersonEntity("林俊杰", false, ""));
        list.add(new SelectPersonEntity("啥精神可嘉", false, ""));
        list.add(new SelectPersonEntity("sad", false, ""));
        recyclerView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private int mSelectedPos = -1;

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {

            if (list.get(position).isCheck()) {
                holder.checkBox.setChecked(true);
            } else {
                holder.checkBox.setChecked(false);
            }
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //如果是-1 就表明是第一进来的没有
                    if (mSelectedPos != -1) {
                        list.get(mSelectedPos).setCheck(false);
                    }
                    mSelectedPos = position;
                    list.get(position).setCheck(!list.get(position).isCheck());
                    notifyDataSetChanged();
                }
            });
            holder.userName.setText(list.get(position).getName());
        }


        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    public CheckBox checkBox;
    public TextView userName;
    public ImageView userImg;

    public MyViewHolder(View itemView) {
        super(itemView);
        checkBox = (CheckBox) itemView.findViewById(R.id.check_box);
        userName = (TextView) itemView.findViewById(R.id.user_name);
        userImg = (ImageView) itemView.findViewById(R.id.cover);
    }
}
