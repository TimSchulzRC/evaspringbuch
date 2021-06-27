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
Die Buch-Projekte stehen in folgenden Versionen zur Verfügung, wobei aktuell der master mit Spring Boot 2.4.6 gebuildet ist.

|  | **master** | **springboot-2.3.4** | **springboot-2.2.5** | **springboot-2.1.2** |
| --- | :---: | :---: | :---: | :---: |
| Spring Boot | **2.4.6** | 2.3.4 | 2.2.5 | 2.1.2 |
| Spring Framework | 5.3.7  | 5.2.9  | 5.2.4  | 5.1.4 |
| Spring Data | 2020.0.9 | Neumann | 2.2.5 | 2.1.4 |
| Spring Security | 5.4 | 5.3 | 5.2.2 | 5.1.3 |
| Java | 11 | 11 | 11 | 11 |
| JUnit | 5 | 5 | 5 | 4 |
| Bootstrap | 4.6.0 | 4.3.1 | 4.3.1 | 4.2.1 |
| gradle | 6.8 | 6.3 | 6.1 | 5.1.1 |

**Änderungen**

* Spring Boot 2.3.4 zu Spring Boot 2.4.6
    * in allen `build.gradle`: Das Namensschema für springBootVersion ist geändert worden. Nun gilt `springBootVersion = '2.4.6'`. Der Zusatz RELEASE entfällt.
    * in allen Projekten, die jpa verwenden, ist in den application.properties die "alte" Datenbank-Konfiguration mit `spring.datasource.generate-unique-name=false` (Details in dem Abschnitt Spring Boot 2.2.5 durch Spring Boot 2.3.4) vorgenommen worden.
    * `bootstrap`-Version von 4.3.1 auf 4.6.0 geändert, inklusive Änderungen von `jquery.js` und `popper.js`
* Spring Boot 2.2.5 zu Spring Boot 2.3.4
    * in den `build.gradle` Dateien `eva07chatapp`, `eva07chatappuiadvanced`, `eva08csrffront`, `eva08https`, `eva11chatapp`,  `eva12chatappevent`, `eva12chatappeventjs` ist unter Implementation die Zeile
          `'org.springframework.boot:spring-boot-starter-validation',`
  hinzugefügt worden. GRUND: die Abhängigkeit (Dependency) zu `javax.validation` wird nicht mehr automatisch aufgelöst. 
    * die Verwendung der h2-Console ohne weitere Konfiguration hat sich etwas geändert. Die JDBC-URL wird anders als zuvor festgelegt. Als JDBC-URL ist nun auf der Spring-Console folgender String  `jdbc:h2:mem:896ab7dd-c95f-4205-a0e7-b052f282b5b7` zu finden, wobei der letzte Teil (hinter `mem:`) eine UUID als Datenbankname darstellt. Den vollständigen String muss man als JDBC-URL verwenden. Bei jedem Neustart der Anwendung wird die JDBC-URL bzw. der Datenbankname neu generiert. Wer das nicht möchte, kann den ursprünglichen Default (Datenbankname `testdb`) mit einer der beiden Einstellungen in der `application.properties` festlegen
        * `spring.datasource.url=jdbc:h2:mem:testdb`
        * `spring.datasource.generate-unique-name=false`
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
