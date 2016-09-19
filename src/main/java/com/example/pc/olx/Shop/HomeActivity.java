package com.example.pc.olx.Shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pc.olx.Offer.OfferFragment;
import com.example.pc.olx.R;
import com.example.pc.olx.User.LoginActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OfferFragment.Communicator {
    private DrawerLayout drawer;
    private Button login;
    private ImageView offerIV;
    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        FragmentManager fm1 = getSupportFragmentManager();
        OfferFragment offerFragment = new OfferFragment(null);
        fm1.beginTransaction().add(R.id.content_home_layout,offerFragment,"offerFrag").commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerview = navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(this);

        login = (Button) headerview.findViewById(R.id.button_log_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                intent.putExtra("login", "loginButton");
                startActivity(intent);
            }
        });




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
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return true;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        if (id == R.id.nav_offer_for_u) {

        } else if (id == R.id.nav_messages) {
            intent.putExtra("login", "message");
            drawer.closeDrawer(GravityCompat.START);
            startActivity(intent);
        } else if (id == R.id.nav_add_offer) {
            intent.putExtra("login", "addOffer");
            drawer.closeDrawer(GravityCompat.START);
            startActivity(intent);
        } else if (id == R.id.nav_settings) {
            intent.putExtra("login", "settings");
            drawer.closeDrawer(GravityCompat.START);
            startActivity(intent);
        } else if (id == R.id.nav_info) {
            InformationHomeFragment timePicker = new InformationHomeFragment();
            drawer.closeDrawer(GravityCompat.START);
            timePicker.show(this.getSupportFragmentManager(), "infoDialog");
            return true;
        }
        return true;
    }

}
