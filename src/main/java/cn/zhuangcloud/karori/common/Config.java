package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.handler.StaticHandler;
import cn.zhuangcloud.karori.common.interceptor.StaticInterceptor;
import cn.zhuangcloud.karori.common.kit.SharedMethodLib;
import cn.zhuangcloud.karori.common.model._MappingKit;
import cn.zhuangcloud.karori.common.route.ApiRoutes;
import cn.zhuangcloud.karori.common.route.FrontRoutes;
import com.jfinal.config.*;
import com.jfinal.i18n.I18nInterceptor;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

import java.sql.Connection;

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
        me.add(new ApiRoutes());
    }

    public void configEngine(Engine me) {
        me.addSharedFunction("/view/common/_layout.html");
        me.addSharedFunction("/view/fujishiro/_layout.html");
        me.addSharedMethod(new SharedMethodLib());
        me.setCompressorOn('\n');
    }

    public void configConstant(Constants me) {
        loadConfig();
        Start.devMode = p.getBoolean("devMode", false);
        me.setDevMode(Start.devMode);
        me.setInjectDependency(true);
        me.setInjectSuperClass(true);
        me.setI18nDefaultBaseName("i18n");
        me.setI18nDefaultLocale("zh_CN");
        me.setToSlf4jLogFactory();
        me.setJsonFactory(new MixedJsonFactory());
        me.setViewType(ViewType.JFINAL_TEMPLATE);
        me.setJsonDatePattern("yyyy-MM-dd HH:mm:ss");
    }

    public void configPlugin(Plugins me) {
        RedisPlugin redisUser = new RedisPlugin("user", p.get("redisHost"), p.getInt("redisPort"), p.get("redisPassword"));
        me.add(redisUser);

        DruidPlugin dp = createDruidPlugin();
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        arp.setBaseSqlTemplatePath("/sql");
        arp.addSqlTemplate("all.sql");
        arp.setTransactionLevel(Connection.TRANSACTION_READ_COMMITTED);
        _MappingKit.mapping(arp);
        me.add(arp);
    }

    public void configInterceptor(Interceptors me) {
//        me.addGlobalActionInterceptor(new ExceptionInterceptor());
        me.addGlobalActionInterceptor(new I18nInterceptor());
        me.addGlobalActionInterceptor(new StaticInterceptor());
    }

    public void configHandler(Handlers me) {
        me.add(new StaticHandler());
    }

    public void onStart() {

    }
}