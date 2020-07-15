package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.interceptor.ExceptionInterceptor;
import cn.zhuangcloud.karori.hello.HelloController;
import cn.zhuangcloud.karori.index.IndexController;
import cn.zhuangcloud.karori.login.LoginController;
import cn.zhuangcloud.karori.version.VersionController;
import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {
    public void config() {
        addInterceptor(new ExceptionInterceptor());
        setBaseViewPath("/view");
        add("/", IndexController.class, "index");
        add("/hello", HelloController.class);
        add("/login", LoginController.class);
        add("/version", VersionController.class);
    }
}