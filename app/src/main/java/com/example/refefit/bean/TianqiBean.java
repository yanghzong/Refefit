package com.example.refefit.bean;

import java.util.List;

public class TianqiBean {
    /**
     * data : {"city":"北京","forecast":[{"date":"4日星期五","fengli":"<![CDATA[3-4级]]>","fengxiang":"北风","high":"高温 2℃","low":"低温 -7℃","type":"晴"},{"date":"5日星期六","fengli":"<![CDATA[<3级]]>","fengxiang":"东北风","high":"高温 0℃","low":"低温 -8℃","type":"多云"},{"date":"6日星期天","fengli":"<![CDATA[<3级]]>","fengxiang":"西南风","high":"高温 3℃","low":"低温 -7℃","type":"多云"},{"date":"7日星期一","fengli":"<![CDATA[3-4级]]>","fengxiang":"北风","high":"高温 3℃","low":"低温 -7℃","type":"多云"},{"date":"8日星期二","fengli":"<![CDATA[<3级]]>","fengxiang":"西南风","high":"高温 2℃","low":"低温 -7℃","type":"晴"}],"ganmao":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。","wendu":"1","yesterday":{"date":"3日星期四","fl":"<![CDATA[<3级]]>","fx":"西南风","high":"高温 2℃","low":"低温 -7℃","type":"霾"}}
     * desc : OK
     * status : 1000
     */

    private DataBean data;
    private String desc;
    private int status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBean {
        /**
         * city : 北京
         * forecast : [{"date":"4日星期五","fengli":"<![CDATA[3-4级]]>","fengxiang":"北风","high":"高温 2℃","low":"低温 -7℃","type":"晴"},{"date":"5日星期六","fengli":"<![CDATA[<3级]]>","fengxiang":"东北风","high":"高温 0℃","low":"低温 -8℃","type":"多云"},{"date":"6日星期天","fengli":"<![CDATA[<3级]]>","fengxiang":"西南风","high":"高温 3℃","low":"低温 -7℃","type":"多云"},{"date":"7日星期一","fengli":"<![CDATA[3-4级]]>","fengxiang":"北风","high":"高温 3℃","low":"低温 -7℃","type":"多云"},{"date":"8日星期二","fengli":"<![CDATA[<3级]]>","fengxiang":"西南风","high":"高温 2℃","low":"低温 -7℃","type":"晴"}]
         * ganmao : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
         * wendu : 1
         * yesterday : {"date":"3日星期四","fl":"<![CDATA[<3级]]>","fx":"西南风","high":"高温 2℃","low":"低温 -7℃","type":"霾"}
         */

        private String city;
        private String ganmao;
        private String wendu;
        private YesterdayBean yesterday;
        private List<ForecastBean> forecast;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getGanmao() {
            return ganmao;
        }

        public void setGanmao(String ganmao) {
            this.ganmao = ganmao;
        }

        public String getWendu() {
            return wendu;
        }

        public void setWendu(String wendu) {
            this.wendu = wendu;
        }

        public YesterdayBean getYesterday() {
            return yesterday;
        }

        public void setYesterday(YesterdayBean yesterday) {
            this.yesterday = yesterday;
        }

        public List<ForecastBean> getForecast() {
            return forecast;
        }

        public void setForecast(List<ForecastBean> forecast) {
            this.forecast = forecast;
        }

        public static class YesterdayBean {
            /**
             * date : 3日星期四
             * fl : <![CDATA[<3级]]>
             * fx : 西南风
             * high : 高温 2℃
             * low : 低温 -7℃
             * type : 霾
             */

            private String date;
            private String fl;
            private String fx;
            private String high;
            private String low;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getFx() {
                return fx;
            }

            public void setFx(String fx) {
                this.fx = fx;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }

        public static class ForecastBean {
            /**
             * date : 4日星期五
             * fengli : <![CDATA[3-4级]]>
             * fengxiang : 北风
             * high : 高温 2℃
             * low : 低温 -7℃
             * type : 晴
             */

            private String date;
            private String fengli;
            private String fengxiang;
            private String high;
            private String low;
            private String type;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getFengli() {
                return fengli;
            }

            public void setFengli(String fengli) {
                this.fengli = fengli;
            }

            public String getFengxiang() {
                return fengxiang;
            }

            public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }

}
