package org.pengyr.tool.models.sample.page.normal;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.pengyr.tool.models.recyclerlist.ListRecyclerAdapter;
import org.pengyr.tool.models.sample.R;

/**
 * Created by Peng on 2018/4/15.
 */

public class NormalRecyclerListAdapter extends ListRecyclerAdapter<Long, NormalRecyclerRowHolder> {

    @Override public NormalRecyclerRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.sample_row, parent, false);
        return new NormalRecyclerRowHolder(binding);
    }

}
