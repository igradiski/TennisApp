import { BrowserRouter } from "react-router-dom";
import MainLayout from "./components/MainLayout/MainLayout";
import MainRoutes from "./routes/MainRoutes";

function App() {
  return (
    <BrowserRouter>
      <div className="App">
        <MainRoutes />
      </div>
    </BrowserRouter>
  );
}

export default App;
