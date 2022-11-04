# Clean Code

This project is a honing of coding skills on ***foxminded*** education course, according to **Robert Martin's** Clean Code standards.

It consists of 5 tasks.
* Anagrams
* Unit Tests
* Integer Divisions
* Collection Framework
* Java Streams API

## Task 1.1 Anagrams
### Assignment
Write an application that reverses all the words of input text:

**Examples**:

Each word in the text should be reversed:
**"abcd efgh" => "dcba hgfe"**

All non-letter symbols should stay on the same places:
**"a1bcd efg!h" => "d1cba hgf!e"**

Use only the *Latin* alphabet to test.

**Requirements**:

1. Create an empty Maven project

2. Start with the implementation of a method that reverses only 1 word at a time.

3. (Optional) Add Main (Application) class where you can read console input or hard code it to check yourself.

4. Add a method that splits the string into words and runs the previous method for each word.

5. Make your compiled jar executable, check with 

**Solution**:

This program reads the input and reverse String using the standard string reversal algorithm. This algorithm defines Line boundaries on the *left* and the *right* side, checks whether both characters are letters, if true swaps them.

**Compiling**:

```
mvc package
```
```
java -jar CleanCodeApplication.jar
```

To launch the program **Java11+** requires.

## Task 1.2 Unit tests

**Assignment**:

Pick-up previous task and write JUnit tests for it.

* Use Junit5 dependency

* Tests should run with project build

* Maven surefire plugin

* Use appropriate test methods naming convention (ask Mentor for preferred one)

* Add Sonar lint plugin support to your IDE.

**Compiling**:

```
mvc test
```

## Task 1.3 Integer division

**Assignment**:

Write an integer-division application that divides numbers and prints results into the console. Use maven, and don't forget to cover your code with unit tests.

**Example**:
```
|Enter number to execute|
1 Anagrams
2 IntegerDivision
3 Exit
2
Insert dividend:
20
Insert divisor:
2
_20|2
 2 |--
 - |10
  0
```