import ICourts from "../data/ICourts";
import axiosInstance from "./axios";

export const getAllCourts = async () => {
  const response = await axiosInstance.get("tennis-rest/api/courts/all");
  return response.data;
};

export const addCourt = async (data: ICourts) => {
  const response = await axiosInstance.post("tennis-rest/api/courts", data);
  return response.data;
};
