package com.jdurieu.reddevils.app.fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.jdurieu.reddevils.app.FootApplication;
import com.jdurieu.reddevils.app.R;
import com.jdurieu.reddevils.app.model.DetailPlayer;
import com.jdurieu.reddevils.app.model.Team;
import com.jdurieu.reddevils.app.network.FootService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PlayerFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class PlayerFragment extends Fragment {

    private Team.Player mPlayer;

    private TextView textViewPlayerName, textViewPlayerSummary;
    private NetworkImageView playerNetworkImageView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PlayerFragment.
     */

    public static PlayerFragment newInstance(Team.Player player) {
        PlayerFragment fragment = new PlayerFragment();
        fragment.mPlayer = player;
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    public PlayerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_player, container, false);
        playerNetworkImageView = (NetworkImageView)mainView.findViewById(R.id.networkimage_player);

        textViewPlayerName = (TextView)mainView.findViewById(R.id.textview_player_name);
        textViewPlayerSummary = (TextView)mainView.findViewById(R.id.textview_player_summary);

        return mainView;
    }

    @Override
    public void onStart() {
        super.onStart();

        final FootService footService = ((FootApplication)(getActivity().getApplication())).getFootService();

        footService.retrievePlayerDetail(mPlayer, new FootService.FootServiceDetailListener() {
            @Override
            public void onFindDetail(DetailPlayer detailPlayer) {

                DetailPlayer.DetailPlayerData playerData = detailPlayer.getData();

                String emblemUrl = playerData.getC_EmblemImage();

                if(emblemUrl!=null) {
                    playerNetworkImageView.setImageUrl(emblemUrl, footService.getVolleyImageLoader());
                }

                textViewPlayerName.setText(playerData.getC_Headline());
                textViewPlayerSummary.setText(playerData.getC_Summary());
            }
        });
    }
}
