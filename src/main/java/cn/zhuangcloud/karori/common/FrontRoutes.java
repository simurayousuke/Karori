package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.hello.HelloController;
import cn.zhuangcloud.karori.index.IndexController;
import cn.zhuangcloud.karori.login.LoginController;
import cn.zhuangcloud.karori.reg.RegController;
import cn.zhuangcloud.karori.version.VersionController;
import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {
    public void config() {
        setBaseViewPath("/view");
        add("/", IndexController.class, "index");
        add("/hello", HelloController.class);
        add("/login", LoginController.class);
        add("/version", VersionController.class);
        add("/reg", RegController.class);

        //todo
        add("/food", IndexController.class);
        add("/log", IndexController.class);
        add("/statistic", IndexController.class);
        add("/upload", IndexController.class);
        add("/share", IndexController.class);
    }
}