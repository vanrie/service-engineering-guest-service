import { Routes, Route, BrowserRouter } from "react-router-dom"
import Login from "./pages/Login"
import Register from "./pages/Register"
import Home from "./pages/Home"
import Header from "./components/Header";

function App() {
 return (
   <div className="App">
     <BrowserRouter>
       <Routes>
           <Route path="/" element={<Login />} />
           <Route path="register" element={<Register />} />
           <Route path="home" element={<Home />} />
       </Routes>
     </BrowserRouter>
   </div>
 )
}

export default App