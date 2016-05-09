package com.jdurieu.reddevils.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.jdurieu.reddevils.app.adapter.PlayerAdapter;
import com.jdurieu.reddevils.app.fragment.LoadingFragment;
import com.jdurieu.reddevils.app.model.Team;
import com.jdurieu.reddevils.app.network.FootService;

import java.util.ArrayList;


public class MainActivity extends FragmentActivity {


    private ViewPager mainViewPager;
    private PlayerAdapter mainPlayerAdapter;

    private LoadingFragment mLoadingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadingFragment = LoadingFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_container,mLoadingFragment)
                .commit();

        mainViewPager = (ViewPager)findViewById(R.id.main_player_pager);
        mainPlayerAdapter = new PlayerAdapter(getSupportFragmentManager());

        mainViewPager.setAdapter(mainPlayerAdapter);


        FootService footService = ((FootApplication)getApplication()).getFootService();

        footService.retrieveTeamInfo(new FootService.FootServiceListener() {
            @Override
            public void onFindTeam(Team team) {
                ArrayList<Team.Player> allPlayers = new ArrayList<Team.Player>();

                ArrayList<Team.Players> poolPlayers = team.getData().getPlayers();

                for(int i=0;i<poolPlayers.size();i++) {
                    Team.Players pool = poolPlayers.get(i);

                    allPlayers.addAll(pool.getPlayers());
                }

                mainPlayerAdapter.refreshData(allPlayers);

                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(mLoadingFragment)
                        .commit();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
