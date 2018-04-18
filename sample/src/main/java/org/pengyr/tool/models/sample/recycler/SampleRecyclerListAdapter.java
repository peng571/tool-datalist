package org.pengyr.tool.models.sample.recycler;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.pengyr.tool.models.recyclerlist.ListRecyclerAdapter;
import org.pengyr.tool.models.sample.R;

/**
 * Created by Peng on 2018/4/15.
 */

public class SampleRecyclerListAdapter extends ListRecyclerAdapter<Long, SampleRecyclerRowHolder> {

    @Override public SampleRecyclerRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.sample_row, parent, false);
        return new SampleRecyclerRowHolder(binding);
    }

}
