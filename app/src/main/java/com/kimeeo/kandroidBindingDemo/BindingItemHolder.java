package com.kimeeo.kandroidBindingDemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kandroidBindingDemo.databinding.CellBinding;
import com.kimeeo.library.listDataView.recyclerView.BaseItemHolder;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by bhavinpadhiyar on 3/9/16.
 */
public class BindingItemHolder<T extends ViewDataBinding> extends BaseItemHolder {

    private final BindHelper<T> bindHelper;
    public BindingItemHolder(View itemView,int variableID) {
        super(itemView);
        bindHelper = new BindHelper<T>(itemView,variableID);
    }
    public BindingItemHolder(View itemView)
    {
        this(itemView, -1);
    }
    public BindHelper getBindHelper() {
        return bindHelper;
    }
    public T getBinding()
    {
        return bindHelper.getBinding();
    }
    public void updateItemView(Object item, int position){
        setVariable(item);
        super.updateItemView(item, position);
    }
    public void updateItemView(Object data, View view, int position){

    }
    public void setVariables(Map<Integer,Object> data)
    {
        bindHelper.setVariables(data);
    };
    public void setVariable(Object data)
    {
        bindHelper.setVariable(data);
    }
    public void setVariable(int variableID,Object data) {
        bindHelper.setVariable(variableID, data);
    }
    public View getView(int resID)
    {
        return bindHelper.getView(resID);
    }
}
