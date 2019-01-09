package com.example.refefit.model;

import com.example.refefit.inter.ICallBack;
import com.example.refefit.utils.RescofitUtils;

import java.lang.reflect.Type;

public class TianqiModel {

    public  void  getTianqi(String url, ICallBack callBack, Type type){
        RescofitUtils.getInstance().getWeatherU(url,callBack,type);
    }
}
