import axios from "axios"
import { useRef } from "react"
import { useSignIn } from "react-auth-kit"
import { FaForumbee } from "react-icons/fa"
import { useMutation } from "react-query"
import { Link, useNavigate } from "react-router-dom"
import { z } from "zod"

const AuthResponse = z.object({
  token: z.string(),
  tokenType: z.string(),
  expiresIn: z.number(),
})
type AuthResponse = z.infer<typeof AuthResponse>

const AuthRequest = z.object({
  username: z.string().optional(),
  password: z.string().optional(),
})
type AuthRequest = z.infer<typeof AuthRequest>

function Login() {
  const usernameRef = useRef<HTMLInputElement>(null)
  const passwordRef = useRef<HTMLInputElement>(null)
  const navigate = useNavigate()
  const signIn = useSignIn()
  const authQuery = useMutation(
    ({ username, password }: AuthRequest) =>
      axios.post("/login", { username, password }).then(res => AuthResponse.parse(res.data)),
    {
      onSuccess: ({ token, tokenType, expiresIn }: AuthResponse) => {
        signIn({
          token: token,
          tokenType: tokenType,
          expiresIn: expiresIn,
          authState: { username: usernameRef.current?.value },
        })
        axios.defaults.headers.common["Authorization"] = `${tokenType} ${token}`
        navigate("/")
      },
    },
  )

  return (
    <div className="h-screen w-screen bg-zinc-800 flex justify-center items-center">
      <form
        action="submit"
        className="form-gradient shadow-lg flex flex-col place-items-center h-fit pb-16 pt-8 px-8 rounded-lg min-w-[400px]"
      >
        <div className="mb-12">
          <FaForumbee size={80} color="white" />
        </div>
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
        <button
          onClick={(e: any) => {
            e.preventDefault()
            authQuery.mutate({ username: usernameRef.current?.value, password: passwordRef.current?.value })
          }}
          className="form-submit"
        >
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
