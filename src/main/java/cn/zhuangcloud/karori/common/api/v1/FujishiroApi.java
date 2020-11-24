package cn.zhuangcloud.karori.common.api.v1;

import cn.zhuangcloud.karori.common.base.ApiV1;
import cn.zhuangcloud.karori.common.interceptor.NeedLogin;
import cn.zhuangcloud.karori.common.model.Kofuku;
import com.jfinal.aop.Clear;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.i18n.Res;
import com.jfinal.kit.Ret;

import java.util.List;

@Clear(NeedLogin.class)
public class FujishiroApi extends ApiV1 {

    Kofuku kofukuDao=new Kofuku().dao();

    public void kofuku()
    {
        Kofuku kofuku=new Kofuku();
        kofuku.setQ1(getInt("1"));
        kofuku.setQ2(getInt("2"));
        kofuku.setQ3(getInt("3"));
        kofuku.setQ4(getInt("4"));
        kofuku.setQ5(getInt("5"));
        Res res = getRes();
        if(kofuku.save())
            success("success");
        else
            fail("fail");
    }

    @Clear(POST.class)
    public void getkofuku()
    {
        List<Kofuku> data=kofukuDao.findAll();
        renderJson(Ret.by("data",data));
    }

}
