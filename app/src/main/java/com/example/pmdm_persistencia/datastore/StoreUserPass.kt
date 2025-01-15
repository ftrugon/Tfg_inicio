package com.example.pmdm_persistencia.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StoreUserPass(private val context: Context) {

    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("UserPass")
        val USER_EMAIL_KEY = stringPreferencesKey("user_pass")
    }

    val getPass: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[USER_EMAIL_KEY] ?: ""
        }

    suspend fun savePass(pass: String) {
        context.dataStore.edit { preferences ->
            preferences[USER_EMAIL_KEY] = pass
        }
    }
}