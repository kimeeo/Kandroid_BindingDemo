package com.kimeeo.kandroidBindingDemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

import com.kimeeo.kandroidBindingDemo.BR;
/**
 * Created by bhavinpadhiyar on 3/9/16.
 */
public class User extends BaseObservable {
    public User(String name)
    {
        setName(name);
    }


    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    private String url="http://www.clker.com/cliparts/b/1/f/a/1195445301811339265dagobert83_female_user_icon.svg.med.png";


    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        notifyPropertyChanged(BR.name);
    }


    private String name;



    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        //notifyPropertyChanged(BR.lastName);
    }

    private String lastName =" Patel";
}
