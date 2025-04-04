package com.sitadigi.coachingtop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sitadigi.coachingtop.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(userRepository: UserRepository): ViewModel() {
    val users = userRepository.getAllUsers().stateIn(viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

}