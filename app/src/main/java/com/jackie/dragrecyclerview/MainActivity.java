package com.jackie.dragrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rec0 = findViewById(R.id.rec);
        initRecyclerView(rec0);
    }

    private void initRecyclerView(RecyclerView rec) {
        List<Integer> data = new ArrayList<>(30);

        for (int i = 0; i < 100; i++) {
            data.add(new Random().nextInt(30));
        }
        Adapter adapter = new Adapter(data);
        ItemTouchHelper helper = new ItemTouchHelper(new CallBack(adapter));


        helper.attachToRecyclerView(rec);

        rec.setAdapter(adapter);
    }
}
