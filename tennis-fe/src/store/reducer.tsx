import { combineReducers } from "redux";
import { courtReducer } from "./slices/courtSlice";
import { locationsReducer } from "./slices/locationsSlice";

export const rootReducer = combineReducers({
  locations: locationsReducer,
  courts: courtReducer,
});

export type RootState = ReturnType<typeof rootReducer>;
