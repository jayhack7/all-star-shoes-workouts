package info.slifers.allstarworkouts.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.models.BioModel;

/**
 * Created by user on 8/11/2016.
 */
public class BioAdapter extends RecyclerView.Adapter<BioAdapter.MyBioViewHolder> {
    private final ArrayList<BioModel> BioDataSet;

    public class MyBioViewHolder extends RecyclerView.ViewHolder {
        TextView description;

        public MyBioViewHolder(View itemView) {
            super(itemView);
            this.description = (TextView) itemView.findViewById(R.id.tv_player_bio);


        }
    }


    //dataset = data from Main Activity

    public BioAdapter(ArrayList<BioModel> data) {
        this.BioDataSet = new ArrayList<>(data);
    }


    @Override
    public MyBioViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_career_bio_cv, parent, false);

        MyBioViewHolder myViewHolder = new MyBioViewHolder(view);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyBioViewHolder holder, final int Position) {
        // called everytime user scrolls up or down
        TextView description = holder.description;


        description.setText(BioDataSet.get(Position).getDescription());

    }


    @Override
    public int getItemCount() {
        return BioDataSet.size();
    }
}

