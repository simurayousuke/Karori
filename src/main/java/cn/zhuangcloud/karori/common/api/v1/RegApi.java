package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import cn.zhuangcloud.karori.login.LoginService;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;

public class RegApi extends ApiV1 {

    @Inject
    LoginService loginService;

    @Clear(NeedLogin.class)
    public void index(String username, String password) {
        String token = loginService.reg(username, password);
        if (null == token) {
            fail();
            return;
        }
        setCookie("token", token, 60 * 60 * 24);
        success(Ret.by("token", token));
    }

}
