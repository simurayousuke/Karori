package cn.zhuangcloud.karori.common.kit;

import com.jfinal.kit.StrKit;

public class SharedMethodLib {

    public String _generateUuid() {
        return StrKit.getRandomUUID();
    }

}
