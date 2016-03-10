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
        setTextWatcher(new ObservableField(tx));
    }

    TextWatcher tx= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!getName().equals(s.toString()))
                setName(s.toString());
        }
        @Override
        public void afterTextChanged(Editable s) {
        }
    };
    private String name;

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    private String url="http://www.clker.com/cliparts/b/1/f/a/1195445301811339265dagobert83_female_user_icon.svg.med.png";


    public ObservableField<TextWatcher> getTextWatcher() {
        return textWatcher;
    }

    public void setTextWatcher(ObservableField<TextWatcher> textWatcher) {
        this.textWatcher = textWatcher;
        //notifyPropertyChanged(BR.textWatcher);
    }

    public ObservableField<TextWatcher> textWatcher;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

        notifyPropertyChanged(BR.name);
    }
}
