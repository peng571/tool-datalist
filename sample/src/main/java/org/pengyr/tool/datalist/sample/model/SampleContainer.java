package org.pengyr.tool.datalist.sample.model;

import org.pengyr.tool.datalist.model.KeyModelContainer;
import org.pengyr.tool.datalist.sample.model.pojo.SampleObject;

/**
 * Created by Peng on 2018/4/15.
 */

public class SampleContainer extends KeyModelContainer<Long, SampleObject> {

    private static SampleContainer instance;

    public synchronized static SampleContainer getInstance() {
        if (instance == null) {
            instance = new SampleContainer();
        }
        return instance;
    }

    private SampleContainer() {
        // anyway, add some data into container.
        add(new SampleObject(1, "First message"));
        add(new SampleObject(2, "Second message"));
    }
}
