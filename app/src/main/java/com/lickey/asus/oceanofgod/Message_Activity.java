package com.lickey.asus.oceanofgod;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lickey.asus.oceanofgod.domain.Message;
import com.lickey.asus.oceanofgod.domain.Notice;
import com.lickey.asus.oceanofgod.domain.Welcome;
import com.lickey.asus.oceanofgod.utils.MyApplication;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.lickey.asus.oceanofgod.R.id.imageView;

public class Message_Activity extends Activity {

    Handler handler =new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                dataBean = new ArrayList<Notice.DataBean>();
                dataBean = notice.getData();
                users = new Message[dataBean.size()];//数据源
                for (int i = 0; i < dataBean.size(); i++) {
                    Message message = new Message(dataBean.get(i).getContent(), dataBean.get(i).getTime().getTime());
                    users[i] = message;
                }
                //1.新建数据适配器  // 2.添加数据源到适配器
                MyArrayAdapter arrayAdapter = new MyArrayAdapter(Message_Activity.this, R.layout.items_message_layout, users);
                //3.视图加载适配器
                listView.setAdapter(arrayAdapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(new Intent(Message_Activity.this, WebViewPage_Activity.class).putExtra("url", notice.getData().get(position).getUrl()));
                    }
                });
                    break;

                case 2:
                    Toast.makeText(getApplication(),"网络连接出错，请检查网络",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private ListView listView;
    private Notice notice;
    private List<Notice.DataBean> dataBean;
    private Message[] users;
    private String url="http://120.77.171.122:8080/ao-web/home/getNoticeList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);


        listView= (ListView) findViewById(R.id.activity_message_lv);

        loadMessage();

    }

    public void finish(View v){
        finish();
    }



    private void loadMessage(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    notice=new Notice();
                    OkHttpClient okHttpClient=new OkHttpClient();
                    Request request=new Request.Builder().url(url).build();
                    Response response=okHttpClient.newCall(request).execute();
                    String responseData=response.body().string();
                    Gson gson=new Gson();
                    notice= gson.fromJson(responseData,Notice.class);
                    android.os.Message msg=handler.obtainMessage();
                    msg.what=1;
                    handler.sendMessage(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                    android.os.Message msg=handler.obtainMessage();
                    msg.what=2;
                    handler.sendMessage(msg);
                }
            }
        }.start();
    }
}
