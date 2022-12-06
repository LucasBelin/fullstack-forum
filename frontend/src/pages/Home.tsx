import { useSignOut } from "react-auth-kit"
import { useNavigate } from "react-router-dom"

function Home() {
  const signOut = useSignOut()
  const navigate = useNavigate()

  const logout = () => {
    signOut()
    navigate("/login")
  }

  return (
    <>
      <button onClick={logout}>Click me</button>
    </>
  )
}

export default Home
