package com.example.pc.olx.User;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.pc.olx.Offer.AddOfferActivity;
import com.example.pc.olx.Offer.OfferFragment;
import com.example.pc.olx.R;
import com.example.pc.olx.Shop.SettingsActivity;

public class UserHomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OfferFragment.Communicator{
    private TextView logUsernameTV;
    private String logedUser;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_user);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_user);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        fm = getSupportFragmentManager();
        OfferFragment offerFragment = new OfferFragment();
        fm.beginTransaction().add(R.id.content_layout, offerFragment, "userOffer").commit();

        Intent intent = getIntent();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_user);
        View headerview2 = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);
        logedUser = intent.getStringExtra("logUser");
        logUsernameTV = (TextView) headerview2.findViewById(R.id.username_view);
        logUsernameTV.setText(logedUser);
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatem

        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_offer_for_u) {
            // Handle the camera action
        } else if (id == R.id.nav_user_offer) {

        } else if (id == R.id.nav_my_offer) {

        } else if (id == R.id.nav_user_messages) {

        } else if (id == R.id.nav_observed) {

        } else if (id == R.id.nav_user_add_offer) {
            Intent intent = new Intent(UserHomeActivity.this, AddOfferActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_user_settings) {
           
        } else if (id == R.id.nav_user_info) {

        } else if (id == R.id.nav_log_out) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_user);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

