package com.kimeeo.kandroidBindingDemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.kandroidBindingDemo.databinding.CellBinding;
import com.kimeeo.library.listDataView.recyclerView.BaseItemHolder;

/**
 * Created by bhavinpadhiyar on 3/9/16.
 */
public class BindingItemHolder<T extends ViewDataBinding> extends BaseItemHolder {

    private final BindHelper<T> bindHelper;
    public BindingItemHolder(View itemView,int variableID)
    {
        super(itemView);
        bindHelper = new BindHelper<T>(itemView,variableID);
    }
    public BindingItemHolder(View itemView)
    {
        super(itemView);
        bindHelper = new BindHelper<T>(itemView,-1);
    }
    public BindHelper getBindHelper() {
        return bindHelper;
    }
    public void updateItemView(Object item, int position) {
        updateBindings(item);
        super.updateItemView(item, position);
    }
    public T getBinding()
    {
        return bindHelper.getBinding();
    }
    public void updateBindings(Object data)
    {
        bindHelper.updateBindings(data);
    }
    public void updateBindings(int variableID,Object data) {
        bindHelper.updateBindings(variableID,data);
    }
    public void updateItemView(Object data, View view, int position){

    }
    public View getView(int resID)
    {
        return bindHelper.getView(resID);
    }
}
