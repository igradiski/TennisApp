import { FunctionComponent } from "react";
import { Navigate, Outlet } from "react-router-dom";

const PublicRoutes: FunctionComponent = () => {
  const auth = false;

  return auth ? <Navigate to="/" /> : <Outlet />;
};
export default PublicRoutes;
