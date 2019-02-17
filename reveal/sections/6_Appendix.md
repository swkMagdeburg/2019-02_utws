<!--s-->

<!--v-->
### positive Seiteneffekte

* boolesche Metrik für die Erfüllung der Anforderungen: Tests werden bestanden oder nicht
* geringeres Refactoring-Risiko:
  * in kleinen Schritten
  * stets entlang bestandener Tests
  * dadurch weniger neue, zustäzlich besser lokalisierbarere Fehler.
* Tests definieren das System als korrekt:
  * Konzentration auf die aktuelle Teilaufgabe möglich
  * Keine „Durchquerung der Wüste“, kein „Alles hängt mit allem zusammen“
* bestehende Unit-Tests sind „ausführbare Spezifikation“ und dokumentieren das System

<!--v-->
### positive Seiteneffekte

* Produktivcode mit hoher Testabdeckung tendiert zu "clean" Code:
  * gute Testbarkeit erfordert modularisierten Code (um Testfälle zu reduzieren)
  * modularisierter Code ist in der Regel einfacher wartbar
  * Legacy-Code wird zugunsten der Testbarkeit häufig in kleinere Einheiten aufgebrochen
* Die korrespondierenden Softwareeinheiten (Klassen, Module, …) werden:
  * kleiner,
  * spezifischer,
  * Kopplung wird lockerer
  * Schnittstellen werden einfacher

## Wo nachlesen
