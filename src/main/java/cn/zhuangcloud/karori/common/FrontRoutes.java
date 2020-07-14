package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.hello.HelloController;
import cn.zhuangcloud.karori.index.IndexController;
import com.jfinal.config.Routes;

public class FrontRoutes extends Routes {
    public void config() {
        setBaseViewPath("/view/front");
        add("/", IndexController.class);
        add("/hello", HelloController.class);
    }
}