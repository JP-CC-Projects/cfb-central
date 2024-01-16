// loadingSlice.ts
import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { LoadingState } from './loadingTypes';

const initialState: LoadingState = {};

const loadingSlice = createSlice({
  name: 'loading',
  initialState,
  reducers: {
    setLoading: (state, action: PayloadAction<{ key: string, value: boolean }>) => {
      const { key, value } = action.payload;
      state[key] = value;
    }
  }
});

export const { setLoading } = loadingSlice.actions;
export default loadingSlice.reducer;
