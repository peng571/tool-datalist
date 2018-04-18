package org.pengyr.tool.models.sample.model.pojo;


import org.pengyr.tool.models.KeyModel;

/**
 * Created by Peng on 2018/4/15.
 */
public class SampleObject implements KeyModel<Long> {

    final long ID;

    final String message;

    public SampleObject(long ID, String message) {
        this.ID = ID;
        this.message = message;
    }

    @Override public Long getID() {
        return ID;
    }

    public String getMessage() {
        return message;
    }
}
