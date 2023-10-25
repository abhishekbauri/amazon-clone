
import Navbar from "./components/navbar/Navbar.jsx";
import { Routes, Route } from "react-router-dom";
import SignIn from "./section/signin/SignIn";
import SignUp from "./section/signup/SignUp";
import Home from "./section/home/Home.jsx";
import ListCategory from "./section/categories/ListCategory.jsx";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/sigin" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/listCategory" element={<ListCategory />} />
      </Routes>
    </>
  );
}

export default App;

