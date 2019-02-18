<!--s-->
## Testisolierung

<!--v-->
### Isolation ist hart

* in der Praxis haben fast alle Klassen Abhängigkeiten
* Abhängigkeiten im Original zu gewährleisten:
  * verursacht unerwartete Seiteneffekte
  * potenziert Testfälle
  * ist zum Teil unmöglich
* Abhängigkeiten für den Test "simulieren": <!-- .element: class="fragment" data-fragment-index="2" -->
  * isoliert das SUT
  * ermöglicht Konzentration auf die für das SUT notwendigen Testfälle

<!--v-->
### Mocks und Spies

* Mocks:
  * simuliert eine Instanz eines Objekts
  * Rückgabewerte für Methodenaufrufe können definiert werden
  * Aufrufe von Methoden können verfiziert werden
* Spy:
  * kapselt eine existierende Instanz eines Objekts
  * kann Methodenaufrufe "abfangen" und definierte Werte zurückliefern
  * Aufrufe von Methoden können verfiziert werden

<!--v-->
### Mockframeworks

* JMock
  * nur Interfaces können gemockt werden
  * alle Methodenaufrufe und Verifikationen müssen vorher definiert werden
  * vereinzelt in älteren UnitTests verwendet
* Mockito
  * kann Klassen mocken
  * liefert sinnvolle Defaults (null, Optional.absent())
  * nutzt inuitivere Flow-Syntax
  * trennt Mock-Verhalten und Verifikation
  * wird bevorzugt eingesetzt

<!--v-->
### Mockframeworks

* PowerMockito
  * erlaubt mittels Reflections zusätzlich des Mocken von:
    * Konstruktoren
    * privater und statischer Methoden
  * nur einsetzen, falls tatsächlich notwendig

<!--v-->
### JMock

```java
public class PublisherTest extends TestCase {
  Mockery context = new Mockery();

  public void testOneSubscriberReceivesAMessage() {
    final Subscriber subscriber =
      context.mock(Subscriber.class);
    Publisher publisher = new Publisher();
    publisher.add(subscriber);

    final String message = "message";

    context.checking(new Expectations() {{
        oneOf (subscriber).receive(message);
    }});

    publisher.publish(message);

    context.assertIsSatisfied();
  }
}
```

<!--v-->
### Mockito

```java
public class PublisherTest extends TestCase {
  public void testOneSubscriberReceivesAMessage() {
    final Subscriber subscriber = mock(Subscriber.class);
    Publisher publisher = new Publisher();
    publisher.add(subscriber);

    final String message = "message";
    publisher.publish(message);

    verify(subscriber, times(1)).receive(message);
  }
}
```

<!--v-->
### PowerMockito

```java
@RunWith(PowerMockRunner.class)
@PrepareForTest(Subscriber.class)
public class YourTestCase {
  @Test
  public void testMethodThatCallsPrivateMethod() {
    final Subscriber subscriber = mock(Subscriber.class);
    Publisher publisher = new Publisher();
    publisher.add(subscriber);

    final String message = "message";
    publisher.publish(message);

    verifyPrivate(subscriber, times(1))
      .invoke("privateMethodName", message);
  }
}
```

<!--v-->
### Mock

```java
MyClass test = mock(MyClass.class);
when(test.getUniqueId()).thenReturn(43);
assertEquals(test.getUniqueId(), 43);
```

### Spy

```java
MyClass test = spy(new MyClass());
doReturn(43).when(test).getUniqueId();
assertEquals(test.getUniqueId(), 43);
```

<!--v-->
### zum  Nachdenken

```java
MyClass test = mock(MyClass.class);
assertEquals(test.getUniqueId(), ??); // Was kommt hier raus?

MyClass toBeSpiedOn = new MyClass();
MyClass spying = spy(toBeSpiedOn);

when(spying.getUniqueId()).thenReturn(43)

doReturn(43).when(spying).getUniqueId();
assertEquals(toBeSpiedOn.getUniqueId(), ??);
```

<!--v-->
<small>
```java
public int makeDebtListKeyFigureColumn(String customerOid, Calendar bookKeepingDate)
{
  dbConversationHandler.ensureValidTransaction();
  int count = 0;

  try
  {
    // Calendar für spätere verwendung hg: truncate wurde schon gemacht
    final Calendar normalizedBookKeepingDate =
            Utils.truncateDate(bookKeepingDate, Calendar.DAY_OF_MONTH);

    // Vormonatsultimo holen
    Calendar pmu = Utils.truncateDate(Utils.getPmu(), Calendar.DAY_OF_MONTH);

    // beide auf 12:00 setzen, weil sonst vorhandene DebtListKeyFigureColumns nicht
    // gefunden werden, da Referenzdatum beim Erzeugen auf 12:00 gesetzt wird, und
    // die nochmal erzeugt werden. (Bug 11951)
    normalizedBookKeepingDate.set(Calendar.HOUR, 12);
    pmu.set(Calendar.HOUR, 12);

    // Kennzahlen nur erzeugen, wenn Buchungsdatum größer gleich
    // dem Vormonatsultimo ist (Bug 9111)
    if (normalizedBookKeepingDate.compareTo(pmu) >= 0)
    {
      // Monat und jahr für späteren vergleich merken
      int pmuMonth = pmu.get(Calendar.MONTH);
      int pmuYear = pmu.get(Calendar.YEAR);

      // Die Kennzahlenspalte sollte anhand des vormonatssultimos holen
      final IGenericDAO<DebtListKeyFigureColumn> debtListKeyFigureColumnDAO =
              this.daoFactory.getGenericDAOFor(DebtListKeyFigureColumn.class);
      DebtListKeyFigureColumn keyFigureColumn =
              debtListKeyFigureColumnDAO.findByAttributes(new String[] {
                      DebtListKeyFigureColumn.ATTR_CUSTOMERID,
                      DebtListKeyFigureColumn.ATTR_REFERENCE_DATE}, new Object[] {
                      customerOid, pmu.getTime()});

      // prüfen, ob wir für den vormonat schon eine spalte haben
      if (keyFigureColumn != null)
      {
        Calendar pmuColumnReferenceDate = Calendar.getInstance();
        pmuColumnReferenceDate.setTime(keyFigureColumn.getReferenceDate());

        int pmuColumnReferenceMonth = normalizedBookKeepingDate.get(Calendar.MONTH);
        int pmuColumnReferenceYear = normalizedBookKeepingDate.get(Calendar.YEAR);

        // Monat und jahr prüfen
        if ((pmuColumnReferenceMonth == pmuMonth)
                && (pmuColumnReferenceYear == pmuYear))
        {
            // die spalte ist bereits aus dem monat, für den wir eine neue
            // erzeugen wollten -> wir können daher abbrechen
            logger.debug("Key figures for customer " + customerOid + " are up to date");
            return count;
        }
      }

      // keine spalte für den vormonat gefunden; versuchen den kunden zu laden
      SingleCustomer singleCustomer = null;
      try
      {
        final IGenericDAO<SingleCustomer> singleCustomerDAO =
                this.daoFactory.getGenericDAOFor(SingleCustomer.class);
        singleCustomer = singleCustomerDAO.findById(customerOid);
      }
      catch (ObjectNotFoundException e)
      {
        logger.debug("Customer with ID " + customerOid + " not found");
        return count;
      }

      // ... und kennzahlenspalten erzeugen
      if (singleCustomer != null)
      {
        logger.debug("Calculating debt list key figures for customer "
                + singleCustomer.getNumber());

        // versuchen die masterbilanz des kunden zu holen
        BalanceDataRow mbRow = null;
        try
        {
            mbRow = this.getMasterBalanceRow(singleCustomer);
        }
        catch (StandardException e)
        {
            // Exception ignorieren; kunde hat keine masterbilanz oder die
            // ID stimmt nicht.
        }

        // Letztes importiertes Bb3ProductUsageData-objekt des kunden holen
        final IGenericDAO<Bb3ProductUsageData> bb3ProductUsageDataDAO = this.daoFactory
                .getGenericDAOFor(Bb3ProductUsageData.class);
        Bb3ProductUsageData pud = bb3ProductUsageDataDAO.findByAttribute(
                Bb3ProductUsageData.ATTR_CUSTOMERID, singleCustomer.getOid());

        // alle vorhandenen kennzahlenspalten des kunden holen
        Collection<DebtListKeyFigureColumn> cols =
                debtListKeyFigureColumnDAO
                .findAllByAttribute(DebtListKeyFigureColumn.ATTR_CUSTOMERID,
                        singleCustomer.getOid());

        // Sonderbehandlung: falls zur neu erzeugten spalte *keine* fünf
        // vormonate
        // existieren, müssen wir diese spalten zuerst erzeugen
        if (cols.size() < 6)
        {
          // DebtListKeyFigureColumn.PREV_MONTH_M2 -> -2
          // DebtListKeyFigureColumn.PREV_MONTH_M6 -> -6
          for (int prevMonthIdx = -6; prevMonthIdx < -1; prevMonthIdx++)
          {
              // Kennzahlenspalte für (vor)vormonate erzeugen
              keyFigureColumn =
                      new DebtListKeyFigureColumn(singleCustomer, mbRow, pud, cols,
                              prevMonthIdx);
              // ...und persistent machen
              debtListKeyFigureColumnDAO.persist(keyFigureColumn);
              cols.add(keyFigureColumn);
              count++;
          }
        }

        // Kennzahlenspalte für den vormonat (ausgehend vom heutigen datum)
        // erzeugen
        keyFigureColumn = new DebtListKeyFigureColumn(singleCustomer, mbRow, pud, cols);

        // ...und persistent machen
        debtListKeyFigureColumnDAO.persist(keyFigureColumn);
        count++;
      }
    }
  }
  catch (Exception e)
  {
      StandardErrorHandler
              .getInstance()
              .handleException(new PersistenceException("Error while trying to make a "
                                       + "DebtListKeyFigureColumn.", e,
                                       "2001_GenericDataManagerError", new String[] {}), true);
  }
  // Anzahl der erzeugten spalten zurückliefern
  return count;
}
```
<!-- .element: max-width: none; -->
</small>

<!--v-->
### Wie Tests für bestehenden Code entwickeln?

1. Isoliere den zu testenden Teil durch Method-Extraction
2. Setze den zu testenden Teil auf package-private
3. Teste die extrahierte Methode
4. Refactore den nun getesteten Code in eine neue Klasse

<!--v-->
### 4. Übung
