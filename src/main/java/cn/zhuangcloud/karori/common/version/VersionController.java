package cn.zhuangcloud.karori.common.version;

import cn.zhuangcloud.karori.common.Start;
import com.jfinal.core.Controller;

public class VersionController extends Controller {

    public void index() {
        renderText(Start.version);
    }

}
