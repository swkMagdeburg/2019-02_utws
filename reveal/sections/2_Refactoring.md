<!--s-->
## Testpyramide

<!--v-->
### Warum testen wir?

* Übereinstimmung des Testgegenstandes mit einer Spezifikation sicherstellen
* ist ausgeliefert & wurde irgendwie getestet, warum dafür extra einen UnitTest entwickeln
* häufige Modifikationen an Software  <!-- .element: class="fragment" data-fragment-index="2" -->
  * durch Pflege, Anforderungsänderungen, Korrektur
  * UnitTests ermöglichen Wiederholung der bereits validen Testfällen
  * Sicherstellung, dass Änderungen keine neuen Fehler verursachen (Regressionen)

<!--v-->
<!-- .slide: data-background="https://media.giphy.com/media/vvLWidwZNYH5e/giphy.gif"-->


<!--v-->
### UnitTests allein reichen nicht

* UnitTest testet einzelne Einheit und kann nicht alle Fehler aufdecken
* **Integrationstests**: testen Zusammenspiel zwischen verschiedenen Programmen oder Programmteilen
* **Usability-Tests**: testet Gebrauchstauglichkeit einer Software
* **Behavior Driven Development / Systemtest**: Entsprechung der Software gegenüber den funktionalen und nicht-funktionalen Anforderungen sicherstellen.

<!--v-->
### Testpyramide

<div id="left">
<ul>
<li>Metapher für optimale Balance der Softwaretests</li>
<li>UnitTests haben darin den größten Anteil</li>
<li>Service-Layer beinhaltet: Api-, Integrations- und Komponententests</li>
<li>UI sind automatisierte Klicktests</li>
</ul>
</div>

<div id="right">

  ![](https://martinfowler.com/bliki/images/testPyramid/test-pyramid.png)

  [Martin Fowler - TestPyramid](https://martinfowler.com/bliki/TestPyramid.html)

</div>

<!--v-->
### Testpyramide

* UnitTests haben den größten Anteil, weil:
  * geringer Entwicklungsaufwand
  * einfach zu automatisieren
  * schnell durchzuführen
  * testen nur kleine Einheiten von Software (Fokus)
  * in der Regel keine externe Abhängigkeiten
* sind dadurch stabiler gegenüber Änderungen als Integrations oder UI-Tests

<!--### Integrationstest-->
<!--SucheMoeglicheEmpfaengerTest-->

<!--v-->
## 2. Übung - Tennis

* Ziel: Refactoring existierenden Codes
* Experiment:
  * Gruppe (1) nutzt existierende Tests: refactoren, Tests laufen lassen
    * IntelliJ/Eclipse
      * Strg-Shift-T/Strg-R: Zum Test springen
      * Alt-Shift-F10/Alt-Shift-X + T: (Test ausführen)
      * Strg-F5/Strg-F11: Test wiederholen
      * Strg-Umschalt-Alt-T/Umschalt-Alt-T: Refactor
  * Gruppe (2): refactoren ohne Tests
