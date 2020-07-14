package cn.zhuangcloud.karori.index;

import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;

public class IndexController extends Controller {

    public void index() {

        renderText(PropKit.get("devMode"));
    }
}
