#sql("unionByUidAndDate")
SELECT F.fid,
       F.ean,
       F.foodname,
       C.*,
       L.type
FROM t_log L
         LEFT JOIN t_food F ON L.fid = F.fid
         LEFT JOIN t_composition C ON F.composition = C.cid

WHERE L.uid =#para(0)
  AND TO_DAYS(L.meal_date) = TO_DAYS(#para(1))
#end

#sql("unionByUidAndDateAndType")
        SELECT F.fid,
        F.ean,
        F.foodname,
        C.*,
        L.type
        FROM t_log L
        LEFT JOIN t_food F ON L.fid = F.fid
        LEFT JOIN t_composition C ON F.composition = C.cid
        WHERE L.uid =#para(0)
            AND TO_DAYS(L.meal_date) = TO_DAYS(#para(1))
                    AND L.type =
#para(2)
#end
