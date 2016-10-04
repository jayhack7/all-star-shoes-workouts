package info.slifers.allstarworkouts;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import info.slifers.allstarworkouts.util.RecyclerViewFragment;

import info.slifers.allstarworkouts.tab_fragments.CareerFragment;
import info.slifers.allstarworkouts.tab_fragments.ShoeFragment;
import info.slifers.allstarworkouts.tab_fragments.WorkoutFragment;
import io.fabric.sdk.android.Fabric;

public class PlayerProfile extends AppCompatActivity {

    private MaterialViewPager mViewPager;

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;
    Integer playerID;
    public static String INSTAGRAM_BASE_URL = "http://www.instagram.com/";
    public static String INSTAGRAM_USER_NAME = "";
    public static String INSTAGRAM_COMPLETE_URL = INSTAGRAM_BASE_URL + INSTAGRAM_USER_NAME;
    public static String TWITTER_BASE_URL = "http://www.twitter.com/";
    public static String TWITTER_USER_NAME = "";
    public static String TWITTER_COMPLETE_URL = TWITTER_BASE_URL + TWITTER_USER_NAME;
    public static String FACEBOOK_BASE_URL = "http://www.facebook.com/";
    public static String FACEBOOK_USER_NAME = "";
    public static String FACEBOOK_COMPLETE_URL = FACEBOOK_BASE_URL + FACEBOOK_USER_NAME;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playerprofile);

        if (!BuildConfig.DEBUG)
            Fabric.with(this, new Crashlytics());
        String setTitle = "";

        // receive bundle from PlayerAdapter
        Bundle TabTitle = getIntent().getExtras();

        playerID = TabTitle.getInt("playerID");
        if (TabTitle != null){
            // set TabLayout title = layer name
            setTitle(TabTitle.getString("playerName"));
        }
        for (String key: TabTitle.keySet())
        {
            Log.d("Bundle Debug", key + " = \"" + TabTitle.get(key) + "\"");
        }
        // extract and send PlayerID to other fragments
        Intent newIntent = new Intent(PlayerProfile.this, ShoeFragment.class);
        newIntent.putExtra("PlayerID", playerID);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }


        //setTitle = "";
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
        mDrawer.setDrawerListener(mDrawerToggle);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 3) {
                    case 0:
                        return CareerFragment.newInstance();
                    case 1:
                        return WorkoutFragment.newInstance();
                    case 2:
                        return ShoeFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 3) {
                    case 0:
                        return "SUMMARY";
                    case 1:
                        return "WORKOUT";
                    case 2:
                        return "SHOES";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override

            public HeaderDesign getHeaderDesign(int page) {
                SharedPreferences sharedPref = getSharedPreferences("playerID", Context.MODE_PRIVATE);
                Integer value = sharedPref.getInt("playerID", 0);
                switch (value) {
                    case 23:
                        // 23 = mj
                        switch (page) {

                            case 0:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/2NLiGlw.jpg");
                            case 1:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/aCvhWfc.jpg");
                            case 2:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/EP31EMw.jpg ");

                        }
                        break;

                    case 0:
                        // 0 = kobe
                        switch (page) {

                            case 0:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/20WrqDX.jpg");
                            case 1:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/oFiCnJn.png");
                            case 2:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/QyPaUKU.jpg ");

                        }
                        break;
                    case 1:
                        // 1 = Steph Curry
                        switch (page) {

                            case 0:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/T7QE5YR.jpg");
                            case 1:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/Dh2Gvw8.jpg");
                            case 2:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/oe8E7iy.jpg");

                        }
                        break;
                    case 2:
                        // 2 = Lebron
                        switch (page) {

                            case 0:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/4nGcFpJ.png");
                            case 1:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://sports.cbsimg.net/images/visual/whatshot/lebron-james-chalk.jpg");
                            case 2:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://8328-presscdn-0-65.pagely.netdna-cdn.com/wp-content/uploads/2014/07/lebron-james-tire-workout.png");
                        }
                        break;
                    case 3:
                        // 3 = KD
                        switch (page) {

                            case 0:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/e3rHqqt.jpg");
                            case 1:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/MDnrxtq.jpg");
                            case 2:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/QXw4TCb.jpg");
                        }
                        break;
                    case 14:
                        // 14 = drose
                        switch (page) {

                            case 0:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/XB3D9l0.jpg");
                            case 1:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/HUYY8Ez.png");
                            case 2:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.switch_tabs,
                                        "http://i.imgur.com/tBpWEx6.jpg");
                        }
                        break;
                    case 15:
                        // 14 = iverson
                        switch (page) {

                            case 0:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.green,
                                        "http://i.imgur.com/T6kSfVN.jpg");
                            case 1:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.blue,
                                        "http://i.imgur.com/malOhCs.jpg");
                            case 2:
                                return HeaderDesign.fromColorResAndUrl(
                                        R.color.cyan,
                                        "http://i.imgur.com/bweTeFK.jpg");
                        }
                        break;
                }
                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return mDrawerToggle.onOptionsItemSelected(item);
        // super.onOptionsItemSelected(item);
        //TODO: open GROCER, copy login/ FIREBASE FROM THAT and other tabs open
        //copy facebook login from yourself
        // have 'create' basketball workout
        // maybe some other login stuff like login and commenting...
        clearSocialMediaInfo();
        getSocialMediaInfo();
        updateSocialMediaURL();

        int id = item.getItemId();
        if (id == R.id.text) {

//TODO: test fav shoes
        }
            if (id == R.id.instagram) {
            // have sharedpref to get userID
            // then assign a url to get their ID
            // when the case id breaks, have the username be added to string
            // like "Uri.parse("http://instagram.com/_u/x" + "greenmoneysniper35"
            Uri uri = Uri.parse("" + Uri.parse("" + INSTAGRAM_COMPLETE_URL));
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");
            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("" + INSTAGRAM_COMPLETE_URL)));
            }

            return true;
        }
        if (id == R.id.twitter) {
            // have sharedpref to get userID
            // then assign a url to get their ID
            // when the case id breaks, have the username be added to string
            // like "Uri.parse("http://instagram.com/_u/x" + "greenmoneysniper35"
            Uri uri = Uri.parse("" + Uri.parse("" + TWITTER_COMPLETE_URL));
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.twitter.android");
            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("" + TWITTER_COMPLETE_URL)));
            }

            return true;
        }
        if (id == R.id.facebook) {
            // have sharedpref to get userID
            // then assign a url to get their ID
            // when the case id breaks, have the username be added to string
            // like "Uri.parse("http://instagram.com/_u/x" + "greenmoneysniper35"
            Uri uri = Uri.parse("" + Uri.parse("" + FACEBOOK_COMPLETE_URL));
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.facebook.katana");
            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("" + FACEBOOK_COMPLETE_URL)));
            }

            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_profile, menu);
        clearSocialMediaInfo();
        getSocialMediaInfo();
        //check if strings are empty. if so, remove that social site
        if (INSTAGRAM_USER_NAME.isEmpty())
            menu.findItem(R.id.instagram).setVisible(false);
        if (TWITTER_USER_NAME.isEmpty())
            menu.findItem(R.id.twitter).setVisible(false);
        if (FACEBOOK_USER_NAME.isEmpty())
            menu.findItem(R.id.facebook).setVisible(false);

        return true;
    }

    public void getSocialMediaInfo() {
        SharedPreferences sharedPref = getSharedPreferences("playerID", Context.MODE_PRIVATE);
        Integer value = sharedPref.getInt("playerID", 0);
        switch (value) {
            case 0:
                //kobe
                INSTAGRAM_USER_NAME = "kobebryant";
                TWITTER_USER_NAME = "kobebryant";
                FACEBOOK_USER_NAME = "kobebryant";
                break;
            case 23:
             //jordan
                INSTAGRAM_USER_NAME = "jumpman23";
                TWITTER_USER_NAME = "jumpman23";
                break;
            case 2:
                //lebron
                FACEBOOK_USER_NAME = "LeBron";
                TWITTER_USER_NAME = "kingjames";
                INSTAGRAM_USER_NAME = "kingjames";

                break;
            case 1:
                //curry
                FACEBOOK_USER_NAME = "StephenCurryOfficial";
                TWITTER_USER_NAME = "StephenCurry30";
                INSTAGRAM_USER_NAME = "stephencurry30";

                break;
            case 3:
                //kd
                FACEBOOK_USER_NAME = "KevinDurant";
                TWITTER_USER_NAME = "kdtrey5";
                INSTAGRAM_USER_NAME = "easymoneysniper";

                break;
            case 4:
                //drose
                FACEBOOK_USER_NAME = "derrickrose";
                TWITTER_USER_NAME = "drose";

                break;
    }

    }
    public void clearSocialMediaInfo(){
        FACEBOOK_USER_NAME = "";
        TWITTER_USER_NAME = "";
        INSTAGRAM_USER_NAME = "";
    }
    public void updateSocialMediaURL(){
        INSTAGRAM_COMPLETE_URL = INSTAGRAM_BASE_URL + INSTAGRAM_USER_NAME;
       TWITTER_COMPLETE_URL = TWITTER_BASE_URL + TWITTER_USER_NAME;
        FACEBOOK_COMPLETE_URL = FACEBOOK_BASE_URL + FACEBOOK_USER_NAME;
    }
}
