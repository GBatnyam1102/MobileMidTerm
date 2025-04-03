package com.example.flashcardapp.data

import kotlinx.coroutines.flow.Flow

class OfflineWordRepository(private val WordDao: WordDao): WordRepository {
    override suspend fun insertWord(WordPair: WordPair) = WordDao.WordInsert(WordPair)

    override suspend fun updateWord(WordPair: WordPair) = WordDao.WordUpdate(WordPair)

    override suspend fun deleteWord(WordPair: WordPair) = WordDao.WordDelete(WordPair)

    override fun getOneWordStream(id: Int): Flow<WordPair?> = WordDao.getWord(id)

    override fun getAllWordsStream(): Flow<List<WordPair>> = WordDao.getAllWords()

    override fun getEnglishWordsStream(): Flow<List<WordPair>> = WordDao.getEnglishWords()

    override fun getMongolianWordsStream(): Flow<List<WordPair>> = WordDao.getMongolianWords()
}