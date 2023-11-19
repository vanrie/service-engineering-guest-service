Back-End (Johny, Maxl, Lisa-Maria, Tobi)
- Java Spring Boot ✔️
- Server Controller (CRUD Operations mit REST API) ✔️
- Datenbank ✔️
- QueryController ✔️

ToDo: 
- Database initialisation


Front-End (Vanessa)
- React

ToDo:
- 


GuestService Funktionen:
- Kalender, in welchem Veranstaltungen eingefügt werden können zu dem sich Nutzer anmelden können.

- Admin (Festlegen von Maximalanzahl der Personen bei Veranstaltungen + Anlegen, Bearbeiten etc.)
- User (Anmeldung, Anmeldung zu Veranstaltungen, Bearbeiten von Daten etc.)
- Login mit Keycloak
- Usererstellung von Admin ODER mit UserRegistrierung -> noch offen



Docker Setup Anleitung für Keycloak:
1. Terminal öffnen (Windows + R -> "cmd" -> Enter)
2. docker run --name guestservice-keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.0 start-dev
3. http://localhost:8080/auth/ -> username: "admin", passwort: "admin"
4. Create Realm (guestservice-db)
5. Create Client (login-client)
6. Optional: Create user for testing
7. Falls Namen verschieden sind: Application.properties File anpassen

Bilderanleitung (mit anderen Namen): https://www.baeldung.com/spring-boot-keycloak
