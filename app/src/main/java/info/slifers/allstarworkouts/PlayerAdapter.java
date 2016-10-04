package info.slifers.allstarworkouts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.MyViewHolder> {

    // Dataset = list of players and their attributes
    private final ArrayList<PlayerData> dataSet;
    // private final List<PlayerData> filteredList;
    private ArrayList<PlayerData> originalItems;
    public class MyViewHolder extends RecyclerView.ViewHolder  {
        Context context3;
        TextView textViewName;
        TextView textViewPos;
        CircleImageView imageViewFace;
        ImageView imageTeamLogo;
        TextView textViewTeam;
        CardView wholeCard;
        Context mContext;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewPos = (TextView) itemView.findViewById(R.id.textViewPos);
            this.imageViewFace = (CircleImageView) itemView.findViewById(R.id.imageViewFace);
            this.imageTeamLogo = (ImageView) itemView.findViewById(R.id.ImgTeamLogo);
            this.textViewTeam = (TextView) itemView.findViewById(R.id.textViewTeam);
            this.wholeCard = (CardView) itemView.findViewById(R.id.card_view);
            this.mContext = itemView.getContext();
            context3 = itemView.getContext();
        }
    }


    //dataset = data from Main Activity
    public PlayerAdapter(ArrayList<PlayerData> data) {
        //this.dataSet = data;
        this.dataSet = new ArrayList<>(data);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_playersearch_cv, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int Position) {
        // called everytime user scrolls up or down
        TextView textViewName = holder.textViewName;
        TextView textViewPos = holder.textViewPos;
        ImageView imageViewFace = holder.imageViewFace;
        ImageView imageViewLogo = holder.imageTeamLogo;
        TextView textViewTeam = holder.textViewTeam;
        CardView wholeCard = holder.wholeCard;
        textViewName.setText(dataSet.get(Position).getName());

        textViewPos.setText(dataSet.get(Position).getPos());

        textViewTeam.setText(dataSet.get(Position).getTeam());

        wholeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentA =  new Intent(v.getContext(),PlayerProfile.class);
                // send PlayerName and PlayerID to populate PlayerProfile tabs
                intentA.putExtra("playerName", (dataSet.get(Position).getName()));
                intentA.putExtra("playerID", (dataSet.get(Position).getId()));
                v.getContext().startActivity(intentA);


                Activity myActivity=(Activity)(v.getContext());

                //Here define all your sharedpreferences code with key and value
                SharedPreferences sharedPref =  v.getContext().getSharedPreferences("playerID", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPref.edit();
                edit.putInt("playerID", (dataSet.get(Position).getId()));
                edit.commit();

                SharedPreferences checkIfChamp =  v.getContext().getSharedPreferences("playerMVP", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit_champ = checkIfChamp.edit();
                edit_champ.putBoolean("player_accolodes_champ", (dataSet.get(Position).getChamp()));
                edit_champ.commit();



                SharedPreferences checkifMVP =  v.getContext().getSharedPreferences("playerMVP", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit_mvp = checkifMVP.edit();
                edit_mvp.putBoolean("player_accolodes_mvp", (dataSet.get(Position).getMVP()));
                edit_mvp.commit();


            }
        });





        Context context = imageViewFace.getContext();
        Context context2 = imageViewLogo.getContext();

        Picasso.with(context)
                .load(dataSet.get(Position).getFace())
                .placeholder(R.drawable.ic_loading)
                .error(R.drawable.img_error)
                .into(holder.imageViewFace);

        Glide.with(context2).load(dataSet.get(Position).getTeamLogo()).into(holder.imageTeamLogo);


    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
    public void animateTo(ArrayList<PlayerData> players) {
        //checks what query found and adds / removes results
        // problem is, it is not adding back results
        applyAndAnimateRemovals(players);
        applyAndAnimateAdditions(players);
        applyAndAnimateMovedItems(players);

    }

    private void applyAndAnimateRemovals(ArrayList<PlayerData> newPlayers) {
        for (int i = dataSet.size() - 1; i >= 0; i--) {
            final PlayerData player = dataSet.get(i);
            if (!newPlayers.contains(player)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(ArrayList<PlayerData> newPlayers) {
        for (int i = 0, count = newPlayers.size(); i < count; i++) {
            final PlayerData player = newPlayers.get(i);
            if (!dataSet.contains(player)) {
                addItem(i, player);
            }
        }
    }


    private void applyAndAnimateMovedItems(ArrayList<PlayerData> newPlayers) {
        for (int toPosition = newPlayers.size() - 1; toPosition >= 0; toPosition--) {
            final PlayerData player = newPlayers.get(toPosition);
            final int fromPosition = dataSet.indexOf(player);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public PlayerData removeItem(int position) {
        final PlayerData player = dataSet.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, dataSet.size());
        return player;
    }
    public void addItem(int position, PlayerData player) {
        dataSet.add(position, player);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, dataSet.size());

    }

    public void moveItem(int fromPosition, int toPosition) {
        final PlayerData player = dataSet.remove(fromPosition);
        dataSet.add(toPosition, player);
        notifyItemMoved(fromPosition, toPosition);
    }
}
