package cn.yodes.open.crawler.utils;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.utils.DateUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/4/10
 */
public class TextUtilsTests {
    private Logger log = LoggerFactory.getLogger(TextUtilsTests.class);

    @Test
    public void filterOthers() throws IOException {
        String outputUri = "C:\\Users\\Administrator\\Desktop\\Spider\\Music\\Hip-Hop\\Format\\formatIrc.txt";
        String formatStr = TextUtils.filterOthers();
        FileUtils.writeStringToFile(new File(outputUri), formatStr, "utf8");
    }

    @Test
    public void deleteHtmlTag() {
        String htmlStr = "<div class=\"arc-body\"> \n" +
                " <blockquote style=\"border: 2px dashed #b6b6b6; background-color: #f4f4f4; text-indent: 2em; margin: 5px 0px 0px; font-size: 14px; line-height: 25px; font-family: arial, helvetica, sans-serif; color: #333333; padding: 10px 10px 0px;\"> \n" +
                "  <p style=\"line-height: 1.8em; min-height: 1.5em; padding: 10px; margin-top: 0px; margin-bottom: 10px; font-style: normal; text-align: center;\"> <strong><a href=\"http://manage-www.18183.com/yxzjol/xzy/xiazailuodiye.html?type=1\"><u><span style=\"color: rgb(0, 0, 205);\">下载玩GO 登录背景修改器&amp;体验服预约提醒等你用</span></u></a></strong></p> \n" +
                " </blockquote> \n" +
                " <p> 大家都知道孙策的大招是驾驶着一艘大船，而在驾驶大船的时候行走的速度也是非常快，那么峡谷中其他跑的快的英雄和孙策大招比速度的话谁能超过孙策呢，下面我们就来做一个测试看看。</p> \n" +
                " <p> 测试方法都带一双疾跑鞋，从自家的泉水出发，从中路直接跑到对方的泉水里看谁用的时间最少。</p> \n" +
                " <p> 1 典韦</p> \n" +
                " <p style=\"text-align:center;\"> <img max-width=\"600\" src=\"https://c-img.18183.com/images/2018/07/22/8e3a57f58616084aeb4f86b64a2caa71.jpg@!18183\"></p> \n" +
                " <p> 典韦不停的用1技能加速奔跑，最后用时21秒到达，看来典韦还是很能跑的。</p> \n" +
                " <p> 2 关羽</p> \n" +
                " <p style=\"text-align:center;\"> <img max-width=\"600\" src=\"https://c-img.18183.com/images/2018/07/22/a45cad95ad65d63c73cb782dc2fd5f9d.jpg@!18183\"></p> \n" +
                " <p> 关羽基本没使用寿命技能完全靠的被动，而最终时间为21秒，如果使用技能的话估计会快很多。</p> \n" +
                " <p> 3 孙策</p> \n" +
                " <p style=\"text-align:center;\"> <img max-width=\"600\" src=\"https://c-img.18183.com/images/2018/07/22/4189a50e9a713f7b65b61503754207f9.jpg@!18183\"></p> \n" +
                " <p> 作为对比的对象孙策大船只用了2次就能从自己的泉水到对方的泉水，因为孙策大招释放完后会跳船耽误了一点时间，如果扣除这些的话估计会比测试的19秒还要快很多。</p> \n" +
                " <p> 4 哪吒</p> \n" +
                " <p style=\"text-align:center;\"> <img max-width=\"600\" src=\"https://c-img.18183.com/images/2018/07/22/e02bc7b3e98362874ebfd1923d5b010d.jpg@!18183\"></p> \n" +
                " <p> 哪吒的速度就不用说 ，一个大招锁定后就可以直接自动飞行了，而且速度极快从自己家飞到对方泉水只用了12秒，而且操作也是最简单的一个。</p> \n" +
                " <p> 小伙伴还觉得还有哪些英雄的技能速度能超过孙策的么。</p> \n" +
                " <p style=\"text-align: center;\"> <a href=\"http://manage-www.18183.com/yxzjol/xzy/xiazailuodiye.html?type=1\" target=\"_blank\"><span style=\"color:#0000ff;\">快快扫描下方二维码或者 点击这里下载“玩GO” 吧~</span></a></p> \n" +
                " <p style=\"text-align: center;\"> <a href=\"http://manage-www.18183.com/yxzjol/xzy/xiazailuodiye.html?type=1\" target=\"_blank\"><span style=\"color:#0000ff;\"><img alt=\"\" src=\"https://img.18183.com/uploads/allimg/180511/194-1P511151431964.png\" style=\"width: 150px; height: 150px;\"></span></a></p> \n" +
                "</div>";
        String result = TextUtils.filterHtmlTag(htmlStr);
        System.out.println(result);
    }

    @Test
    public void forDate() {
        System.out.println(DateUtils.formatDate(Calendar.getInstance().getTime(), "yyyy-MM-dd HH:mm:ss"));
    }
}
