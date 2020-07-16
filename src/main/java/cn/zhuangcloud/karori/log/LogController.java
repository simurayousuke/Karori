package cn.zhuangcloud.karori.log;

import cn.zhuangcloud.karori.common.MyController;

/*
    需要数据表
    todo 计量单位表 后续考虑加入
    营养成分表？
    食物表-》联查
 */

public class LogController extends MyController {

    /*
    选择日期和三餐-》扫码-》如果存在则列出可选食物表，本人提交的优先-》选择量        -》提交
                         如果不存在则显示添加按钮，跳转到添加页面-》跳转回选择量
     */

    public void index() {
        building();
    }


}
