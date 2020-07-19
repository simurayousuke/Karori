package cn.zhuangcloud.karori.common.api.v1.validator;

import cn.zhuangcloud.karori.common.base.MyValidator;
import cn.zhuangcloud.karori.common.model.Share;
import cn.zhuangcloud.karori.common.model.User;
import com.jfinal.core.Controller;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;

import java.util.Date;

public class ShareApiValidator extends MyValidator {
    @Override
    protected void validate(Controller c) {
        setRet(Ret.fail());
        this.setShortCircuit(true);
        Share share = c.getBean(Share.class, "");
        if (null == share)
            addError("msg", "illegal data");
        switch (share.getType()) {
            case 1:
                Date start = share.getStartDate();
                Date end = share.getEndDate();
                if (null == start)
                    addError("msg", "start date required");
                if (null == end)
                    addError("msg", "end date required");
                if (start.compareTo(end) > 0)
                    addError("msg", "end date must bigger than start date");
                break;
            case 2:
                if (null == share.getStartDate())
                    addError("msg", "start date required");
                break;
        }

        User user = c.getAttr("user");
        String token = StrKit.getRandomUUID();
        share.setToken(token);
        share.setUid(user.getUid());
        share.setUsername(user.getUsername());
        c.set("__share", share);
        c.set("__token", token);
    }

    @Override
    protected void handleError(Controller c) {
        c.renderJson(getRet());
    }
}
