<!--s-->
## Test-Driven-Development (TDD)

<!--v-->
### Ziel

* klassische Entwicklung eines Systems erreicht nur unzureichende Testabdeckung:
  * Tests werden parallel zum System entwickelt
  * es besteht Zeit-/Kostendruck
  * Testerstellung wird als erstes gestrichen
* TDD durchbricht den Zyklus durch die Bedingung: schreibe erst den Test, dann den Produktivcode

<!--v-->
### Vorgehensweise

* Entwicklung von Test- und Produktivcode stets parallel
* in Mikroiterationen: Red-Green-Refactor
  * Red: Definiere einen Test für das neue Verhalten. Dieser Test muss zwangsweise fehlschlagen.
  * Green: Ändere den Produktivcode minimal, sodass der Test durchläuft.
  * Refactor: Entferne Duplikationen, abstrahiere wo nötig, richte ihn nach den verbindlichen Code-Konventionen. Es darf kein neues Verhalten eingeführt werden.
* eine Iteration in der Regel wenige Minuten

<!--v-->
### Vorgehensweise
![](https://fmansoblog.files.wordpress.com/2016/02/tdd-circle-of-life.png)

<!--v-->
### Zusatzaufwand

* Hauptaufwand während Sw-Entwicklung liegt bei der Erarbeitung einzelner zu erfüllender Punkte bzw. Fälle (nicht im Tippen von Code)
* an diesem Punkt, vor der Programmierung, ist der Aufwand zur Erstellung von UnitTests sehr gering
* zusätzlich tendiert Code zur:
  * besseren gedanklichen Strukturierung
  * stärkeren Modularisierung
  * Fokussierung auf Kundennutzenstiftende Funktionalität (YAGNI)
  * höheren Test-Abdeckung

<!--v-->
### Zusatzaufwand
* je langlebiger das System, desto höher die Ersparnis durch geringeren Wartungsaufwand, da:
  * einzelne Anforderungen nicht aus Code heraus analysiert werden müssen
  * vergleichbare Testabdeckung wie bei TDD nur mit hohem Aufwand möglich

<!--v-->
### Nachteile

* TDD benötigt:
  * Training
  * Disziplin

<!--v-->
### 5. Übung
