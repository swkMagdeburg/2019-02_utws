---
title: UnitTests
separator: <!--s-->
verticalSeparator: <!--v-->
theme: solarized
highlight-theme: monokai
css: custom.css
revealOptions:
  controls: false
  slideNumber: false
  transition: 'slide'
  backgroundTransition: 'fade'
---

# UnitTests

<!--s-->
<!-- .slide: data-background="https://media.giphy.com/media/eekKdgXhvESIM/giphy.gif"-->
# Commercials

<!--s-->
## Tests allgemein

* Wenn wir ein Auto auf ein Prüfstand schieben, dann ist das Ziel:
  * die Übereinstimmung des Fahrzeugs mit seiner Spezifikation zu überprüfen
  * Einhaltung gesetzlicher Grenzwerte
Dazu Testfälle definiern, die Funktionsumfang und Grenzwerte sicherstellen:
  * Rahmenbedingungen definieren
  * Eingangswerte
  * Ausgangswerte

<!--v-->
## Unit-Tests

* Testgegenstand ist eine Methode, Klasse oder Komponente (Verbund von Klassen)
* definieren Rahmenbedingungen (über korrekte Initialisierung)
* definieren unterschiedliche Eingangswerte
  * können fachlich vorgegeben sein
* definieren zu jedem Eingangswert unseren Erwartungswert
* stellen sicher, dass Erwartungswerte mit realen Werten übereinstimmen

<!--v-->
## Beispiel für UnitTest
```kotlin
fun main(args : Array<String>) {
  println("Hello World")
}
```

<!--v-->
## 1. Praxisübung - schreiben einfacher Tests

<!--v-->
## Kotlin kann ...
* Extension functions <span class="fragment" data-fragment-index="2">(geklaut aus C#)</span>
* Builder <span class="fragment" data-fragment-index="3">(geklaut aus Groovy)</span>
* Operator Overloading <span class="fragment" data-fragment-index="4">(geklaut aus C)</span>
* Lambdas <span class="fragment" data-fragment-index="5">(Python, C#, LISP, Perl, ...)</span>
* Delegation <span class="fragment" data-fragment-index="6">(wahrscheinlich auch geklaut)</span>
* default non-null und Nullable-Operator '`?`'
* implizite Typisierung
* data classes (value types)
* Semikolons sind optional <!-- .element: class="fragment" data-fragment-index="8" -->
* Coroutines, Inline Functions, usw. ... <!-- .element: class="fragment" data-fragment-index="7" -->

<!--s-->
# Warum der Stress

<!--v-->
* Regressionstest:
  * Wiederholung von Testfällen
  * sicherzustellen, dass Modifikationen in bereits getesteten Teilen der Software keine neuen Fehler („Regressionen“) verursachen.
  * entstehen aufgrund der Pflege, Änderung und Korrektur von Software
  * wesentlich häufiger als bei einem Toaster

<!--v-->
# Sicherheit beim Refactoring  

<!--v-->
## Was nicht getestet wird

* Verhalten ausserhalb der Rahmenbedingungen
  * Arbeitet der Toaster bei hohen G-Kräften
  * Wir können nicht alle Fehler/Fremdnutzungen vorhersehen
* wenn wir es versuchten, hätten wir einen Großteil unsinniger Tests
  * wir für die [Erwärmung von Katzen](https://de.wikipedia.org/wiki/Haustier_in_der_Mikrowelle)
  * Vorsicht: Inhalt könnte heiß sein

<!--v-->
## 2. Praxisübung - Refactoring

* eine Gruppe mit existierenden Tests
* eine Gruppe ohne existierende Tests

<!--s-->
# Lesbarkeit von Tests

* Negativ-Beispiele: QualityDataServiceImplTest, Erics Test
  * mehrere Testfälle in einer Methode
  * sich wiederholender Code in der Initialisierung
  * schwierig zu erkennen, welche Eingangswerte zu welchem Ausgangswert führen
  * komplex
* Geben solche UnitTests Vertrauen beim Refactoring? ja, aber weniger
* lassen sich solche Tests warten?
* Untersuchen, warum schwierig lesbar
* jede fachliche Regel ein Test

<!--v-->
## Parametrisierte Tests

<!--v-->
## JUnit4 vs. JUnit5

<!--v-->
## Praxisübung

<!--s-->
# Isolieren von Tests mit Mockito
* JMOck gegenüberstellen, aber nicht behandeln

## Stub

## Spy

## Singletons und statische Methoden

<!--s-->
# Test-Driven-Development

* Zuerst die Tests
* Dann die Entwicklung
