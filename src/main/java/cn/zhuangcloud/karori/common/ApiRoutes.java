package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.api.v1.FoodApi;
import cn.zhuangcloud.karori.common.api.v1.LoginApi;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import com.jfinal.config.Routes;
import com.jfinal.ext.interceptor.POST;

public class ApiRoutes extends Routes {

    @Override
    public void config() {
        addInterceptor(new POST());
        addInterceptor(new NeedLogin());
        add("/api/v1/food", FoodApi.class);
        add("/api/v1/login", LoginApi.class);
    }

}
