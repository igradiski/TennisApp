import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import { addCourt, getAllCourts } from "../../api/courts";
import ICourts from "../../data/ICourts";

export const fetchCourtsForDropdown = createAsyncThunk(
  "courts/fetchCourtsForDropdown",
  async () => {
    return getAllCourts();
  }
);

export const insertNewCourt = createAsyncThunk(
  "courts/insertNewCourt",
  async (data: ICourts) => {
    return addCourt(data);
  }
);

const initialState = {
  courts: [],
  insertedCourt: [],
};

const courtSlice = createSlice({
  name: "courts",
  initialState: initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder.addCase(fetchCourtsForDropdown.fulfilled, (state, action) => {
      return { ...state, courts: action.payload.content };
    });
    builder.addCase(insertNewCourt.fulfilled, (state, action) => {
      return { ...state, insertedCourt: action.payload };
    });
  },
});

const { actions, reducer } = courtSlice;
export { reducer as courtReducer };
