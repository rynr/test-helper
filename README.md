test-helper
===========

I like using random values for tests. So I wrote the methods for random values
quite often. Now i started this library to not write it again and again.

example
-------

``` java
@Test
public void testSomethingWithARandomValue() {
    int randomIntFullIntegerRange = RandomValues.randomInt();
    int randomPositiveIntWithMax = RandomValues.randomInt(15);
    ExampleEnum randomEnumValue = RandomValues.randomEnum(ExampleEnum.class);
    // ...
}
```

links
-----


 - [Info](https://rynr.github.io/test-helper/)
 - [Github](https://github.com/rynr/test-helper)
 - [Bugs](https://github.com/rynr/test-helper/issues)
 - [Documentation](https://javadoc.io/doc/org.rjung.util/test-helper)
 - [![Build Status](https://travis-ci.org/rynr/test-helper.svg?branch=master)](https://travis-ci.org/rynr/test-helper)

