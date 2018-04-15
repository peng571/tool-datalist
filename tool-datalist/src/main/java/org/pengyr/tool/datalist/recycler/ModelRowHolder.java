package org.pengyr.tool.datalist.recycler;

import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Recycler ViewHolder
 * that has item clickable action
 * <p>
 * Updated by Peng on 2017/10/26.
 */
public abstract class ModelRowHolder<T> extends RecyclerView.ViewHolder {

    private OnItemClickListener<T> clickListener;
    private OnItemLongClickListener<T> longClickListener;

    protected int index;
    protected T object;

    private View clickableItem;

    public ModelRowHolder(final View itemView) {
        super(itemView);
        setClickableItem(itemView);
        setLongClickableItem(itemView);
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


    final protected View.OnClickListener listener = (View v) -> {
        if (clickListener == null) return;
        clickListener.onItemClick(ModelRowHolder.this, index, object);
    };

    final protected View.OnLongClickListener longListener = (View view) -> {
        if (longClickListener == null) return true;
        longClickListener.onItemLongClick(ModelRowHolder.this, index, object);
        return false;
    };


    /**
     * Use whole item view as default clickable range,
     * Override this to change clickable item view like this,
     * - customView.setOnClickListener(listener);
     * or set at viewHolder adapter
     * - viewHolder.setClickableItem(viewHolder.getView());
     * <p>
     *
     * @param view clickable item view
     */
    public void setClickableItem(View view) {
        // remove old clickable item listener
        if (clickableItem != null) {
            clickableItem.setOnClickListener(null);
        }

        // add click listener to clickable view
        if (view != null) {
            view.setOnClickListener(listener);
            clickableItem = view;
        }
    }


    public void setLongClickableItem(View view) {
        // remove old clickable item listener
        if (clickableItem != null) {
            clickableItem.setOnLongClickListener(null);
        }

        // add click listener to clickable view
        if (view != null) {
            view.setOnLongClickListener(longListener);
            clickableItem = view;
        }
    }

    /**
     * Do the same thing as above.
     * <p>
     * But it's strange to set ViewHolder.itemView to setOnClickListener will cause NPE,
     * so parse view inside method instead. Try to FIXME
     *
     * @return clickable view
     */
    @Deprecated
    protected View getClickableItemView() {
        return itemView;
    }

    @Deprecated
    public void setClickableItem() {
        getClickableItemView().setOnClickListener(listener);
    }

    @Deprecated
    public void setLongClickableItem() {
        getClickableItemView().setOnLongClickListener(longListener);
    }


    /**
     * Use this method to set ViewHolder to listen on item click or long click listener
     *
     * @param listener OnItemClickListener or OnItemLongClickListener
     * @return this
     */
    public ModelRowHolder<T> listen(OnItemClickListener<T> listener) {
        this.clickListener = listener;
        return this;
    }

    public ModelRowHolder<T> listen(OnItemLongClickListener<T> listener) {
        this.longClickListener = listener;
        return this;
    }


    /**
     * transition
     *
     * @return transaction target (null as default)
     */
    @Nullable public View getTransactionTarget() {
        return null;
    }

}
