package org.pengyr.tool.datalist.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import org.pengyr.tool.datalist.sample.databinding.MainActivityBinding;
import org.pengyr.tool.datalist.sample.model.SampleContainer;
import org.pengyr.tool.datalist.sample.model.pojo.SampleObject;


/**
 * Created by Peng on 2018/3/25.
 */
public class MainActivity extends BaseActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private MainActivityBinding binding;

    private SampleContainer container;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);


        SampleObject sampleObject = new SampleObject(0, "Data not found, use default object");

        container = SampleContainer.get();
        binding.message1.setText(container.getObject(2l, sampleObject).getMessage());
        binding.message2.setText(container.getObject(3l, sampleObject).getMessage());


    }

}
