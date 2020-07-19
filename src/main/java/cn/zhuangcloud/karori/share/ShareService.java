package cn.zhuangcloud.karori.share;

import cn.zhuangcloud.karori.common.model.Share;

public class ShareService {

    private Share dao=new Share().dao();

    public boolean create(Share share){
        return share.save();
    }

    public Share getByToken(String token){
        return dao.findFirst(dao.getSqlPara("share.findByToken",token));
    }

}
