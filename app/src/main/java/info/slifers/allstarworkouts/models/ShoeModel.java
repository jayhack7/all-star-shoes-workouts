package info.slifers.allstarworkouts.models;

/**
 * Created by user on 5/15/2016.
 */
public class ShoeModel {
    private transient String shoeName;
    private transient String shoeReleaseYear;
    private transient int shoePic;
    private transient int shoeCompanyLogo;
    long shoeID;
    boolean favorite;
    public ShoeModel(){

    }
    public ShoeModel(String shoeName,  String shoeReleaseYear,int shoePic, int shoeCompanyLogo, long shoeID) {
        this.shoeName = shoeName;
        this.shoeCompanyLogo = shoeCompanyLogo;
        this.shoePic = shoePic;
        this.shoeReleaseYear = shoeReleaseYear;
        this.shoeID = shoeID;
    }
    public String getshoeName() {
        return shoeName;
    }


    public String getshoeReleaseYear() {
        return shoeReleaseYear;
    }

    public int getshoePic() {
        return shoePic;
    }

    public int getshoeCompanyLogo() {
        return shoeCompanyLogo;
    }

    public long getShoeID() {
        return shoeID;
    }


    public boolean isitFavorite() {
        return favorite;
    }

    public void setitFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}