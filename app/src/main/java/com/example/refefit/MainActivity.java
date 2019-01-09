package com.example.refefit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.refefit.adapter.TianQiAdapter;
import com.example.refefit.bean.TianqiBean;
import com.example.refefit.presenter.TianQiPresenter;
import com.example.refefit.view.TianqiView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TianqiView {

    private RecyclerView rvTianqi;
    private List<TianqiBean.DataBean.ForecastBean> tianqilist;
    private TianQiAdapter tianQiAdapter;
    private TianQiPresenter tianQiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化布局
        initView();
        //初始化list和adapter
        initAdapter();
        //初始化p层
        initPresenter();
    }

    private void initPresenter() {
        tianQiPresenter = new TianQiPresenter();
        tianQiPresenter.attach(this);
        tianQiPresenter.getTianqiP();
    }

    private void initAdapter() {
        tianqilist = new ArrayList<>();
        tianQiAdapter = new TianQiAdapter(this,tianqilist);
        rvTianqi.setAdapter(tianQiAdapter);
    }

    private void initView() {
        rvTianqi = findViewById(R.id.rv_tianqi);
        rvTianqi.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void getTianqi(TianqiBean bean) {
        List<TianqiBean.DataBean.ForecastBean> forecast = bean.getData().getForecast();
        if (forecast!=null){
            tianqilist.clear();
            tianqilist.addAll(forecast);
            tianQiAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onFailed(String e) {
        Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tianQiPresenter.datach();

    }
}
