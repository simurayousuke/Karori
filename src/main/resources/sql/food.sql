#sql("unionByFid")
SELECT F.fid, F.ean, F.foodname, F.uploader upid, C.*, U.username uploader
FROM t_food F
         LEFT JOIN t_composition C ON F.composition = C.cid
         left join t_user U on F.uploader = U.uid
WHERE F.fid =
#para(0);
#end