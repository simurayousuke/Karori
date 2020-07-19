package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import cn.zhuangcloud.karori.common.model.Share;
import cn.zhuangcloud.karori.common.model.Target;
import cn.zhuangcloud.karori.common.model.User;
import cn.zhuangcloud.karori.share.ShareService;
import cn.zhuangcloud.karori.target.TargetService;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.i18n.Res;

public class TargetApi extends ApiV1 {

    @Inject
    TargetService targetService;
    @Inject
    ShareService shareService;

    public void index() {
        Res res = getRes();
        Target target = bean(Target.class);
        target.setUid(getUid());
        if (targetService.save(target))
            success(res.get("success"));
        else
            fail(res.get("fail"));
    }

    @Clear(NeedLogin.class)
    public void fetch() {
        User user = getAttr("user");
        if (null != user) {
            renderJson(targetService.getByUidNotNull(user.getUid()));
            return;
        }
        Share share = shareService.getByToken(get("token"));
        if (null == share) {
            renderJson(targetService.getNew());
            return;
        }
        renderJson(targetService.getByUidNotNull(share.getUid()));
    }

}
