package com.koombea.material_design;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CoordinatorLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<MockObject> myDataset = new ArrayList();

        for(int i = 0;i < 100; i++){
            MockObject mockObject = new MockObject();
            mockObject.name = "Name "+i;
            mockObject.text = "Text "+i;
            myDataset.add(mockObject);
        }

        MyAdapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_coordinator_layout, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        ArrayList<MockObject>  myDataset;

        public MyAdapter(ArrayList myDataset){
            this.myDataset = myDataset;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.holder, viewGroup, false);
            Holder holder = new Holder(v);
            return holder;
        }

        @Override
        public int getItemCount() {
            return myDataset.size();
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            ((Holder) viewHolder).textView.setText(myDataset.get(i).name);
        }
    }

    public class Holder extends RecyclerView.ViewHolder{

        TextView textView;

        public Holder(View view){
            super(view);

            textView = (TextView) view.findViewById(R.id.textView);

        }

    }
}
