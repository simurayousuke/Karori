package cn.zhuangcloud.karori.log;

import cn.zhuangcloud.karori.common.model.Log;
import com.jfinal.plugin.activerecord.Db;

import java.util.ArrayList;
import java.util.Collections;

public class LogService {

    private Log dao = new Log().dao();
    private static final ArrayList<Integer> users247 = new ArrayList<>(Collections.singletonList(3));

    public boolean log(Log log) {
        return log.save();
    }

    public boolean init247(Integer uid) {
        if (uid != 3)
            return false;
        return Db.tx(() -> {
            boolean flag = true;
            for (int i = 1; i < 4; ++i) {
                Log log = new Log();
                log.setUid(uid);
                log.setFid(19);
                log.setType(i);
                flag = flag && log.save();
            }
            for (int i = 1; i < 4; ++i) {
                Log log = new Log();
                log.setUid(uid);
                log.setFid(20);
                log.setType(i);
                flag = flag && log.save();
            }
            Log log = new Log();
            log.setUid(uid);
            log.setFid(18);
            log.setType(1);
            flag = flag && log.save();
            return flag;
        });

    }

}
