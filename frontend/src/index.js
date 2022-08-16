import React from "react";
import App from "./App";
import 'antd/es/spin/style/css';

import { createRoot } from "react-dom/client";
const container = document.getElementById("root");


const root = createRoot(container);
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
