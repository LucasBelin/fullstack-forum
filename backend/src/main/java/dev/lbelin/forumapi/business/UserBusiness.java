package dev.lbelin.forumapi.business;

import dev.lbelin.forumapi.model.User;

public interface UserBusiness {

    public Boolean isPasswordValid(String password);

    public void validateUserData(User user);
}
