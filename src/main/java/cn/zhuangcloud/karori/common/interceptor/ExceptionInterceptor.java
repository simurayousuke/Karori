package cn.zhuangcloud.karori.common.interceptor;

import cn.zhuangcloud.karori.common.Start;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ExceptionInterceptor implements Interceptor {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionInterceptor.class);

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        try {
            controller.set("version", Start.version);
            inv.invoke();
        } catch (Exception e) {
            //System.out.println(e.toString());
            LOG.error(e.getMessage(), e);
            controller.renderJson(Ret.fail("msg", e.getMessage()));
        }
    }
}
