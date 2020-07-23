package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.common.model.Log;
import cn.zhuangcloud.karori.log.LogService;
import com.jfinal.aop.Inject;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;

public class LogApi extends ApiV1 {

    @Inject
    LogService logService;

    public void index() {
        Res res = getRes();
        Log log = bean(Log.class);
        log.setUid(getUid());
        if (logService.log(log))
            success(Ret.by("msg", res.get("logSuccess")));
        else
            fail(Ret.by("code", 500).set("msg", res.get("logFail")));
    }

    public void init247(){
        Res res = getRes();
        if (logService.init247(getUid()))
            success(Ret.by("msg", res.get("logSuccess")));
        else
            fail(Ret.by("code", 500).set("msg", res.get("logFail")));
    }

}
