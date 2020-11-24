package cn.zhuangcloud.karori.fujishiro;

import cn.zhuangcloud.karori.common.base.MyController;


public class FujishiroController extends MyController {

    public void kofuku()
    {
        title("幸福調査結果");
        render("kofuku.html");
    }

    public void aaaf0906abcab9dabe1c0bd7626fcbdd()
    {
        String[] choices={"全くそう思わない","ほとんどそう思わない","あまりそう思わない","どちらともいえない","ややそう思う","かなりそう思う","とてもそう思う"};
        String[] questions={"ほとんどの面で、私の人生は私の理想に近い。","私の人生はとても素晴らしい状態だ。","私は自分の人生に満足している。",
                "私はこれまで、自分の人生に求める大切なものを得てきた。", "もう一度う人生をやり直せるとしても、ほとんど何も変えないだろう。"};
        set("choices",choices);
        set("questions",questions);
        title("幸福調査");
        render("kofukuquestion.html");
    }

}
