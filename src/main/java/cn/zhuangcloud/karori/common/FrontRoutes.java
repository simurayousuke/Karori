package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.food.FoodController;
import cn.zhuangcloud.karori.index.IndexController;
import cn.zhuangcloud.karori.log.LogController;
import cn.zhuangcloud.karori.login.LoginController;
import cn.zhuangcloud.karori.reg.RegController;
import cn.zhuangcloud.karori.share.ShareController;
import cn.zhuangcloud.karori.statistic.StatisticController;
import cn.zhuangcloud.karori.upload.UploadController;
import cn.zhuangcloud.karori.version.VersionController;
import com.jfinal.config.Routes;

/*
    403,404,500,logout
 */
public class FrontRoutes extends Routes {
    public void config() {
        setBaseViewPath("/view");
        add("/", IndexController.class, "index");
        add("/login", LoginController.class);
        add("/version", VersionController.class);
        add("/reg", RegController.class);
        add("/error", ErrorController.class, "common");

        //todo upload > log > statistic > share > upload mine > food
        add("/food", FoodController.class);
        add("/log", LogController.class);
        add("/statistic", StatisticController.class);
        add("/upload", UploadController.class);
        add("/share", ShareController.class);
    }
}