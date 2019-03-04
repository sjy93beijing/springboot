package com.sjy.springboot;

import com.dianping.pigeon.remoting.common.codec.json.JacksonUtils;
import com.sjy.springboot.model.TestDao;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author sjy on 2018/12/27
 * @version 1.0
 */
public class TestString {

    private static String  temptype="剧情 古装 武侠 家庭 爱情 喜剧 战争 惊悚 悬疑 科幻 奇幻 历史 动画 动作 真人秀 传记 犯罪 运动 纪录片 偶像 都市 言情 青春 宫廷 年代 伦理 罪案 警匪 军旅 神话 穿越 农村 谍战 商战 权谋 玄幻 情景 少儿";
    private static  String OTHERS = "其它";




    @Test
    public void findCommonString() {
        String[] types ={"电视剧,神话,古装,爱情,奇幻,偶像,剧情","电视剧,爱情,言情,剧情,都市","电视剧,剧情,爱情","电视剧,剧情","电视剧","电视剧,爱情"};
        List<String> str = new ArrayList<>();
        str.add("电视剧,神话,古装,爱情,奇幻,偶像,剧情");
        str.add("电视剧,爱情,言情,剧情,都市");
        str.add("电视剧,剧情,爱情");
        str.add("电视剧,剧情,动画");
        str.add("电视剧,剧情,古装,偶像,宫廷");
        str.add("电视剧,剧情");
        str.add("电视剧");
        str.add("电视剧,爱情");
        String newStr = "剧情 古装 武侠 家庭 爱情 喜剧 战争 惊悚 悬疑 科幻 奇幻 历史 动画 动作 真人秀 传记 犯罪 运动 纪录片 偶像 都市 言情 青春 宫廷 年代 伦理 罪案 警匪 军旅 神话 穿越 农村 谍战 商战 权谋 玄幻 情景 少儿\";";
        Map<String, Object> map = new HashMap<String, Object>();
        for (int i = 0; i < str.size(); i++) {
//            System.out.println(str.get(i));
            String movieType = findTV(str.get(i));
            System.out.println(movieType);
        }

    }

    private  static String  findTV(String temp) {
    String[] sts = temp.split(",");
        String result = OTHERS ;
        for (int j = 0; j < sts.length; j++) {

            //最后发现数据读不进去是因为前面取数的时候，取少了，现在应该把前面的数都取进去的，最后就对了
            if(isExist(sts[j])){
                //如果这个里面包括这个数，就是说排除了电视剧，都是想要的
                //如果是包括剧情的则取下一个数，直到结束为止。
                if(sts[j].equals("剧情")){
                    if(j==sts.length-1)
                        result = "剧情";
                }else {
                    //如果是到了最后一步，就变成剧情
                    result = sts[j];
                    break;
                }

            }

        }
        return result;
    }

    //判断是否存在字符串,存在即返回true
    private static Boolean isExist(String st) {
        Boolean flag = false;
        if(st==null)
            return flag;
        if(temptype.contains(st)){
            flag = true;
        }
        return flag;
    }
    @Test
    public void testHashMap(){


        String searchKeyword;
        String keyword = "三国杀:三国杀2";
        String newKeyword = keyword.split(" ")[0];
        if (newKeyword.contains("：")) {
            if (Character.isDigit(keyword.charAt(newKeyword.indexOf('：') - 1))) {
                newKeyword = keyword.substring(0, newKeyword.indexOf("："));
            }
        }
        searchKeyword = newKeyword.replaceAll("[\\pP\\p{Punct}]", StringUtils.EMPTY);

        System.out.println(searchKeyword);
        String s = 5>6 ? "盛俊阳":"liss";
        System.out.println(s);
        int cac = 3>>> 16;
        System.out.println(cac);
        String str = "{\"军旅\":24,\"喜剧\":130,\"青春\":4,\"科幻\":18,\"少儿\":2,\"其它\":38,\"运动\":3,\"罪案\":1,\"偶像\":26,\"言情\":17,\"犯罪\":7,\"警匪\":2,\"商战\":2,\"动画\":85,\"传记\":8,\"纪录片\":68,\"惊悚\":6,\"奇幻\":16,\"年代\":10,\"穿越\":2,\"历史\":13,\"悬疑\":104,\"古装\":141,\"真人秀\":1,\"神话\":1,\"都市\":26,\"剧情\":194,\"武侠\":12,\"爱情\":230,\"家庭\":75,\"战争\":30,\"动作\":49,\"农村\":1}";
        char[] c = str.toCharArray();
        int count=0;
        for(int i = 0; i < c.length; i ++)
        {
            String len = Integer.toBinaryString(c[i]);
            if(len.length() > 8)
                count ++;
        }
        System.out.println(count);
    }


}