import { createGlobalStyle } from "styled-components";

const GlobalStyle = createGlobalStyle`
 html {
    width: 100%;
    height: 100%;
    font-size: 16px;
  }

  body {
    width: 100%;
    height: 100%;
    font-family: 'Pretendard' !important;
    box-sizing: border-box;

    #root {
      width: 100%;
      height: 100%;
    }
  }

  a {
    color: inherit;
    text-decoration: none;
  }

  button {
    cursor: pointer;
    border: none;

    &:focus {
      outline: none;
    }
  }

  button, input, textarea {
    font: inherit;
  }

  * {
    box-sizing: inherit;
  }
`;
export default GlobalStyle;