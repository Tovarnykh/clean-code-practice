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
```
╔═══════════════════════════════╗
║Select which Program to execute║
╠───────────────────────────────╣
║1 - Anagrams                   ║
║2 - IntegerDivision            ║
║3 - CharsCounter               ║
║                               ║
║? - Any symbol to Exit         ║
╚═══════════════════════════════╝
 >1
╔═════════════════════════╗
║Insert a word or sentence║
╟─────────────────────────╢
 in:h.e!ll0o W...orld!
 out:o.l!le0h d...lroW!
╚═════════════════════════╝
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
╔═══════════════════════════════╗
║Select which Program to execute║
╠───────────────────────────────╣
║1 - Anagrams                   ║
║2 - IntegerDivision            ║
║3 - CharsCounter               ║
║                               ║
║? - Any symbol to Exit         ║
╚═══════════════════════════════╝
 >2
╔═══════════════════════════╗
║Insert dividend and divisor║
╟───────────────────────────╢
║      Insert dividend      ║
 >140
║      Insert divisor       ║
 >5
╚═══════════════════════════╝

_140|5
 10 |--
 -- |28
 _40
  40
  --
   0
```

## Task 1.4 Collection Framework

**Assignment**:

Write a char-counter application  that takes a string and returns the number of unique characters in the string.

It is expected that a string with the same character sequence may be passed several times to the method.

Since the counting operation can be time-consuming, the method should cache the results, so that when the method is given a string previously encountered, it should return the result from the cache.

Use collections and maps where appropriate.

**Example**:
```
╔═══════════════════════════════╗
║Select which Program to execute║
╠───────────────────────────────╣
║1 - Anagrams                   ║
║2 - IntegerDivision            ║
║3 - CharsCounter               ║
║                               ║
║? - Any symbol to Exit         ║
╚═══════════════════════════════╝
 >3
╔═════════════════════════╗
║Insert a word or sentence║
╟─────────────────────────╢
 in:Hello World

 'h' - 1
 'e' - 1
 'l' - 3
 'o' - 2
 ' ' - 1
 'w' - 1
 'r' - 1
 'd' - 1
 
 in:exit

╚═════════════════════════╝
```

## Task 1.5 Java Streams API

**Assignment**:

Write a Formula 1 application. 

There are 2 log files ‘start.log’ and ‘end.log’ that contain start and end data of the best lap for each racer of Formula 1 - Monaco 2018 Racing. (Start and end times are fictional, but the best lap times are true). Data contains only the first 20 minutes that refers to the first stage of the qualification

Q1: For the first 20 minutes (Q1), all cars together on the track try to set the fastest time. The slowest seven cars are eliminated, getting the bottom grid positions. Drivers are allowed to complete as many laps as they want during this short period of time.

**Example**:
```
╔═══════════════════════════════╗
║Select which Program to execute║
╠───────────────────────────────╣
║1 - Anagrams                   ║
║2 - IntegerDivision            ║
║3 - CharsCounter               ║
║4 - FormulaOne Leader Board    ║
║                               ║
║? - Any symbol to Exit         ║
╚═══════════════════════════════╝
 >4
╔═════════════════════════╗
║Insert file paths for:   ║
║   Start.log  End.log    ║
║   abbreviations.txt     ║
╟─────────────────────────╢
start.log>**\start.log
end.log>**\end.log
abbreviations.txt>**\abbreviations.txt
╚═════════════════════════╝
Loading Files....

╔═══════════════════════════════════════════════════════════════╗
║                           Formula  One                        ║
║                           Leader Board                        ║
╟───────────────────────────────────────────────────────────────╢
 1. Sebastian Vettel     | FERRARI                   | 01:04.415
 2. Daniel Ricciardo     | RED BULL RACING TAG HEUER | 01:12.013
 3. Valtteri Bottas      | MERCEDES                  | 01:12.434
 4. Lewis Hamilton       | MERCEDES                  | 01:12.460
 5. Stoffel Vandoorne    | MCLAREN RENAULT           | 01:12.463
 6. Kimi Raikkonen       | FERRARI                   | 01:12.639
 7. Fernando Alonso      | MCLAREN RENAULT           | 01:12.657
 8. Sergey Sirotkin      | WILLIAMS MERCEDES         | 01:12.706
 9. Charles Leclerc      | SAUBER FERRARI            | 01:12.829
10. Sergio Perez         | FORCE INDIA MERCEDES      | 01:12.848
11. Romain Grosjean      | HAAS FERRARI              | 01:12.930
12. Pierre Gasly         | SCUDERIA TORO ROSSO HONDA | 01:12.941
13. Carlos Sainz         | RENAULT                   | 01:12.950
14. Esteban Ocon         | FORCE INDIA MERCEDES      | 01:13.028
15. Nico Hulkenberg      | RENAULT                   | 01:13.065
----------------------------------------------------------------
17. Marcus Ericsson      | SAUBER FERRARI            | 01:13.265
18. Lance Stroll         | WILLIAMS MERCEDES         | 01:13.323
19. Kevin Magnussen      | HAAS FERRARI              | 01:13.393
╚═══════════════════════════════════════════════════════════════╝
```