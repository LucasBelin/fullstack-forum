import { RequireAuth } from "react-auth-kit"
import { Toaster } from "react-hot-toast"
import { QueryClient, QueryClientProvider } from "react-query"
import { Route, Routes } from "react-router-dom"
import Home from "./pages/Home"
import Login from "./pages/Login"
import Register from "./pages/Register"

function App() {
  const queryClient = new QueryClient()
  return (
    <QueryClientProvider client={queryClient}>
      <Toaster position="bottom-right" />
      <Routes>
        <Route
          path="/"
          element={
            <RequireAuth loginPath="/login">
              <Home />
            </RequireAuth>
          }
        />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
      </Routes>
    </QueryClientProvider>
  )
}

export default App
