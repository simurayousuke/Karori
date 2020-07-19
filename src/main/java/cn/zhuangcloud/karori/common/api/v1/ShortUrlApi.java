package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import cn.zhuangcloud.karori.common.service.ShortUrlService;
import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;

public class ShortUrlApi extends ApiV1 {

    @Inject
    ShortUrlService shortUrlService;

    public void create() {
        String shortUrl = shortUrlService.creat(get("url"), getUid());
        Res res = getRes();
        if (null == shortUrl)
            fail(res.get("fail"));
        else
            success(Ret.by("msg", res.get("success")).set("sUrl", shortUrl));
    }

    @Clear(NeedLogin.class)
    public void fetch() {
        renderJson(Ret.by("url", shortUrlService.getByShortUrl(get("sUrl"))));
    }

}
