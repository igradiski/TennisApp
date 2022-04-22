import create from "@ant-design/icons/lib/components/IconFont";
import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import {
  addLocation,
  getLocationsPaged,
  fetchAllLocationsCascader,
} from "../../api/locations";
import ILocations from "../../data/ILocations";

export const fetchAllLocations = createAsyncThunk(
  "locations/fetchAllLocations",
  async ({ data, filter }: any) => {
    return getLocationsPaged(data, filter);
  }
);
export const fetchAllLocationsForCascader = createAsyncThunk(
  "locations/fetchAllLocationsForCascader",
  async () => {
    return fetchAllLocationsCascader();
  }
);

export const insertNewLocation = createAsyncThunk(
  "locations/insertNewLocations",
  async (data: ILocations) => {
    return addLocation(data);
  }
);

const initialState = {
  pageNo: "",
  tableData: [],
  location: [],
  locationCascader: [],
};

const locationsSlice = createSlice({
  name: "locations",
  initialState: initialState,
  reducers: {
    addLocationInDB: (state, action) => {
      console.log(state + " " + action.payload.data);
    },
  },
  extraReducers: (builder) => {
    builder.addCase(fetchAllLocations.fulfilled, (state, action) => {
      return { ...state, tableData: action.payload.content };
    });
    builder.addCase(insertNewLocation.fulfilled, (state, action) => {
      return { ...state, location: action.payload.content };
    });
    builder.addCase(fetchAllLocationsForCascader.fulfilled, (state, action) => {
      console.log(action.payload);
      return { ...state, locationCascader: action.payload };
    });
  },
});

const { actions, reducer } = locationsSlice;

export const { addLocationInDB } = actions;
export { reducer as locationsReducer };
