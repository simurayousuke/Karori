package cn.zhuangcloud.karori.common.api.v1;

import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;

public class ApiV1 extends Controller {

    protected void fail() {
        renderJson(Ret.fail());
    }

    protected void fail(String msg) {
        renderJson(Ret.fail("msg", msg));
    }

    protected void success() {
        renderJson(Ret.ok());
    }

    protected <T> T bean(Class<T> beanClass) {
        return getBean(beanClass, "");
    }

}
