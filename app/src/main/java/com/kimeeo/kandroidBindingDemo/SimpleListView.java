package com.kimeeo.kandroidBindingDemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.library.listDataView.dataManagers.DataManager;
import com.kimeeo.library.listDataView.dataManagers.IListProvider;
import com.kimeeo.library.listDataView.dataManagers.PageData;
import com.kimeeo.library.listDataView.dataManagers.StaticDataManger;
import com.kimeeo.library.listDataView.dataManagers.simpleList.ListDataManager;
import com.kimeeo.library.listDataView.recyclerView.BaseItemHolder;
import com.kimeeo.library.listDataView.recyclerView.verticalViews.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.kimeeo.kandroidBindingDemo.BR;
/**
 * Created by bhavinpadhiyar on 1/27/16.
 */
public class SimpleListView extends ListView
{
    // Data Manager
    protected DataManager createDataManager()
    {

        StaticDataManger listData1= new StaticDataManger(getActivity());
        listData1.setRefreshEnabled(false);
        listData1.add(new User("B1"));
        listData1.add(new User("B2"));
        listData1.add(new User("B3"));
        listData1.add(new User("B4"));
        listData1.add(new User("B5"));
        listData1.add(new User("B6"));
        listData1.add(new User("B7"));
        listData1.add(new User("B8"));
        listData1.add(new User("B9"));
        listData1.add(new User("B10"));
        return listData1;
    }
    @Override
    public View getItemView(int viewType,LayoutInflater inflater,ViewGroup viewGroup)
    {
        View view =inflater.inflate(R.layout.cell, viewGroup, false);
        ViewDataBinding binding = DataBindingUtil.bind(view);
        return binding.getRoot();
        //return view;
    }
    public BaseItemHolder getItemHolder(int viewType,View view)
    {
        return new BindingItemHolder(view,BR.user);
    }
}
