import axios, { AxiosError } from "axios"
import React, { useRef, useState } from "react"
import { toast } from "react-hot-toast"
import { AiOutlineMail, AiTwotoneEye, AiTwotoneEyeInvisible, AiTwotoneLock } from "react-icons/ai"
import { FiAtSign } from "react-icons/fi"
import { useMutation } from "react-query"
import { Link, useNavigate } from "react-router-dom"
import styled from "styled-components"
import tw from "twin.macro"
import { z } from "zod"

const RegistrationRequest = z.object({
  username: z.string().optional(),
  email: z.string().email().optional(),
  password: z.string().optional(),
})
type RegistrationRequest = z.infer<typeof RegistrationRequest>

const Container = tw.div`
  h-screen w-screen bg-slate-900 flex justify-center items-center
`
const RegisterForm = tw.form`
  flex flex-col justify-center bg-gradient-to-bl from-gray-900 to-black px-16 py-16 rounded-md bg-opacity-5 h-fit max-w-xl shadow-inner shadow-slate-800
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

const regexUsername = /^[a-zA-Z0-9_ -]{3,16}$/ // 3-16 characters, only letters, numbers, dashes, underscores, and spaces
const regexEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/
const regexPassword = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@#$%&+=!])[A-Za-z\d@$!%*?&]{8,}$/ // 8 characters, 1 uppercase, 1 lowercase, 1 number, 1 special character

function Register() {
  const [showPassword, setShowPassword] = useState(false)
  const [showConfirmPassword, setShowConfirmPassword] = useState(false)

  const [usernameError, setUsernameError] = useState(false)
  const [emailError, setEmailError] = useState(false)
  const [passwordError, setPasswordError] = useState(false)
  const [passwordMismatchError, setPasswordMismatchError] = useState(false)

  const usernameRef = useRef<HTMLInputElement>(null)
  const emailRef = useRef<HTMLInputElement>(null)
  const passwordRef = useRef<HTMLInputElement>(null)

  const navigate = useNavigate()
  const registerMutation = useMutation(
    ({ username, email, password }: RegistrationRequest) =>
      axios.post("/users/register", { username, email, password }),
    {
      onSuccess: () => {
        navigate("/login")
      },
      onError: err => {
        handleError(err as AxiosError)
      },
    },
  )

  const handleError = (err: AxiosError) => {
    console.log("toast")
    switch (err.response?.status) {
      case 400:
        toast.error("Make sure all fields are filled out correctly.")
        break
      case 409:
        toast.error("That username or email is already in use.")
        break
      default:
        toast.error("Something went wrong. Please try again later.")
        break
    }
  }

  const togglePasswordVisibility = (e: React.FormEvent<HTMLButtonElement>) => {
    e.preventDefault()
    setShowPassword(prev => !prev)
  }

  const toggleConfirmPasswordVisibility = (e: React.FormEvent<HTMLButtonElement>) => {
    e.preventDefault()
    setShowConfirmPassword(prev => !prev)
  }

  const validateUsername = (e: React.FormEvent<HTMLInputElement>) => {
    const username = e.currentTarget.value
    if (regexUsername.test(username)) {
      setUsernameError(false)
      return
    }
    setUsernameError(true)
  }

  const validateEmail = (e: React.FormEvent<HTMLInputElement>) => {
    const email = e.currentTarget.value
    if (regexEmail.test(email)) {
      setEmailError(false)
      return
    }
    setEmailError(true)
  }

  const validatePassword = (e: React.FormEvent<HTMLInputElement>) => {
    const password = e.currentTarget.value
    if (regexPassword.test(password)) {
      setPasswordError(false)
      return
    }
    setPasswordError(true)
  }

  const validateConfirmPassword = (e: React.FormEvent<HTMLInputElement>) => {
    const password = passwordRef.current?.value
    const confirmPassword = e.currentTarget.value
    if (password === confirmPassword) {
      setPasswordMismatchError(false)
      return
    }
    setPasswordMismatchError(true)
  }

  return (
    <Container>
      <RegisterForm action="submit">
        <h1 className="text-white text-3xl text-center">Create your account</h1>
        <Label htmlFor="username" className="place-self-start text-white">
          Username
        </Label>
        <div>
          <div className="flex">
            <span className="inline-flex items-center px-3 text-[20px] text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-l-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
              <FiAtSign size={20} />
            </span>
            <Input
              type="text"
              id="username"
              placeholder="Username"
              onBlur={e => validateUsername(e)}
              ref={usernameRef}
            />
          </div>
          {usernameError ? (
            <span className="text-red-600 text-sm ml-2">The username doesn't meet the requirements.</span>
          ) : null}
        </div>

        <Label htmlFor="email" className="place-self-start text-white">
          Email
        </Label>
        <div>
          <div className="flex">
            <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-l-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
              <AiOutlineMail size={20} />
            </span>
            <Input type="text" id="email" placeholder="john-doe@gmail.com" onBlur={validateEmail} ref={emailRef} />
          </div>
          {emailError ? (
            <span className="text-red-600 text-sm ml-2">The email doesn't meet the requirements.</span>
          ) : null}
        </div>

        <Label htmlFor="password" className="place-self-start text-white">
          Password
        </Label>
        <div>
          <div className="flex">
            <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-l-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
              <AiTwotoneLock size={20} />
            </span>
            <Input
              isPassword
              ref={passwordRef}
              type={showPassword ? "text" : "password"}
              id="password"
              placeholder="Your password"
              onBlur={validatePassword}
            />
            <button
              onClick={togglePasswordVisibility}
              className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-r-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600"
            >
              {showPassword ? <AiTwotoneEye size={20} /> : <AiTwotoneEyeInvisible size={20} />}
            </button>
          </div>
          {passwordError ? (
            <span className="text-red-600 text-sm ml-2">The password doesn't meet the requirements.</span>
          ) : null}
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
            type={showConfirmPassword ? "text" : "password"}
            id="confirm-password"
            placeholder="Confirm password"
            onBlur={validateConfirmPassword}
          />
          <button
            onClick={toggleConfirmPasswordVisibility}
            className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-r-0 border-gray-300 rounded-r-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600"
          >
            {showConfirmPassword ? <AiTwotoneEye size={20} /> : <AiTwotoneEyeInvisible size={20} />}
          </button>
        </div>
        {passwordMismatchError ? <span className="text-red-600 text-sm ml-2">The passwords don't match.</span> : null}
        <SubmitButton
          onClick={e => {
            e.preventDefault()
            registerMutation.mutate({
              username: usernameRef.current?.value,
              email: emailRef.current?.value,
              password: passwordRef.current?.value,
            })
          }}
        >
          Register
        </SubmitButton>
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
