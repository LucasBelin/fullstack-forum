import axios from "axios"
import { useRef } from "react"
import { useSignIn } from "react-auth-kit"
import { FaForumbee } from "react-icons/fa"
import { useMutation } from "react-query"
import { Link, useNavigate } from "react-router-dom"
import tw from "twin.macro"
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

const Container = tw.div`
  h-screen w-screen bg-slate-900 flex justify-center items-center
`
const LoginForm = tw.form`
  bg-gradient-to-bl from-gray-900 to-black shadow-lg flex flex-col place-items-center h-fit pb-16 pt-8 px-8 rounded-lg min-w-[400px]
`
const FormInput = tw.input`
  text-sm rounded-lg block w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400
  text-white focus:ring-blue-500 focus:border-blue-500
`
const SubmitButton = tw.button`
  bg-zinc-800 text-white text-xl mt-8 px-8 py-2 rounded-lg mb-5 hover:bg-zinc-700 transition-all duration-200 ease-in-out
`

function Login() {
  const usernameRef = useRef<HTMLInputElement>(null)
  const passwordRef = useRef<HTMLInputElement>(null)
  const navigate = useNavigate()
  const signIn = useSignIn()
  const authMutation = useMutation(
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
    <Container>
      <LoginForm action="submit">
        <div className="mb-12">
          <FaForumbee size={80} color="white" />
        </div>
        <label htmlFor="username" className="place-self-start text-white">
          Username
        </label>
        <FormInput ref={usernameRef} type="text" id="username" placeholder="Enter your username" className="mb-5" />
        <label htmlFor="password" className="place-self-start text-white">
          Password
        </label>
        <FormInput ref={passwordRef} type="password" id="password" placeholder="Enter your password" />
        <SubmitButton
          onClick={(e: any) => {
            e.preventDefault()
            authMutation.mutate({ username: usernameRef.current?.value, password: passwordRef.current?.value })
          }}
        >
          Login
        </SubmitButton>
        <span className="text-white text-sm items-center flex flex-col">
          Don't have an account yet ? <br />
          <Link to="/register" className="text-blue-600 underline hover:text-blue-500 transition-all ease-in-out">
            Register here
          </Link>
        </span>
      </LoginForm>
    </Container>
  )
}

export default Login
