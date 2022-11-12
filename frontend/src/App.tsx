import { useEffect, useState } from "react"
import { getUsers, UserDetails } from "./services/user-service"

function App() {
  const [users, setUsers] = useState<UserDetails[]>([])
  const [loading, setLoading] = useState(true)

  const fetchUsers = async () => {
    setLoading(true)
    const data = await getUsers()
    setUsers(data)
    setLoading(false)
  }

  useEffect(() => {
    fetchUsers()
  }, [])

  return (
    <div className="h-screen w-screen flex items-center flex-col bg-slate-900 pt-28 gap-28">
      <h1 className="text-white font-bold text-3xl mb-5">Hello World</h1>
      {loading ? (
        <p className="text-white">Loading...</p>
      ) : (
        <ul className="flex flex-col gap-5">
          {users.map(user => (
            <li key={user.id} className="text-white">
              {user.username}
            </li>
          ))}
        </ul>
      )}
    </div>
  )
}

export default App
