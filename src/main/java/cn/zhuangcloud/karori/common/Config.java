package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.model._MappingKit;
import com.jfinal.config.*;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

    static Prop p;

    static void loadConfig() {
        if (null == p)
            p = PropKit.useFirstFound("config-dev.txt", "config.txt");
    }

    public static DruidPlugin createDruidPlugin() {
        loadConfig();
        String connUrl = "jdbc:mysql://" + p.get("mysqlHost") + "/" + p.get("mysqlDatabase", "karori");
        return new DruidPlugin(connUrl, p.get("mysqlUser", "karori"), p.get("mysqlPassword"));
    }

    public void configRoute(Routes me) {
        me.add(new FrontRoutes());
    }

    public void configEngine(Engine me) {
        me.addSharedFunction("/view/common/_layout.html");
    }

    public void configConstant(Constants me) {
        loadConfig();
        me.setDevMode(p.getBoolean("devMode", false));
        //me.setInjectDependency(true);
        //me.setInjectSuperClass(true);
    }

    public void configPlugin(Plugins me) {
        RedisPlugin redisUser = new RedisPlugin(p.get("redisUserDatabase"), p.get("redisHost"), p.getInt("redisPort"), p.get("redisPassword"));
        me.add(redisUser);

        DruidPlugin dp = createDruidPlugin();
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        _MappingKit.mapping(arp);
        me.add(arp);
    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
        me.add(new StaticHandler());
    }

    public void onStart() {

    }
}