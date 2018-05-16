package org.pengyr.tool.models.sample.page.normal;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.widget.Toast;

import org.pengyr.tool.models.recyclerlist.ModelRowHolder;
import org.pengyr.tool.models.sample.page.BaseActivity;
import org.pengyr.tool.models.sample.R;
import org.pengyr.tool.models.sample.databinding.RecyclerListActivityBinding;
import org.pengyr.tool.models.sample.model.SampleContainer;
import org.pengyr.tool.models.sample.model.pojo.SampleObject;

import java.util.Locale;


/**
 * If you just want to show a list of data, see this sample
 * <p>
 * Created by Peng on 2018/3/25.
 */
public class NormalRecyclerListActivity extends BaseActivity {

    private final static String TAG = NormalRecyclerListActivity.class.getSimpleName();

    private RecyclerListActivityBinding binding;
    private NormalRecyclerListAdapter adapter;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.recycler_list_activity);

        // create adapter and setup RecyclerView with layoutManager and adapter.
        adapter = new NormalRecyclerListAdapter();
        adapter.setOnItemClickListener(this::onItemClick);
        adapter.setOnItemLongClickListener(this::onItemLongClick);

        binding.listView.setLayoutManager(new LinearLayoutManager(this));
        binding.listView.setAdapter(adapter);
    }

    void onItemClick(ModelRowHolder<Long> holder){
        Toast.makeText(this, String.format(Locale.getDefault(), "Click item %d", holder.getIndex()), Toast.LENGTH_SHORT).show();
    }


    void onItemLongClick(ModelRowHolder<Long> holder){
        SampleObject obj = SampleContainer.getInstance().get(holder.getObject(), new SampleObject(0, "EMPTY"));
        Toast.makeText(this, String.format(Locale.getDefault(), "long click item [%s]", obj.getMessage()), Toast.LENGTH_SHORT).show();
    }


    @Override protected void onResume() {
        super.onResume();

        // add data into adapter, you can add when use edit, or add whole list view into, or anyway.
        if (adapter.isEmpty()) {
            adapter.add(1L);
            adapter.add(2L);
            adapter.add(3L);
        }
    }

    @Override protected void onDestroy() {
        adapter.clear();
        super.onDestroy();
    }
}
