package cn.zhuangcloud.karori.common.service;

import cn.zhuangcloud.karori.common.kit.ConvertKit;
import cn.zhuangcloud.karori.common.model.ShortUrl;

public class ShortUrlService {

    ShortUrl dao = new ShortUrl().dao();

    public ShortUrl getByShortUrl(String sUrl) {
        return null == sUrl ? null : dao.findFirst(dao.getSqlPara("shortUrl.findByShortUrl", sUrl));
    }

    public String creat(String url, Integer uid) {
        if (null == url)
            return null;
        String[] urls = ConvertKit.convertToShortUrl(url);
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setCreator(uid);
        shortUrl.setLongUrl(url);
        for (String s : urls) {
            if (null == getByShortUrl(s)) {
                shortUrl.setShortUrl(s);
                if (shortUrl.save())
                    return s;
                else
                    return null;
            }
        }
        return null;
    }

}
