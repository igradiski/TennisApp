import AsyncStorage from "@react-native-async-storage/async-storage";
import { configureStore, ThunkAction, Action } from "@reduxjs/toolkit";
import { useDispatch } from "react-redux";
import {
  FLUSH,
  PAUSE,
  PERSIST,
  persistReducer,
  persistStore,
  PURGE,
  REGISTER,
  REHYDRATE,
} from "redux-persist";
import { rootReducer } from "./reducer";

const persistReducerConfiguration = {
  key: "root",
  version: 1,
  storage: AsyncStorage,
  whitelist: [],
};

const persistentReducer = persistReducer(
  persistReducerConfiguration,
  rootReducer
);

export const store = configureStore({
  reducer: persistentReducer,
  middleware: (getDefaultMiddleware) => [
    ...getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER],
      },
    }),
  ],
});

export const persistor = persistStore(store);
export type AppDispatch = typeof store.dispatch;
export const useAppDispatch = () => useDispatch<AppDispatch>(); // Export a hook that can be reused to resolve types
