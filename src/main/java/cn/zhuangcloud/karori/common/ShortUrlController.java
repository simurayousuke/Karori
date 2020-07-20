package cn.zhuangcloud.karori.common;

import cn.zhuangcloud.karori.common.base.MyController;
import cn.zhuangcloud.karori.common.kit.JudgeKit;
import cn.zhuangcloud.karori.common.model.ShortUrl;
import cn.zhuangcloud.karori.common.service.ShortUrlService;
import com.jfinal.aop.Inject;

public class ShortUrlController extends MyController {

    @Inject
    ShortUrlService shortUrlService;

    public void index() {
        ShortUrl shortUrl = shortUrlService.getByShortUrl(getPara());
        title("shortUrl");
        if (null != shortUrl) {
            String longUrl = shortUrl.getLongUrl();
            if (!JudgeKit.isHttpUrl(longUrl)) {
                set("_message", longUrl);
                render("message.html");
            } else {
                redirect(longUrl);
            }
        } else if (null != getAttr("user")) {
            render("index.html");
        } else {
            redirect("/");
        }
    }

}
