package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.api.v1.validator.ShareApiValidator;
import cn.zhuangcloud.karori.common.api.v1.validator.TokenDateRequired;
import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.common.model.Share;
import cn.zhuangcloud.karori.statistic.StatisticService;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;

import java.util.Date;

public class ShareApi extends ApiV1 {

    @Inject
    StatisticService statisticService;

    @Before(TokenDateRequired.class)
    public void dateAndType() {
        Date date = getAttr("__date");
        Share share = getAttr("__share");
        renderJson(statisticService.unionByUidAndDateAndType(share.getUid(), date, getInt("type")));
    }

    @Before(ShareApiValidator.class)
    public void create() {
        Share share = getAttr("__share");
        String token = getAttr("__token");
        Res res = getRes();
        if (share.save()) {
            success(Ret.by("token", token).set("msg", res.get("shareSuccess")));
        } else {
            fail(res.get("shareFail"));
        }
    }

}
