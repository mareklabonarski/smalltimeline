package com.example.aroundme.smalltimeline;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by akshaykale on 2017/08/22.
 */

/*
*
MIT License

Copyright (c) 2017 Akshay Kale

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
* */

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewHolder> {


    public ArrayList<TimelineObject> list = new ArrayList<>();

    public HorizontalRecyclerViewAdapter(ArrayList<TimelineObject> list) {
        this.list = list;
    }

    @Override
    public HorizontalRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = TimeLineConfig.horizontalLayout;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        HorizontalRecyclerViewHolder holder = (HorizontalRecyclerViewHolder) TimeLineConfig.getHorizontalHolderClassInstance(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(HorizontalRecyclerViewHolder holder, final int position) {
        holder.onBind(position, list);
    }

    @Override
    public int getItemCount() {
        if (list == null)
            return 0;
        return list.size();
    }

    @Override
    public void onViewRecycled(HorizontalRecyclerViewHolder holder) {
        holder.onViewRecycled();
        super.onViewRecycled(holder);
    }

}