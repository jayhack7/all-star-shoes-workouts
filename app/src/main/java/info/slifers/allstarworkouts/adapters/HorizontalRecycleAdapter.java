package info.slifers.allstarworkouts.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import info.slifers.allstarworkouts.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRecycleAdapter extends RecyclerView.Adapter<HorizontalRecycleAdapter.MyViewHolder> {

    private List<String> mListData = new ArrayList<>();
    public HorizontalRecycleAdapter(List<String> listData){
        this.mListData = listData;
    }

    @Override
    public HorizontalRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_search,parent,false);
        HorizontalRecycleAdapter.MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv);
        }
    }
}
