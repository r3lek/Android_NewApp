package com.example.rkjc.news_app_2;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class JSONPlayerUtils {

    public static ArrayList<PlayerStatsAL> parseNews(String JSONString){

        ArrayList<PlayerStatsAL> newsList = new ArrayList<>();
        try{
            Log.d("PrintingJSON", JSONString);
            //Get userName
            JSONObject mainJSONObject = new JSONObject(JSONString);
            String epicID = mainJSONObject.getString("epicUserHandle"); //EPIC ID
            JSONObject stats = mainJSONObject.getJSONObject("stats"); //stats JSON

            //FOR SOLO
            JSONObject p2 = stats.getJSONObject("p2");
            JSONObject top1 = p2.getJSONObject("top1");
            String soloWins = top1.getString("value"); //keep this as its solo wins

            JSONObject solokd = p2.getJSONObject("kd");
            String soloKD = solokd.getString("value"); //keep this as its SOLO KD

            JSONObject solomatches = p2.getJSONObject("matches");
            String soloMatches = solomatches.getString("value"); //keep this as its SOLO matches

            JSONObject solokills = p2.getJSONObject("kills");
            String soloKills = solokills.getString("value"); //keep this as its SOLO kills

            JSONObject solokpg = p2.getJSONObject("kpg");
            String soloKPG = solokpg.getString("value"); //keep this as its SOLO KPG


            //FOR p10 (DUOS)
            JSONObject p10 = stats.getJSONObject("p10");
            JSONObject p10top1 = p10.getJSONObject("top1");
            String p10Wins = p10top1.getString("value"); //keep this as its DUO wins

            JSONObject p10kd = p10.getJSONObject("kd");
            String p10KD = p10kd.getString("value"); //keep this as its DUO KD

            JSONObject p10matches = p10.getJSONObject("matches");
            String p10Matches = p10matches.getString("value"); //keep this as its DUO matches

            JSONObject p10kills = p10.getJSONObject("kills");
            String p10Kills = p10kills.getString("value"); //keep this as its DUO kills

            JSONObject p10kpg = p10.getJSONObject("kpg");
            String p10KPG = p10kpg.getString("value"); //keep this as its DUO KPG


            //FOR p9 (SQUADS)
            JSONObject p9 = stats.getJSONObject("p9");
            JSONObject p9top1 = p9.getJSONObject("top1");
            String p9Wins = p9top1.getString("value"); //keep this as its SQUAD wins

            JSONObject p9kd = p9.getJSONObject("kd");
            String p9KD = p9kd.getString("value"); //keep this as its SQUAD KD

            JSONObject p9matches = p9.getJSONObject("matches");
            String p9Matches = p9matches.getString("value"); //keep this as its SQUAD matches

            JSONObject p9kills = p9.getJSONObject("kills");
            String p9Kills = p9kills.getString("value"); //keep this as its SQUAD kills

            JSONObject p9kpg = p9.getJSONObject("kpg");
            String p9KPG = p9kpg.getString("value"); //keep this as its SQUAD KPG



            newsList.add(new PlayerStatsAL(epicID, soloWins, soloKD, soloMatches, soloKills, soloKPG, p10Wins, p10KD, p10Matches, p10Kills, p10KPG, p9Wins, p9KD, p9Matches, p9Kills, p9KPG));


            //Print those
            Log.d("SOMEONETAG", epicID);
            Log.d("winTAG", p9Wins);
            Log.d("winTAG", p9KD);
            Log.d("winTAG", p9Matches);
            Log.d("winTAG", p9Kills);
            Log.d("winTAG", p9KPG);













            //JSONObject mainJSONObject = new JSONObject(JSONString);
//            JSONArray items = mainJSONObject.getJSONArray("stats");
//
//            for(int i = 0; i < items.length(); i++){
//                JSONObject item = items.getJSONObject(i);
//                //newsList.add(new PlayerStatsAL(item.getString("author"), item.getString("title"), item.getString("description"), item.getString("url"), item.getString("urlToImage"), item.getString("publishedAt")));
//                Log.d("myjson", item.toString());
//
//            }
        } catch (JSONException e) {
            //Log.d("myjson", e.toString());
            e.printStackTrace();
        }
        return newsList;
    }




}
