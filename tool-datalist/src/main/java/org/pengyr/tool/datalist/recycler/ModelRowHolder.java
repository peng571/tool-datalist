package org.pengyr.tool.datalist.recycler;

import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Recycler ViewHolder
 * that has item clickable action
 * <p>
 * Updated by Peng on 2017/10/26.
 */
public abstract class ModelRowHolder<T> extends RecyclerView.ViewHolder {

    protected int index;
    protected T object;

    public ModelRowHolder(final View itemView) {
        super(itemView);
    }


    /**
     * Override this method to setup when object binding
     *
     * @param position
     * @param object
     * @deprecated change method name to bind, so use bind(int position, T object) instead
     */
    @CallSuper
    @Deprecated
    protected void onBind(int position, T object) {
        bind(position, object);
    }


    @CallSuper
    protected void bind(int position, T object) {
        this.index = position;
        this.object = object;
    }

}
