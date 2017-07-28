package redis.clients.jedis;

import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by huangjing
 * Created on 2017/7/28
 */
public class ScriptCacheKey {
    private byte[] md5;

    ScriptCacheKey(byte[] md5) {
        this.md5 = md5;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(md5).build();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScriptCacheKey) {
            return obj.hashCode() == hashCode();
        }

        return super.equals(obj);
    }
}
