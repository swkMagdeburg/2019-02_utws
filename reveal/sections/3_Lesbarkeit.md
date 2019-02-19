<!--s-->
## Lesbarkeit von Tests

<!--v-->
### Dirty Tests

* sind schwer wartbar
* macht Produktiv-Code umso schwerer wartbar, denn Tests müssen zusammen mit diesem gepflegt werden
* typisches Symptome:
  * viele gleiche Tests mit nur subtilen Änderungen
  * ein Refactoring verursacht viele fehlschlagende Tests

<!--v-->
### Test-Code ist wichtiger als Produktivcode

* Produtktivcode lässt sich aus Tests wieder herstellen
* umgekehrt aber Testcode nicht aus dem Produktivcode
* dokumentieren unser System
* verifizieren Korrektheit des Codes
* unterstützen das Design
* geben Sicherheit für Refactoring und fachl. Änderungen

<!--v-->
### Halte deine Tests sauber

* folgl. für Tests gelten dieselben Code-Standards wie für Produktivcode:
  * lesbar
  * verständlich
  * flexibel
  * **keine** Duplikationen
* QualityDataServiceImplUnitTest

<!--v-->
### Nutze statische Imports

```java
public ChildTest {
  @Test
  public void testChild(){
    Assert.assertTrue(new Child().giveLolly().isHappy());
  }
}
```

```java
import static org.junit.jupiter.api.Assertions.*;

public ChildTest {
  @Test
  public void testChild(){
    assertTrue(new Child().giveLolly().isHappy());
  }
}
```
<!-- .element: class="fragment" data-fragment-index="2" -->

<!--v-->
### Vertausche nicht expected und actual
```java
List<String> limos = new ArrayList<String>("Bionade");
assertEquals(limos.get(0), "Apfelschorle");
```
```
org.opentest4j.AssertionFailedError:
Expected :Bionade
Actual   :Apfelschorle
```
<!-- .element: class="fragment" data-fragment-index="2" -->

<!--v-->
### Nutze prägnante Testnamen

![](img/jenkins.png)

<!--v-->
### Nutze prägnante Testnamen

* Bezeichner des Behavior-Driven-Design (BDD)
  * Given-When-Then/Should
  * in der Regel genutzt um natürlichsprachliche fachliche Testfälle zu definieren
  * aber unterstützen Verständlichkeit der Testnamen

<!--v-->
### Nutze prägnante Testnamen
```java
public ChildTest {
  @Test
  public void testLolly(){
    Child child = new Child();   // given
    child.giveLolly();           // when
    assertTrue(child.isHappy()); // then should be happy
  }
}
```

<!--v-->
### Nutze prägnante Testnamen
```java
public ChildTest {
  @Test
  public void givenAChildWhenGettingALollyThenItShouldBeHappy(){
    assertTrue(new Child().giveLolly().isHappy());
  }
}
```

<!--v-->
### Nutze prägnante Testnamen
```java
public ChildTest {
  @Test
  public void testGettingLollyShouldBeHappy(){
    assertTrue(new Child().giveLolly().isHappy());
  }
}
```

<!--v-->
### Nutze prägnante Testnamen
```java
public KindTest {
  @Test
  public void testBekommtSchokoladeUndIstGluecklich(){
    assertTrue(new Kind().gibSchokolade().istGluecklich());
  }
}
```

<!--v-->
### Fange keine Exceptions im Test

```java
@Test
public void testFailEnsureNoSchema() throws Exception
{
  for (Object[] testData : getFailEnsureNoSchemaTestData())
  {
    String query = (String) testData[0];
    try
    {
      SqlQueryPatternAuthorizer.ensureNoSchema(query, SCHEMAS);
      assertTrue(query, false);
    }
    catch (IllegalSqlQueryExecutorException isqee)
    {
        // Test erfolgreich
    }
  }
}
```

<!--v-->
### Fange keine Exceptions im Test

```java
@Parameterized("getFailEnsureNoSchemaTestData")
@Test(expected = IllegalSqlQueryExecutorException.class)
public void testFailEnsureNoSchema(String query) throws Exception
{
  SqlQueryPatternAuthorizer.ensureNoSchema(query, SCHEMAS);
}
```

<!--v-->
### Initialisiere Tests möglichst lokal
```java
class Child {
  private Lolly lolly;

  @Before
  void init(){ this.lolly = new Lolly("Strawberry"); }

  @Test
  void testChildGetsLolly(){
    new Child().giveLolly(this.lolly);
  }
}
```

<!--v-->
### Initialisiere Tests möglichst lokal
```java
class Child {
  private LollyDb lollydb;

  @Before
  void init(){
    this.lollydb = new LollyDb("Strawberry");
    lollydb.insert("Strawberry", "Cherry", "Nut");
  }

  @Test
  void testChildGetsLolly(){
    Child child = new Child();
    child.giveLolly(lollydb.remove("Strawberry"));
    assertFalse(lollyDb.contains("Strawberry"));
    assertTrue(child.isHappy());
  }
}
```

<!--v-->
### Definiere mehrere Testklassen für eine Produktivklasse

```java
public class ChildGirlTest { /* ... */ }
public class ChildBoyTest { /* ... */ }
```

<!--v-->
### Nutze nur eine Assertion je Test

```java
class Child {
  private LollyDb lollydb;

  @Before
  void init(){
    this.lollydb = new LollyDb("Strawberry");
    lollydb.insert("Strawberry", "Cherry", "Nut");
  }

  @Test
  void testChildGetsLollyShouldBeHappy (){
    Child child = new Child();
    child.setGender(Gender.GIRL);
    child.giveLolly(lollydb.remove("Strawberry"));
    assertFalse(lollyDb.contains("Strawberry"));
    assertTrue(child.isHappy());
    assertEquals(Gender.GIRL, child.getGender());
  }
}
```

<!--v-->
### Nutze nur eine Assertion je Test: Ausnahmen bestätigen die Regel

* Nutze mehrere Assertions nur dann, wenn die Parameter voneinander abhängig sind

```java
@Test
void testChildGetsGenderChangingLollyMakesItHappy(){
  Child child = new Child();
  child.setGender(Gender.GIRL);
  child.giveLolly(lollydb.remove("GenderChangingLolly"));
  assertAll(
    () -> assertTrue(child.isHappy()),
    () -> assertEquals(Gender.BOY, child.getGender())
  )
}
```

MarketValuesParserTest 0a548207ed13

<!--v-->
### Nutze Parametrisierung von Tests

```java
class ParametrizedTest
{
  static Stream<Arguments> provideParseValues() {
    return Stream.of(
        Arguments.of("5", 5),
        Arguments.of("-5", -5),
        Arguments.of("0", 1)
    );
  }

  @DisplayName("tests parsing of Integers")
  @ParameterizedTest(name = "Test #{index}: {0} should be {1}")
  @MethodSource("provideParseValues")
  void testValue(String in, int expected){
    assertEquals(expected, Integer.parseInt(in));
  }
}
```

<!--v-->
### Bilde fachliche Anforderungen als Test ab

> Für Kunden vom Typ privat soll im Fall, dass keine Anrede zur Verfügung steht, das Mapping ohne Anrede und mit Sortname im Nachnamen erstellt werden

```java
@Test
void testPrivatkundeOhneAnredeNutztSortnameAlsMapping() {
  /*...*/
}
```

[PersonenMappingTest](https://confluence.eudemonia-solutions.de/pages/viewpage.action?pageId=70453289)

<!--v-->
### 3. Übung - GildedRose

<small>

* Ziel: verfasse entsprechend der fachlichen Anforderungen UnitTests
* Item = SellIn: Ablaufdatum, Quality: Wertigkeit
* Mit jedem Tag wird verringert sich der Wert
* Nach Ablaufdatum verringert sich die Qualität doppelt so schnell
* die Qualität ist nie negativ
* "Aged Brie" erhöht seine Qualität je älter er wird
* die Qualität ist nie über 50
* "Sulfuras" ist ein Legendary-Item, muss nie verkauft werden und verringert nie seine Qualität
* "Backstage passes", steigt in seiner Qualität, je näher es dem Ablaufdatum kommt:
    * Qualität steigt innerhalb der letzten 10 Tage um das Doppelte
    * Qualität steigt innerhalb der letzten 5 Tage um das 3-fache
    * Qualität ist sofort nach dem Konzert 0

</small>
