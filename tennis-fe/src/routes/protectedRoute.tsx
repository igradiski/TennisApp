import { FunctionComponent } from "react";
import { Navigate, Outlet } from "react-router-dom";

const ProtectedRoute: FunctionComponent = () => {
  const auth = false;
  return auth ? <Outlet /> : <Navigate to="/nisiLogiran" />;
};
export default ProtectedRoute;
