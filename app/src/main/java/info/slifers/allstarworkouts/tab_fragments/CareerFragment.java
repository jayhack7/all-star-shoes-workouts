package info.slifers.allstarworkouts.tab_fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.adapters.AllStarAdapter;
import info.slifers.allstarworkouts.adapters.BioAdapter;
import info.slifers.allstarworkouts.adapters.ChampionshipAdapter;
import info.slifers.allstarworkouts.adapters.MVPAdapter;
import info.slifers.allstarworkouts.models.BioModel;

/**
 * Created by user on 6/15/2016.
 */
public class CareerFragment extends Fragment {
    public static CareerFragment newInstance() {
        return new CareerFragment();
    }

    // Store instance variables based on arguments passed
    private String title;
    private int page;
    public TextView ChampionshipNumber;
    public TextView MVPNumber;
    public TextView AllStarNumber;
    boolean champ;
    boolean mvp;
    boolean allstar;

    private RecyclerView rv_champ;
    private RecyclerView rv_mvp;
    private RecyclerView rv_allstar;
    private RecyclerView rv_bio;

    private RecyclerView testRecyclerView;
    private RecyclerView.Adapter testAdapter;
    private RecyclerView.Adapter BioAdapter;

    private RecyclerView.LayoutManager llm_champ, llm_allstar, llm_mvp;

    private List<String> NumberOfAllStars;
    private List<String> NumberOfChampionships;
    private List<String> NumberOfMVP;
    private static ArrayList<BioModel> BioData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        page = getArguments().getInt("someInt", 0);
//        title = getArguments().getString("someTitle");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_career, container, false);
        rv_champ = (RecyclerView) view.findViewById(R.id.RV_Championship);
        rv_mvp = (RecyclerView) view.findViewById(R.id.RV_MVP);
        rv_allstar = (RecyclerView) view.findViewById(R.id.RV_AllStar);
        rv_bio = (RecyclerView) view.findViewById(R.id.RV_bio);


        return view;



    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView Championship = (TextView) view.findViewById(R.id.TV_Championship);
        TextView MVP = (TextView) view.findViewById(R.id.TV_MVP);

        TextView ChampionshipNumber = (TextView) view.findViewById(R.id.TV_ChampionshipNumber);
        TextView MVPNumber = (TextView) view.findViewById(R.id.TV_MVPNumber);
        TextView AllStarNumber = (TextView) view.findViewById(R.id.TV_AllstarNumber);



        SharedPreferences sharedPref = getActivity().getSharedPreferences("playerID", Context.MODE_PRIVATE);
        Integer value = sharedPref.getInt("playerID", 0);
        if (value == null) {
            // the key does not exist
        } else {
            switch (value) {

                case 0:
                    // 0 = Kobe
                    AllStarNumber.setText("(14)");
                    ChampionshipNumber.setText("(5)");
                    MVPNumber.setText("(1)");
                    champ = true;
                    mvp = true;

                {
                    NumberOfAllStars = new ArrayList<String>();
                    NumberOfAllStars.clear();
                    NumberOfAllStars.add("1");
                    NumberOfAllStars.add("2");
                    NumberOfAllStars.add("3");
                    NumberOfAllStars.add("4");
                    NumberOfAllStars.add("5");
                    NumberOfAllStars.add("6");
                    NumberOfAllStars.add("7");
                    NumberOfAllStars.add("8");
                    NumberOfAllStars.add("9");
                    NumberOfAllStars.add("10");
                    NumberOfAllStars.add("11");
                    NumberOfAllStars.add("12");
                    NumberOfAllStars.add("13");
                    NumberOfAllStars.add("14");
                    NumberOfAllStars.add("15");
                    NumberOfAllStars.add("16");
                    NumberOfAllStars.add("17");
                    NumberOfAllStars.add("18");
                    NumberOfChampionships = new ArrayList<String>();

                    NumberOfChampionships.clear();
                    NumberOfChampionships.add("1");
                    NumberOfChampionships.add("2");
                    NumberOfChampionships.add("3");
                    NumberOfChampionships.add("4");
                    NumberOfChampionships.add("5");

                    NumberOfMVP = new ArrayList<String>();

                    NumberOfMVP.clear();
                    NumberOfMVP.add("1");

                    BioData = new ArrayList<BioModel>();
                    BioData.clear();

                    BioModel bio = new BioModel("" +
                            this.getString(R.string.bio_kobe));
                    BioData.add(0, bio);
                }
                break;

                case 23:
                    // 23 = mj
                    AllStarNumber.setText("(14)");
                    ChampionshipNumber.setText("(6)");
                    MVPNumber.setText("(5)");
                    champ = true;
                    mvp = true;
                {
                    NumberOfAllStars = new ArrayList<String>();

                    NumberOfAllStars.clear();

                    NumberOfAllStars.add("1");
                    NumberOfAllStars.add("2");
                    NumberOfAllStars.add("3");
                    NumberOfAllStars.add("4");
                    NumberOfAllStars.add("5");
                    NumberOfAllStars.add("6");
                    NumberOfAllStars.add("7");
                    NumberOfAllStars.add("8");
                    NumberOfAllStars.add("9");
                    NumberOfAllStars.add("10");
                    NumberOfAllStars.add("11");
                    NumberOfAllStars.add("12");
                    NumberOfAllStars.add("13");
                    NumberOfAllStars.add("14");

                    NumberOfChampionships = new ArrayList<String>();

                    NumberOfChampionships.clear();

                    NumberOfChampionships.add("1");
                    NumberOfChampionships.add("2");
                    NumberOfChampionships.add("3");
                    NumberOfChampionships.add("4");
                    NumberOfChampionships.add("5");
                    NumberOfChampionships.add("6");

                    NumberOfMVP = new ArrayList<String>();

                    NumberOfMVP.clear();

                    NumberOfMVP.add("1");
                    NumberOfMVP.add("2");
                    NumberOfMVP.add("3");
                    NumberOfMVP.add("4");
                    NumberOfMVP.add("5");

                    BioData = new ArrayList<BioModel>();
                    BioData.clear();
                    BioModel bio = new BioModel("" +
                            this.getString(R.string.bio_jordan));
                    BioData.add(0, bio);
                }
                break;
                case 1:
                    // 1 = Steph Curry
                    AllStarNumber.setText("(3)");
                    ChampionshipNumber.setText("(1)");
                    MVPNumber.setText("(2)");
                    champ = true;
                    mvp = true;
                {
                    NumberOfAllStars = new ArrayList<String>();
                    NumberOfAllStars.clear();
                    NumberOfAllStars.add("1");
                    NumberOfAllStars.add("2");
                    NumberOfAllStars.add("3");

                    NumberOfChampionships = new ArrayList<String>();

                    NumberOfChampionships.clear();
                    NumberOfChampionships.add("1");

                    NumberOfMVP = new ArrayList<String>();

                    NumberOfMVP.clear();
                    NumberOfMVP.add("1");
                    NumberOfMVP.add("2");
                    BioData = new ArrayList<BioModel>();
                    BioData.clear();
                    BioModel bio = new BioModel("" +
                            this.getString(R.string.bio_curry));
                    BioData.add(0, bio);

                }
                break;

                case 2: {

                    // 2 = Lebron
                    AllStarNumber.setText("(12)");
                    ChampionshipNumber.setText("(2)");
                    MVPNumber.setText("(4)");
                    champ = true;
                    mvp = true;
                    {
                        NumberOfAllStars = new ArrayList<String>();
                        NumberOfAllStars.clear();
                        NumberOfAllStars.add("1");
                        NumberOfAllStars.add("2");
                        NumberOfAllStars.add("3");
                        NumberOfAllStars.add("4");
                        NumberOfAllStars.add("5");
                        NumberOfAllStars.add("6");
                        NumberOfAllStars.add("7");
                        NumberOfAllStars.add("8");
                        NumberOfAllStars.add("9");
                        NumberOfAllStars.add("10");
                        NumberOfAllStars.add("11");
                        NumberOfAllStars.add("12");

                        NumberOfChampionships = new ArrayList<String>();

                        NumberOfChampionships.clear();
                        NumberOfChampionships.add("1");
                        NumberOfChampionships.add("2");

                        NumberOfMVP = new ArrayList<String>();


                        NumberOfMVP.clear();
                        NumberOfMVP.add("1");
                        NumberOfMVP.add("2");

                        NumberOfMVP.add("3");
                        NumberOfMVP.add("4");
                        BioData = new ArrayList<BioModel>();
                        BioData.clear();
                        BioModel bio = new BioModel("" +
                                this.getString(R.string.bio_lebron));

                        BioData.add(0, bio);

                    }
                    break;


                }
                case 3: {
                    // 3 = kd
                    // no championships
                    champ = false;
                    mvp = true;

                    ChampionshipNumber.setText("(0)");

                    MVPNumber.setText("(1)");

                    AllStarNumber.setText("(7)");


                    {
                        NumberOfAllStars = new ArrayList<String>();
                        NumberOfAllStars.clear();
                        NumberOfAllStars.add("1");
                        NumberOfAllStars.add("2");
                        NumberOfAllStars.add("3");
                        NumberOfAllStars.add("4");
                        NumberOfAllStars.add("5");
                        NumberOfAllStars.add("6");
                        NumberOfAllStars.add("7");


                        NumberOfChampionships = new ArrayList<String>();

                        NumberOfChampionships.clear();


                        NumberOfMVP = new ArrayList<String>();

                        NumberOfMVP.clear();
                        NumberOfMVP.add("1");

                        BioData = new ArrayList<BioModel>();
                        BioData.clear();
                        BioModel bio = new BioModel("" +
                                this.getString(R.string.bio_durant));
                        BioData.add(0, bio);

                    }
                    break;


                }

                case 14: {
                    // 14 drose
                    // no championships
                    champ = false;
                    mvp = true;
                    ChampionshipNumber.setText("(0)");

                    MVPNumber.setText("(1)");

                    AllStarNumber.setText("(3)");


                    {
                        NumberOfAllStars = new ArrayList<String>();
                        NumberOfAllStars.clear();
                        NumberOfAllStars.add("1");
                        NumberOfAllStars.add("2");
                        NumberOfAllStars.add("3");


                        NumberOfChampionships = new ArrayList<String>();

                        NumberOfChampionships.clear();


                        NumberOfMVP = new ArrayList<String>();

Log.d("drose", "before mvp");

                        NumberOfMVP.clear();
                        NumberOfMVP.add("1");
                        Log.d("drose", "after mvp");

                        BioData = new ArrayList<BioModel>();
                        BioData.clear();
                        BioModel bio = new BioModel("" +
                                this.getString(R.string.bio_rose));
                        BioData.add(0, bio);

                    }
                    break;
                }
            }

// i left off adding boolean from playeradapter.java to sharedprefs and putting it here to make rv visibility
            // set default to true so you
            // 7:30 updAate - pass sharedpref boolean to make champ / mvp invisible if player doesn't have those.
            SharedPreferences checkifChamp = getActivity().getSharedPreferences("player_accolodes_champ", Context.MODE_PRIVATE);
            Boolean check_champ = checkifChamp.getBoolean("player_accolodes_champ", true);

            Boolean checkifMVP = sharedPref.getBoolean("player_accolodes_mvp", true);


                LinearLayoutManager llm_champ = new LinearLayoutManager(getActivity());
                llm_champ.setOrientation(LinearLayoutManager.HORIZONTAL);
                rv_champ.setHasFixedSize(true);

                ChampionshipAdapter ChampionshipAdapter = new ChampionshipAdapter(NumberOfChampionships);
                rv_champ.setAdapter(ChampionshipAdapter);
                rv_champ.setLayoutManager(llm_champ);

/////////////////////////
            LinearLayoutManager llm_mvp = new LinearLayoutManager(getActivity());
            llm_mvp.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_allstar.setHasFixedSize(true);

            MVPAdapter MVPAdapter = new MVPAdapter(NumberOfMVP);
            rv_mvp.setAdapter(MVPAdapter);
            rv_mvp.setLayoutManager(llm_mvp);


            /////////////////////////////
            LinearLayoutManager llm_allstar = new LinearLayoutManager(getActivity());
            llm_allstar.setOrientation(LinearLayoutManager.HORIZONTAL);
            rv_allstar.setHasFixedSize(true);

            AllStarAdapter allStarAdapter = new AllStarAdapter(NumberOfAllStars);
            rv_allstar.setAdapter(allStarAdapter);
            rv_allstar.setLayoutManager(llm_allstar);

///////////////////
            rv_bio.setHasFixedSize(true);

            rv_bio.setLayoutManager(new LinearLayoutManager(getActivity()));
            rv_bio.setItemAnimator(new DefaultItemAnimator());


            BioAdapter = new BioAdapter(BioData);

            rv_bio.setAdapter(BioAdapter);
        }


    }

}
