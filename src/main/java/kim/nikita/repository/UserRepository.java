package kim.nikita.repository;

import kim.nikita.model.User;

public interface UserRepository {

    User findByLogin(String login);

}
