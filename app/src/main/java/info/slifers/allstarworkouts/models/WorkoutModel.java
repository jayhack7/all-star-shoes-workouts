package info.slifers.allstarworkouts.models;

/**
 * Created by user on 5/15/2016.
 */
public class WorkoutModel {
    private transient String workoutName;
    private transient String url;
    private transient int workoutThumbnail;

    public WorkoutModel(){

    }
    public WorkoutModel(String workoutName, String url, int workoutThumbnail) {
        this.workoutName = workoutName;
        this.url = url;
        this.workoutThumbnail = workoutThumbnail;
    }
    public String getWorkoutName() {
        return workoutName;
    }


    public String getUrl() {
        return url;
    }


    public int getWorkoutThumbnail() {
        return workoutThumbnail;
    }
}
