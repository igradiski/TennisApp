import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../components/LoginForm/Login";
import MasterLayout from "../components/MainLayout/MainLayout";
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
      <Route path="/login" element={<Login />} />
    </Route>
    /**protected rute */
    <Route element={<ProtectedRoute />}>
      <Route path="/main" element={<Login />} />
    </Route>
  </Routes>
);

export default MainRoutes;
