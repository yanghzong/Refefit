package com.example.refefit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.refefit.R;
import com.example.refefit.bean.TianqiBean;

import java.util.List;

public class TianQiAdapter  extends RecyclerView.Adapter<TianQiAdapter.ViewHolder> {
    private Context context;
    private List<TianqiBean.DataBean.ForecastBean> list;

    public TianQiAdapter(Context context, List<TianqiBean.DataBean.ForecastBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  itemView=View.inflate(context, R.layout.tianqi_item,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TianqiBean.DataBean.ForecastBean forecastBean = list.get(i);
        if (forecastBean!=null){
            viewHolder.tvTianQi.setText(forecastBean.getType());
            viewHolder.tvWendu.setText("最高温度:"+forecastBean.getHigh()+"最低气温:"+forecastBean.getLow());
            viewHolder.tvTime.setText(forecastBean.getDate());

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTianQi;
        private final TextView tvWendu;
        private final TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTianQi = itemView.findViewById(R.id.txt_tianqi);
            tvWendu = itemView.findViewById(R.id.txt_wendu);
            tvTime = itemView.findViewById(R.id.txt_time);
        }
    }
}
