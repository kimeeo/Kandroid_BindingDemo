package com.kimeeo.kandroidBindingDemo;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.kimeeo.kandroidBindingDemo.databinding.CellBinding;
import com.kimeeo.library.listDataView.dataManagers.DataManager;
import com.kimeeo.library.listDataView.dataManagers.StaticDataManger;
import com.kimeeo.library.listDataView.recyclerView.BaseItemHolder;
import com.kimeeo.library.listDataView.recyclerView.verticalViews.ListView;

import java.util.HashMap;
import java.util.Map;

import com.squareup.picasso.Picasso;

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
        return new BindingItemHolder1(view,BR.user);

        //return new BindingItemHolder1<CellBinding>(view);
    }

    public static class BindingItemHolder1<T extends CellBinding> extends BindingItemHolder<T>
    {
        public BindingItemHolder1(View itemView,int variableID)
        {
            super(itemView, variableID);
            CellBinding cellBinding=getBinding();

            Map<Integer,Object> map = new HashMap<>();
            map.put(BR.handlers, this);
            //map.put(BR.inLineTextWatcher, textWatcher);
            setVariables(map);
        }

        /*
        protected Map<Integer, Object> getDefaultMap() {
            Map<Integer,Object> map = new HashMap<>();
            map.put(BR.handlers, this);
            map.put(BR.inLineTextWatcher, textWatcher);
            return map;
        }*/

        public BindingItemHolder1(View itemView) {
            super(itemView);
        }
        public void updateItemView(Object data, View view, int position){
            //updateBindings(BR.user,data);
        }

        public void onClickFriend(View view) {
            Toast.makeText(view.getContext(), "onClickFriend "+position, Toast.LENGTH_SHORT).show();
        }
        public void onClickEnemy(View view) {
            Toast.makeText(view.getContext(), "onClickEnemy "+position, Toast.LENGTH_SHORT).show();
        }


        public TextWatcher onTextChange=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!getBinding().getUser().getName().equals(s.toString())) {
                    getBinding().getUser().setName(s.toString());
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        };
    }
}
