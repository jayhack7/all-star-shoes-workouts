package info.slifers.allstarworkouts.adapters;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.orhanobut.hawk.Hawk;
import com.orm.SugarRecord;
import com.orm.query.Condition;
import com.orm.query.Select;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.models.FavoriteShoesModel;
import info.slifers.allstarworkouts.models.ShoeModel;

/**
 * Created by user on 5/15/2016.
 */
public class ShoeAdapter extends RecyclerView.Adapter<ShoeAdapter.MyShoeViewHolder> {

    private final ArrayList<ShoeModel> shoeDataSet;

public class MyShoeViewHolder extends RecyclerView.ViewHolder {
    TextView shoeName;
    TextView shoeReleaseYear;
    TextView shoe_ID;
    String result_id;
    ImageView shoePic;
    ImageView shoeCompanyLogo;
    CardView cardShoeView;
    Integer checkFav;
    String result_name;
     MaterialFavoriteButton shoeFav;

    public MyShoeViewHolder(View itemView) {
        super(itemView);
        this.shoeName = (TextView) itemView.findViewById(R.id.shoeName);
        this.shoe_ID = (TextView) itemView.findViewById(R.id.tv_shoeID);

        this.shoeReleaseYear = (TextView) itemView.findViewById(R.id.shoeReleaseYear);
        this.shoePic = (ImageView) itemView.findViewById(R.id.shoePic);
        this.shoeCompanyLogo = (ImageView) itemView.findViewById(R.id.shoeCompanyLogo);
        this.cardShoeView = (CardView) itemView.findViewById(R.id.cardShoeView);
        shoeFav = (MaterialFavoriteButton) itemView.findViewById(R.id.shoeFav);
    }
}


    //dataset = data from Main Activity
    public ShoeAdapter(ArrayList<ShoeModel> data) {
        //this.dataSet = data;
        this.shoeDataSet = new ArrayList<>(data);

    }

    @Override
    public MyShoeViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_shoes_cardview, parent, false);

        MyShoeViewHolder myViewHolder = new MyShoeViewHolder(view);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyShoeViewHolder holder, final int Position) {
        // called everytime user scrolls up or down
        TextView shoeName = holder.shoeName;
        TextView shoeReleaseYear = holder.shoeReleaseYear;
        ImageView shoePic = holder.shoePic;
        ImageView shoeCompanyLogo = holder.shoeCompanyLogo;
        CardView cardShoeView = holder.cardShoeView;

        MaterialFavoriteButton shoeFav = holder.shoeFav;
       // holder.shoeFav.setFavorite(shoeDataSet.get(FPosition).isitFavorite());
        Log.d("check favorite 1", " " + shoeDataSet.get(Position).isitFavorite()  + " " + shoeDataSet.get(Position).getshoeName());


         TextView shoeID = holder.shoe_ID;

        //Log.d("favorite check for ", "" + shoeDataSet.get(Position).getshoeName()) + "" + shoeID.getText().toString() );





        shoeID.setText("" + shoeDataSet.get(Position).getShoeID());

        final String result_id = shoeID.getText().toString();
        final String result_name = shoeDataSet.get(Position).getshoeName() ;
        final String result_year = shoeDataSet.get(Position).getshoeReleaseYear() ;
        final int result_pic = shoeDataSet.get(Position).getshoePic() ;
        final int result_logo = shoeDataSet.get(Position).getshoeCompanyLogo() ;
        final long result_ids = shoeDataSet.get(Position).getShoeID();

        Log.d("id check 1 ", "" + result_id);
        FavoriteShoesModel fav = SugarRecord.findById(FavoriteShoesModel.class, Integer.parseInt(result_id));
        if (fav == null) {
            holder.shoeFav.setFavorite(false);
        } else {
            holder.shoeFav.setFavorite(true);

        }

        shoeName.setText(shoeDataSet.get(Position).getshoeName());
        shoeReleaseYear.setText(shoeDataSet.get(Position).getshoeReleaseYear());

        shoeFav.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite) {
                            Log.d("id check ", "" + result_id);
                            Log.d("flow", "1");

                            FavoriteShoesModel fav = SugarRecord.findById(FavoriteShoesModel.class, Integer.parseInt(result_id));
                            if (fav == null) {
                                Log.d("flow", "2favnull");

                                //fav doesn't exist, create new entry
                                fav = new FavoriteShoesModel();
                                fav.setId(Long.parseLong(result_id));
                                fav.setShoeReleaseYear(result_year);
                                fav.setShoePic(result_pic);
                                fav.setShoeName(result_name);
                                fav.setShoeCompanyLogo(result_logo);
                                fav.setShoeID(result_ids);

                                fav.setitFavorite(true);

                                fav.save();
                                //SugarRecord.save(fav);
                                // holder.shoeFav.setFavorite(shoeDataSet.get(Position).isitFavorite(),true);
                                shoeDataSet.get(Position).setitFavorite(true);


                                Snackbar.make(buttonView, "Added " + shoeDataSet.get(Position).getshoeName() + " to Favorites",
                                        Snackbar.LENGTH_SHORT).show();
                            } else {
                                //unfavorite
                                Log.d("flow", "3unfav");
                            }


                        } else {
                            //   holder.shoeFav.toggleFavorite();
                            Log.d("flow", "unfavorite");
                            shoeDataSet.get(Position).setitFavorite(false);
                            Log.d("check favorite false", " " + shoeDataSet.get(Position).isitFavorite() + " " + shoeDataSet.get(Position).getshoeName());
                            FavoriteShoesModel fav = SugarRecord.findById(FavoriteShoesModel.class, Integer.parseInt(result_id));
                            SugarRecord.delete(fav);
                            Snackbar.make(buttonView, "Removed " + shoeDataSet.get(Position).getshoeName() + " from Favorites",
                                    Snackbar.LENGTH_SHORT).show();
                            Snackbar.make(buttonView, "Real Removed " + shoeDataSet.get(Position).getshoeName() + " from Favorites",
                                    Snackbar.LENGTH_SHORT).show();
                        }
                    }
                });



        Context context = shoePic.getContext();
        Context context2 = shoeCompanyLogo.getContext();
        cardShoeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String q = shoeDataSet.get(Position).getshoeName().toString();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
                intent.putExtra(SearchManager.QUERY, q);
                v.getContext().startActivity(intent);
            }
        });

        Picasso.with(context)
                .load(shoeDataSet.get(Position).getshoePic()).resize(500,350)
                .error(R.drawable.img_error)
                .centerCrop()
                .into(holder.shoePic);
        Glide.with(context2).load(shoeDataSet.get(Position).getshoeCompanyLogo()).into(holder.shoeCompanyLogo);
    }


    @Override
    public int getItemCount() {
        return shoeDataSet.size();
    }
    public void addtoFav(){


    }

}