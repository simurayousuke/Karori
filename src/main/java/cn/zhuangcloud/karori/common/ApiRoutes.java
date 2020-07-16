package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.api.v1.FoodApi;
import com.jfinal.config.Routes;

public class ApiRoutes extends Routes {

    @Override
    public void config() {
        //todo 开发结束后取消注释
//        addInterceptor(new POST());
        add("/api/v1/food", FoodApi.class);
    }

}
