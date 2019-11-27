# 2019-02 Unit Test Workshop

Das Repository enthält alle Unterlagen für einen geplanten Unit-Test-Workshop.

## Projekt-Struktur

* [docs](docs) statisch generierte Ressourcen, um die Folien über github-Pages [hier](http://gaerfield.github.io/2019-02_utws/) betrachten zu können
* [reveal](reveal): Die Vortragsfolien
  * [reveal-md](https://github.com/webpro/reveal-md) ist Vorrausetzung um die Folien generieren zu können
  * Anzeige der Folien mittels `reveal-md --preprocessor includes.js --highlight-theme solarized-light ut.md`
  * [ut.md](reveal/ut.md) ist das Main-File, welches die einzelnen Abschnitte verlinkt
  * [sections](reveal/sections) enthält die Markdown-Files der einzelnen Abschnitte
  * [include.js](reveal/include.js) bindet die customscripts in definierter Reihenfolge ein
    * [customscripts/fileInclude.js](reveal/customscripts/fileInclude.js) liest die einzelnen Kapitel ein
    * [customscripts/pumlpreprocessor.js](reveal/customscripts/pumlpreprocessor.js) erzeugt [PlantUML](http://plantuml.com)-Diagramme über den [Gravizo](http://www.gravizo.com)-Service
* die restlichen Ordner ([1_Toaster](1_Toaster), [2a_Tennis](2a_Tennis), usw.) sind Teil eines gradle-Multiprojekts, wobei jeder Ordner eine eigene Übung enthält 
