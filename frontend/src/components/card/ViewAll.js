import * as React from "react";
import Box from "@mui/material/Box";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select from "@mui/material/Select";

export default function BasicSelect() {
  const [selectType, setSelectType] = React.useState("");

  const handleChange = (event) => {
    setSelectType(event.target.value);
  };
  const styles = {
    maxWidth: "120px",
    justifyContent: "center",
  };
  return (
    <Box sx={{ minWidth: 120 }} style={styles}>
      <FormControl fullWidth>
        <InputLabel id="demo-simple-select-label">ViewAll</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={selectType}
          label="ViewAll"
          onChange={handleChange}
        >
          <MenuItem value={"All"}>All</MenuItem>
          <MenuItem value={"Following"}>Following</MenuItem>
        </Select>
      </FormControl>
    </Box>
  );
}
