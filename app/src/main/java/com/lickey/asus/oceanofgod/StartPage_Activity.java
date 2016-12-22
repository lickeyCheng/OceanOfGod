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
import com.lickey.asus.oceanofgod.domain.Welcome;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


public class StartPage_Activity extends Activity {

    private Welcome welcome;
    private ImageView imageView;
    private String url="http://120.77.171.122:8080/ao-web/home/getWelcome";

    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                ImageLoader.getInstance().displayImage(welcome.getData().getWelcome().get(0).getImg(), imageView);
//            startActivity(new Intent(StartPage_Activity.this,MainTab_Activity.class));
//            finish();
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        String skip = welcome.getData().getWelcome().get(0).getUrl();
                        intent.setAction("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(skip.contains("http://") ? skip : "http://" + skip);
                        intent.setData(content_url);
                        startActivity(intent);
                    }
                });
                    break;
                case 2:
                    Toast.makeText(getApplication(),"网络连接出错，请检查网络",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        imageView= (ImageView) findViewById(R.id.imageView);

        startPage();

    }

    private void startPage(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    welcome=new Welcome();
                    OkHttpClient okHttpClient=new OkHttpClient();
                    Request request=new Request.Builder().url(url).build();
                    Response response=okHttpClient.newCall(request).execute();
                    String responseData=response.body().string();
                    Gson gson=new Gson();
                    welcome= gson.fromJson(responseData,Welcome.class);
                    Message msg=handler.obtainMessage();
                    msg.what=1;
                    handler.sendMessage(msg);
                  sleep(2000);
                  startActivity(new Intent(StartPage_Activity.this,MainTab_Activity.class));
                  finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    Message msg=handler.obtainMessage();
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }

}
