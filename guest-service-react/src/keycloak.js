import Keycloak from "keycloak-js";
const keycloak = new Keycloak({
 url: "http://localhost:8080",
 realm: "guestservice-db",
 clientId: "login-client",
});

export default keycloak;