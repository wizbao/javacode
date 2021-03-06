package stringtest;

/**
 * @author hey
 * @creat 2020-05-11-9:20
 */
public class CountAndSayTest {
    public String countAndSay(int n) {
        String str="1";
        for (int i = 2; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count=1;
            for (int j = 1; j < str.length(); j++) {
                char cur = str.charAt(j);
                if (cur == pre) {
                    count++;
                }else{
                    builder.append(count).append(pre);
                    pre=cur;
                    count=1;
                }
            }
            builder.append(count).append(pre);
            str = builder.toString();
        }
        return str;
    }
}
