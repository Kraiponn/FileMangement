package com.ksntechnology.filemangement.activity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.ksntechnology.filemangement.R;
import com.ksntechnology.filemangement.adapter.MainViewPagerAdapter;
import com.rd.PageIndicatorView;

public class MainActivity extends AppCompatActivity {

    //private FloatingActionButton fab;
    private Toolbar toolbar;
    private BottomNavigationView bottomNavView;
    private PageIndicatorView pageIndicatorView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private BottomNavigationMenuView menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstance();
    }

    private void initInstance() {
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        pageIndicatorView = findViewById(R.id.pageIndicatorView);

        setSupportActionBar(toolbar);
        bottomNavView = findViewById(R.id.bottomNavView);

        init(menuView);
    }

    private void init(BottomNavigationMenuView menuView) {
        /*fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        menuView = (BottomNavigationMenuView) bottomNavView.getChildAt(0);
        for (int i=0; i<menuView.getChildCount(); i++) {
            View iconView = menuView
                            .getChildAt(i)
                            .findViewById(android.support.design.R.id.icon);
            ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.width = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics);
            layoutParams.height = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 32, displayMetrics
            );

            iconView.setLayoutParams(layoutParams);
        }

        MainViewPagerAdapter pagerAdapter =
                new MainViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_menu_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_menu_information);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_menu_shared);

        int iconColorUnSelect = ContextCompat.getColor(getBaseContext(), R.color.colorWhite);
        tabLayout.getTabAt(0).getIcon().setColorFilter(
                iconColorUnSelect, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(
                iconColorUnSelect, PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(
                iconColorUnSelect, PorterDuff.Mode.SRC_IN);

        bottomNavView.setOnNavigationItemSelectedListener(buttomNavViewItemSelect);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getBaseContext(), R.color.ColorTransparent);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int tabIconColor = ContextCompat.getColor(getBaseContext(), R.color.colorWhite);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /***********************************
     *  Listener Zone
     */
    BottomNavigationView.OnNavigationItemSelectedListener buttomNavViewItemSelect = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            if (menuItem.getItemId() == R.id.menu_home) {
                //
            } else if (menuItem.getItemId() == R.id.menu_information) {
                //
            } else if (menuItem.getItemId() == R.id.menu_shared) {
                //
            }
            return true;
        }
    };





}
