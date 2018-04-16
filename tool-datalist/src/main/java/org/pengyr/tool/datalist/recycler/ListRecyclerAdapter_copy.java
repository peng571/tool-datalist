//package org.pengyr.tool.datalist.recycler;
//
//import android.support.v7.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//
///**
// * Recycler Adapter with a list inside,
// * can be use like list, and will auto update recycler view when list data edit.
// * <p>
// * Created by momopeng on 3/17/16.
// */
//public abstract class ListRecyclerAdapter_copy<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
//
//    protected List<T> data;
//
//    public ListRecyclerAdapter_copy() {
//        this(new ArrayList<T>());
//    }
//
//    public ListRecyclerAdapter_copy(List<T> list) {
//        setData(list);
//    }
//
//    public void setData(List<T> data) {
//        this.data = data;
//        notifyItemRangeChanged(0, data.size());
//    }
//
//    @Override public int getItemCount() {
//        if (data == null) return 0;
//        return data.size();
//    }
//
//    public List<T> getData() {
//        return data;
//    }
//
//
//    /**
//     *
//     * @param position
//     * @return
//     */
//    public T getItem(int position) {
//        if (data == null) return null;
//        int index = fixSafeIndex(position);
//        return data.get(index);
//    }
//
//    /**
//     * Get index of item in data
//     *
//     * @param item item
//     * @return index of item, -1 if not found
//     */
//    public int indexOf(T item) {
//        return data.indexOf(item);
//    }
//
//
//    /**
//     * Add item into target index
//     * Fix method name to 'addWithIndex' to avoid confused when add an Integer Object into array
//     *
//     * @param t     type
//     * @param index target index in array
//     */
//    public void addWithIndex(T t, int index) {
//        if (t == null) return;
//        if (data.contains(t)) {
//            remove(t);
//        }
//        index = fixSafeIndex(index);
//        data.add(index, t);
//        notifyItemInserted(index);
//    }
//
//    public void add(T t) {
//        if (t == null) return;
//        if (data.contains(t)) return;
//        data.add(t);
//        notifyItemInserted(getItemCount() - 1);
//    }
//
//
//    public void addAll(Collection<T> collection) {
//        if (collection == null) return;
//        for (T t : collection) {
//            add(t);
//        }
//    }
//
//
//    public void addAll(T[] collection) {
//        if (collection == null) return;
//        for (T t : collection) {
//            add(t);
//        }
//    }
//
//    public void remove(T t) {
//        int position = data.indexOf(t);
//        if (position < 0) return;
//        data.remove(t);
//        notifyItemRemoved(position);
//    }
//
//    public void removeIndex(int position) {
//        int p = fixSafeIndex(position);
//        data.remove(p);
//        notifyItemRemoved(p);
//    }
//
//    public void editIndex(T t, int postition) {
//        int p = fixSafeIndex(postition);
//        data.set(p, t);
//        notifyItemChanged(p);
//    }
//
//
//    public void clear() {
//        int range = getItemCount();
//        if (data != null) {
//            data.clear();
//        }
//        notifyItemRangeRemoved(0, range);
//    }
//
//    public boolean isEmpty() {
//        if (data == null) return true;
//        return data.isEmpty();
//    }
//
//    private int fixSafeIndex(int index) {
//        if (data.isEmpty()) return 0;
//        if (index < 0) {
//            return 0;
//        } else if (index >= data.size()) {
//            return data.size() - 1;
//        }
//        return index;
//    }
//
//
//    //    @Deprecated
//    //    public void setItemClickListener(OnItemClickListener<T> listener) {
//    //        if (clickListener == null) {
//    //            clickListener = new ArrayMap<>();
//    //        }
//    //        clickListener.put(0, listener);
//    //    }
//    //
//    //
//    //    @Deprecated
//    //    public void addItemClickListener(int viewType, OnItemClickListener<T> listener) {
//    //        if (clickListener == null) {
//    //            clickListener = new ArrayMap<>();
//    //        }
//    //        clickListener.put(viewType, listener);
//    //    }
//    //
//    //    @Deprecated
//    //    public void setItemLongClickListener(OnItemLongClickListener<T> listener) {
//    //        if (longClickListener == null) {
//    //            longClickListener = new ArrayMap<>();
//    //        }
//    //        longClickListener.put(0, listener);
//    //    }
//    //
//    //    @Deprecated
//    //    public void addItemLongClickListener(int viewType, OnItemLongClickListener<T> listener) {
//    //        if (longClickListener == null) {
//    //            longClickListener = new ArrayMap<>();
//    //        }
//    //        longClickListener.put(viewType, listener);
//    //    }
//
//
//}