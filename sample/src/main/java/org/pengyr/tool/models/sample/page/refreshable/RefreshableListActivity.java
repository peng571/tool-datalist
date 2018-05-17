package org.pengyr.tool.models.sample.page.refreshable;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.pengyr.tool.models.recyclerlist.ModelRowHolder;
import org.pengyr.tool.models.recyclerlist.event.OnItemClickListener;
import org.pengyr.tool.models.recyclerlist.provider.KeyModelProvider;
import org.pengyr.tool.models.sample.R;
import org.pengyr.tool.models.sample.databinding.RecyclerListActivityBinding;
import org.pengyr.tool.models.sample.model.pojo.SampleObject;
import org.pengyr.tool.models.sample.page.BaseActivity;
import org.pengyr.tool.models.sample.page.header.HeaderRecyclerHeaderHolder;
import org.pengyr.tool.models.sample.page.header.HeaderRecyclerRowHolder;

import java.util.Set;


/**
 * show favorite and own list to pickup and follow
 * <p>
 * Created by Peng on 2016/12/13.
 */

public class RefreshableListActivity extends BaseActivity implements
        OnItemClickListener<Integer> {

    private final static String TAG = RefreshableListActivity.class.getSimpleName();

    private SampleListAdapter adapter;
    private KeyModelProvider<SampleObject, Long> dataProvider;

    private RecyclerListActivityBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.recycler_list_activity);

        dataProvider = new KeyModelProvider<>();

        adapter = new SampleListAdapter();
        dataProvider.setPositionFixer(adapter.fixer);

        binding.listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listView.setHasFixedSize(true);
        binding.listView.setAdapter(adapter);
    }


    @Override
    public void onResume() {
        super.onResume();
        dataProvider.bind(adapter, onNotify);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dataProvider.unbind();
    }


    @Override
    protected void onDestroy() {
        adapter = null;
        binding.unbind();
        super.onDestroy();
    }

    /**
     * on row item click
     * <p>
     * override tabCollectionFragment click event
     */
    @Override
    public void onItemClick(ModelRowHolder<Integer> viewHolder) {
        if (viewHolder.getObject() == null) return;
        // TODO what you want
    }


    /**
     * OnNotifyListener
     */
    KeyModelProvider.OnNotifyListener<Long> onNotify = (Set<Long> notifyIDs) -> {
        for (Long id : notifyIDs) {
            // TODO what you want
        }
    };


    public class SampleListAdapter extends RecyclerView.Adapter<ModelRowHolder<Long>> {

        private final static int HEADER_TYPE = 1;
        private final static int ITEM_TYPE = 4;

        @Override
        public int getItemViewType(int position) {
            if (position < 3) {
                return HEADER_TYPE;
            }
            return ITEM_TYPE;
        }

        @Override public int getItemCount() {
            return dataProvider.count() + 3;
        }


        @Override
        public ModelRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            ViewDataBinding binding;
            switch (viewType) {
                case HEADER_TYPE:
                    binding = DataBindingUtil.inflate(layoutInflater, R.layout.header_row, parent, false);
                    return new HeaderRecyclerHeaderHolder(binding);
                default:
                    binding = DataBindingUtil.inflate(layoutInflater, R.layout.sample_row, parent, false);
                    return new HeaderRecyclerRowHolder(binding);
            }
        }

        @Override
        public void onBindViewHolder(ModelRowHolder holder, int position) {
            if (position < 3) return;
            if (!(holder instanceof HeaderRecyclerRowHolder)) return;
            HeaderRecyclerRowHolder rowHolder = (HeaderRecyclerRowHolder) holder;
            rowHolder.bind(position, dataProvider.get(position));
        }


        /**
         * fix position for header
         */
        KeyModelProvider.PositionFixer fixer = (int position) -> position + 3;

    }
}

