package cn.zhuangcloud.karori.common;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

    /**
     * 注意：用于启动的 main 方法可以在任意 java 类中创建，在此仅为方便演示
     *      才将 main 方法放在了 DemoConfig 中
     *
     *      开发项目时，建议新建一个 App.java 或者 Start.java 这样的专用
     *      启动入口类放置用于启动的 main 方法
     */
    public static void main(String[] args) {
        PropKit.use("config.txt").appendIfExists("config-dev.txt");
        UndertowServer.start(Config.class, 80, PropKit.getBoolean("devMode", false));
    }

    public void configConstant(Constants me) {
        PropKit.use("config.txt").appendIfExists("config-dev.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
    }

    public void configRoute(Routes me) {
        me.add(new FrontRoutes());
    }

    public void configEngine(Engine me) {
    }

    public void configPlugin(Plugins me) {
        RedisPlugin redisUser = new RedisPlugin(PropKit.get("redisUserDatabase"), PropKit.get("redisHost"), PropKit.getInt("redisPort"), PropKit.get("redisPassword"));
        me.add(redisUser);
    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
    }

    public void onStart() {
        
    }
}