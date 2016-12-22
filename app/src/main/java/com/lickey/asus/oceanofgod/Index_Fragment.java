package com.lickey.asus.oceanofgod;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lickey.asus.oceanofgod.domain.AppConfig;
import com.lickey.asus.oceanofgod.domain.HomeInfo;
import com.lickey.asus.oceanofgod.utils.GlideImageLoader;
import com.lickey.asus.oceanofgod.utils.MarqueeTextView;
import com.lickey.asus.oceanofgod.utils.MyApplication;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.spdy.Ping;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerClickListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static u.aly.av.S;

public class Index_Fragment extends Fragment implements View.OnClickListener{

    View rootView;
    HomeInfo homeInfo;
    AppConfig appConfig;
    private ImageView index_fg_pay;
    private LinearLayout index_ll_iphone;
    private LinearLayout index_ll_android;
    private LinearLayout index_ll_newplayer;
    private LinearLayout index_ll_register;
    private LinearLayout index_ll_onlineserver;
    private LinearLayout index_ll_discountapply;
    private MarqueeTextView tv_message;
    private TextView index_tv_time1;
    private TextView index_tv_url1;
    private TextView index_tv_time2;
    private TextView index_tv_url2;
    private TextView index_tv_time3;
    private TextView index_tv_url3;
    private Button index_bt_skip1;
    private Button index_bt_skip2;
    private Button index_bt_skip3;
    String realurl1;
    String realurl2;
    String realurl3;
    private String url="http://120.77.171.122:8080/ao-web/home/getHomeList";
    private String urlAppConfig="http://120.77.171.122:8080/ao-web/home/getAppConfig";

    Handler handler =new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                List<HomeInfo.BannerBean> bannerBean = new ArrayList<HomeInfo.BannerBean>();
                bannerBean = homeInfo.getBanner();
                List<String> texturl = new ArrayList<String>();
                for (int i = 0; i < bannerBean.size(); i++) {
                    texturl.add(bannerBean.get(i).getImg());
                }

                Banner banner = (Banner) rootView.findViewById(R.id.banner);
                //设置banner样式
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                //设置图片加载器
                banner.setImageLoader(new GlideImageLoader());
                //设置图片集合
                banner.setImages(texturl);
                //设置轮播时间
                banner.setDelayTime(3000);
                final List<HomeInfo.BannerBean> finalBannerBean = bannerBean;
                banner.setOnBannerClickListener(new OnBannerClickListener() {
                    @Override
                    public void OnBannerClick(int i) {
                        startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", finalBannerBean.get(i).getUrl()));
                    }
                });
                //设置指示器位置（当banner模式中有指示器时）
                banner.setIndicatorGravity(BannerConfig.CENTER);
                //banner设置方法全部调用完毕时最后调用
                banner.start();
                tv_message = (MarqueeTextView) rootView.findViewById(R.id.message);
                tv_message.setText(homeInfo.getNotice().get(0));
                tv_message.startScroll();
                    String geturl1=homeInfo.getList().get(0).get(0).getUrl();
                    String geturl2=homeInfo.getList().get(0).get(1).getUrl();
                    String geturl3=homeInfo.getList().get(0).get(2).getUrl();
                    realurl1=geturl1.contains("http://") ? geturl1.substring(7) : geturl1;
                    realurl2=geturl2.contains("http://") ? geturl2.substring(7) : geturl2;
                    realurl3=geturl3.contains("http://") ? geturl3.substring(7) : geturl3;
                index_tv_url1.setText(realurl1);
                    index_tv_url2.setText(realurl2);
                    index_tv_url3.setText(realurl3);
                    new NetPing1().execute();
                    new NetPing2().execute();
                    new NetPing3().execute();
                    break;

                case 2:
                    index_tv_time1.setText(msg.obj.toString());
                    break;

                case 3:
                    index_tv_time2.setText(msg.obj.toString());
                    break;

                case 4:
                    index_tv_time3.setText(msg.obj.toString());
                    break;

                case 5:
                    Toast.makeText(getActivity(),"网络连接出错，请检查网络",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public Index_Fragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_index, container, false);
        }
        // 缓存的rootView需要判断是否已经被加过parent，
        // 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();

        if (parent != null) {
            parent.removeView(rootView);
        }

        index_tv_time1= (TextView) rootView.findViewById(R.id.index_tv_time1);
        index_tv_url1= (TextView) rootView.findViewById(R.id.index_tv_url1);
        index_tv_time2= (TextView) rootView.findViewById(R.id.index_tv_time2);
        index_tv_url2= (TextView) rootView.findViewById(R.id.index_tv_url2);
        index_tv_time3= (TextView) rootView.findViewById(R.id.index_tv_time3);
        index_tv_url3= (TextView) rootView.findViewById(R.id.index_tv_url3);
        index_bt_skip1= (Button) rootView.findViewById(R.id.index_bt_skip1);
        index_bt_skip2= (Button) rootView.findViewById(R.id.index_bt_skip2);
        index_bt_skip3 = (Button) rootView.findViewById(R.id.index_bt_skip3);

        index_fg_pay= (ImageView) rootView.findViewById(R.id.index_fg_pay);
        index_ll_iphone= (LinearLayout) rootView.findViewById(R.id.index_ll_iphone);
        index_ll_android= (LinearLayout) rootView.findViewById(R.id.index_ll_android);
        index_ll_newplayer= (LinearLayout) rootView.findViewById(R.id.index_ll_newplayer);
        index_ll_register= (LinearLayout) rootView.findViewById(R.id.index_ll_register);
        index_ll_onlineserver= (LinearLayout) rootView.findViewById(R.id.index_ll_onlineserver);
        index_ll_discountapply= (LinearLayout) rootView.findViewById(R.id.index_ll_discountapply);

        index_bt_skip1.setOnClickListener(this);
        index_bt_skip2.setOnClickListener(this);
        index_bt_skip3.setOnClickListener(this);


        index_fg_pay.setOnClickListener(this);
        index_ll_iphone.setOnClickListener(this);
        index_ll_android.setOnClickListener(this);
        index_ll_newplayer.setOnClickListener(this);
        index_ll_register.setOnClickListener(this);
        index_ll_onlineserver.setOnClickListener(this);
        index_ll_discountapply.setOnClickListener(this);
        loadData();



        return rootView;
    }

    public String Ping(String str) {
        String resault = "";
        Process p;
        try {
//ping -c 3 -w 100  中  ，-c 是指ping的次数 3是指ping 3次 ，-w 100  以秒为单位指定超时间隔，是指超时时间为100秒
            p = Runtime.getRuntime().exec("ping -c 3 -w 100 " + str);
            int status = p.waitFor();
            InputStream input = p.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null){
                buffer.append(line);
            }
            String bffstr=buffer.toString();
            System.out.println("Return ============" + buffer.toString());
            if (status == 0) {
                resault = "success";
            } else {
                resault = "faild";
            }
            Message msg=handler.obtainMessage();
            if(str.equals(realurl1)){
                int a =bffstr.indexOf("mdev");
                int b=bffstr.lastIndexOf("/");
                String[]  s=bffstr.substring(a+7,b+1).split("/");
                int c=s[1].indexOf(".");
                String fstr=s[1].substring(0,c);
                msg.what=2;
                msg.obj=fstr+"ms";
                handler.sendMessage(msg);
            }else if(str.equals(realurl2)){
                int a =bffstr.indexOf("mdev");
                int b=bffstr.lastIndexOf("/");
                String[]  s=bffstr.substring(a+7,b+1).split("/");
                int c=s[1].indexOf(".");
                String fstr=s[1].substring(0,c);
                msg.what=3;
                msg.obj=fstr+"ms";
                handler.sendMessage(msg);
            }else if(str.equals(realurl3)){
                int a =bffstr.indexOf("mdev");
                int b=bffstr.lastIndexOf("/");
                String[]  s=bffstr.substring(a+7,b+1).split("/");
                int c=s[1].indexOf(".");
                String fstr=s[1].substring(0,c);
                msg.what=4;
                msg.obj=fstr+"ms";
                handler.sendMessage(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return resault;
    }
    private class NetPing1  extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            String s = "";
            s = Ping(realurl1);
//            Log.i("ping", s);
            return s;
        }
    }


    private class NetPing2  extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            String s = "";
            s = Ping(realurl2);
            Log.i("ping", s);
            return s;
        }
    }

    private class NetPing3  extends AsyncTask<String, String, String>{
        @Override
        protected String doInBackground(String... params) {
            String s = "";
            s = Ping(realurl3);
            Log.i("ping", s);
            return s;
        }
    }




    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.index_fg_pay:
                startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", MyApplication.appConfig.getPayaddress()));
                break;

            case R.id.index_ll_iphone:
//                startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", MyApplication.appConfig.getIos_game_download()));
                String skip = MyApplication.appConfig.getIos_game_download();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(skip.contains("http://") ? skip : "http://"+skip);
                intent.setData(content_url);
                startActivity(intent);
                break;

            case R.id.index_ll_android:
                startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", MyApplication.appConfig.getAndroid_game_download()));
                break;

            case R.id.index_ll_newplayer:
                startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", MyApplication.appConfig.getNewplayer()));
                break;

            case R.id.index_ll_register:
                startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", MyApplication.appConfig.getMember_regist()));
                break;

            case R.id.index_ll_onlineserver:
                startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", MyApplication.appConfig.getOnline_service()));
                break;

            case R.id.index_ll_discountapply:
                startActivity(new Intent(getActivity(), WebViewPage_Activity.class).putExtra("url", MyApplication.appConfig.getDiscount_apply()));
                break;

            case R.id.index_bt_skip1:
                String btskip1 = homeInfo.getList().get(0).get(0).getUrl();
                intent.setAction("android.intent.action.VIEW");
                Uri bt_url1 = Uri.parse(btskip1.contains("http://") ? btskip1 : "http://"+btskip1);
                intent.setData(bt_url1);
                startActivity(intent);
                break;

            case R.id.index_bt_skip2:
                String btskip2 = homeInfo.getList().get(0).get(1).getUrl();
                intent.setAction("android.intent.action.VIEW");
                Uri bt_url2 = Uri.parse(btskip2.contains("http://") ? btskip2 : "http://"+btskip2);
                intent.setData(bt_url2);
                startActivity(intent);
                break;

            case R.id.index_bt_skip3:
                String btskip3 = homeInfo.getList().get(0).get(2).getUrl();
                intent.setAction("android.intent.action.VIEW");
                Uri bt_url3 = Uri.parse(btskip3.contains("http://") ? btskip3 : "http://"+btskip3);
                intent.setData(bt_url3);
                startActivity(intent);
                break;

        }
    }

    private void loadData(){
        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    homeInfo=new HomeInfo();
                    OkHttpClient okHttpClient=new OkHttpClient();

                    Request request=new Request.Builder().url(url).build();
                    Response response=okHttpClient.newCall(request).execute();
                    String responseData=response.body().string();

                    Gson gson=new Gson();
                    homeInfo= gson.fromJson(responseData,HomeInfo.class);
                    Message msg=handler.obtainMessage();
                    msg.what=1;
                    handler.sendMessage(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                    Message msg=handler.obtainMessage();
                    msg.what=5;
                    handler.sendMessage(msg);
                }

                try {
                    OkHttpClient okHttpClient=new OkHttpClient();

                    Request request=new Request.Builder().url(urlAppConfig).build();
                    Response response=okHttpClient.newCall(request).execute();
                    String responseData=response.body().string();

                    Gson gson=new Gson();
                    MyApplication.appConfig= gson.fromJson(responseData,AppConfig.class);
                } catch (IOException e) {
                    e.printStackTrace();
                    Message msg=handler.obtainMessage();
                    msg.what=5;
                    handler.sendMessage(msg);
                }
            }
        };
        t.start();
    }


}
