package com.xiaoyezi.mvpdemo.dao.url;

import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liushuai on 2018/2/11.
 */

public final class UrlManager {
    private static LinkedList<UrlItem> urlItems;

    public static UrlManager getInstance() {
        return InstanceHolder.urlManager;
    }

    private static class InstanceHolder {
        static UrlManager urlManager = new UrlManager();
    }

    private UrlManager() {
        queryHistory();
    }

    public List<UrlItem> getAllUrlItems() {
        return urlItems;
    }

    public void saveUrl(String url) {
        UrlItem urlItem = new UrlItem(url);
        urlItem.save();
        urlItems.addFirst(urlItem);
    }

    public void deleteUrl(UrlItem urlItem) {
        urlItems.remove(urlItem);
        urlItem.delete();
    }

    private static void queryHistory() {
        List<UrlItem> urlItems = new Select().from(UrlItem.class).orderBy(UrlItem_Table.id, false).queryList();
        UrlManager.urlItems = new LinkedList<>(urlItems);
    }
}
