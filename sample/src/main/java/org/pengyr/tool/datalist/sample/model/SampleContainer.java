package org.pengyr.tool.datalist.sample.model;

import org.pengyr.tool.datalist.data.KeyModelContainer;
import org.pengyr.tool.datalist.sample.model.pojo.SampleObject;

/**
 * Created by Peng on 2018/4/15.
 */

public class SampleContainer extends KeyModelContainer<Long, SampleObject> {

    private static SampleContainer instance;

    public synchronized static SampleContainer get() {
        if (instance == null) {
            instance = new SampleContainer();
        }
        return instance;
    }

    private SampleContainer() {
        addObject(new SampleObject(1, "First message"));
        addObject(new SampleObject(2, "Second message"));
    }
}
