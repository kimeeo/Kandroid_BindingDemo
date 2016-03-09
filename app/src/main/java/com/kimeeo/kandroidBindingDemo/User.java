package com.kimeeo.kandroidBindingDemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import com.kimeeo.kandroidBindingDemo.BR;
/**
 * Created by bhavinpadhiyar on 3/9/16.
 */
public class User extends BaseObservable {
    public User(String name)
    {
        setName(name);
        setUrl("http://www.clker.com/cliparts/b/1/f/a/1195445301811339265dagobert83_female_user_icon.svg.med.png");
        final Handler handler = new Handler();
        final Runnable runnablelocal = new Runnable() {
            @Override
            public void run() {
                setName(getName()+1);

            }
        };
        handler.postDelayed(runnablelocal, 4000);
    }
    private String name;

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    private String url;



    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        notifyPropertyChanged(BR.name);
    }
}
