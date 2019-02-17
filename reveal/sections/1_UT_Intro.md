<!--s-->
## Warum testen wir?

<!--v-->
### Ein Auto auf dem Rollenprüfstand
<ul>
<li class="fragment" data-fragment-index="1">Tuner: die Leistung seines Fahrzeugs feststellen</li>
<li class="fragment" data-fragment-index="2">TÜV: Feststellen der Farbe des Aufklebers für die Windschutzscheibe</li>
<li class="fragment" data-fragment-index="3">Hersteller: sicherstellen das die vom Kraftfahrbundesamt/der EU vorgegebenen Spezifikationen eingehalten werden</li>
</ul>

<!--v-->
### Warum testen wir?
<ol>
<li class="fragment" data-fragment-index="1">Systematische Ermittlung der Fähigkeiten eines Testgegenstandes</li>
<li class="fragment" data-fragment-index="2">Übereinstimmung des Testgegenstandes mit einer Spezifikation sicherstellen</li>
</ol>

<!--v-->
### Wie wird getestet?

<div id="left">

Definieren von:
<ul>
  <li>Rahmenbedingungen</li>
  <li>Eingangswerte</li>
  <li>erwartete Ausgangswerte</li>
</ul>

</div>

<div id="right">

```puml
left to right direction

node "component\nto be tested" as sut
card a
card b
card c

a --> sut
b --> sut
sut --> c
```

</div>

<!--v-->
### Unit-Tests

* Testgegenstand ist eine Methode, Klasse oder Komponente (Verbund von Klassen)
* definieren unterschiedliche Testfälle
  * können fachlich vorgegeben sein
  * je Testfall Erwartungswert
  * je Testfall Rahmenbedingungen (über korrekte Initialisierung)
* stellen sicher, dass Erwartungswerte mit realen Werten übereinstimmen

<!--v-->
### Beispiel für UnitTest
```java
class ArrayListTest {
  @Test
  void testArrayListContains() {
    // Eingangswerte und Erwartungswert definieren
    List<String> in = Arrays.asList("Auto", "Brot", "Fuß")
    final boolean expected = true;

    // Rahmenbedingungen definieren und Test durchführen
    final List<String> sut = new ArrayList<>(
            Arrays.asList("Auto", "Brot", "Fuß"));
    final boolean containsBrot = sut.contains("Brot");

    // Spezifikation sicherstellen
    assertEquals(expected, containsBrot);
  }
}
```

<!--v-->
### Beispiel für UnitTest
```java
class ArrayListTest {
  @Test
  void testArrayListContains() {
    final List<String> sut = new ArrayList<>(
            Arrays.asList("Auto", "Brot", "Fuß"));
    assertTrue(sut.contains("Brot"));
  }
  @Test
  void testArrayListDoesNotContain() {
    final List<String> sut = new ArrayList<>(
            Arrays.asList("Auto", "Brot", "Fuß"));
    assertFalse(sut.contains("Blumen"));
  }
}
```

<!--v-->
### 1. Übung - schreiben einfacher Tests

* [https://github.com/gaerfield/2019-02_utws](https://github.com/gaerfield/2019-02_utws)
* 20min
  * Ziel: Projekt aufsetzen und mit UnitTests vertraut machen
  * gradle-Projekt in IDE importieren
* Projekt "1_Toaster"
  * Klasse ArrayListTest suchen und ausführen
  * Klasse ToasterTest suchen und Tests implementieren
