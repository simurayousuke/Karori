package cn.zhuangcloud.karori.common.route;

import cn.zhuangcloud.karori.common.ShortUrlController;
import cn.zhuangcloud.karori.common.base.ErrorController;
import cn.zhuangcloud.karori.common.base.ResJsController;
import cn.zhuangcloud.karori.common.interceptor.ExceptionInterceptor;
import cn.zhuangcloud.karori.food.FoodController;
import cn.zhuangcloud.karori.fujishiro.FujishiroController;
import cn.zhuangcloud.karori.index.IndexController;
import cn.zhuangcloud.karori.log.LogController;
import cn.zhuangcloud.karori.login.LoginController;
import cn.zhuangcloud.karori.reg.RegController;
import cn.zhuangcloud.karori.share.ShareController;
import cn.zhuangcloud.karori.statistic.StatisticController;
import cn.zhuangcloud.karori.target.TargetController;
import cn.zhuangcloud.karori.upload.UploadController;
import cn.zhuangcloud.karori.version.VersionController;
import com.jfinal.config.Routes;

/*
    403,404,500,logout
 */
public class FrontRoutes extends Routes {
    public void config() {
        addInterceptor(new ExceptionInterceptor());
        setBaseViewPath("/view");
        add("/", IndexController.class, "index");
        add("/login", LoginController.class);
        add("/version", VersionController.class);
        add("/reg", RegController.class);
        add("/error", ErrorController.class, "common");
        //todo mine modify
        add("/upload", UploadController.class);
        //todo search
        add("/food", FoodController.class);
        //todo more ways
        add("/log", LogController.class);
        add("/js/res", ResJsController.class, "common");

        //todo log > statistic > share > upload mine > food
        add("/statistic", StatisticController.class);
        add("/share", ShareController.class);

        add("/target", TargetController.class);
        add("/s", ShortUrlController.class,"shortUrl");

        add("/fujishiro", FujishiroController.class);
    }
}