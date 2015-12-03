package com.scaryboxstudios.sampleapp;

import java.util.List;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.os.Bundle;

public class CardListFragment extends Fragment {
    private static class CardData {
        public String title;
        public String description;
        public int iconId;

        CardData(String title, String desc, int icon) {
            this.title = title;
            this.description = desc;
            this.iconId = icon;
        }
    }

    private static class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardListHolder> {
        // The cards
        List<CardData> cards;

        //
        private static class CardListHolder extends RecyclerView.ViewHolder {
            public CardView cv;
            public TextView title;
            public TextView description;
            public ImageView icon;

            CardListHolder(View view) {
                super(view);
                cv = (CardView) view.findViewById(R.id.card_view);
                title = (TextView) view.findViewById(R.id.card_view_title);
                description = (TextView) view.findViewById(R.id.card_view_description);
                icon = (ImageView) view.findViewById(R.id.card_view_icon);
            }
        }

        public CardListAdapter(List<CardData> cards) {
            this.cards = cards;
        }

        @Override
        public CardListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                                   .inflate(R.layout.card, parent, false);
            CardListHolder clh = new CardListHolder(v);
            return clh;
        }

        @Override
        public void onBindViewHolder(CardListHolder cardListHolder, int i) {
            cardListHolder.title.setText(cards.get(i).title);
            cardListHolder.description.setText(cards.get(i).description);
            cardListHolder.icon.setImageResource(cards.get(i).iconId);
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView rView) {
            super.onAttachedToRecyclerView(rView);
        }

        @Override
        public int getItemCount() {
            return cards.size();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_list_fragment, container, false);

        // Dummy cards
        List<CardData> cardData = new ArrayList<>();
        cardData.add(new CardData("Title1", "Description 1", R.drawable.nav_header_bg));
        cardData.add(new CardData("Title2", "Description 2", R.drawable.nav_header_bg));
        cardData.add(new CardData("Title3", "Description 3", R.drawable.nav_header_bg));
        cardData.add(new CardData("Title4", "Description 4", R.drawable.nav_header_bg));

        // RecyclerView
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);
        rv.setHasFixedSize(true);
        CardListAdapter cla = new CardListAdapter(cardData);
        rv.setAdapter(cla);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        rv.setLayoutManager(llm);

        return view;
    }
}

