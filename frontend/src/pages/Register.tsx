import axios from "axios"
import React, { useState } from "react"
import { AiOutlineMail, AiTwotoneEye, AiTwotoneEyeInvisible, AiTwotoneLock } from "react-icons/ai"
import { FiAtSign } from "react-icons/fi"
import { useMutation } from "react-query"
import { Link, useNavigate } from "react-router-dom"
import styled from "styled-components"
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
  createdOn: z.string().datetime(),
  updatedOn: z.string().datetime(),
})
type RegistrationResponse = z.infer<typeof RegistrationResponse>

const Container = tw.div`
  h-screen w-screen bg-slate-900 flex justify-center items-center
`
const RegisterForm = tw.form`
  bg-gradient-to-bl from-gray-900 to-black shadow-lg flex flex-col place-items-center h-fit pb-16 pt-8 px-8 rounded-lg min-w-[400px]
`
const Label = tw.label`
  place-self-start text-white mt-5
`

const Input = styled.input<{ isPassword?: boolean }>`
  ${tw`rounded-none rounded-r-lg border block flex-1 min-w-0 w-full text-sm p-2.5 bg-gray-700 border-gray-600 placeholder-gray-400 text-white`}
  ${({ isPassword }) => isPassword && tw`rounded-none rounded-r-none`}
`
const SubmitButton = tw.button`
  bg-slate-800 text-white text-xl mt-8 px-8 py-2 rounded-lg mb-5 hover:bg-slate-700 transition-all
  duration-200 ease-in-out w-fit place-self-center
`

function Register() {
  const [showPassword, setShowPassword] = useState(false)
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

  const togglePasswordVisibility = (e: React.FormEvent<HTMLButtonElement>) => {
    e.preventDefault()
    setShowPassword(prev => !prev)
  }

  return (
    <Container>
      <form
        action="submit"
        className="flex flex-col bg-gradient-to-bl from-gray-900 to-black border border-black shadow-lg py-8 px-16 rounded-md bg-opacity-5 h-[80%] max-w-xl"
      >
        <h1 className="text-white text-3xl text-center">Create your account</h1>
        <Label htmlFor="username" className="place-self-start text-white">
          Username
        </Label>
        <div className="flex">
          <span className="inline-flex items-center px-3 text-[20px] text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-l-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
            <FiAtSign size={20} />
          </span>
          <Input type="text" id="username" placeholder="Jymmiah" />
        </div>

        <Label htmlFor="email" className="place-self-start text-white">
          Email
        </Label>
        <div className="flex">
          <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-l-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
            <AiOutlineMail size={20} />
          </span>
          <input
            type="text"
            id="email"
            className="rounded-none rounded-r-lg bg-gray-50 border text-gray-900 focus:ring-blue-500 focus:border-blue-500 block flex-1 min-w-0 w-full text-sm border-gray-300 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="lorem@ipsum.com"
          />
        </div>

        <Label htmlFor="password" className="place-self-start text-white">
          Password
        </Label>
        <div className="flex">
          <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-l-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
            <AiTwotoneLock size={20} />
          </span>
          <Input isPassword type={showPassword ? "text" : "password"} id="password" placeholder="Your password" />
          <button
            onClick={togglePasswordVisibility}
            className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-r-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600"
          >
            {showPassword ? <AiTwotoneEye size={20} /> : <AiTwotoneEyeInvisible size={20} />}
          </button>
        </div>

        <Label htmlFor="confirm-password" className="place-self-start text-white">
          Confirm password
        </Label>
        <div className="flex">
          <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-l-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
            <AiTwotoneLock size={20} />
          </span>
          <Input
            isPassword
            type={showPassword ? "text" : "password"}
            id="confirm-password"
            placeholder="Just to make sure"
          />
          <button
            onClick={togglePasswordVisibility}
            className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-r-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600"
          >
            {showPassword ? <AiTwotoneEye size={20} /> : <AiTwotoneEyeInvisible size={20} />}
          </button>
        </div>
        <SubmitButton>Register</SubmitButton>
        <div className="px-32 flex flex-col items-center">
          <span className="text-white text-sm items-center flex flex-col">
            Already have an account ? <br />
            <Link to="/login" className="text-blue-500 underline hover:text-blue-400 transition-all ease-in-out">
              Log in here
            </Link>
          </span>
        </div>
      </form>
    </Container>
  )
}

export default Register
