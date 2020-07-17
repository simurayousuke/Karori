package cn.zhuangcloud.karori.common.kit;

import com.jfinal.kit.Ret;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertKit {

    public static final Map<String, String> UNIT_MAP = new HashMap<String, String>() {{
        put("calorie", "kcal");
        put("protein", "g");
        put("fat", "g");
        put("carbohydrate", "g");
        put("sodium", "mg");
        put("salt", "g");
        put("cholesterol", "mg");
        put("sugar", "g");
        put("vitaminA", "μg(mcg)");
        put("vitaminD", "μg(mcg)");
        put("vitaminE", "mg");
        put("vitaminK", "μg(mcg)");
        put("vitaminB1", "mg");
        put("vitaminB2", "mg");
        put("vitaminB6", "mg");
        put("vitaminB12", "μg(mcg)");
        put("vitaminC", "mg");
        put("calcium", "mg");
        put("iron", "mg");
        put("magnesium", "mg");
        put("zinc", "mg");
        put("potassium", "mg");
    }};

    public static Ret convertPageToZuiDatagridJsonResult(Page<Record> page) {
        Ret ret = Ret.by("result", "success");
        if (null == page) {
            ret.set("result", "fail");
            return ret;
        }
        ret.set("data", page.getList());
        Ret pager = Ret.by("page", page.getPageNumber()).set("recTotal", page.getTotalRow()).set("recPerPage", page.getPageSize());
        ret.set("pager", pager);
        return ret;
    }

    public static Ret convertPageToDatatablesJsonResult(Page<Record> page) {
        return convertPageToZuiDatagridJsonResult(page);
    }

    public static Map<String, Object> convertCompositionWithUnit(Map<String, Object> ret, boolean removeNull) {
        UNIT_MAP.forEach((k, v) -> {
            if (null != ret.get(k))
                ret.put(k, String.format("%.2f", ret.get(k)) + " " + v);
            else if (removeNull)
                ret.remove(k);

        });
        return ret;
    }

    public static List<Map<String, Object>> getSumForDouble(List<Record> recordList) {
        if (recordList.size() < 1)
            return null;
        Map<String, Object> counter = new HashMap<>();
        List<Map<String, Object>> ret = new ArrayList<>();
        recordList.get(0).getColumns().forEach((k, v) -> {
            counter.put(k, null);
        });
        recordList.forEach((record) -> {
            ret.add(record.getColumns());
            record.getColumns().forEach((k, v) -> {
                if (v instanceof Double) {
                    Double temp = (Double) counter.get(k);
                    if (null == temp)
                        temp = 0.0;
                    counter.put(k, temp + (Double)v);
                }
            });
        });
        ret.add(counter);
        return ret;
    }

}
