# Unit Testing - von 0 auf TDD an einem Tag

Unittests sind mittlerweile Bestandteil des Werkzeugkastens eines jeden Softwareentwicklers. Dennoch wirkt dieses Werkzeug, wenn man es in die Hand nimmt, häufig kompliziert, aufwendig, unnötig, ganz und gar nicht [DRY](https://de.wikipedia.org/wiki/Don%E2%80%99t_repeat_yourself) oder [YAGNI](https://de.wikipedia.org/wiki/YAGNI). Wie ein Multi Funktionstool steht es bereit, bei den vielfältigsten Problemen zu unterstützen. Aber der Zeitpunkt, zu dem sich der Aufwand des Einsatzes lohnt, scheint nicht einzutreten.

Wenn man auf der anderen Seite einmal in einem Projekt mit Unittests zu Gast ist, fühlt man sich in der Regel wohl. Die Unittests unterstützen beim Beheben von Bugs, beim Refaktorisieren von Modulen sowie beim Ergänzen bestehender Projekte um neue Funktionalitäten. Der Code ist meist aufgeräumt, wirkt klar strukturiert, jede Variable hat ihren wohl durchdachten Platz und alles ist irgendwie in sich konsistent.

Versucht man diese positive Erfahrung in eigenen, oft über mehrere Jahre gewachsenen Projekten zu imitieren, so endet man nicht selten in Verzweiflung. Die vielen kleinen, idealtypischen Übungen der Pro-Test-Hippies der [Softwerkskammer[(https://www.softwerkskammer.org/groups/magdeburg)], scheinen einem nicht allzu selten im Stich zu lassen. Real sind dagegen:
* hunderte Tests,
* mühevolle und umfangreiche Initialisierungen der Testumgebung,
* zu viele Überprüfungen pro Testfall
* Testnamen die verdeutlichen "hier wird nur die Testabdeckung erfüllt",
* statische Abhängigkeiten die erst gar keinen UnitTest ermöglichen,
* und **jede kleinste Änderung führt zu mindestens 20 fehlschlagenden Tests**.

Dieser Workshop richtet sich an Unittest Anfänger und Fortgeschrittene gleichermaßen. Nach einem kurzen Einstieg werden wir die fortgeschrittene Strategien für die Erstellung von Unit-Tests betrachten. Alle Beispiele und Übungen werden wir gruppenweise in C# und Java durchführen.

Themen:
 * Einführung in Unittests
 * Vorteile testgestützter Software-Entwicklung
 * typische Anti-Pattern bei Unit-Tests
 * Best Practices für die Erstellung von Unit-Tests (Testnamen, Parametrisierung, usw.)
 * Die Test-Pyramide
 * Isolierung externer Abhängigkeiten (bspw. Datenbanken)
 * Strategien für iterative Ergänzung von Unit-Tests in Legacy-Projekten
 * Test Driven Development

# Andreas Richter

Andreas Richter ist seit vielen Jahren leidenschaftlicher Softwarecraftsman und Architekt. Über die Jahre hat er durch die Arbeit an unterschiedlich großen Projekten mit einer Vielzahl an Plattformen, Frameworks und Programmiersprachen ein ausgeprägtes Verständnis für sauberen Code, gutes Design und effektive Architekturen entwickelt.

Aktuell liegt sein Schwerpunkt auf dem .NET Framework mit C# und diversen Bibliotheken aus diesem Umfeld. Neben klassischen Desktop-Anwendungen entwickelt er auch Mobile- und Web-Anwendungen u.a. mit Xamarin. Dabei kommt bereits seit einigen Jahren das arc42 Template für die begleitende Architekturdokumentation zum Einsatz. Aktuell ist er bei der advanto Software GmbH in Magdeburg als Softwareentwickler und Architekt tätig und betreut dort mit seinen Kollegen hochwertige Software für den Einsatz im Finanzsektor.

Softwareentwicklung ist für ihn keine reine Produktion von Code sondern vielmehr eine Profession und eine Handwerkskunst. Um dem Anspruch gerecht zu werden, ist lebenslanges Lernen, stetiger Wissensaustausch und häufiges Üben essentiell. Aus diesem Grunde besucht er Konferenzen, bildet sich  in Workshops weiter und nimmt aktiv an Communityveranstaltungen wie der Spartakiade, dem Developer Open Space und den Magdeburger Developer Days teil. Weiterhin leitet er seit September 2013 erfolgreich die [Softwerkskammer in Magdeburg](https://www.softwerkskammer.org/groups/magdeburg).

* Blog: https://blog.anrichter.net  
* Twitter: https://twitter.com/anrichter  
* GitHub: https://github.com/anrichter  
* Xing: http://xing.to/anrichter  

# Tobias Blaschke

Tobias Blaschke macht Softwareentwicklung Spaß. Die schnellebige IT-Welt mit ihren verschiedensten Facetten bieten ihm die Chance immer neue Technologien auszuprobieren und auch mal daran zu scheitern. Linux, Bash, Docker, Raspberry, Scrum, Jenkins, Zsh, Kodi, ZFS, Haskell, Gradle, tmux, Kotlin, fzf, squeezebox, k8s - die IT-Welt kann so wunderschön kompliziert sein.

Hauptberuflich unterstützt er in der [Eudemonia Solutions AG](https://www.eudemonia-solutions.de/) die Entwicklung von Software für die Finanzberatung als Entwickler und Architekt. Viele Jahre davon in einem über 10 Jahre hinweg gewachsenen Java-Projekt die sein Blick für komplexe Architekturen schärften und das Verständnis in der Entstehung von sogenanntem Legacy-Code steigerten.

In unregelmäßigen Abständen trifft man ihn in auf Communityveranstaltungen wie der Softwerkskammer oder dem Developer Open Space, als Teilnehmer aber auch als Vortragenden.
