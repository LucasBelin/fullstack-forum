import { Link } from "react-router-dom"

function Login() {
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
        <input type="text" id="username" placeholder="Enter your username" className="form-input mb-5" />
        <label htmlFor="password" className="place-self-start text-white">
          Password
        </label>
        <input type="password" id="password" placeholder="Enter your password" className="form-input" />
        <button type="submit" className="form-submit">
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
