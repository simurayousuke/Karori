package cn.zhuangcloud.karori.share;

import cn.zhuangcloud.karori.common.base.MyValidator;
import cn.zhuangcloud.karori.common.model.Share;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

public class NeedToken extends MyValidator {

    @Inject
    ShareService shareService;

    @Override
    protected void validate(Controller c) {
        this.setShortCircuit(true);
        validateRequired("token", "msg", "token required");
        Share share = shareService.getByToken(c.get("token"));
        if (null == share)
            addError("msg", "token invalid");
        c.set("__share", share);
    }

    @Override
    protected void handleError(Controller c) {
        c.renderError(403);
    }
}
