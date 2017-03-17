package org.rjung.util.helper;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.rjung.util.helper.RegexMatcher.matchesRegex;

public class RandomValuesTest {

  private static final String VALID_EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
  private final int REPEAT = 100;
  private final String VALID_DOMAIN_REGEX =
      "^(([a-zA-Z]{1})|([a-zA-Z]{1}[a-zA-Z]{1})|([a-zA-Z]{1}[0-9]{1})|([0-9]{1}[a-zA-Z]{1})|([a-zA-Z0-9][a-zA-Z0-9-_]{1,61}[a-zA-Z0-9]))\\.([a-zA-Z]{2,6}|[a-zA-Z0-9-]{2,30}\\.[a-zA-Z]{2,3})$";
  private final String VALID_LETTER_REGEX = "^[a-zA-Z]{1,}$";

  @Test
  public void verifyRandomBooleanSucceeds() {
    for (int i = 0; i < REPEAT; i++) {
      RandomValues.randomBoolean();
    }
  }

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
  public void verifyRandomLongSucceeds() {
    for (int i = 0; i < REPEAT; i++) {
      RandomValues.randomLong();
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void verifyRandomStringFailsWithNegativeValue() {
    final int length = -1 - RandomValues.randomInt(99999);

    RandomValues.randomString(length);
  }

  @Test(expected = IllegalArgumentException.class)
  public void verifyRandomStringFailsWithValue0() {
    RandomValues.randomString(0);
  }

  @Test
  public void verifyRandomStringHasRightLength() {
    for (int i = 0; i < REPEAT; i++) {
      final int length = RandomValues.randomInt(99999) + 1;

      String result = RandomValues.randomString(length);

      assertThat(result.length(), is(length));
    }
  }

  @Test(expected = IllegalArgumentException.class)
  public void verifyRandomLetterStringFailsWithNegativeValue() {
    final int length = -1 - RandomValues.randomInt(99999);

    RandomValues.randomLetterString(length);
  }

  @Test(expected = IllegalArgumentException.class)
  public void verifyRandomLetterStringFailsWithValue0() {
    RandomValues.randomLetterString(0);
  }

  @Test
  public void verifyRandomLetterStringHasRightLengthAndConsistsOfLetters() {
    for (int i = 0; i < REPEAT; i++) {
      final int length = RandomValues.randomInt(99999) + 1;

      String result = RandomValues.randomLetterString(length);

      assertThat(result.length(), is(length));
      assertThat(result, matchesRegex(VALID_LETTER_REGEX));
    }
  }

  @Test
  public void verifyRandomUsernameIsInLengthRange() {
    for (int i = 0; i < REPEAT; i++) {
      String result = RandomValues.randomUsername();

      assertThat(result.length(), greaterThanOrEqualTo(2));
      assertThat(result.length(), lessThanOrEqualTo(12));
    }
  }

  @Test
  public void verifyRandomDomainValidates() {
    for (int i = 0; i < REPEAT; i++) {
      String result = RandomValues.randomDomain();

      assertThat(result, matchesRegex(VALID_DOMAIN_REGEX));
    }
  }

  @Test
  public void verifyRandomEmailValidates() {
    for (int i = 0; i < REPEAT; i++) {
      String result = RandomValues.randomEmailAddress();

      assertThat(result, matchesRegex(VALID_EMAIL_REGEX));
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
