import axios from "axios";
import TokenService from "../feature/userLogin/TokenService";

const tokenService = new TokenService();

const axiosInstance = axios.create({
  baseURL: "http://localhost:8081/",
  //baseURL: "https://vineapp-spring.herokuapp.com/",
  headers: {
    "Access-Control-Allow-Origin": "/**",
  },
});

export default axiosInstance;
