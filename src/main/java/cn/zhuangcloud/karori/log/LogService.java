package cn.zhuangcloud.karori.log;

import cn.zhuangcloud.karori.common.model.Log;

public class LogService {

    private Log dao = new Log().dao();

    public boolean log(Log log) {
        return log.save();
    }

}
