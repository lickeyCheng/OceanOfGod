package com.lickey.asus.oceanofgod;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.lickey.asus.oceanofgod.utils.MyApplication;

import static com.lickey.asus.oceanofgod.R.id.wv_content;


/**
 * A simple {@link Fragment} subclass.
 */
public class Discount_Fragment extends Fragment {


    public Discount_Fragment() {
        // Required empty public constructor
    }

    private WebView discount_fg_wv;
    private View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_discount, container, false);
        discount_fg_wv= (WebView) view.findViewById(R.id.discount_fg_wv);
        discount_fg_wv.getSettings().setJavaScriptEnabled(true);
        discount_fg_wv.setWebViewClient(new WebViewClient());
        String url= MyApplication.appConfig.getDiscount();
        Log.d("url:",url);
        discount_fg_wv.loadUrl(url);
        return view;
    }

}
