package cn.zhuangcloud.karori.common;

import com.jfinal.server.undertow.UndertowServer;

public class Start {

    public static final String version = "1.4.1";
    public static boolean devMode;

    public static void main(String[] args) {
        Config.loadConfig();
        devMode = Config.p.getBoolean("devMode", false);
        UndertowServer.start(Config.class, 80, devMode);
    }

}
