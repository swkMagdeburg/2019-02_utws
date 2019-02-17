<!--s-->
## Lesbarkeit von Tests

<!--v-->
### Tests sind auch Code

* Wie Produktiv-Code, sollte auch Test-Code "clean" sein
* eigentlich Test-Code wertvoller als Produktiv-Code
  * angenommen, Produktiv-Code plötzlich weg: Firma geht pleite
  * angenommen, Tests sind erhalten geblieben: Produktiv-Code kann gegen Tests entwickelt werden
  * angenommen, Test-Code plötzlich weg: keine Aussage, welcher Produktiv-Code korrekt oder inkorrekt funktioniert

<!--v-->
### schlecht lesbare Tests

* lassen urpsrüngliche Testfälle nur schwer erkennen
* sind schwierig an neue Anforderungen anpassbar
* geben wenig Vertrauen
* werden eher `@Ignore` gesetzt als angepasst

QualityDataServiceImplUnitTest

<!--v-->
### Definiere keine unnötigen Testfälle

* Verhalten ausserhalb der Rahmenbedingungen
  * Arbeitet der Toaster bei hohen G-Kräften
  * Wir können nicht alle Fehler/Fremdnutzungen vorhersehen
* wenn wir es versuchten, hätten wir einen Großteil unsinniger Tests
  * wir für die [Erwärmung von Katzen](https://de.wikipedia.org/wiki/Haustier_in_der_Mikrowelle)
  * Vorsicht: Inhalt könnte heiß sein

SqlReaderTest - lieber nicht, aber so etwas ähnliches vll?

<!--v-->
### Benennen deine Tests ordentlich
TechProductVariationDialogServiceImplTest
ShowTargetLeftAssignmentTest


<!--v-->
### Nutze statische Imports

<!--v-->
### Fange keine Exceptions im Test

```java
@Test
public void testFailEnsureNoSchema() throws Exception
{
  for (Object[] testData : getFailEnsureNoSchemaTestData())
  {
    String query = (String) testData[0];
    try
    {
      SqlQueryPatternAuthorizer.ensureNoSchema(query, SCHEMAS);
      assertTrue(query, false);
    }
    catch (IllegalSqlQueryExecutorException isqee)
    {
        // Test erfolgreich
    }
  }
}
```

<!--v-->
### Fange keine Exceptions im Test

```java
@Test(expected = IllegalSqlQueryExecutorException.class)
public void testFailEnsureNoSchema() throws Exception
{
  for (Object[] testData : getFailEnsureNoSchemaTestData())
  {
    String query = (String) testData[0];
    SqlQueryPatternAuthorizer.ensureNoSchema(query, SCHEMAS);
  }
}
```

<!--v-->
### Initialisiere Tests möglichst lokal

<!--v-->
### Definiere mehrere Testklassen für eine Produktivklasse

QualityDataServiceImpl

<!--v-->
### Nutze Parametrisierung von Tests

Revisionstest

<!--v-->
### Bilde fachliche Anforderungen als jeweils ein Test ab

https://jira.eudemonia-solutions.de/browse/WAVEX-2645
PersonenMappingTest.java


<!--v-->
### 3. Übung - GildedRose

* Ziel: verfasse entsprechend der fachlichen Anforderungen UnitTests
