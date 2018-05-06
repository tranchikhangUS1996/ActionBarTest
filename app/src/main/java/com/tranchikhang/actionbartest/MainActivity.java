package com.tranchikhang.actionbartest;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private class PageAdapter extends FragmentPagerAdapter{

        FragmentManager ft;

        public PageAdapter(FragmentManager ft) {
            super(ft);
            this.ft = ft;
        }

        @Override
        public Fragment getItem(int position) {
            switch(position) {
                case 0: return new TopFragment();
                case 1: return new PizzasFragment();
                case 2: return new PastaFragment();
                case 3: return new StoresFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0: return getResources().getString(R.string.home);
                case 1: return getResources().getString(R.string.pizza);
                case 2: return getResources().getString(R.string.pasta);
                case 3: return getResources().getString(R.string.store);
            }
            return super.getPageTitle(position);
        }
    }

    private ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v7.widget.Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());
        ViewPager parger = (ViewPager) findViewById(R.id.pager);
        parger.setAdapter(pageAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tap);
        tabLayout.setupWithViewPager(parger);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.share_action);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("want to join me for pizza?");
        return super.onCreateOptionsMenu(menu);
    }

    private void setShareActionIntent(String s) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,s);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_oder:
                Intent intent = new Intent(this,order_Activity.class);
                startActivity(intent);
                return true;
            default:
               return super.onOptionsItemSelected(item);
        }
    }
}
