package org.pengyr.tool.models.sample.recycler;


import android.databinding.ViewDataBinding;

import org.pengyr.tool.models.recyclerlist.ModelRowHolder;
import org.pengyr.tool.models.sample.BR;
import org.pengyr.tool.models.sample.model.SampleContainer;
import org.pengyr.tool.models.sample.model.pojo.SampleObject;

/**
 * Created by Peng on 2018/4/15.
 */

public class SampleRecyclerRowHolder extends ModelRowHolder<Long> {

    private final ViewDataBinding binding;

    private final SampleObject emptySampleObject = new SampleObject(0, "Empty Object");

    public SampleRecyclerRowHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    @Override protected void bind(int position, Long object) {
        super.bind(position, object);
        SampleObject sampleObject = SampleContainer.getInstance().get(object, emptySampleObject);
        binding.setVariable(BR.data, sampleObject);
        binding.executePendingBindings();
    }

}
