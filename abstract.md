# Unit Testing - von 0 auf TDD an einem Tag

Unittests sind mittlerweile Bestandteil des Werkzeugkastens eines jeden Softwareentwicklers. Dennoch wirkt dieses Werkzeug, wenn man es in die Hand nimmt, häufig kompliziert, aufwendig, unnötig, ganz und gar nicht DRY oder YAGNI. Wie ein Multi Funktionstool steht es bereit, bei den vielfältigsten Problemen zu unterstützen. Aber der Zeitpunkt, zu dem sich der Aufwand des Einsatzes lohnt, scheint nicht einzutreten.

Wenn man auf der anderen Seite einmal in einem Projekt mit Unittests zu Gast ist, fühlt man sich in der Regel wohl. Die Unittests unterstützen beim Beheben von Bugs, beim Refaktorisieren von Modulen sowie beim Ergänzen bestehender Projekte um neue Funktionalitäten. Der Code ist meist aufgeräumt, wirkt klar strukturiert, jede Variable hat ihren wohl durchdachten Platz und alles ist irgendwie in sich konsistent. Trotz der unglaublichen Größe des Gasthauses, weiss man sofort hinter welcher Tür sich der Staubsauger verbirgt.

Versucht man diese positive Erfahrung in eigenen, oft über mehrere Jahre gewachsenen Projekten zu imitieren, so endet man nicht selten in Verzweiflung. Die vielen kleinen, idealtypischen Übungen der Pro-Test-Hippies aus der Softwerkskammer, scheinen einem nicht allzu selten im Stich zu lassen. Real sind dagegen:
* hunderte Tests,
* mühevolle und umfangreiche Initialisierungen der Testumgebung,
* zu viele Überprüfungen pro Testfall
* Testnamen die verdeutlichen "hier wird nur die Testabdeckung erfüllt",
* statische Abhängigkeiten die erst gar keinen UnitTest ermöglichen,
* und **jede kleinste Änderung führt zu mindestens 20 fehlschlagenden Tests**.

Dieser Workshop richtet sich an Unittest Anfänger und Fortgeschrittene gleichermaßen. Wir beginnen bei den Grundlagen zu Unittests. Anschließend betrachten wir Praktiken, mit denen existierende Projekte iterationsweise um erste Unittests ergänzt werden können. Weiterhin zeigen wir, wie eistierende Unittests beim Refaktorisieren helfen, um zum Schluss auf die Königsdisziplin Test Driven Development einzugehen.

Alle Beispiele und Übungen werden wir gruppenweise in C# und Java durchführen. 

Themen:
 * Einführung in Unittests
 * Best Practices in der Erstellung von Tests (Testnamen, Parametrisierung, Prüfung von erwarteten Exceptions, usw.)
 * Mocken externer Abhängigkeiten
 * Test Driven Development
