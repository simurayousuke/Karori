package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.base.MyController;
import cn.zhuangcloud.karori.common.model.ShortUrl;
import cn.zhuangcloud.karori.common.service.ShortUrlService;
import com.jfinal.aop.Inject;

public class ShortUrlController extends MyController {

    @Inject
    ShortUrlService shortUrlService;

    public void index() {
        ShortUrl shortUrl = shortUrlService.getByShortUrl(getPara());
        if (null == shortUrl)
            redirect("https://zhuangcloud.cn");
        else
            redirect(shortUrl.getLongUrl());
    }

}
