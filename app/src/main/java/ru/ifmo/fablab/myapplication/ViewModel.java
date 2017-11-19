package ru.ifmo.fablab.myapplication;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Observable;
import java.util.regex.Pattern;

/**
 * Created by mlebedev on 04/11/2017.
 */

public class ViewModel {
    private final static Pattern IMAGE_PATTERN = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
    public ObservableField<String> url;
    interface ErrorListener {
        void onError(String message);
    }

    private final ErrorListener errorListener;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;

//        if (input != null && !input.isEmpty() && IMAGE_PATTERN.matcher(input).find()){
//            url.set(input);
//        }
    }

    private String input;

    public ViewModel(String url, ErrorListener errorListener) {
        this.url = new ObservableField<>(url);
        this.input = url;
        this.errorListener = errorListener;
    }

    public void refreshClick(View view) {
        Log.i("TEST", "Refresh click");
        if (input != null && !input.isEmpty() && IMAGE_PATTERN.matcher(input).find()) {
            url.set(input);
        } else {
            errorListener.onError("Error");
        }
    }

//    public ObservableField<String> getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
}
