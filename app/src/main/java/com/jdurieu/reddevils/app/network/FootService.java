package com.jdurieu.reddevils.app.network;


import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.jdurieu.reddevils.app.model.DetailPlayer;
import com.jdurieu.reddevils.app.model.Team;

import java.util.HashMap;

public class FootService {

    public interface FootServiceListener {
        public void onFindTeam(Team team);
    }

    public interface FootServiceDetailListener {
        public void onFindDetail(DetailPlayer detailPlayer);
    }

    private static final String TEAM_URL = "http://live.mobileapp.fifa.com/api/wc/team/43935/fr";

    private static final String PLAYER_ID = "PLAYER_ID";
    private static final String PLAYER_DETAIL_URL = "http://live.mobileapp.fifa.com/api/wc/player/"+PLAYER_ID+"/fr";

    private RequestQueue mVolleyRequestQueue;
    private ImageLoader mVolleyImageLoader;

    public FootService(Context context) {
        this.mVolleyRequestQueue = Volley.newRequestQueue(context);
        this.mVolleyRequestQueue.start();

        this.mVolleyImageLoader = new ImageLoader(mVolleyRequestQueue, new LruBitmapCache(1024 * 1024 * 1));
    }

    public ImageLoader getVolleyImageLoader() {
        return mVolleyImageLoader;
    }

    public void retrieveTeamInfo(final FootServiceListener listener) {
        Response.Listener responseListener = new Response.Listener<Team>() {
            @Override
            public void onResponse(Team resultTeam) {
                if(listener!=null) {
                    listener.onFindTeam(resultTeam);
                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Foot", "error : " + volleyError);
            }
        };

        // Construction de la requête
        JacksonRequest<Team> request = new JacksonRequest<Team>(Request.Method.GET, TEAM_URL, null, Team.class, new HashMap<String, String>(),
                responseListener, errorListener, 1, 1);

        mVolleyRequestQueue.add(request);
    }

    public void retrievePlayerDetail(Team.Player player, final FootServiceDetailListener detailListener) {

        String urlDetail = PLAYER_DETAIL_URL;

        urlDetail = urlDetail.replace(PLAYER_ID, player.getN_PersonID().toString());

        Response.Listener responseListener = new Response.Listener<DetailPlayer>() {
            @Override
            public void onResponse(DetailPlayer detailPlayer) {
                if(detailListener!=null) {
                    detailListener.onFindDetail(detailPlayer);
                }
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Foot", "error : " + volleyError);
            }
        };

        // Construction de la requête
        JacksonRequest<DetailPlayer> request = new JacksonRequest<DetailPlayer>(Request.Method.GET, urlDetail, null, DetailPlayer.class, new HashMap<String, String>(),
                responseListener, errorListener, 1, 1);

        mVolleyRequestQueue.add(request);

    }



}
