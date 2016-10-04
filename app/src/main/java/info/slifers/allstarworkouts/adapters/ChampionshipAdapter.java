package info.slifers.allstarworkouts.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import info.slifers.allstarworkouts.R;

public class ChampionshipAdapter extends RecyclerView.Adapter<ChampionshipAdapter.MyViewHolder> {

    private List<String> mNumberOfChampionships = new ArrayList<>();
    public ChampionshipAdapter(List<String> NumberOfChampionships){
        this.mNumberOfChampionships = NumberOfChampionships;
    }

    @Override
    public ChampionshipAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_career_cv_championship,parent,false);
        ChampionshipAdapter.MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mNumberOfChampionships.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.icon_championship);
        }
    }
}
