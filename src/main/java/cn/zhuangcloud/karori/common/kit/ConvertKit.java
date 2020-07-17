package cn.zhuangcloud.karori.common.kit;

import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

public class ConvertKit {

    public static Ret convertPageToZuiDatagridJsonResult(Page<Record> page) {
        Ret ret = Ret.by("result", "success");
        if (null == page) {
            ret.set("result", "fail");
            return ret;
        }
        ret.set("data", page.getList());
        Ret pager = Ret.by("page", page.getPageNumber() - 1).set("recTotal", page.getTotalRow()).set("recPerPage", page.getPageSize());
        ret.set("pager", pager);
        return ret;
    }

    public static Ret convertPageToDatatablesJsonResult(Page<Record> page) {
        return convertPageToZuiDatagridJsonResult(page);
    }

}
