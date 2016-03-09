package com.kimeeo.kandroidBindingDemo;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;

/**
 * Created by bhavinpadhiyar on 3/9/16.
 */
public class BindHelper {
    private final int variableID;
    private final ViewDataBinding binding;
    public BindHelper(View itemView,int variableID)
    {
        this.variableID=variableID;
        ViewDataBinding bindingTemp = DataBindingUtil.getBinding(itemView);
        if(bindingTemp==null)
            bindingTemp = DataBindingUtil.bind(itemView);
        binding =bindingTemp;
    }
    public ViewDataBinding getBinding()
    {
        return binding;
    }

    public void updateBindings(Object data) {
        binding.setVariable(variableID, data);
        binding.executePendingBindings();
    }
}
