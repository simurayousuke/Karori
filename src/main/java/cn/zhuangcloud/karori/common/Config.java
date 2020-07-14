package cn.zhuangcloud.karori.common;

import com.jfinal.config.*;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.template.Engine;
import com.jfinal.server.undertow.UndertowServer;

public class Config extends JFinalConfig {

    /**
     * 注意：用于启动的 main 方法可以在任意 java 类中创建，在此仅为方便演示
     *      才将 main 方法放在了 DemoConfig 中
     *
     *      开发项目时，建议新建一个 App.java 或者 Start.java 这样的专用
     *      启动入口类放置用于启动的 main 方法
     */
    public static void main(String[] args) {
        UndertowServer.start(Config.class, 80, true);
    }

    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    public void configRoute(Routes me) {
        me.add("/", HelloController.class);
    }

    public void configEngine(Engine me){}

    public void configPlugin(Plugins me) {
        RedisPlugin userRedis=new RedisPlugin("user","localhost");
    }
    public void configInterceptor(Interceptors me) {}
    public void configHandler(Handlers me) {}
}