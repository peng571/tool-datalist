package org.pengyr.tool.models.sample.page.header;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.pengyr.tool.models.recyclerlist.ListRecyclerAdapter;
import org.pengyr.tool.models.recyclerlist.ModelRowHolder;
import org.pengyr.tool.models.recyclerlist.event.OnItemClickListener;
import org.pengyr.tool.models.sample.R;

/**
 * Created by Peng on 2018/4/15.
 */

public class HeaderRecyclerListAdapter extends ListRecyclerAdapter<Long, ModelRowHolder<Long>> {

    final static int HEADER_TYPE = 1;

    private OnItemClickListener headerListener;

    @Override public ModelRowHolder<Long> onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding;
        switch (viewType) {
            case HEADER_TYPE:
                binding = DataBindingUtil.inflate(layoutInflater, R.layout.header_row, parent, false);
                HeaderRecyclerHeaderHolder header = new HeaderRecyclerHeaderHolder(binding);
                header.listen(headerListener);
                return header;
            default:
                binding = DataBindingUtil.inflate(layoutInflater, R.layout.sample_row, parent, false);
                return new HeaderRecyclerRowHolder(binding);
        }
    }

    @Override public int getItemViewType(int position) {
        if (position == 0) return HEADER_TYPE;
        return super.getItemViewType(position - 1);
    }


    @Override public int getItemCount() {
        return super.getItemCount() + 1;
    }


    public void setHeaderListener(OnItemClickListener headerListener) {
        this.headerListener = headerListener;
    }
}
