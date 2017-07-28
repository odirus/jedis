package redis.clients.util;

import java.io.UnsupportedEncodingException;

import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;

/**
 * The only reason to have this is to be able to compatible with java 1.5 :(
 */
public final class SafeEncoder {
  private SafeEncoder(){
    throw new InstantiationError( "Must not instantiate this class" );
  }

  public static byte[][] encodeMany(final String... strs) {
    byte[][] many = new byte[strs.length][];
    for (int i = 0; i < strs.length; i++) {
      many[i] = encode(strs[i]);
    }
    return many;
  }

  public static byte[] encode(final String str) {
    try {
      if (str == null) {
        throw new JedisDataException("value sent to redis cannot be null");
      }
      return str.getBytes(Protocol.CHARSET);
    } catch (UnsupportedEncodingException e) {
      throw new JedisException(e);
    }
  }

  public static String encode(final byte[] data) {
    try {
      return new String(data, Protocol.CHARSET);
    } catch (UnsupportedEncodingException e) {
      throw new JedisException(e);
    }
  }

  public static int decode(final byte[] data) {
    try {
      return Integer.parseInt(encode(data));
    } catch (NumberFormatException e) {
      throw new JedisException(e);
    }
  }

  /**
   * convert string array to byte array
   *
   * @see <a href="https://stackoverflow.com/questions/14669820/how-to-convert-a-string-array-to-a-byte-array-java">stackoverflow</a>
   *
   * @param strings
   * @return
   */
  public static byte[][] convertToBytes(String[] strings) {
    try {
      byte[][] data = new byte[strings.length][];
      for (int i = 0; i < strings.length; i++) {
        String string = strings[i];
        data[i] = string.getBytes(Protocol.CHARSET);
      }
      return data;
    } catch (UnsupportedEncodingException e) {
      throw new JedisException(e);
    }
  }
}
