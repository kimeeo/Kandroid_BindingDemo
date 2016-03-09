package com.kimeeo.kandroidBindingDemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kimeeo.library.listDataView.recyclerView.BaseItemHolder;

/**
 * Created by bhavinpadhiyar on 3/9/16.
 */
public class BindingItemHolder extends BaseItemHolder {

    private final BindHelper bindHelper;

    public BindingItemHolder(View itemView,int variableID)
    {
        super(itemView);
        bindHelper = new BindHelper(itemView,variableID);
    }
    public BindHelper getBindHelper() {
        return bindHelper;
    }
    public void updateItemView(Object item, int position) {
        updateBindings(item);
        super.updateItemView(item, position);
    }
    public void updateBindings(Object data)
    {
        bindHelper.updateBindings(data);
    }
    public void updateItemView(Object data, View view, int position){}
}
