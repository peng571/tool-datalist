package org.pengyr.tool.models.recyclerlist;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.pengyr.tool.datalist.R;

import static org.junit.Assert.assertEquals;

/**
* Instrumentation test, which will execute on an Android device.
*
* @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
*/
@RunWith(AndroidJUnit4.class)
public class ExampleRecyclerAdapterWithClickTest {
   @Test
   public void useAppContext() throws Exception {
       // Context of the app under test.
       Context appContext = InstrumentationRegistry.getTargetContext();

       assertEquals( "", appContext.getPackageName());
   }

   class ExampleViewHolder extends ModelRowHolder<String>{

       public ExampleViewHolder(View itemView) {
           super(itemView);
       }
   }

//   ListRecyclerAdapter<String, ExampleViewHolder> adapter = new ListRecyclerAdapter<String, ExampleViewHolder>() {
//
//       @Override
//       public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//           LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//           View v = inflater.inflate(/* test layout */ R.layout.sample_row, parent, false);
//           ExampleViewHolder viewHolder = new ExampleViewHolder(v);
//           viewHolder.listen(itemClickListener);
//           return viewHolder;
//       }
//
//   };

}
