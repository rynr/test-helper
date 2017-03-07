package org.rjung.util.helper;

import java.security.SecureRandom;

public class RandomValues {

  private static final SecureRandom RANDOM = new SecureRandom();
  private static final char[] SYMBOLS =
      "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();

  private RandomValues() {
    // prevent initialization
  }

  /**
   * Returns the next pseudorandom, uniformly distributed {@code int} value from a
   * {@link SecureRandom} random number generator's sequence. The general contract of
   * {@code randomtInt} is that one {@code int} value is pseudorandomly generated and returned. All
   * 2<sup>32</sup> possible {@code int} values are produced with (approximately) equal probability.
   */
  public static int randomInt() {
    return RANDOM.nextInt();
  }

  /**
   * Returns a pseudorandom, uniformly distributed {@code int} value between 0 (inclusive) and the
   * specified value (exclusive).
   */
  public static int randomInt(final int maxInt) {
    return RANDOM.nextInt(maxInt);
  }

  /**
   * Returns the next pseudorandom, uniformly distributed {@code long} value from a
   * {@link SecureRandom} random number generator's sequence. The general contract of
   * {@code nextLong} is that one {@code long} value is pseudorandomly generated and returned.
   */
  public static long randomLong() {
    return RANDOM.nextLong();
  }

  public static String randomString(final int length) {
    if (length < 1)
      throw new IllegalArgumentException("length < 1: " + length);

    char[] buf = new char[length];
    for (int i = 0; i < length; ++i)
      buf[i] = SYMBOLS[randomInt(SYMBOLS.length)];

    return new String(buf);
  }

  /**
   * Returns one {@link Enum}-value of a given {@link Enum}-class uniformly distributed between the
   * different values.
   * 
   * @param klazz
   * @return
   */
  public static <T extends Enum<T>> T randomEnum(final Class<T> klazz) {
    return klazz.getEnumConstants()[randomInt(klazz.getEnumConstants().length)];
  }
}
