package org.rjung.util.helper;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class RegexMatcher extends TypeSafeMatcher<String> {

  private final String regex;

  public RegexMatcher(final String regex) {
    this.regex = regex;
  }

  public void describeTo(Description description) {
    description.appendText("matches regular expression=`" + regex + "`");
  }

  @Override
  public boolean matchesSafely(final String string) {
    return string.matches(regex);
  }

  // matcher method you can call on this matcher class
  public static RegexMatcher matchesRegex(final String regex) {
    return new RegexMatcher(regex);
  }
}
