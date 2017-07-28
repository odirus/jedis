package redis.clients.jedis;

/**
 * Created by huangjing
 * Created on 2017/7/28
 */
public class ConnectionOption {
    // optimize eval script, turn off default
    private boolean optimizeEval = false;

    public void setOptimizeEval(boolean optimizeEval) {
        this.optimizeEval = optimizeEval;
    }

    public boolean getOptimizeEval() {
        return optimizeEval;
    }
}
