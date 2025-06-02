package com.denisczwicz.onemenu.application.usecase;

/**
 * DeleteUserUseCase is an interface that defines the contract for deleting a user.
 * It provides a method to delete a user by their ID.
 */
public interface DeleteUserUseCase {

    void deleteUser(Long id);
}
