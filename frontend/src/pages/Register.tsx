import axios from "axios"
import { FaForumbee } from "react-icons/fa"
import { useMutation } from "react-query"
import { Link, useNavigate } from "react-router-dom"
import tw from "twin.macro"
import { z } from "zod"

const RegistrationRequest = z.object({
  username: z.string(),
  email: z.string().email(),
  password: z.string(),
})
type RegistrationRequest = z.infer<typeof RegistrationRequest>

const RegistrationResponse = z.object({
  username: z.string(),
  email: z.string().email(),
  createdOn: z.string(),
  updatedOn: z.string(),
})
type RegistrationResponse = z.infer<typeof RegistrationResponse>

const Container = tw.div`
  h-screen w-screen bg-zinc-800 flex justify-center items-center
`
const RegisterForm = tw.form`
  bg-gradient-to-bl from-gray-900 to-black shadow-lg flex flex-col place-items-center h-fit pb-16 pt-8 px-8 rounded-lg min-w-[400px]
`
const Label = tw.label`
  place-self-start text-white mt-5
`
const FormInput = tw.input`
  text-sm rounded-lg block w-full p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400
  text-white focus:ring-blue-500 focus:border-blue-500
`
const SubmitButton = tw.button`
  bg-zinc-800 text-white text-xl mt-8 px-8 py-2 rounded-lg mb-5 hover:bg-zinc-700 transition-all duration-200 ease-in-out
`

function Register() {
  const navigate = useNavigate()
  const registerMutation = useMutation(
    ({ username, email, password }: RegistrationRequest) =>
      axios.post("/register", { username, email, password }).then(res => RegistrationResponse.parse(res.data)),
    {
      onSuccess: ({ username, email, createdOn, updatedOn }: RegistrationResponse) => {
        navigate("/login")
      },
    },
  )

  return (
    <Container>
      <RegisterForm action="submit">
        <div className="mb-7">
          <FaForumbee size={80} color="white" />
        </div>
        <Label htmlFor="username" className="place-self-start text-white">
          Username
        </Label>
        <FormInput type="text" id="username" placeholder="Enter your username" />
        <Label htmlFor="email" className="place-self-start text-white">
          Email
        </Label>
        <FormInput type="email" id="email" placeholder="Enter your email" />
        <Label htmlFor="password" className="place-self-start text-white">
          Password
        </Label>
        <FormInput type="password" id="password" placeholder="Enter your password" />
        <Label htmlFor="confirmPassword" className="place-self-start text-white">
          Confirm password
        </Label>
        <FormInput type="password" id="confirmPassword" placeholder="Confirm your password" />
        <SubmitButton type="submit">Register</SubmitButton>
        <div className="px-32 flex flex-col items-center">
          <span className="text-white text-sm items-center flex flex-col">
            Already have an account ? <br />
            <Link to="/login" className="text-blue-500 underline hover:text-blue-400 transition-all ease-in-out">
              Log in here
            </Link>
          </span>
        </div>
      </RegisterForm>
    </Container>
  )
}

export default Register
