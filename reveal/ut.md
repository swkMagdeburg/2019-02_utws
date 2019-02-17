---
title: UnitTests
separator: <!--s-->
verticalSeparator: <!--v-->
theme: solarized
css: custom.css
highlight-theme: solarized-light
revealOptions:
  controls: false
  slideNumber: false
  transition: 'slide'
  backgroundTransition: 'fade'
---

# Unit-Tests

{{sections/1_UT_Intro.md}}
{{sections/2_Refactoring.md}}
{{sections/3_Lesbarkeit.md}}
{{sections/4_Isolierung.md}}
{{sections/5_TDD.md}}


<!--s-->

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
