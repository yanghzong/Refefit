package com.example.refefit.presenter;

import android.os.Handler;

import com.example.refefit.bean.TianqiBean;
import com.example.refefit.inter.ICallBack;
import com.example.refefit.model.TianqiModel;
import com.example.refefit.utils.APIS;
import com.example.refefit.view.TianqiView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class TianQiPresenter {
    private TianqiModel model;
    private TianqiView mview;
    private Handler handler=new Handler();


    public  void attach(TianqiView tv){
        mview= tv;
        model=new TianqiModel();
    }
    public  void getTianqiP(){
        Type type=new TypeToken<TianqiBean>(){}.getType();
        model.getTianqi(APIS.APIWeatherBeiJing, new ICallBack() {
            @Override
            public void onSuccess(Object obj) {
                final TianqiBean tianqiBean= (TianqiBean) obj;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                 mview.getTianqi(tianqiBean);
                    }
                });

            }

            @Override
            public void onFailed(String e) {
                mview.onFailed(e);
            }
        },type);
    }
    public void datach(){
        if(mview!=null){
            mview = null;
        }
    }
}
