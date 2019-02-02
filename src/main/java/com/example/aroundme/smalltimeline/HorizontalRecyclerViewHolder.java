package com.example.aroundme.smalltimeline;

import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HorizontalRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;
    public ImageView imageView;
    public CardView cardView;

    //public MaterialRatingBar ratingBar;

    public HorizontalRecyclerViewHolder(View view) {
        super(view);
        textView = (TextView) view.findViewById(R.id.tv_timeline_horizontal_card_name);
        cardView = (CardView) view.findViewById(R.id.timeline_obj_cardview);
        imageView = (ImageView) view.findViewById(R.id.iv_horizontal_card_image);

        textView.setTextSize(TimeLineConfig.getTimelineCardTextSize());
        textView.setTextColor(Color.parseColor(TimeLineConfig.getTimelineCardTextColour()));
        textView.setBackgroundColor(Color.parseColor(TimeLineConfig.getTimelineCardTextBackgroundColour()));
    }

    public void onBind(final int position, final ArrayList<TimelineObject> list) {
        this.textView.setText("" + list.get(position).getTitle());

        TimeLineConfig.getImageLoadEngine().onLoadImage(this.imageView, list.get(position).getImageUrl());

        if (TimeLineConfig.getListener() != null) {
            this.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimeLineConfig.getListener().onTimelineObjectClicked(list.get(position));
                }
            });

            this.cardView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    TimeLineConfig.getListener().onTimelineObjectLongClicked(list.get(position));
                    return true;
                }
            });
        }
    }

    public void onViewRecycled(){
        this.imageView.setImageDrawable(null);
    }
}
