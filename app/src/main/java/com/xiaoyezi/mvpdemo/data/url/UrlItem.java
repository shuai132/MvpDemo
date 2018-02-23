package com.xiaoyezi.mvpdemo.data.url;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.xiaoyezi.mvpdemo.data.db.AppDatabase;
import com.xiaoyezi.mvpdemo.util.TimeUtil;

/**
 * Created by liushuai on 2018/2/9.
 */

@Table(database = AppDatabase.class)
public class UrlItem extends BaseModel {

    @PrimaryKey(autoincrement = true)
    public int id;

    @Column
    public String url;

    @Column
    public String addTime;

    UrlItem() {

    }

    UrlItem(String url) {
        this.url = url;
        this.addTime = TimeUtil.getTimeNow();
    }

    @Override
    public String toString() {
        return String.format("id:%d, url:%s, addTime:%s", id, url, addTime);
    }
}
