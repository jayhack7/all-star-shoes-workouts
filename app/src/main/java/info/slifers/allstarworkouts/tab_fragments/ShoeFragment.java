package info.slifers.allstarworkouts.tab_fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.florent37.materialviewpager.adapter.RecyclerViewMaterialAdapter;

import java.util.ArrayList;

import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.adapters.ShoeAdapter;
import info.slifers.allstarworkouts.models.ShoeModel;

/**
 * Created by user on 5/15/2016.
 */
public class ShoeFragment extends Fragment {

    // newInstance constructor for creating fragment with arguments
    public static ShoeFragment newInstance() {
        return new ShoeFragment();
    }

    private static RecyclerView recyclerView;
    private static RecyclerViewMaterialAdapter adapter;
    private static ArrayList<ShoeModel> shoeData;
    private static RecyclerViewMaterialAdapter materialAdapter;
    Integer PlayerID;


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        page = getArguments().getInt("someInt", 0);
//        title = getArguments().getString("someTitle");
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int i = bundle.getInt("playerID");
            Log.d("ShoeFragment Debug", String.valueOf(i));
        }

        // int PlayerID = bundle.getInt("playerID");


    }


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
        shoeData = new ArrayList<ShoeModel>();


        addShoes();
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        adapter = new RecyclerViewMaterialAdapter(new ShoeAdapter(shoeData));

        recyclerView.setAdapter(adapter);
        MaterialViewPagerHelper.registerRecyclerView(getActivity(), recyclerView, null);


    }


    private void addShoes() {
        SharedPreferences sharedPref = getContext().getSharedPreferences("playerID", Context.MODE_PRIVATE);
        Integer value = sharedPref.getInt("playerID", 0);
        if (value == null) {
            // the key does not exist
        } else {
            switch (value) {
                case 0:
                    // 1 = Kobe
                    ShoeModel shoe = new ShoeModel("Kobe 11", "2016", R.drawable.shoes_kobe_nike_kobe_kobe11, R.drawable.shoes_logo_nike1, 20);
                    shoeData.add(0, shoe);

                    shoe = new ShoeModel("Kobe 10", "2015", R.drawable.shoes_kobe_nike_kobe_kobe10, R.drawable.shoes_logo_nike1, 19);
                    shoeData.add(shoe);

                    shoe = new ShoeModel("Kobe 9", "2014", R.drawable.shoes_kobe_nike_kobe_kobe9, R.drawable.shoes_logo_nike1, 18);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Kobe 8", "2013", R.drawable.shoes_kobe_nike_kobe_kobe8, R.drawable.shoes_logo_nike1, 17);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Kobe 7", "2012", R.drawable.shoes_kobe_nike_kobe_kobe7, R.drawable.shoes_logo_nike1, 16);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Kobe 6", "2011", R.drawable.shoes_kobe_nike_kobe_kobe6, R.drawable.shoes_logo_nike1, 15);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Zoom Kobe 5", "2010", R.drawable.shoes_kobe_nike_kobe_kobe5, R.drawable.shoes_logo_nike1, 14);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Zoom Kobe 4", "2009", R.drawable.shoes_kobe_nike_kobe_kobe4, R.drawable.shoes_logo_nike1, 13);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Zoom Kobe 3", "2008", R.drawable.shoes_kobe_nike_kobe_kobe3, R.drawable.shoes_logo_nike1, 12);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Zoom Kobe II", "2007", R.drawable.shoes_kobe_nike_kobe_kobe2, R.drawable.shoes_logo_nike1, 11);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Zoom Kobe I", "2006", R.drawable.shoes_kobe_nike_kobe_kobe1, R.drawable.shoes_logo_nike1, 10);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Huarache 2k4", "2004", R.drawable.shoes_kobe_nike_kobe_kobe1, R.drawable.shoes_logo_nike1, 10);
                    shoeData.add(shoe);
                    break;

                case 23:
                    // 0 = Kobe
                    shoe = new ShoeModel("Jordan 31", "2016", R.drawable.shoes_jordan_jordan31, R.drawable.shoes_logo_jordan2, 225);
                    shoeData.add(0, shoe);
                    shoe = new ShoeModel("Air Jordan 30 (XXX)", "2016", R.drawable.shoes_jordan_jordan30, R.drawable.shoes_logo_jordan2, 224);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Air Jordan XX9", "2014", R.drawable.shoes_jordan_jordan29, R.drawable.shoes_logo_jordan2, 223);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Air Jordan XX8", "2012", R.drawable.shoes_jordan_jordan28, R.drawable.shoes_logo_jordan2, 222);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Air Jordan 2012", "2012", R.drawable.shoes_jordan_jordan27, R.drawable.shoes_logo_jordan2, 221);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Air Jordan 2011", "2011", R.drawable.shoes_jordan_jordan26, R.drawable.shoes_logo_jordan2, 220);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Air Jordan 2010", "2010", R.drawable.shoes_jordan_jordan25, R.drawable.shoes_logo_jordan2, 219);
                    shoeData.add(shoe);
                    break;

                case 1:
                // 1 = Steph Curry
                shoe = new ShoeModel("Curry 2.5 / 73-9", "2016", R.drawable.shoes_curry_ua_curry_curry25, R.drawable.shoes_logo_ua2,
                        475);
                shoeData.add(0, shoe);

                    shoe = new ShoeModel("Curry 2", "2015", R.drawable.shoes_curry_ua_curry_curry2, R.drawable.shoes_logo_ua2, 474);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("Curry 1", "2015", R.drawable.shoes_curry_ua_curry_curry1, R.drawable.shoes_logo_ua2, 473);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("ClutchFit Drive", "2014", R.drawable.shoes_curry_ua_curry_clutchfitdrive, R.drawable.shoes_logo_ua2, 472);
                    shoeData.add(shoe);
                    shoe = new ShoeModel("UA Anatomix Spawn 1", "2013", R.drawable.shoes_curry_ua_curry_anatomixspawn, R.drawable.shoes_logo_ua2, 471);
                    shoeData.add(shoe);

                    break;
            case 2: {
                // 2 = Lebron
                shoe = new ShoeModel("LeBron 13", "2015", R.drawable.shoes_lebron_nike_lebron_lebron13, R.drawable.shoes_logo_nike1, 350);
                shoeData.add(0, shoe);
                shoe = new ShoeModel("Solder 10", "2015", R.drawable.shoes_lebron_nike_solders_10, R.drawable.shoes_logo_nike1, 349);
                shoeData.add(shoe);
                shoe = new ShoeModel("LeBron 12", "2014", R.drawable.shoes_lebron_nike_lebron_lebron12, R.drawable.shoes_logo_nike1, 348);
                shoeData.add(shoe);
                shoe = new ShoeModel("Solder 9", "2014", R.drawable.shoes_lebron_nike_solders_9, R.drawable.shoes_logo_nike1, 347);
                shoeData.add(shoe);
                shoe = new ShoeModel("LeBron 11", "2013", R.drawable.shoes_lebron_nike_lebron_lebron11, R.drawable.shoes_logo_nike1, 346);
                shoeData.add(shoe);

                shoe = new ShoeModel("LeBron 10", "2012", R.drawable.shoes_lebron_nike_lebron_lebron10, R.drawable.shoes_logo_nike1, 345);
                shoeData.add(shoe);


                shoe = new ShoeModel("LeBron 9", "2011", R.drawable.shoes_lebron_nike_lebron_lebron09, R.drawable.shoes_logo_nike1, 344);
                shoeData.add(shoe);
                shoe = new ShoeModel("LeBron 8", "2010", R.drawable.shoes_lebron_nike_lebron_lebron08, R.drawable.shoes_logo_nike1, 343);
                shoeData.add(shoe);
                shoe = new ShoeModel("LeBron 7", "2009", R.drawable.shoes_lebron_nike_lebron_lebron07, R.drawable.shoes_logo_nike1, 342);
                shoeData.add(shoe);
                break;

            }
            case 3: {
                // 3 kd
                shoe = new ShoeModel("KD 8", "2016", R.drawable.shoes_durant_kd8, R.drawable.shoes_logo_nike1, 579);
                shoeData.add(0, shoe);
                shoe = new ShoeModel("KD 7", "2015", R.drawable.shoes_durant_kd7, R.drawable.shoes_logo_nike1, 578);
                shoeData.add(0, shoe);
                shoe = new ShoeModel("KD 6", "2014", R.drawable.shoes_durant_kd6, R.drawable.shoes_logo_nike1, 577);
                shoeData.add(0, shoe);
                break;

            }
            case 14: {
                // 14 rose
                shoe = new ShoeModel("Rose 7 Boost", "2016", R.drawable.shoes_rose_rose7, R.drawable.shoes_logo_adidas1, 621);
                shoeData.add(0, shoe);
                shoe = new ShoeModel("Rose 6 Boost", "2015", R.drawable.shoes_rose_rose6, R.drawable.shoes_logo_adidas1, 622);
                shoeData.add(0, shoe);
                shoe = new ShoeModel("Rose 5 Boost", "2014", R.drawable.shoes_rose_rose5, R.drawable.shoes_logo_adidas1, 623);
                shoeData.add(0, shoe);
                shoe = new ShoeModel("Rose 4 Boost", "2013", R.drawable.shoes_rose_rose4, R.drawable.shoes_logo_adidas1, 624);
                shoeData.add(0, shoe);
                break;

                    }
                }


        }
    }
}