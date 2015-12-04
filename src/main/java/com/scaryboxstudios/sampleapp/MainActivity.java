package com.scaryboxstudios.sampleapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.design.widget.NavigationView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    /**/
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show the hamburger
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setHomeButtonEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.string.accessibility_open_drawer,
                R.string.accessibility_close_drawer
        );
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.drawer);
        navigationView.setNavigationItemSelectedListener(new NavigationDrawerItemSelectedListener());

        // Begin fragment transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        // Replace the contents of the container with the new fragment
        ft.replace(R.id.content_frame, new TabsFragment());
        // Complete the changes added above
        ft.commit();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        if (mDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    /**
     * Handles clicks on the navigation menu.
     */
    private class NavigationDrawerItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(final MenuItem menuItem) {
            // Update highlighted item in the navigation menu
            //menuItem.setChecked(true);
            int itemId = menuItem.getItemId();
            mDrawerLayout.closeDrawer(GravityCompat.START);

            Bundle args = new Bundle();
            args.putString("tc", menuItem.getTitle().toString());
            Fragment ft = new SampleFragment();
            ft.setArguments(args);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, ft)
                .commit();
            return true;
        }
    }
}
