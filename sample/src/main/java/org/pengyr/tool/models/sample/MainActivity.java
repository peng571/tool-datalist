package org.pengyr.tool.models.sample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import org.pengyr.tool.models.sample.databinding.MainActivityBinding;
import org.pengyr.tool.models.sample.recycler.SampleRecyclerListActivity;


/**
 * 所有Activity的父類別
 * <p>
 * Created by Peng on 2017/10/29.
 */
public class MainActivity extends BaseActivity {

    private final static String TAG = MainActivity.class.getSimpleName();


    private MainActivityBinding binding;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        //        binding.buttonClickable.setOnClickListener((v) -> startActivity(new Intent(this, RecyclerClickableListActivity.class)));
        binding.buttonNormal.setOnClickListener((v) -> startActivity(new Intent(this, SampleRecyclerListActivity.class)));

    }

    @Override protected void onDestroy() {
        if (binding != null) binding.unbind();
        super.onDestroy();
    }
}
