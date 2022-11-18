import { Link } from "react-router-dom"

function Register() {
  return (
    <div className="flex w-screen h-screen justify-center items-center">
      <div className="form-gradient text-white min-w-[600px] flex rounded-lg">
        <div className="px-32 flex flex-col items-center">
          <img src="/assets/logo.svg" alt="logo" className="w-32 h-32" />
          <p className="max-w-md text-center">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Iure quidem dolore ea beatae cumque cupiditate
            nesciunt odit minus, soluta iste aperiam totam sed exercitationem magnam quia voluptas earum aut saepe!
          </p>
          <span className="text-white text-sm items-center flex flex-col">
            Already have an account ? <br />
            <Link to="/login" className="text-blue-600 underline hover:text-blue-500 transition-all ease-in-out">
              Log in here
            </Link>
          </span>
        </div>
        <form action="submit">
          <h1>Register</h1>
          <label htmlFor="username">Username</label>
          <input type="text" id="username" placeholder="Enter your username" className="form-input" />
          <label htmlFor="email">Email</label>
          <input type="email" id="email" placeholder="Enter your email" className="form-input" />
          <label htmlFor="password">Password</label>
          <input type="password" id="password" placeholder="Enter your password" className="form-input" />
          <label htmlFor="confirmPassword">Confirm password</label>
          <input type="password" id="confirmPassword" placeholder="Confirm your password" className="form-input" />
          <button type="submit" className="form-submit">
            Register
          </button>
        </form>
      </div>
    </div>
  )
}

export default Register
