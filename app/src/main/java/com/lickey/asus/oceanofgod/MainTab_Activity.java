package com.lickey.asus.oceanofgod;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.lickey.asus.oceanofgod.utils.BaseActivity;
import com.lickey.asus.oceanofgod.utils.MyApplication;


public class MainTab_Activity extends BaseActivity implements View.OnClickListener{

    private Index_Fragment index_fragment;
    private Discount_Fragment discount_fragment;
    private Message_Fragment message_fragment;
    private Register_Fragment register_fragment;
    private LinearLayout ll_index;
    private LinearLayout ll_discount;
    private LinearLayout ll_message;
    private LinearLayout ll_register;
    public View oldView;// 之前选中的view

    @Override
    public void setView() {
        setContentView(R.layout.main_tab_layout);
    }

    @Override
    public void initView() {
        ll_index= (LinearLayout) findViewById(R.id.main_ll_index);
        ll_discount= (LinearLayout) findViewById(R.id.main_ll_discount);
        ll_message= (LinearLayout) findViewById(R.id.main_ll_message);
        ll_register= (LinearLayout) findViewById(R.id.main_ll_register);
        setDefaultFragment();
        startActivity(new Intent(this,AlterMessage_Activity.class));
    }

    @Override
    public void setListener() {
        ll_index.setOnClickListener(this);
        ll_discount.setOnClickListener(this);
        ll_message.setOnClickListener(this);
        ll_register.setOnClickListener(this);
    }

    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        index_fragment = new Index_Fragment();
        transaction.replace(R.id.id_content, index_fragment);
        transaction.commit();
        oldView = ll_index;
        ll_index.setSelected(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            final AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("确认退出");
            builder.setMessage("确认要退出应用吗？");
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            AlertDialog ad=builder.create();
            ad.show();
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        FragmentManager fm = getFragmentManager();
        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        changeTabState(v, oldView);
        switch (v.getId()) {
            case R.id.main_ll_index:
                if (index_fragment == null) {
                    index_fragment = new Index_Fragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, index_fragment);
                break;
            case R.id.main_ll_discount:
                if (discount_fragment == null) {
                    discount_fragment = new Discount_Fragment();
                }
                // 使用当前Fragment的布局替代id_content的控件
                transaction.replace(R.id.id_content, discount_fragment);
                break;
            case R.id.main_ll_message:
                startActivity(new Intent(MainTab_Activity.this,Message_Activity.class));
                break;
            case R.id.main_ll_register:
                Intent intent = new Intent();
                String skip = MyApplication.appConfig.getRegist();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse(skip.contains("http://") ? skip : "http://"+skip);
                intent.setData(content_url);
                startActivity(intent);
                break;
            default:
                break;
        }
        // transaction.addToBackStack();
        // 事务提交
        transaction.commit();
    }

    public void changeTabState(View view, View oldView) {
        if (view == oldView) {
            return;
        }
        view.setSelected(true);
        oldView.setSelected(false);
        this.oldView = view;
    }
}
