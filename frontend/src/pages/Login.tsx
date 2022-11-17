import { Link } from "react-router-dom"

function Login() {
  return (
    <div className="h-screen w-screen bg-zinc-800 flex justify-center items-center">
      <form
        action="submit"
        className="bg-gradient-to-bl from-gray-900 to-black shadow-lg flex flex-col place-items-center h-fit pb-16 pt-8 px-8 rounded-lg min-w-[400px]"
      >
        <img src="/assets/logo.svg" alt="logo" className="w-[80px] h-[80px] mb-12" />
        <label htmlFor="username" className="place-self-start text-white">
          Username
        </label>
        <input type="text" id="username" placeholder="Enter your username" className="login-input mb-5" />
        <label htmlFor="password" className="place-self-start text-white">
          Password
        </label>
        <input type="password" id="password" placeholder="Enter your password" className="login-input" />
        <button
          type="submit"
          className="bg-zinc-800 text-white text-xl mt-8 px-8 py-2 rounded-lg mb-5 hover:bg-zinc-700 transition-all duration-200 ease-in-out"
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
