import IDefaultFilter from "../data/IDefaultFilter";
import ILocations from "../data/ILocations";
import IPaging from "../data/IPaging";
import axiosInstance from "./axios";

export const addLocation = async (data: ILocations) => {
  const response = await axiosInstance.post("tennis-rest/api/locations", data);
  return response.data;
};

export const getLocationsPaged = async (
  { pageNo, pageSize, sort }: IPaging,
  { dateFrom, dateUntil, name }: IDefaultFilter
) => {
  const response = await axiosInstance.get("tennis-rest/api/locations", {
    params: { dateFrom, dateUntil, name, pageNo, pageSize, sort },
  });
  return response.data;
};
