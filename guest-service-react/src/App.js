import { Routes, Route, BrowserRouter } from "react-router-dom"
import Login from "./pages/Login"
import Register from "./pages/Register"
import Home from "./pages/Home"
import { ReactKeycloakProvider } from "@react-keycloak/web";
import keycloak from "./keycloak";
import Header from "./components/Header";
import PrivateRoute from "./helpers/PrivateRoute";

function App() {
 return (
   <div className="App">
    <ReactKeycloakProvider authClient={keycloak}>
     <BrowserRouter>
       <Routes>
           <Route path="/register" element={<Register />} />
           <Route path="/" element={
               <PrivateRoute>
                   <Home />
               </PrivateRoute>
           } />
       </Routes>
     </BrowserRouter>
     </ReactKeycloakProvider>
   </div>
 )
}

export default App