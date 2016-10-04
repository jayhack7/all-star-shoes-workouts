package info.slifers.allstarworkouts.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import info.slifers.allstarworkouts.R;

public class MVPAdapter extends RecyclerView.Adapter<MVPAdapter.MyViewHolder> {

    private List<String> mNumberOfMVP = new ArrayList<>();
    public MVPAdapter(List<String> NumberOfMVP){
        this.mNumberOfMVP = NumberOfMVP;
    }

    @Override
    public MVPAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_career_cv_mvp,parent,false);
        MVPAdapter.MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return mNumberOfMVP.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.icon_mvp);
        }
    }
}
