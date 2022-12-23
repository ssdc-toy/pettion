import axios from "axios";
import { useEffect, useState } from "react";

const Hello = () => {
  const [text, setText] = useState("");

  useEffect(() => {
    axios({
      url: "/api",
      method: "get",
    }).then((response) => {
      setText(response.data);
    });
  }, []);

  return <div>{text}</div>;
};

export default Hello;
