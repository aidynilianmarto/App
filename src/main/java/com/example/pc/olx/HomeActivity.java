package com.example.pc.olx;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.pc.olx.Offer.Offer;
import com.example.pc.olx.Offer.OfferAdapter;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Offer offer1 = new Offer("Prodavam ostrov  ", 2000000, "V mnogo dobro sastoqnie, chudesen izgled kam oekana, ima tuk tam nqkoi kamak da bade izvaden.", "Chillie", R.drawable.island1);
        Offer offer2 = new Offer("Prodavam computer", 445, "V mnogo dobro sastoqnie, stava za vsqkakvi igri, HDD:1TB, VC:Vapor-X R, CPU: i7-4790K", "Varna", R.drawable.pc);

        ArrayList<Offer> offers = new ArrayList<>();

        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);
        offers.add(offer1);
        offers.add(offer2);

        OfferAdapter adapter = new OfferAdapter(this, offers);
        ListView lv = (ListView) findViewById(R.id.offer);
        lv.setAdapter(adapter);


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
        getMenuInflater().inflate(R.menu.home, menu);

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

        if (id == R.id.nav_offer_for_u) {

        } else if (id == R.id.nav_offer) {

        } else if (id == R.id.nav_messages) {

        } else if (id == R.id.nav_add_offer) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_info) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
