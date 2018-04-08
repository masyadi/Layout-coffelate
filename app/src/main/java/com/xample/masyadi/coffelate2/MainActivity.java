package com.xample.masyadi.coffelate2;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import layout.FragmentBeranda;
import layout.FragmentKontak;
import layout.FragmentLokasi;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    EditText pencarian;

    RecyclerView recyclerView;

    BottomNavigationView bottomNavigationView;

    TextView txtBadgeCount;
    int itemCountBadge = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //pencarian = (EditText) findViewById(R.id.pencrian);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        /*fragmentAdapterView = new FragmentAdapterView(getSupportFragmentManager());
        fragmentAdapterView.addFragment(new FragmentBeranda());
        fragmentAdapterView.addFragment(new FragmentPromo());
        fragmentAdapterView.addFragment(new FragmentKontak());*/

        Fragment beranda = new FragmentBeranda();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, beranda);
        transaction.commit();


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;

                switch (tab.getPosition()){
                    case 0:
                        fragment = new FragmentBeranda();
                        break;
                    case 1:
                        fragment = new FragmentLokasi();
                        break;
                    case 2:
                        fragment = new FragmentKontak();
                        break;
                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, fragment);
                //transaction.addToBackStack(null);
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setCheckable(true); //biar menu bisa diklik kembali
                int idMenu = item.getItemId();
                switch (idMenu){
                    case R.id.favorit:
                        startActivity(new Intent(MainActivity.this, ActivityFavorit.class));
                        break;
                    case R.id.pesanan:
                        startActivity(new Intent(MainActivity.this, ActivityPesanan.class));
                        break;
                    case R.id.akun:
                        startActivity(new Intent(MainActivity.this, ActivityAkun.class));
                        break;
                }
                return true;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        bottomNavigationView.getMenu().getItem(0).setCheckable(false);
        bottomNavigationView.getMenu().getItem(1).setCheckable(false);
        bottomNavigationView.getMenu().getItem(2).setCheckable(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);

        final MenuItem menuItem = menu.findItem(R.id.pesanan_badge);

        View actionView = MenuItemCompat.getActionView(menuItem);

        txtBadgeCount = (TextView) actionView.findViewById(R.id.txt_badge_count);
        setUpBadge();


        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        return true;
    }

    private void setUpBadge() {
        if (txtBadgeCount != null){
            if (itemCountBadge == 0){
                if(txtBadgeCount.getVisibility() != View.GONE){
                    txtBadgeCount.setVisibility(View.GONE);
                }
            }
            else {
                txtBadgeCount.setText(String.valueOf(Math.min(itemCountBadge, 99)));
                if (txtBadgeCount.getVisibility() != View.VISIBLE){
                    txtBadgeCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int idMenu = item.getItemId();
        switch (idMenu){
            case R.id.pesanan_badge:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Catatan pesanan");
                alert.setMessage("1. Nasi goreng 1 \t 15000 \n2. Nasi goreng 2 10000\nTotal: 25000");
                alert.show();
                break;

            case R.id.tentang_app_menu:
                startActivity(new Intent(this, ActivityTentangApp.class));
                break;
            case R.id.cara_penggunaan_menu:
                startActivity(new Intent(this, ActivityCaraPenggunaan.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }






}
