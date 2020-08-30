<!--s-->
## Warum testen wir?

<!--v-->
### Ein Auto auf dem Rollenprüfstand
* Tuner: die Leistung seines Fahrzeugs feststellen <!-- .element: class="fragment" -->
* TÜV: Feststellen der Farbe des Aufklebers für die Windschutzscheibe <!-- .element: class="fragment" -->
* Hersteller: sicherstellen das die vom Kraftfahrbundesamt/der EU vorgegebenen Spezifikationen eingehalten werden <!-- .element: class="fragment" -->

<!--v-->
### Warum testen wir?
* Systematische Ermittlung der Fähigkeiten eines Testgegenstandes <!-- .element: class="fragment" -->
* Übereinstimmung des Testgegenstandes mit einer Spezifikation sicherstellen <!-- .element: class="fragment" -->

<!--v-->
### Unit Tests
* Testgegenstand ist eine Methode, Klasse oder Komponente (Verbund von Klassen) <!-- .element: class="fragment" -->
* definieren unterschiedliche Testfälle <!-- .element: class="fragment" -->
  * können fachlich vorgegeben sein
  * je Testfall Erwartungswert
  * je Testfall Rahmenbedingungen (über korrekte Initialisierung)
* stellen sicher, dass Erwartungswerte mit realen Werten übereinstimmen <!-- .element: class="fragment" -->

<!--v-->
### Wie wird getestet?

<div id="left">

Definieren von: <!-- .element: class="fragment" data-fragment-index="1" -->
* Rahmenbedingungen <!-- .element: class="fragment" data-fragment-index="1" -->
* Eingangswerte <!-- .element: class="fragment" -->
* erwartete Ausgangswerte <!-- .element: class="fragment" -->

</div>

<div id="right" class="fragment">

```puml
left to right direction

node "System\nUnder\nTest" as sut
card a
card b
card c

a --> sut
b --> sut
sut --> c
```

</div>

<!--v-->
### Beispiele in Java
```java
@Test
public void EncryptShouldHandleEmptyString() {
    // Arrange
    var sut = new Rot13Security();

    // Act
    var actual = sut.Encrypt("");

    // Assert
    assertEquals("", actual);
}
```

```java
@BeforeEach
public void SetUp() {
    _sut = new Rot13Security();
}

@Test
public void EncryptShouldNotShiftSpecialCharacters() {
    var specialCharacters = "01234567890, !§$%&/()=[]{}";
    assertEquals(specialCharacters, _sut.Encrypt(specialCharacters));
}
```

<!--v-->
### Beispiele in C#

```csharp
[Test]
public void EncryptShouldHandleEmptyString()
{
    // Arrange
    var sut = new Rot13Security();

    // Act
    var actual = sut.Encrypt(string.Empty);

    // Assert
    Assert.That(actual, Is.EqualTo(string.Empty));
}
```

```csharp
[Test]
public void EncryptShouldNotShiftSpecialCharacters()
{
    var specialCharacters = "01234567890, !§$%&/()=[]{}";
    Assert.That(_sut.Encrypt(specialCharacters), Is.EqualTo(specialCharacters));
}
```

<!--v-->
<!-- .slide: data-background="img/practice.svg" data-background-size="40%" -->

### Übung - mit Unit Tests vertraut machen

* [swkMagdeburg/UnitTestWorkshop](https://github.com/swkMagdeburg/UnitTestWorkshop)
* Was: Beispielimplementierung der [Function Kata ROT-13](https://ccd-school.de/coding-dojo/function-katas/rot-13/)
* Ziele:
  * Test Runner laufen lassen
  * Struktur von Test- und Produktivcode erkunden
  * Produktiven Code ändern und Tests beobachten
  * Erste eigene Testfälle schreiben 
