import axios from "axios"
import React from "react"
import { AuthProvider } from "react-auth-kit"
import ReactDOM from "react-dom/client"
import { BrowserRouter } from "react-router-dom"
import App from "./App"
import "./index.css"
import GlobalStyles from "./styles/GlobalStyles"

axios.defaults.baseURL = "http://localhost:8080/api"
axios.defaults.headers.post["Content-Type"] = "application/json"

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <AuthProvider authType={"cookie"} authName={"_auth"} cookieDomain={window.location.hostname} cookieSecure={false}>
      <BrowserRouter>
        <GlobalStyles />
        <App />
      </BrowserRouter>
    </AuthProvider>
  </React.StrictMode>,
)
