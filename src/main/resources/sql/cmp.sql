#sql("findByCid")
SELECT *
FROM t_composition
WHERE cid =
#para(0)
#end