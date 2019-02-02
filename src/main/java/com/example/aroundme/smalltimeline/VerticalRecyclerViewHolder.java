package com.example.aroundme.smalltimeline;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VerticalRecyclerViewHolder extends RecyclerView.ViewHolder {

    Context context;
    public TextView time, header;
    public RecyclerView recyclerView;

    RelativeLayout timelineindicator_container;
    TextView timelineindicator_line;

    public VerticalRecyclerViewHolder(Context context, View view) {
        super(view);
        this.context = context;
        time = (TextView) view.findViewById(R.id.tv_timeline_time);
        header = (TextView) view.findViewById(R.id.tv_timeline_header);
        header.setVisibility(View.INVISIBLE);

        timelineindicator_container = (RelativeLayout) view.findViewById(R.id.container_timeline_indicator);
        timelineindicator_line = (TextView) view.findViewById(R.id.tv_timeline_indicator_line);

        /*apply configs*/
        time.setTextColor(Color.parseColor(TimeLineConfig.getTimelineHeaderTextColour()));
        time.setTextSize(TimeLineConfig.getTimelineHeaderSize());
        timelineindicator_line.setBackgroundColor(Color.parseColor(TimeLineConfig.getTimelineIndicatorLineColour()));
        timelineindicator_container.setBackgroundColor(Color.parseColor(TimeLineConfig.getTimelineIndicatorBackgroundColour()));

        recyclerView = (RecyclerView) view.findViewById(R.id.rv_horizontal_timeline);

        LinearLayoutManager recyclerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        LinearLayoutManager horizontalLinearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLinearLayoutManager);
    }

    public HorizontalRecyclerViewAdapter onBind(int position){
        this.time.setText(TimeLineConfig.headerList.get(position));

        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(TimeLineConfig.timelineObjMap.get(TimeLineConfig.headerList.get(position)));
        this.recyclerView.setAdapter(horizontalRecyclerViewAdapter);
        return horizontalRecyclerViewAdapter;
    }
}