package info.slifers.allstarworkouts.models;

/**
 * Created by user on 6/13/2016.
 */
public class AccomplishmentsModel {
    private transient int championships;
    private transient int MVP;
    private transient int AllStarApperances;
    private transient  int ScoringChampion;
    private transient  String bio;
    private transient  int bio_face;


    public AccomplishmentsModel(){


    }

    public  AccomplishmentsModel(int championships, int MVP,int AllStarApperances, int ScoringChampion, String bio,
            int bio_face) {
        this.championships = championships;
        this.MVP = MVP;
        this.AllStarApperances = AllStarApperances;
        this.ScoringChampion = ScoringChampion;
        this.bio = bio;
        this.bio_face = bio_face;

    }
    public int getChampionships() {
        return championships;
    }
    public int getMVP() {
        return MVP;
    }

    public int AllStarApperances() {
        return AllStarApperances;
    }
    public int getScoringChampion() {
        return championships;
    }
    public String getBio() {
        return bio;
    }
    public int getBio_face() {
        return bio_face;
    }



}
