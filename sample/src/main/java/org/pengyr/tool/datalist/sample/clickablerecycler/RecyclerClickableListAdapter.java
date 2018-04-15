package org.pengyr.tool.datalist.sample.clickablerecycler;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.pengyr.tool.datalist.recycler.ListRecyclerAdapter;
import org.pengyr.tool.datalist.sample.R;

/**
 * Created by Peng on 2018/4/15.
 */

public class RecyclerClickableListAdapter extends ListRecyclerAdapter<Long, RecyclerClickableRowHolder> {

    @Override public RecyclerClickableRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.sample_row, parent, false);
        return new RecyclerClickableRowHolder(binding);
    }

    @Override public void onBindViewHolder(@NonNull RecyclerClickableRowHolder holder, int position) {
        holder.bind(position, getItem(position));
    }

}
