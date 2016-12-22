package com.lickey.asus.oceanofgod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lickey.asus.oceanofgod.domain.Message;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：第二{xianjianlicheng@foxmail.com}
 * 版本：1.0
 * Created by ASUS on 2016/12/22 0:31.
 * 描述：
 * 修订历史：
 */

public class MyArrayAdapter extends ArrayAdapter<Message> {
    private int resourceId;
    public MyArrayAdapter(Context context, int resource, Message[] objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    public String getStrTime(String cc_time) {
        String re_StrTime = null;
        //同理也可以转为其它样式的时间格式.例如："yyyy/MM/dd HH:mm"
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 例如：cc_time=1291778220
        long lcc_time = Long.valueOf(cc_time);
        re_StrTime = sdf.format(new Date(lcc_time * 1000L));

        return re_StrTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);
        LinearLayout userListItem = new LinearLayout(getContext());
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
        vi.inflate(resourceId, userListItem, true);
        TextView time = (TextView) userListItem.findViewById(R.id.items_tv_time);
        TextView content = (TextView) userListItem.findViewById(R.id.items_tv_content);
        time.setText(getStrTime((message.getTime()+"").substring(0,10)));
        content.setText(String.valueOf(message.getContent()));
        return userListItem;
    }
}
