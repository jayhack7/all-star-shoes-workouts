package info.slifers.allstarworkouts.models;

import com.orm.SugarRecord;

/**
 * Created by user on 10/1/2016.
 */
public class FavoriteShoesModel extends SugarRecord {
    String shoeName;
    String shoeReleaseYear;
    int shoePic;
    int shoeCompanyLogo;
    long shoeID;
    boolean favorite;

    public FavoriteShoesModel(){

    }

    public String setShoeName(String s) {
        this.shoeName = s;
        return s;

    }
    public String getshoeName() {
        return shoeName;
    }

    public String setShoeReleaseYear(String syear) {
        this.shoeReleaseYear = syear;
        return syear;
    }
    public String getshoeReleaseYear() {
        return shoeReleaseYear;
    }

    public int getshoePic() {
        return shoePic;
    }


    public int setShoePic(Integer shoeThumb) {
        this.shoePic = shoeThumb;
        return shoeThumb;
    }

    public int getshoeCompanyLogo() {
        return shoeCompanyLogo;
    }
    public int setShoeCompanyLogo(Integer shoeLogo) {
        this.shoeCompanyLogo = shoeLogo;
        return shoeLogo;
    }

    public long getShoeID() {
        return shoeID;
    }
    public long setShoeID(long shoeID) {
        this.shoeID = shoeID;
        return shoeID;
    }
    public boolean isitFavorite() {
        return favorite;
    }

    public void setitFavorite(boolean favorite) {
        this.favorite = favorite;
    }

}