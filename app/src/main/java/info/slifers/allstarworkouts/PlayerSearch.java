package info.slifers.allstarworkouts;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import info.slifers.allstarworkouts.fragments_fav.FavsActivity;

public class PlayerSearch extends Fragment  implements SearchView.OnQueryTextListener {
    public static PlayerSearch newInstance() {
        return new PlayerSearch();
    }

    private static RecyclerView recyclerView;
    private static PlayerAdapter adapter;
    private static ArrayList<PlayerData> data;





    private RecyclerView.LayoutManager layoutManager;
    static View.OnClickListener myOnClickListener;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View view = inflater.inflate(R.layout.fragment_playersearch, container, false);


            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            getKeyHash();
            return view;

        }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<PlayerData>();


        addPlayers();
        adapter = new PlayerAdapter(data);

        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intentA;
                intentA =  new Intent(getContext(),FavsActivity.class);
                startActivity(intentA);

            }
        });
    }


    public interface Constants {
        String LOG = "com.vogella.testapp";
    }
    private void addPlayers() {

        PlayerData player = new PlayerData("Michael Jordan", "SG", R.drawable.player_jordan_head, R.drawable.team_logo_bulls1, "Chicago Bulls", 23, true, true);
        data.add(player);
        player = new PlayerData("Kobe Bryant", "SG", R.drawable.player_kobe_head, R.drawable.team_logo_laker, "Los Angeles Lakers", 0, true, true);
        data.add(0,player);

        player = new PlayerData("LeBron James", "SF", R.drawable.player_lebron_head, R.drawable.team_logo_cavs1, "Cleveland Cavaliers", 2, true, true);
        data.add(player);

        player = new PlayerData("Stephen Curry", "PG", R.drawable.player_curry_head, R.drawable.team_logo_warriors1, "Golden State Warriors", 1, true, true);
        data.add(player);



        player = new PlayerData("Kevin Durant", "SF", R.drawable.player_durant_head, R.drawable.team_logo_warriors1, "Golden State Warriors", 3, false, true);
        data.add(player);

        player = new PlayerData("Derrick Rose", "PG", R.drawable.player_rose_head, R.drawable.team_logo_knicks1, "New York Knicks", 14, false, true);
        data.add(player);



    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);

    }
    @Override
    public boolean onQueryTextChange(String query) {
        final ArrayList<PlayerData> filteredModelList = filter(data, query);
        adapter.animateTo(filteredModelList);
        recyclerView.scrollToPosition(0);
        return false;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private ArrayList<PlayerData> filter(ArrayList<PlayerData> players, String query) {
        query = query.toLowerCase();

        final ArrayList<PlayerData> filteredModelList = new ArrayList<>();
        for (PlayerData player : players) {
            final String text = player.getName().toLowerCase() + player.getPos().toLowerCase()+ player.getTeam().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(player);
            }
        }
        return filteredModelList;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        return true;
    }
    private void getKeyHash() {

        PackageInfo info;
        try {
            info = getContext().getPackageManager().getPackageInfo("com.androidlift.facebookdemo", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }
    }

}