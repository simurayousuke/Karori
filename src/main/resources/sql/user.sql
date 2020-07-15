#sql("findByUsername")
SELECT *
FROM t_user
WHERE username =
#para(0)
#end