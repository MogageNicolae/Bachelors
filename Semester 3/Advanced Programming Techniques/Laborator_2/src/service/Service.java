package service;

import domain.Friendship;
import domain.User;
import exceptions.NetworkException;
import exceptions.RepositoryException;
import exceptions.ValidationException;

import java.util.Vector;

public interface Service {
    /**
     * @param firstName = name of the entity
     * @param lastName  - name of the entity
     * @throws ValidationException if the entity is not valid
     * @throws RepositoryException if the entity already exists
     */
    void add(String firstName, String lastName) throws ValidationException, RepositoryException;

    /**
     * @param id        of the entity to update
     * @param firstName new name to update with
     * @param lastName  last name to update with
     * @throws RepositoryException if the entity does not exist
     * @throws ValidationException if the new entity is not valid
     */
    void updateUser(Long id, String firstName, String lastName) throws RepositoryException, ValidationException;

    /**
     * @param id id of the entity to remove
     * @return the entity that was removed
     * @throws RepositoryException if the entity does not exist
     */
    User remove(Long id) throws RepositoryException, NetworkException;

    /**
     * @param id of the entity to find
     * @return the user the id given as parameter
     * @throws RepositoryException if the entity with this id does not exist
     */
    User getUser(Long id) throws RepositoryException;

    /**
     * @param id1 id of the first entity to add friendship
     * @param id2 id of the second entity to add friendship
     * @throws NetworkException if they are already friends
     */
    void makeFriends(Long id1, Long id2) throws NetworkException, ValidationException, RepositoryException;

    /**
     * @param friendshipId of the entity to update
     * @param idUser1      new first id user to update with
     * @param idUser2      new second id user to update with
     * @throws ValidationException if the new friendship is not valid
     * @throws RepositoryException if the entity does not exist
     * @throws NetworkException    if the new friendship already exists
     */
    void updateFriends(Long friendshipId, Long idUser1, Long idUser2) throws ValidationException, RepositoryException, NetworkException;

    /**
     * @param id of the friendship to remove
     * @throws NetworkException if this friendship does not exist
     */
    void removeFriends(Long id) throws NetworkException, ValidationException, RepositoryException;

    /**
     * @return number of communities
     */
    int numberOfCommunities();

    /**
     * @return the community with the most people
     */
    Vector<User> mostPopulatedCommunity();

    /**
     * @return get all users
     */
    Iterable<User> getAllUsers();

    /**
     * @return get all friendships
     */
    Iterable<Friendship> getAllFriendships();

    /**
     * @return number of users in repository
     */
    int numberOfUsers();

    /**
     * @return number of friendships in repository
     */
    int numberOfFriendships();
}
