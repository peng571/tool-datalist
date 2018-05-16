package org.pengyr.tool.models.sample.page.header;


import android.databinding.ViewDataBinding;

import org.pengyr.tool.models.recyclerlist.ModelRowHolder;
import org.pengyr.tool.models.sample.BR;
import org.pengyr.tool.models.sample.model.SampleContainer;
import org.pengyr.tool.models.sample.model.pojo.SampleObject;

/**
 * Created by Peng on 2018/4/15.
 */
public class HeaderRecyclerHeaderHolder extends ModelRowHolder<Long> {

    private final ViewDataBinding binding;

    public HeaderRecyclerHeaderHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

}
