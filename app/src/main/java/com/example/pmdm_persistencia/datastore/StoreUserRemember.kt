package com.example.pmdm_persistencia.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserRemember(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserRemember")
        val USER_EMAIL_KEY = stringPreferencesKey("user_remember")
    }

    val getRemember: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: "n"
        }

    suspend fun saveRemember(option: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = option
        }
    }
}