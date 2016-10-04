package info.slifers.allstarworkouts.tab_fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.adapters.ShoeAdapter;
import info.slifers.allstarworkouts.adapters.WorkoutAdapter;
import info.slifers.allstarworkouts.models.ShoeModel;
import info.slifers.allstarworkouts.models.WorkoutModel;


public class WorkoutFragment extends Fragment {
    // Store instance variables
    private static RecyclerView recyclerView;
    private static RecyclerViewMaterialAdapter adapter;
    private static ArrayList<WorkoutModel> workoutData;
    private static RecyclerViewMaterialAdapter materialAdapter;


    // newInstance constructor for creating fragment with arguments
    public static WorkoutFragment newInstance() {
        return new WorkoutFragment();
    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        page = getArguments().getInt("someInt", 0);
//        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shoes, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        workoutData = new ArrayList<WorkoutModel>();


        addWorkout();
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        adapter = new RecyclerViewMaterialAdapter(new WorkoutAdapter(workoutData));

        recyclerView.setAdapter(adapter);
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);


    }

    private void addWorkout() {
        SharedPreferences sharedPref = getContext().getSharedPreferences("playerID", Context.MODE_PRIVATE);
        Integer value = sharedPref.getInt("playerID", 0);
        if (value == null) {
            // the key does not exist
        } else {
            switch (value) {
                case 0:
                    // 0 = Kobe
                    WorkoutModel workout = new WorkoutModel("Nike Basketball Workout", "https://www.youtube.com/watch?v=_E3O0K02HpM", R.drawable.workouts_kobe_1);
                    workoutData.add(0, workout);
                    workout = new WorkoutModel("Preseason Training Workout", "https://www.youtube.com/watch?v=3fEnOeBTeQ0", R.drawable.workouts_kobe_2);
                    workoutData.add(workout);
                    workout = new WorkoutModel("Team USA Workout", "https://www.youtube.com/watch?v=QkQCb9NGmiU", R.drawable.workouts_kobe_3);
                    workoutData.add(workout);
                    workout = new WorkoutModel("Working Out W/ Hakeem Olajuwon", "https://www.youtube.com/watch?v=vQF3hWds-Vw", R.drawable.workouts_kobe_4);
                    workoutData.add(workout);
                    break;
                case 23:
                    // 23 mj
                    workout = new WorkoutModel("Mind of a Champion", "https://www.youtube.com/watch?v=w39-_rauFSk", R.drawable.workouts_mj_1);
                    workoutData.add(0, workout);

                    break;
                case 2:
                    // 2 lbj
                    workout = new WorkoutModel("1 Hour Workout", "https://www.youtube.com/watch?v=wQWmRIHavC8", R.drawable.workouts_lebron_1);
                    workoutData.add(0, workout);
                    workout = new WorkoutModel("Training with Kevin Durant", "https://www.youtube.com/watch?v=ItioFbo0vWw", R.drawable.workouts_lebron_2);
                    workoutData.add(0, workout);
                    break;
                case 1:
                    // 1 curry
                    workout = new WorkoutModel("Full Pre-Game Routine", "https://www.youtube.com/watch?v=5mQGA1_7yTk", R.drawable.workouts_curry_1);
                    workoutData.add(0, workout);
                    // 2 mj
                    workout = new WorkoutModel("Offseason", "https://www.youtube.com/watch?v=E580drb8x5g", R.drawable.workouts_curry_2);
                    workoutData.add(0, workout);
                    break;
                case 3:
                    // 3 kd
                    workout = new WorkoutModel("Training with Russell Westbrook", "https://www.youtube.com/watch?v=2vA2EvoQou0", R.drawable.workouts_kd_1);
                    workoutData.add(0, workout);
                    // 2 mj
                    workout = new WorkoutModel("Training with Lebron James", "https://www.youtube.com/watch?v=ItioFbo0vWw", R.drawable.workouts_lebron_2);
                    workoutData.add(0, workout);
                    break;
                case 14:
                    // 11 rose
                    workout = new WorkoutModel("2010 offseason", "https://www.youtube.com/watch?v=Fhc2SKW_fMo", R.drawable.workouts_rose_1);
                    workoutData.add(0, workout);
            }
        }


    }
}