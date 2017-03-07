package org.rjung.util.helper;

import org.junit.Test;

import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;

public class RandomValuesTest {

  private final int REPEAT = 100;

  @Test
  public void verifyRandomIntSucceeds() {
    for (int i = 0; i < REPEAT; i++) {
      RandomValues.randomInt();
    }
  }

  @Test
  public void verifyRandomIntWithMaximumDoesNotExceedLimits() {
    for (int i = 0; i < REPEAT; i++) {
      int testMax = Math.abs(RandomValues.randomInt());

      int result = RandomValues.randomInt(testMax);

      assertThat("Expected value lower than " + testMax + ", but received " + result, result,
          lessThan(testMax));
      assertThat("Expected value greater or equal to 0, but received " + result, result,
          greaterThanOrEqualTo(0));
    }
  }

  @Test
  public void verifyRandomEnumSucceeds() {
    for (int i = 0; i < REPEAT; i++) {
      RandomValues.randomEnum(TestEnum.class);
    }
  }

  private enum TestEnum {
    ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE
  }
}
