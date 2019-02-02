package com.example.aroundme.smalltimeline;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Created by akshaykale on 2017/08/18.
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

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewHolder> {

    ArrayList<String> list;
    Context context;

    public HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter;

    public VerticalRecyclerViewAdapter(Context context, ArrayList<String> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public VerticalRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = TimeLineConfig.verticalLayout;
        View itemView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        VerticalRecyclerViewHolder holder = (VerticalRecyclerViewHolder) TimeLineConfig.getVerticalHolderClassInstance(context, itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(VerticalRecyclerViewHolder holder, int position) {
        horizontalRecyclerViewAdapter = holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return TimeLineConfig.headerList.size();
    }

    public void notifyDataSetChangedToHorizontalView() {
        if (horizontalRecyclerViewAdapter == null){
            return;
        }
        horizontalRecyclerViewAdapter.notifyDataSetChanged();
    }
}
