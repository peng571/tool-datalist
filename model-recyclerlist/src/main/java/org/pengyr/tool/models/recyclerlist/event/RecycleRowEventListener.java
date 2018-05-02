package org.pengyr.tool.models.recyclerlist.event;

import android.support.annotation.IntDef;

import org.pengyr.tool.models.recyclerlist.ModelRowHolder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Peng on 2018/4/18.
 */

public interface RecycleRowEventListener<T> {

    int CLICK_EVENT = 1;
    int LONG_CLICK_EVENT = 2;

    @IntDef({CLICK_EVENT, LONG_CLICK_EVENT})
    @Retention(RetentionPolicy.SOURCE) @interface actionType {}


    void onRowAction(@actionType int event, ModelRowHolder<T> holder);

}
