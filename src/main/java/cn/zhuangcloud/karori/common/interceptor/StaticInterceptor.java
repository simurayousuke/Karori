package cn.zhuangcloud.karori.common.interceptor;

import cn.zhuangcloud.karori.common.Start;
import cn.zhuangcloud.karori.login.LoginService;
import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class StaticInterceptor implements Interceptor {

    @Inject
    LoginService loginService;

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        controller.set("devMode", Start.devMode);
        controller.set("version", Start.version);
        controller.set("user", loginService.findByToken(controller.getCookie("token")));
        inv.invoke();
    }
}
