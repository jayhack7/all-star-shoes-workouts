package info.slifers.allstarworkouts.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import info.slifers.allstarworkouts.R;

import java.util.ArrayList;
import java.util.List;

public class AllStarAdapter extends RecyclerView.Adapter<AllStarAdapter.MyViewHolder> {

    private List<String> mNumberOfAllStars = new ArrayList<>();
    public AllStarAdapter(List<String> NumberOfAllStars){
        this.mNumberOfAllStars = NumberOfAllStars;
    }

    @Override
    public AllStarAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_career_cv_allstar,parent,false);
        AllStarAdapter.MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mNumberOfAllStars.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv);
        }
    }
}
