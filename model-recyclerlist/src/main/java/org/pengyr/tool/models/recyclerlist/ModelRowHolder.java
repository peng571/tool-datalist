package org.pengyr.tool.models.recyclerlist;


import android.support.annotation.CallSuper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import static org.pengyr.tool.models.recyclerlist.RecycleRowEventListener.CLICK_EVENT;
import static org.pengyr.tool.models.recyclerlist.RecycleRowEventListener.LONG_CLICK_EVENT;

/**
 * Recycler ViewHolder
 * that has item clickable action
 * <p>
 * Updated by Peng on 2017/10/26.
 */
public abstract class ModelRowHolder<T> extends RecyclerView.ViewHolder {

    private int index;
    private T object;

    private RecycleRowEventListener<T> eventListener;

    public ModelRowHolder(final View itemView) {
        super(itemView);
        itemView.setOnClickListener(onClickListener);
        itemView.setOnLongClickListener(onLongClickListener);
    }


    void setOnRowEventListener(RecycleRowEventListener<T> listener) {
        this.eventListener = listener;
    }

    private final View.OnClickListener onClickListener = (v) -> {
        if (eventListener == null) return;
        eventListener.onRowAction(CLICK_EVENT, this);
    };

    private final View.OnLongClickListener onLongClickListener = (v) -> {
        if (eventListener == null) return false;
        eventListener.onRowAction(LONG_CLICK_EVENT, this);
        return true;
    };

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

    public int getIndex() {
        return index;
    }

    public T getObject() {
        return object;
    }


}
