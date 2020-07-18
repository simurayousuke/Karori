let __res = {
#for(p : __res)
#(p.key):"#(p.value)",
#end
};
let _locale="#(__locale)";