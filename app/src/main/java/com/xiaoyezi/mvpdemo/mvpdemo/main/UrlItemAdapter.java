package com.xiaoyezi.mvpdemo.mvpdemo.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaoyezi.mvpdemo.R;
import com.xiaoyezi.mvpdemo.dao.url.UrlItem;

import java.util.List;

/**
 * Created by liushuai on 2018/2/11.
 */
public class UrlItemAdapter extends ArrayAdapter<UrlItem> {
    private int resourceId;

    private OnClickListener onButtonClickListener;

    public static abstract class OnClickListener implements View.OnClickListener{
        @Override
        public final void onClick(View v) {
            UrlItem urlItem = (UrlItem)v.getTag();
            switch (v.getId()) {
                case R.id.ib_delete:
                    onClickDelete(urlItem);
                    break;
            }
        }

        abstract void onClickDelete(UrlItem urlItem);
    }

    UrlItemAdapter(Context context, int textViewResourceId, List<UrlItem> objects, OnClickListener onButtonClickListener) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
        this.onButtonClickListener = onButtonClickListener;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UrlItem urlItem = getItem(position);
        ViewHolder viewHolder;
        View view;

        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.tvId.setText(Integer.toString(position + 1));
        viewHolder.tvUrl.setText(urlItem.url);
        viewHolder.tvAddTime.setText(urlItem.addTime);
        viewHolder.ibDelete.setOnClickListener(onButtonClickListener);
        viewHolder.ibDelete.setTag(urlItem);

        return view;
    }

    private static class ViewHolder {
        TextView  tvId;
        TextView  tvUrl;
        TextView  tvAddTime;
        ImageView ibDelete;

        ViewHolder(View view) {
            tvId      = view.findViewById(R.id.tv_id);
            tvUrl     = view.findViewById(R.id.tv_url);
            tvAddTime = view.findViewById(R.id.tv_addtime);
            ibDelete  = view.findViewById(R.id.ib_delete);
        }
    }
}

