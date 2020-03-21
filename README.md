# Repo zum Buch "Entwicklung verteilter Anwendungen"
Im Buch wird in die Entwicklung verteilter Anwendungen unter Verwendung des Spring Boot 2 Frameworks eingeführt. 
Das Buch ist im Springer-Verlag erscheinen, hier der Link zur [Buchseite vom Springer-Verlag](https://www.springer.com/de/book/9783658268138)
und der Link zu [meiner Buchseite](https://evaspringbuch.de).

# Beispiel-Anwendung EvaChatApp
Als Demo-Anwendung wird eine sogenannte EvaChatApp sukzessive entwickelt. In jedem Kapitel werden neue Funktionalitäten hinzugefügt.

Der zur Verfügung gestellte Programmcode muss nicht immer sofort ausführbar sein, da teilweise nur Code-Fragmente eingestellt werden, die im Buch ausführlich erläutert werden. 

# Inhalt
Grundlagen
 
* Erste Schritte zur Anwendung
 
* Eine kleine Chat-Anwendung mit Spring MVC
 
* Ein Blick hinter die Kulissen von Dependency Injection
 
* Speichern von Model-Daten mit Spring Data
 
* Bearbeiten von Model-Daten mit Spring Data
 
* Die EvaChatApp unter der Haube
 
* Sicherheit geht vor – Schutz vor Angriffen und nicht autorisierten Zugriffen
 
* Aspektorientierte Programmierung (AOP)
 
* Transaktionen – alles oder nichts
 
* Rest – zwei Apps arbeiten Hand in Hand
 
* Events und Aktualisierung

# Eingesetzte Frameworks
Die Buch-Projekte stehen in folgenden Versionen zur Verfügung, wobei aktuell master und Branch springboot-2.2.5 identisch sind.

|  | **master** | **springboot-2.2.5** | **springboot-2.1.2** |
| --- | :---: | :---: | :---: |
| Spring Boot | 2.2.5 | 2.2.5 | 2.1.2 |
| Spring Framework | 5.2.4  | 5.2.4  | 5.1.4 |
| Spring Data | 2.2.5 | 2.2.5 | 2.1.4 |
| Spring Security | 5.2.2 | 5.2.2 | 5.1.3 |
| Java | 11 | 11 | 11 |
| JUnit | 5 | 5 | 4 |
| Bootstrap | 4.3.1 | 4.3.1 | 4.2.1 |
| gradle | 6.1 | 6.1 | 5.1.1 |




**Änderungen**
* Spring Boot 2.1.2 zu Spring Boot 2.2.5
    * JUnit 4 durch JUnit 5 ersetzt
        * Annotation `@Before` wird zu `@BeforeEach`
        * in den Testklassen `@DirtiesContext(classMode=ClassMode.AFTER_CLASS)` bei den Annotationen der Klasse hinzugefügt. GRUND: wenn mehrere Testklassen ausgeführt werden sollen, 
        wird jeweils der Kontext nach Durchführung aller Testmethoden einer Klasse zurückgesetzt. Damit werden Abhängigkeiten in der Ausführungsreihenfolge der Testklassen verhindert.

# Code downloaden oder mit git clonen

für Master

    git clone https://gitlab.com/wogo/evaspringbuch.git

für Branch (z. B. für den Branch springboot-2.1.2)

    git clone -branch springboot-2.1.2 https://gitlab.com/wogo/evaspringbuch.git

Als Entwicklungsumgebungen können u.a. Eclipse, SpringToolsSuite 4 (damit sind die Projekte entwickelt worden) oder IntelliJ sowie ... verwendet werden.  

Als Build-Managment-Tool kommt gradle zum Einsatz.