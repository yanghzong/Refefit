package com.example.refefit.utils;

import android.util.Log;

import com.example.refefit.bean.TianqiBean;
import com.example.refefit.inter.ICallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RescofitUtils {
    private  static  volatile  RescofitUtils  instance;
    private final Retrofit.Builder mbuilder;
    private Myinterface myinterface;

    public  RescofitUtils(){
        //日志拦截器
        //1.设置日志拦截器的级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //2.创建一个日志拦截器
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印拦截器
                Log.i("http信息打印", "log: "+message);
            }
        });
        //为日志拦截器设置日志拦截级别
        loggingInterceptor.setLevel(level);
        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        //将Client对象加入到Retrofit中

        //创建Retrofit对象

        mbuilder = new Retrofit.Builder();
                //设置json转换器
        mbuilder.addConverterFactory(GsonConverterFactory.create());

        mbuilder.client(client);

    }
    //双重锁
    public  static  RescofitUtils getInstance(){
        if (instance==null){
            synchronized (RescofitUtils.class){
                if (instance==null){
                    instance=new RescofitUtils();
                }
            }
        }
        return instance;
    }

        private void getWeatherBeiJing(String url) {
            Retrofit retrofit = mbuilder.baseUrl(url)//添加请求网址,以/结尾
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //RxJava 适配器
                    .build();
            myinterface = retrofit.create(Myinterface.class);
        }

        public  void  getWeatherU(String url, final ICallBack callBack, final Type type){
           getWeatherBeiJing(url);

           //通过接口,调用抽象方法
            Observable<ResponseBody> weather = myinterface.getWeather("北京");
            //通过对象,进行设置
            weather.subscribeOn(Schedulers.io())//IO线程加载数据
                    .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                    .subscribe(new Subscriber<ResponseBody>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            String str = "网络请求访问失败";
                            callBack.onFailed(str);
                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            try {
                                //注意：这儿不用response.body了，它已经是responsebody
                                String result = responseBody.string();
                                TianqiBean tianqiBean = new Gson().fromJson(result, type);

                                if(tianqiBean!=null){
                                    callBack.onSuccess(tianqiBean);
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        }
}
