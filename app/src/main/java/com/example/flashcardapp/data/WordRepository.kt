package com.example.flashcardapp.data

import kotlinx.coroutines.flow.Flow

interface WordRepository {
    suspend fun insertWord(WordPair: WordPair)

    suspend fun deleteWord(WordPair: WordPair)

    suspend fun updateWord(WordPair: WordPair)

    fun getAllWordsStream(): Flow<List<WordPair>>

    fun getOneWordStream(id: Int): Flow<WordPair?>

    fun getMongolianWordsStream(): Flow<List<WordPair>>

    fun getEnglishWordsStream(): Flow<List<WordPair>>
}