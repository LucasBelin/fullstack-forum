import axios from "axios"
import { z } from "zod"

const UserSchema = z.object({
  id: z.number(),
  username: z.string(),
  email: z.string().email(),
  createdOn: z.date(),
  updatedOn: z.date(),
})

const UserArraySchema = z.array(UserSchema)

export type User = z.infer<typeof UserSchema>

const baseUrl = "http://localhost:8080/api"

export const getUsers = async (): Promise<User[]> => {
  return axios
    .get(`${baseUrl}/users`)
    .then(res => {
      const users: User[] = []
      res.data.forEach((user: User) => {
        users.push({
          id: user.id,
          username: user.username,
          email: user.email,
          createdOn: new Date(user.createdOn),
          updatedOn: new Date(user.updatedOn),
        })
      })
      return UserArraySchema.parse(users)
    })
    .catch(err => {
      console.log(err)
      throw err
    })
}
