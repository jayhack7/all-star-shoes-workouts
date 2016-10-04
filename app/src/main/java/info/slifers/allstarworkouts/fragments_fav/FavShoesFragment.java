package info.slifers.allstarworkouts.fragments_fav;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import info.slifers.allstarworkouts.R;
import info.slifers.allstarworkouts.adapters.FavShoesAdapter;
import info.slifers.allstarworkouts.models.FavoriteShoesModel;

public class FavShoesFragment extends Fragment {
    List<FavoriteShoesModel> saved_shoes = new ArrayList<>();
    FavShoesAdapter adapter_shoes;

    @Bind(R.id.rv_shoes)
    RecyclerView mRV_shoes;

    @Bind(R.id.tv_empty)
    TextView tv_empty;

    public static FavShoesFragment newInstance() {
        return new FavShoesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fav_shoes, container, false);
        ButterKnife.bind(this, view);

        saved_shoes = FavoriteShoesModel.listAll(FavoriteShoesModel.class);

        if (!saved_shoes.isEmpty()){
            tv_empty.setVisibility(View.INVISIBLE);

            Log.d("text visible", "BLANK");



        }else{
            tv_empty.setVisibility(View.VISIBLE);

            Log.d("text invisible", "SEE");
        }


        mRV_shoes.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRV_shoes.setItemAnimator(new DefaultItemAnimator());
        mRV_shoes.setHasFixedSize(true);

        adapter_shoes = new FavShoesAdapter(saved_shoes);
        mRV_shoes.setAdapter(adapter_shoes);

        return view;

    }

}
