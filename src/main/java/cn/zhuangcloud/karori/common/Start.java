package cn.zhuangcloud.karori.common;

import com.jfinal.server.undertow.UndertowServer;

public class Start {

    public static final String version = "0.0.0.dev16";

    public static void main(String[] args) {
        Config.loadConfig();
        UndertowServer.start(Config.class, 80, Config.p.getBoolean("devMode", false));
    }

}
