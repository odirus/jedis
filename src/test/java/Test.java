import redis.clients.jedis.ConnectionOption;
import redis.clients.jedis.Jedis;

/**
 * Created by huangjing
 * Created on 2017/7/28
 */
public class Test {
    public static void main(String[] args) {
        ConnectionOption option = new ConnectionOption();
        option.setOptimizeEval(true);
        Jedis jedis = new Jedis("10.0.0.12", 6379, option);
        jedis.auth("test");
        for (int i = 0; i < 10; i++) {
            System.out.println(jedis.eval("return {KEYS[1],KEYS[2],ARGV[1],ARGV[2]}", 2, "str-1", "str-2"));
        }
    }
}
