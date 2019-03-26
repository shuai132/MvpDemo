package com.xiaoyezi.mvpdemo.mvpdemo.main;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.xiaoyezi.mvpdemo.R;
import com.xiaoyezi.mvpdemo.dao.url.UrlItem;
import com.xiaoyezi.mvpdemo.mvpdemo.BaseActivity;
import com.xiaoyezi.mvpdemo.mvpdemo.utils.Toaster;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();

    private List<UrlItem> urlItems = new ArrayList<>();
    private UrlItemAdapter urlItemAdapter;

    @Inject
    MainPresenter presenter;

    @BindView(R.id.et_url)
    EditText etUrl;

    @OnClick(R.id.ib_add)
    public void onClickAdd(View v) {
        String inputUrl = etUrl.getText().toString();
        Log.d(TAG, "onClick: " + inputUrl);

        presenter.saveUrl(inputUrl);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_ble)
            Toaster.show("Not implement now!");

        return super.onOptionsItemSelected(item);
    }

    @BindView(R.id.lv_urls)
    ListView lvUrls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);

        initView();
        showUrlItems(presenter.getAllUrlItems());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter getPresenterImpl() {
        return presenter;
    }

    private void initView() {
        // ListView
        urlItemAdapter = new UrlItemAdapter(this, R.layout.url_item, urlItems, new UrlItemAdapter.OnClickListener() {

            @Override
            void onClickDelete(UrlItem urlItem) {
                presenter.deleteUrl(urlItem);
            }
        });
        lvUrls.setAdapter(urlItemAdapter);

        lvUrls.setOnItemClickListener((parent, view, position, id) -> {
            final UrlItem urlItem = urlItems.get(position);
            presenter.launchUrl(urlItem);
        });

        lvUrls.setOnItemLongClickListener((parent, view, position, id) -> {
            final UrlItem urlItem = urlItems.get(position);
            Toaster.showLong(urlItem.url);
            return true;
        });
    }

    @Override
    public void showUrlItems(List<UrlItem> urlItems) {
        Log.d(TAG, "showUrlItems: " + urlItems);
        this.urlItems.clear();
        this.urlItems.addAll(urlItems);
        urlItemAdapter.notifyDataSetChanged();
    }
}
