package org.pengyr.tool.datalist.sample.clickablerecycler;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import org.pengyr.tool.datalist.sample.BaseActivity;
import org.pengyr.tool.datalist.sample.R;
import org.pengyr.tool.datalist.sample.databinding.MainActivityBinding;


/**
 * use
 *
 * Created by Peng on 2018/3/25.
 */
public class RecyclerClickableListActivity extends BaseActivity {

    private MainActivityBinding binding;
    private RecyclerClickableListAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        adapter = new RecyclerClickableListAdapter();
        binding.listView.setLayoutManager(new LinearLayoutManager(this));
        binding.listView.setAdapter(adapter);
    }

    @Override protected void onResume() {
        super.onResume();
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
