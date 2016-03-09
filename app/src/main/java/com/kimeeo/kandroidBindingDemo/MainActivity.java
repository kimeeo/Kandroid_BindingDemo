package com.kimeeo.kandroidBindingDemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kimeeo.library.fragments.BaseFragment;
import com.kimeeo.library.model.IFragmentData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IFragmentData data= new IFragmentData()
        {

            @Override
            public Class getView() {
                return SimpleListView.class;
            }
            @Override
            public String getID() {
                return "1";
            }
            private Object param;
            @Override
            public String getName() {
                return "My View";
            }

            @Override
            public Object getParam() {
                return param;
            }

            @Override
            public void setParam(Object o) {
                param=o;
            }

            @Override
            public Object getActionValue() {
                return null;
            }

            @Override
            public String getActionType() {
                return null;
            }
        };
        FragmentManager fragmentManager = getSupportFragmentManager();
        BaseFragment mActivePage = BaseFragment.newInstance(data);
        fragmentManager.beginTransaction().replace(R.id.mainView, mActivePage).commit();
    }
}
