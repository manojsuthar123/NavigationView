package com.manoj.navigationdrawer;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.myDrawer);
        toolbar = findViewById(R.id.myToolbar);
        navigationView = findViewById(R.id.myNavigation);

        //set default toolbar
        setSupportActionBar(toolbar);

        //it is used for toggle icon(three line icon).
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.OPEN, R.string.CLOSE);

        /*using this you can open and close drawer by
        tapping on action bar icon(three line icon).*/
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        //syncState -> it change the icon(three line icon) to back navigation and vice-versa.
        actionBarDrawerToggle.syncState();

        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.home);
        }

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        /*Here you can do anything like add/replace Fragments,
                         * Change toolbar title according to fragment,
                         * open dialog box,
                         * open any activity
                         * and etc.*/
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.starred:
                        Toast.makeText(MainActivity.this, "Starred", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.archive:
                        Toast.makeText(MainActivity.this, "Archive", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.share:
                        Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.contact:
                        Toast.makeText(MainActivity.this, "Contact", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.privacy:
                        Toast.makeText(MainActivity.this, "Privacy", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        //Close drawer if it is open.
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }
}
