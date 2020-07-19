package cn.zhuangcloud.karori.share;

import cn.zhuangcloud.karori.common.kit.DateKit;
import cn.zhuangcloud.karori.common.model.Share;

import java.util.Date;

public class ShareService {

    private Share dao = new Share().dao();

    public boolean create(Share share) {
        return share.save();
    }

    public Share getByToken(String token) {
        return null == token ? null : dao.findFirst(dao.getSqlPara("share.findByToken", token));
    }

    public boolean check(String token, Date date) {
        Share share = getByToken(token);
        return check(share,date);
    }

    public boolean check(Share share, Date date) {
        if (null == date)
            return false;
        if (null == share)
            return false;
        switch (share.getType()) {
            case 1:
                return (date.compareTo(share.getStartDate()) > 0 && date.compareTo(share.getEndDate()) < 0);
            case 2:
                return DateKit.isSameDay(date, share.getStartDate());
        }
        return true;
    }

}
