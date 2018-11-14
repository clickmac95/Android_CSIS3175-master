package com.example.a300288081.auction_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class App_home_Nav_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home__nav_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        SharedPreferences settins = PreferenceManager
                .getDefaultSharedPreferences(App_home_Nav_Activity.this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();
        //Change the menu items according to the user type

        // 0 - bidder menu
        // 1 - bid creator
        if(settins.getString("userType","00").equals("0")  ) {



// -------- code to change navigation menu items according to user type-----------
            // find MenuItem you want to change

            MenuItem nav_item_one = menu.findItem(R.id.navt_item_one);

            // set new title to the MenuItem
            nav_item_one.setTitle("Home");

            // do the same for other MenuItems
            MenuItem nav_item_two = menu.findItem(R.id.nav_item_two);
            nav_item_two.setTitle("Categories");


            MenuItem nav_item_three = menu.findItem(R.id.nav_item_three);
            nav_item_three.setTitle("History");

            MenuItem nav_item_four = menu.findItem(R.id.nav_item_four);
            nav_item_four.setTitle("Profile Settings");

            MenuItem nav_item_five = menu.findItem(R.id.nav_item_five);
            nav_item_five.setTitle("Logout");

        }


        else
        {
            MenuItem nav_item_one = menu.findItem(R.id.navt_item_one);

            // set new title to the MenuItem
            nav_item_one.setTitle("Home");

            // do the same for other MenuItems
            MenuItem nav_item_two = menu.findItem(R.id.nav_item_two);
            nav_item_two.setTitle("Add new Bid");


            MenuItem nav_item_three = menu.findItem(R.id.nav_item_three);
            nav_item_three.setTitle("History");

            MenuItem nav_item_four = menu.findItem(R.id.nav_item_four);
            nav_item_four.setTitle("Profile Settings");

            MenuItem nav_item_five = menu.findItem(R.id.nav_item_five);
            nav_item_five.setTitle("Logout");
        }



        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.app_home__nav_, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
