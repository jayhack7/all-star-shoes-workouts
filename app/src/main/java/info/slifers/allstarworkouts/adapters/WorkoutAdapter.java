package info.slifers.allstarworkouts.adapters;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.models.ShoeModel;
import info.slifers.allstarworkouts.models.WorkoutModel;

/**
 * Created by user on 6/15/2016.
 */
public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.MyWorkoutViewHolder> {

    private final ArrayList<WorkoutModel> WorkoutDataSet;

    public class MyWorkoutViewHolder extends RecyclerView.ViewHolder {
        TextView tv_workout_name;
        ImageView iv_workout;
        CardView cv_workout;

        public MyWorkoutViewHolder(View itemView) {
            super(itemView);
            this.tv_workout_name = (TextView) itemView.findViewById(R.id.tv_workout_name);
            this.iv_workout = (ImageView) itemView.findViewById(R.id.iv_workout);
            this.cv_workout = (CardView) itemView.findViewById(R.id.cv_workout);

        }
    }


    //dataset = data from Main Activity
    public WorkoutAdapter(ArrayList<WorkoutModel> data) {
        //this.dataSet = data;
        this.WorkoutDataSet = new ArrayList<>(data);

    }

    @Override
    public MyWorkoutViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_workouts_cv, parent, false);

        MyWorkoutViewHolder myViewHolder = new MyWorkoutViewHolder(view);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyWorkoutViewHolder holder, final int Position) {
        // called everytime user scrolls up or down


        TextView tv_workout_name = holder.tv_workout_name;

        ImageView iv_workout = holder.iv_workout;
        CardView cv_workout = holder.cv_workout;

        tv_workout_name.setText(WorkoutDataSet.get(Position).getWorkoutName());


        Context context = iv_workout.getContext();
        cv_workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String q = WorkoutDataSet.get(Position).getUrl().toString();
                v.getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("" + q)));
            }
        });

        Picasso.with(context)
                .load(WorkoutDataSet.get(Position).getWorkoutThumbnail())
                .error(R.drawable.img_error)
                .into(holder.iv_workout);
    }


    @Override
    public int getItemCount() {
        return WorkoutDataSet.size();
    }
}

