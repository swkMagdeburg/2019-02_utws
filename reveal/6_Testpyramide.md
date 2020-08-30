<!--s-->
## Reichen Unit Tests aus?

<!--v-->
<!-- .slide: data-background="https://media.giphy.com/media/vvLWidwZNYH5e/giphy.gif"-->

<!--v-->
### Unit Tests allein reichen nicht

* &shy;<!-- .element: class="fragment" --> **Unit Tests** testen einzelne Komponenten
* &shy;<!-- .element: class="fragment" --> **Integrationstests** testen Zusammenspiel von Komponenten 
* &shy;<!-- .element: class="fragment" --> **Systemtests** testen das gesamte System 
* &shy;<!-- .element: class="fragment" --> **UITests** testen das gesamte System über die UI

<!--v-->
### Testpyramide

<div id="left">
<ul>
<li>Metapher für optimale Balance der Softwaretests</li>
<li>Unit Tests haben darin den größten Anteil</li>
<li>Service Tests beinhalten Api-, Integrations- und Systemtests</li>
<li>UI Tests sind automatisierte Klicktests</li>
</ul>
</div>

<div id="right">

  ![](https://martinfowler.com/bliki/images/testPyramid/test-pyramid.png)

  [Martin Fowler - TestPyramid](https://martinfowler.com/bliki/TestPyramid.html)

</div>

<!--v-->
### Testpyramide - Unit Tests

* Unit Tests haben den größten Anteil, weil:
  * geringer Entwicklungsaufwand
  * einfach zu automatisieren
  * schnell durchzuführen
  * testen nur kleine Einheiten von Software (Fokus)
  * in der Regel keine externe Abhängigkeiten
* sind dadurch stabiler gegenüber Änderungen als Integrations oder UI-Tests
