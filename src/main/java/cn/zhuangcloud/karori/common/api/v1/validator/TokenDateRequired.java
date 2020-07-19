package cn.zhuangcloud.karori.common.api.v1.validator;


import cn.zhuangcloud.karori.common.base.MyValidator;
import cn.zhuangcloud.karori.common.model.Share;
import cn.zhuangcloud.karori.share.ShareService;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;

import java.util.ArrayList;
import java.util.Date;

public class TokenDateRequired extends MyValidator {

    @Inject
    ShareService shareService;

    @Override
    protected void validate(Controller c) {
        this.setShortCircuit(true);
        validateRequired("token", "msg", "token required");
        validateRequired("date", "msg", "date required");
        validateDate("date", "msg", "wrong date format");
        Share share = shareService.getByToken(c.get("token"));
        if (null == share)
            addError("msg", "token invalid");
        Date date = c.getDate(("date"));
        switch (share.getType()) {
            case 1:
                if(date.compareTo(share.getStartDate())<0||date.compareTo(share.getEndDate())>0)
                    addError("msg","access denied");
                break;
            case 2:
                if (!isSameDay(date, share.getStartDate()))
                    addError("msg","access denied");
                break;
        }
        c.set("__share", share);
        c.set("__date", date);
    }

    @Override
    protected void handleError(Controller c) {
        c.renderJson(new ArrayList<Object>());
    }
}
