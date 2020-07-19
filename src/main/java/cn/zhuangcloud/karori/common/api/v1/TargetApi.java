package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.common.model.Target;
import cn.zhuangcloud.karori.target.TargetService;
import com.jfinal.aop.Inject;
import com.jfinal.i18n.Res;

public class TargetApi extends ApiV1 {

    @Inject
    TargetService targetService;

    public void index() {
        Res res = getRes();
        Target target = bean(Target.class);
        target.setUid(getUid());
        if (targetService.save(target))
            success(res.get("success"));
        else
            fail(res.get("fail"));
    }

    public void fetch(){
        renderJson(targetService.getByUidNotNull(getUid()));
    }

}
