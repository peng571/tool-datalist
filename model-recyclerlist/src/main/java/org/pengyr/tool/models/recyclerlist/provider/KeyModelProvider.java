package org.pengyr.tool.models.recyclerlist.provider;

import android.support.annotation.NonNull;

import org.pengyr.tool.models.KeyModel;


/**
 * to keep change data for adapter
 * <p>
 * only refresh data when adapter is on main ui thread
 * <p>
 * Created by Peng on 2017/6/13.
 */
public class KeyModelProvider<M extends KeyModel<P>, P> extends DataProvider<P> {

    private final static String TAG = KeyModelProvider.class.getSimpleName();

    public KeyModelProvider() {
        super();
    }


    /**
     * add Methods
     */
    public void add(@NonNull M model) {
        super.add(model.getID());
    }

    public void addAll(@NonNull M[] models) {
        for (M m : models) {
            add(m);
        }
    }


    /**
     * remove methods
     */
    public void remove(@NonNull M m) {
        remove(m.getID());
    }


    /**
     * update methods
     */
    public void update(@NonNull M m) {
        update(m.getID());
    }

}
