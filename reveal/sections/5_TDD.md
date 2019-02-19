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

*  parallele Entwicklung Test- und Produktivcode
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

* Hauptaufwand während Sw-Entwicklung liegt bei der Erarbeitung einzelner zu erfüllender Punkte bzw. Fälle (nicht im Tippen vom Code)
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
### 5. Übung - String-Rechner

<small>

1. Ein leerer String liefert 0
2. Eine einzelne Ziffer liefert den eigenen Wert
3. Zwei Ziffern kommasepariert liefern die Summe
4. Zwei Ziffern durch newline getrennt liefern die Summe
5. Drei Ziffern, durch Komma oder newline getrennt, liefern die Summe
6. Negative Ziffern werfen eine Exception
7. Ziffern größer als 1000 werden ignoriert
8. Auf der ersten Zeile kann ein einzelnes Zeichen als 'delimiter' in der Form '//#' für bspw. '#' angegeben werden
9. Auf der ersten Zeile kann eine Zeichenfolge als delimter in eckigen Klammern angegeben werden ('//[###]' bspw. für '###')
10. Auf der ersten Zeile können beliebig viele Zeichen bzw. Zeichenfolgen als delimiter angegeben werden (jedes in eckigen Klammern angegeben)

</small>
