import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../components/LoginForm/Login";
import MasterLayout from "../components/MainLayout/MainLayout";
import Match from "../components/MatchForm/Match";
import Location from "../components/LocationForm/Location";
import Register from "../components/RegisterForm/Register";
import ProtectedRoute from "./protectedRoute";
import PublicRoutes from "./publicRoute";

const MainRoutes = () => (
  <Routes>
    /**public rute */
    <Route element={<PublicRoutes />}>
      <Route
        path="/"
        element={
          <MasterLayout>
            <Login />
          </MasterLayout>
        }
      />
    </Route>
    <Route element={<PublicRoutes />}>
      <Route
        path="/register"
        element={
          <MasterLayout>
            <Register />
          </MasterLayout>
        }
      />
    </Route>
    <Route element={<PublicRoutes />}>
      <Route
        path="/match"
        element={
          <MasterLayout>
            <Match />
          </MasterLayout>
        }
      />
    </Route>
    <Route element={<PublicRoutes />}>
      <Route
        path="/location"
        element={
          <MasterLayout>
            <Location />
          </MasterLayout>
        }
      />
    </Route>
    /**protected rute */
    <Route element={<ProtectedRoute />}>
      <Route path="/main" element={<Login />} />
    </Route>
  </Routes>
);

export default MainRoutes;
