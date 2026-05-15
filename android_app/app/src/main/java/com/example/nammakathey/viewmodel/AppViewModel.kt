package com.example.nammakathey.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private val prefs = application.getSharedPreferences("namma_kathey_prefs", Context.MODE_PRIVATE)

    private val _language = MutableStateFlow(prefs.getString("language", "en") ?: "en")
    val language: StateFlow<String> = _language.asStateFlow()

    private val _badges = MutableStateFlow<List<String>>(prefs.getStringSet("badges", emptySet())?.toList() ?: emptyList())
    val badges: StateFlow<List<String>> = _badges.asStateFlow()
    
    private val _readStories = MutableStateFlow<Set<String>>(prefs.getStringSet("readStories", emptySet()) ?: emptySet())
    val readStories: StateFlow<Set<String>> = _readStories.asStateFlow()

    private val _completedQuizzes = MutableStateFlow<Set<String>>(prefs.getStringSet("completedQuizzes", emptySet()) ?: emptySet())
    val completedQuizzes: StateFlow<Set<String>> = _completedQuizzes.asStateFlow()
    
    private val _savedStories = MutableStateFlow<Set<String>>(prefs.getStringSet("savedStories", emptySet()) ?: emptySet())
    val savedStories: StateFlow<Set<String>> = _savedStories.asStateFlow()
    
    private val _userName = MutableStateFlow(prefs.getString("userName", "User Name") ?: "User Name")
    val userName: StateFlow<String> = _userName.asStateFlow()
    
    private val _userProfileAvatarUri = MutableStateFlow<String?>(prefs.getString("userProfileAvatarUri", null))
    val userProfileAvatarUri: StateFlow<String?> = _userProfileAvatarUri.asStateFlow()
    
    // index maps to some default profile images or dicebear seeds
    private val _userProfileSeed = MutableStateFlow(prefs.getString("userProfileSeed", "default") ?: "default")
    val userProfileSeed: StateFlow<String> = _userProfileSeed.asStateFlow()

    private val _ttsSpeed = MutableStateFlow(prefs.getFloat("ttsSpeed", 1.0f))
    val ttsSpeed: StateFlow<Float> = _ttsSpeed.asStateFlow()
    
    private val _isDarkMode = MutableStateFlow(prefs.getBoolean("isDarkMode", false))
    val isDarkMode: StateFlow<Boolean> = _isDarkMode.asStateFlow()
    
    private val _isLoggedIn = MutableStateFlow(prefs.getBoolean("is_logged_in", false))
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()
    
    // email -> password
    private val _registeredUsers = MutableStateFlow<Map<String, String>>(
        mapOf(
            (prefs.getString("registered_email", "") ?: "") to (prefs.getString("registered_pass", "") ?: "")
        ).filterKeys { it.isNotEmpty() }
    )
    
    fun toggleLanguage() {
        val newLang = if (_language.value == "en") "kn" else "en"
        _language.value = newLang
        prefs.edit().putString("language", newLang).apply()
    }
    
    fun setTtsSpeed(speed: Float) {
        _ttsSpeed.value = speed
        prefs.edit().putFloat("ttsSpeed", speed).apply()
    }
    
    fun toggleDarkMode() {
        _isDarkMode.value = !_isDarkMode.value
        prefs.edit().putBoolean("isDarkMode", _isDarkMode.value).apply()
    }
    
    fun register(email: String, pass: String): Boolean {
        if (email.isBlank() || pass.isBlank()) return false
        val currentUsers = _registeredUsers.value.toMutableMap()
        if (currentUsers.containsKey(email)) return false
        currentUsers[email] = pass
        _registeredUsers.value = currentUsers
        
        prefs.edit().putString("registered_email", email).putString("registered_pass", pass).apply()
        return true
    }
    
    fun login(email: String, pass: String): Boolean {
        if (_registeredUsers.value[email] == pass) {
            _isLoggedIn.value = true
            prefs.edit().putBoolean("is_logged_in", true).apply()
            return true
        }
        return false
    }
    
    fun logout() {
        _isLoggedIn.value = false
        prefs.edit().putBoolean("is_logged_in", false).apply()
    }

    fun addBadge(badgeId: String) {
        val currentList = _badges.value.toMutableList()
        if (!currentList.contains(badgeId)) {
            currentList.add(badgeId)
            _badges.value = currentList
            prefs.edit().putStringSet("badges", currentList.toSet()).apply()
        }
    }
    
    fun markStoryRead(heroId: String) {
        val currentSet = _readStories.value.toMutableSet()
        currentSet.add(heroId)
        _readStories.value = currentSet
        prefs.edit().putStringSet("readStories", currentSet).apply()
    }
    
    fun markQuizCompleted(heroId: String) {
        val currentSet = _completedQuizzes.value.toMutableSet()
        currentSet.add(heroId)
        _completedQuizzes.value = currentSet
        prefs.edit().putStringSet("completedQuizzes", currentSet).apply()
        addBadge(heroId)
    }
    
    fun updateUserProfileSeed(seed: String) {
        _userProfileSeed.value = seed
        prefs.edit().putString("userProfileSeed", seed).apply()
    }
    
    fun updateProfile(name: String, seed: String) {
        _userName.value = name
        _userProfileSeed.value = seed
        prefs.edit().putString("userName", name).putString("userProfileSeed", seed).apply()
    }

    fun updateUserProfileAvatarUri(uri: String?) {
        _userProfileAvatarUri.value = uri
        prefs.edit().putString("userProfileAvatarUri", uri).apply()
    }

    fun toggleSavedStory(heroId: String) {
        val currentSet = _savedStories.value.toMutableSet()
        if (currentSet.contains(heroId)) {
            currentSet.remove(heroId)
        } else {
            currentSet.add(heroId)
        }
        _savedStories.value = currentSet
        prefs.edit().putStringSet("savedStories", currentSet).apply()
    }
}
