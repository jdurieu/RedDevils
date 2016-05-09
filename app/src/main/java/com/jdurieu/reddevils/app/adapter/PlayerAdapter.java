package com.jdurieu.reddevils.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jdurieu.reddevils.app.fragment.PlayerFragment;
import com.jdurieu.reddevils.app.model.Team;

import java.util.ArrayList;

public class PlayerAdapter extends FragmentStatePagerAdapter {

    public ArrayList<Team.Player> players;

    public PlayerAdapter(FragmentManager fm) {
        super(fm);
        this.players = new ArrayList<Team.Player>();
    }

    @Override
    public Fragment getItem(int position) {
        return PlayerFragment.newInstance(this.players.get(position));
    }

    @Override
    public int getCount() {
        return players.size();
    }

    public void refreshData(ArrayList<Team.Player> players) {
        this.players.clear();
        this.players.addAll(players);
        this.notifyDataSetChanged();
    }
}
