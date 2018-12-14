package com.example.rkjc.news_app_2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class FRecyclerViewAdapter  extends RecyclerView.Adapter<FRecyclerViewAdapter.FNewsViewHolder> {

    Context mContext;
    ArrayList<PlayerStatsAL> mNewsItem;

    public FRecyclerViewAdapter(Context mContext, ArrayList<PlayerStatsAL> mNewsItem) {
        this.mContext = mContext;
        this.mNewsItem = mNewsItem;
    }

    @Override
    public FRecyclerViewAdapter.FNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.news_item, parent, shouldAttachToParentImmediately); //hopefully correct
        FNewsViewHolder viewHolder = new FNewsViewHolder(view);
        //view.setOnClickListener();

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(FRecyclerViewAdapter.FNewsViewHolder holder, final int position) {
        //view.setOnClickListener();

//        holder.url.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Uri url = Uri.parse(mNewsItem.get(position).getUrl());
//
//                Intent i = new Intent(Intent.ACTION_VIEW, url);
//                i.setData(url);
//
//                mContext.startActivity(i);
//            }
//        }));
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNewsItem.size();
    }

    public class FNewsViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView description;
        TextView date;
        TextView url;

        /*15 to 19. Inside p2. p2 includes Lifetime solo stats*/
        TextView epicUserHandle;
        TextView soloWins;
        TextView soloKD;
        TextView soloMatches;
        TextView soloKills;
        TextView soloKPG; //killsPerGame;

        /*21 to 26. Inside p2. p2 includes Lifetime duos stats*/
        TextView duosWins;
        TextView duosKD;
        TextView duosMatches;
        TextView duosKills;
        TextView duosKPG; //killsPerGame;

        /*28 to 34. Inside p2. p2 includes Lifetime squad stats*/
        TextView squadWins;
        TextView squadKD;
        TextView squadMatches;
        TextView squadKills;
        TextView squadKPG; //killsPerGame;


        public FNewsViewHolder(View itemView) {
            super(itemView);

            epicUserHandle = (TextView) itemView.findViewById(R.id.epicUserHandle);

            soloWins = (TextView) itemView.findViewById(R.id.soloWins);
            soloKD = (TextView) itemView.findViewById(R.id.soloKD);
            soloMatches = (TextView) itemView.findViewById(R.id.soloMatches);
            soloKills = (TextView) itemView.findViewById(R.id.soloKills);
            soloKPG = (TextView) itemView.findViewById(R.id.soloKPG);


            duosWins = (TextView) itemView.findViewById(R.id.duoWins);
            duosKD = (TextView) itemView.findViewById(R.id.duoKD);
            duosMatches = (TextView) itemView.findViewById(R.id.duoMatches);
            duosKills = (TextView) itemView.findViewById(R.id.duoKills);
            duosKPG = (TextView) itemView.findViewById(R.id.duoKPG);

            squadWins = (TextView) itemView.findViewById(R.id.squadWins);
            squadKD = (TextView) itemView.findViewById(R.id.squadKD);
            squadMatches = (TextView) itemView.findViewById(R.id.squadMatches);
            squadKills = (TextView) itemView.findViewById(R.id.squadKills);
            squadKPG = (TextView) itemView.findViewById(R.id.squadKPG);


//
//            title = (TextView) itemView.findViewById(R.id.title);
//            date = (TextView) itemView.findViewById(R.id.date);
//            description = (TextView) itemView.findViewById(R.id.description);
//            url = (TextView) itemView.findViewById(R.id.url);

//            itemView.setOnClickListener(
//                    (new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            Uri urls = Uri.parse(url.getText().toString());
//
//                            Intent i = new Intent(Intent.ACTION_VIEW, urls);
//                            i.setData(urls);
//
//                            mContext.startActivity(i);
//                        }
//                    })
//            );

        }

        void bind(int listIndex) {
            soloWins.setText("SOLO WINS: " + mNewsItem.get(listIndex).getSoloWins());
            soloKD.setText("SOLO WINS: " + mNewsItem.get(listIndex).getSoloKD());
            soloMatches.setText("SOLO WINS: " + mNewsItem.get(listIndex).getSoloMatches());
            soloKills.setText("SOLO WINS: " + mNewsItem.get(listIndex).getSoloKills());
            soloKPG.setText("SOLO KPG: " + mNewsItem.get(listIndex).getSoloKPG());

            duosWins.setText("DUOS WINS: " + mNewsItem.get(listIndex).getDuosWins());
            duosKD.setText("DUOS K/D: " + mNewsItem.get(listIndex).getDuosKD());
            duosMatches.setText("DUOS Matches: " + mNewsItem.get(listIndex).getDuosMatches());
            duosKills.setText("DUOS Kills: " + mNewsItem.get(listIndex).getDuosKills());
            duosKPG.setText("DUOS Kills: " + mNewsItem.get(listIndex).getDuosKPG());

            squadWins.setText("SQUAD WINS: " + mNewsItem.get(listIndex).getSquadWins());
            squadKD.setText("SQUAD K/D: " + mNewsItem.get(listIndex).getSquadKD());
            squadMatches.setText("SQUAD Matches: " + mNewsItem.get(listIndex).getSquadMatches());
            squadKills.setText("SQUAD Kills: " + mNewsItem.get(listIndex).getSquadKills());
            squadKPG.setText("SQUAD KPG: " + mNewsItem.get(listIndex).getSquadKPG());







//            title.setText("Title"+ mNewsItem.get(listIndex).getTitle());
//            description.setText("Description"+ mNewsItem.get(listIndex).getDescription());
//            date.setText("Date:"+ mNewsItem.get(listIndex).getPublishedAt());
//            url.setText(mNewsItem.get(listIndex).getUrl());
        }
    }
}
