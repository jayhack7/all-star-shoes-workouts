package info.slifers.allstarworkouts.adapters;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;
import com.orm.SugarRecord;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.models.FavoriteShoesModel;
import info.slifers.allstarworkouts.models.ShoeModel;

/**
 * Created by user on 10/1/2016.
 */
public class FavShoesAdapter extends RecyclerView.Adapter<FavShoesAdapter.MyShoeViewHolder> {

    private final ArrayList<FavoriteShoesModel> shoeDataSet;

    public class MyShoeViewHolder extends RecyclerView.ViewHolder {
        TextView shoeName;
        TextView shoeReleaseYear;
        TextView shoe_ID;
        String result_id;
        ImageView shoePic;
        ImageView shoeCompanyLogo;
        CardView cardShoeView;
        Integer checkFav;
        MaterialFavoriteButton shoeFav;

        public MyShoeViewHolder(View itemView) {
            super(itemView);
            this.shoeName = (TextView) itemView.findViewById(R.id.shoeName);
            this.shoe_ID = (TextView) itemView.findViewById(R.id.tv_shoeID);

            this.shoeReleaseYear = (TextView) itemView.findViewById(R.id.shoeReleaseYear);
            this.shoePic = (ImageView) itemView.findViewById(R.id.shoePic);
            this.shoeCompanyLogo = (ImageView) itemView.findViewById(R.id.shoeCompanyLogo);
            this.cardShoeView = (CardView) itemView.findViewById(R.id.cardShoeView);
            this.shoeFav = (MaterialFavoriteButton) itemView.findViewById(R.id.shoeFav);
        }
    }


    //dataset = data from Main Activity
    public FavShoesAdapter(List<FavoriteShoesModel> data) {
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
        int position = holder.getAdapterPosition();

        TextView shoeName = holder.shoeName;
        TextView shoeReleaseYear = holder.shoeReleaseYear;
        ImageView shoePic = holder.shoePic;
        ImageView shoeCompanyLogo = holder.shoeCompanyLogo;
        CardView cardShoeView = holder.cardShoeView;

        MaterialFavoriteButton shoeFav = holder.shoeFav;
        TextView shoeID = holder.shoe_ID;






        shoeID.setText("" + shoeDataSet.get(position).getShoeID());

        final String resultid = shoeID.getText().toString();
        String result_id_copy = resultid;
        Log.d("idFAVcheck ", "" + resultid);

        FavoriteShoesModel fav = SugarRecord.findById(FavoriteShoesModel.class, Integer.parseInt(resultid));
        Log.d("idFAVboolean ", "" + fav);

        if (shoeDataSet.get(position).isitFavorite() == true) {
            holder.shoeFav.setFavorite(true);
        } else {
            holder.shoeFav.setFavorite(false);

        }

        shoeName.setText(shoeDataSet.get(position).getshoeName());
        shoeReleaseYear.setText(shoeDataSet.get(position).getshoeReleaseYear());

        shoeFav.setOnFavoriteChangeListener(
                new MaterialFavoriteButton.OnFavoriteChangeListener() {
                    @Override
                    public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                        if (favorite) {
                            Log.d("wave1", "ifFav");
                            Log.d("wave1", "SHOULD NOT EVER APPEAR");
                            Log.d("wave1", "delete CV from list");


                            //holder.shoeFav.toggleFavorite();
                        }else{
                            Log.d("wave2", "not fave");

                            FavoriteShoesModel fav = SugarRecord.findById(FavoriteShoesModel.class, Integer.parseInt(resultid));
                            if (fav == null) {
                                Log.d("wave3", "db entry doesnt exist");

                                Snackbar.make(buttonView, "??? " + shoeDataSet.get(Position).getshoeName() + " from Favorites",
                                        Snackbar.LENGTH_SHORT).show();
                            }else{
                                int Position = holder.getAdapterPosition();

                                Log.d("wave4", "DB EXISTS - deleting");

                                shoeDataSet.get(Position).setitFavorite(false);
                                Log.d("check favorite false", " " + shoeDataSet.get(Position).isitFavorite()  + " " + shoeDataSet.get(Position).getshoeName());
                                Snackbar.make(buttonView, "Removed " + shoeDataSet.get(Position).getshoeName() + " from Favorites",
                                        Snackbar.LENGTH_SHORT).show();
                                SugarRecord.delete(fav);
                                fav = shoeDataSet.remove(Position);
                                notifyItemRemoved(Position);
                                notifyItemRangeChanged(Position, getItemCount());



                            }


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
        if(shoeDataSet.size() == 0) {
            Log.d("index", "shoedataset = 0");
        }
        return shoeDataSet.size();
    }
    public void addtoFav(){


    }

    public void deleteItems (int position){


    }
}