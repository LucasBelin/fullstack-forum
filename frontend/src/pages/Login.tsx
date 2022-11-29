import axios from "axios"
import { useRef } from "react"
import { useSignIn } from "react-auth-kit"
import { Link, useNavigate } from "react-router-dom"

function Login() {
  const usernameRef = useRef<HTMLInputElement>(null)
  const passwordRef = useRef<HTMLInputElement>(null)
  const signIn = useSignIn()
  const navigate = useNavigate()

  const onSubmit = async (e: any) => {
    e.preventDefault()

    try {
      const username = usernameRef.current?.value
      const password = passwordRef.current?.value
      const res = await axios.post("http://localhost:8080/api/login", {
        username: username,
        password: password,
      })
      signIn({
        token: res.data.token,
        expiresIn: 6000000,
        tokenType: "Bearer",
        authState: { username: username },
      })
      navigate("/")
    } catch (err) {
      console.log(err)
    }
  }

  return (
    <div className="h-screen w-screen bg-zinc-800 flex justify-center items-center">
      <form
        action="submit"
        className="form-gradient shadow-lg flex flex-col place-items-center h-fit pb-16 pt-8 px-8 rounded-lg min-w-[400px]"
      >
        <img src="/assets/logo.svg" alt="logo" className="w-[80px] h-[80px] mb-12" />
        <label htmlFor="username" className="place-self-start text-white">
          Username
        </label>
        <input
          ref={usernameRef}
          type="text"
          id="username"
          placeholder="Enter your username"
          className="form-input mb-5"
        />
        <label htmlFor="password" className="place-self-start text-white">
          Password
        </label>
        <input
          ref={passwordRef}
          type="password"
          id="password"
          placeholder="Enter your password"
          className="form-input"
        />
        <button onClick={onSubmit} className="form-submit">
          Login
        </button>
        <span className="text-white text-sm items-center flex flex-col">
          Don't have an account yet ? <br />
          <Link to="/register" className="text-blue-600 underline hover:text-blue-500 transition-all ease-in-out">
            Register here
          </Link>
        </span>
      </form>
    </div>
  )
}

export default Login
