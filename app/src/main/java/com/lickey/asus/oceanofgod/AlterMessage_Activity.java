package com.lickey.asus.oceanofgod;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lickey.asus.oceanofgod.domain.AlertBanner;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class AlterMessage_Activity extends Activity implements View.OnClickListener{

    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                ImageLoader.getInstance().displayImage(ab.getData().getBanner().get(0).getImg(), iv);
                    break;

                case 2:
                    Toast.makeText(getApplication(),"网络连接出错，请检查网络",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private AlertBanner ab;
    private ImageView close;
    private ImageView iv;
    private String url="http://120.77.171.122:8080/ao-web/home/getAlertBanner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alter_message);

        close= (ImageView) findViewById(R.id.am_colse);
        iv= (ImageView) findViewById(R.id.am_iv);
        close.setOnClickListener(this);
        iv.setOnClickListener(this);

        getAlter();
    }

    private void getAlter(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    ab=new AlertBanner();
                    OkHttpClient okHttpClient=new OkHttpClient();
                    Request request=new Request.Builder().url(url).build();
                    Response response=okHttpClient.newCall(request).execute();
                    String responseData=response.body().string();
                    Gson gson=new Gson();
                    ab= gson.fromJson(responseData,AlertBanner.class);
                    Message msg=handler.obtainMessage();
                    msg.what=1;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    Message msg=handler.obtainMessage();
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.am_colse:
                finish();
                break;

            case R.id.am_iv:
                Intent intent = new Intent();
                String skip = ab.getData().getBanner().get(0).getUrl();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(skip.contains("http://") ? skip : "http://"+skip);
                intent.setData(content_url);
                startActivity(intent);
                break;
        }
    }
}
