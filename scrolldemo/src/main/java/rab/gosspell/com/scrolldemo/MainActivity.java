package rab.gosspell.com.scrolldemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import rab.gosspell.com.scrolldemo.wheelview.WheelView;
import rab.gosspell.com.scrolldemo.wheelview.adapter.AbstractWheelTextAdapter1;

public class MainActivity extends AppCompatActivity {
    private WheelView mWheelview, mWheelview1, mWheelview2, mWheelview3;
    TextAdapter adapter;
    List<String> list;
    MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myView);
        mWheelview = findViewById(R.id.wheelView);
        mWheelview1 = findViewById(R.id.wheelView1);
        mWheelview2 = findViewById(R.id.wheelView2);
        mWheelview3 = findViewById(R.id.wheelView3);
        list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        adapter = new TextAdapter(this, list, 0, 14, 12);
        mWheelview.setVisibleItems(1);
        mWheelview.setViewAdapter(adapter);
        mWheelview.setCurrentItem(0);


        mWheelview1.setVisibleItems(1);
        mWheelview1.setViewAdapter(adapter);
        mWheelview1.setCurrentItem(0);


        mWheelview2.setVisibleItems(1);
        mWheelview2.setViewAdapter(adapter);
        mWheelview2.setCurrentItem(0);


        mWheelview3.setVisibleItems(1);
        mWheelview3.setViewAdapter(adapter);
        mWheelview3.setCurrentItem(0);

    }

    private class TextAdapter extends AbstractWheelTextAdapter1 {
        List<String> list;

        protected TextAdapter(Context context, List<String> list, int currentItem, int maxsize, int minsize) {
            super(context, R.layout.item_birth_year, NO_RESOURCE, currentItem, maxsize, minsize);
            this.list = list;
            setItemTextResource(R.id.tempValue);
        }

        @Override
        public View getItem(int index, View cachedView, ViewGroup parent) {
            View view = super.getItem(index, cachedView, parent);
            return view;
        }

        @Override
        public int getItemsCount() {
            return list.size();
        }

        @Override
        protected CharSequence getItemText(int index) {
            return list.size() == 0 ? "" : list.get(index) + "";
        }
    }

    public void onclick(View view) {
        mWheelview.scroll(5, 3000);
        mWheelview1.scroll(1, 3000);
        mWheelview2.scroll(3, 3000);
        mWheelview3.scroll(9, 3000);
        myView.start();
    }
}
