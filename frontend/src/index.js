// import React from "react";
// import ReactDOM from "react-dom";
// import App from "./App";
// import { StyledEngineProvider } from "@mui/material/styles";

// ReactDOM.render(
//   <StyledEngineProvider injectFirst>
//     <App />
//   </StyledEngineProvider>,
//   document.getElementById("root")
// );
import React from "react";
import App from "./App";

import { createRoot } from "react-dom/client";
const container = document.getElementById("root");
const root = createRoot(container);
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
