package com.michael.courierassistant.domain.usecase

import com.michael.courierassistant.domain.model.User
import com.michael.courierassistant.domain.model.UserRegistrationModel
import com.michael.courierassistant.domain.repository.ICourierRepository
import io.reactivex.Observable

class RegistrationUseCase(private val courierRepository: ICourierRepository) {
    fun execute(userRegistrationModel: UserRegistrationModel): Observable<User> {
        return courierRepository.registerUser(userRegistrationModel)
    }
}