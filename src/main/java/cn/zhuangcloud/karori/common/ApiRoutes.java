package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.api.v1.*;
import cn.zhuangcloud.karori.common.interceptor.ApiExceptionInterceptor;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import com.jfinal.config.Routes;
import com.jfinal.ext.interceptor.POST;

public class ApiRoutes extends Routes {

    @Override
    public void config() {
        addInterceptor(new ApiExceptionInterceptor());
        addInterceptor(new POST());
        addInterceptor(new NeedLogin());
        add("/api/v1/food", FoodApi.class);
        add("/api/v1/login", LoginApi.class);
        add("/api/v1/reg", RegApi.class);
        add("/api/v1/log", LogApi.class);
        add("/api/v1/statistic", StatisticApi.class);
    }

}
