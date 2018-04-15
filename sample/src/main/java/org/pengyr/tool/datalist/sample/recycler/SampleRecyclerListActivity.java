package org.pengyr.tool.datalist.sample.recycler;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import org.pengyr.tool.datalist.sample.BaseActivity;
import org.pengyr.tool.datalist.sample.R;
import org.pengyr.tool.datalist.sample.databinding.MainActivityBinding;


/**
 * If you just want to show a list of data, see this sample
 *
 * Created by Peng on 2018/3/25.
 */
public class SampleRecyclerListActivity extends BaseActivity {

    private MainActivityBinding binding;
    private SampleRecyclerListAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        // create adapter and setup RecyclerView with layoutManager and adapter.
        adapter = new SampleRecyclerListAdapter();
        binding.listView.setLayoutManager(new LinearLayoutManager(this));
        binding.listView.setAdapter(adapter);
    }

    @Override protected void onResume() {
        super.onResume();

        // add data into adapter, you can add when use edit, or add whole list view into, or anyway.
        if (adapter.isEmpty()) {
            adapter.add(1l);
            adapter.add(2l);
            adapter.add(3l);
        }
    }

    @Override protected void onDestroy() {
        adapter.clear();
        super.onDestroy();
    }
}
