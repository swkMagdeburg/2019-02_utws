# UnitTestWorkshop

Unit-Tests sind mittlerweile Bestandteil des Werkzeugkastens eines jeden Softwareentwicklers. Dennoch wirkt dieses Werkzeug, wenn man es in die Hand nimmt, häufig kompliziert, aufwendig, unnötig, ganz und gar nicht DRY oder YAGNI. Wie ein 3D-Drucker steht es bereit bei den vielfältigsten Problemen zu unterstützen. Aber der Zeitpunkt zu dem sich der Aufwand des Einsatzes lohnt, scheint nicht einzutreten.

Wenn man auf der anderen Seite einmal in einem Projekt mit Unit-Tests zu Gast ist, sei es um einen Bug zu beheben, ein Modul zu refactoren oder eine ganz eigene Idee zu ergänzen, dann fühlt man sich dort in der Regel wohl. Es ist aufgeräumt, wirkt klar strukturiert, jede Variable hatte ihren wohl durchdachten Platz und alles ist in sich irgendwie konsistent. Trotz der unglaublichen Größe des Gasthauses, weiss man sofort hinter welche Tür sich der Staubsauger verbirgt.

Versucht man diese positive Erfahrung im eigenen Arbeitsumfeld im über die Jahre gewachsenen Projekt imitieren, so endet man nicht selten in Verzweiflung. Die vielen kleinen idealtypischen Übungen der Pro-Test-Hippies aus der Softwerkskammer scheinen einem in Stich zu lassen. Real sind dagegen:
* hunderte Tests,
* immer dieselben langwierigen mühevollen Initialisierungen über zehn Zeilen,
* fünf oder mehr Werte die asserted werden,
* Testnamen die verdeutlichen "hier wird nur die Testabdeckung erfüllt",
* statische Abhängigkeiten die erst gar keinen UnitTest ermöglichen,
* und **jede kleinste Änderung führt zu mindestens 20 fehlschlagenden Tests**.

Dieser Workshop richtet sich an Unit-Test-Anfänger und -Fortgeschrittene. Anfangs wiederholen wir die Grundlagen und werden anschließend erweiterte Praktiken kennenlernen um Projekte mit ungenügender oder fehlender Testabdeckung iterationsweise um erste UnitTests zu ergänzen. Die Übungen werden wir zweisprachig in C# und Java durchführen.

Themen:
 * Einführung in Unit-Tests
 * Best-Practices in der Erstellung von Tests (Testnamen, Parametrisierung, Prüfung von erwarteten Exceptions, usw.)
 * Mocken externer Abhängigkeiten
 * Test-Driven-Development
