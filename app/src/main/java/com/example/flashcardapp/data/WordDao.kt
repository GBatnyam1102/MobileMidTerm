package com.example.flashcardapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun WordInsert(WordPair: WordPair)

    @Update
    suspend fun WordUpdate(WordPair: WordPair)

    @Delete
    suspend fun WordDelete(WordPair: WordPair)

    @Query("SELECT * FROM WordPair")
    fun getAllWords(): Flow<List<WordPair>>

    @Query("SELECT * FROM WordPair WHERE id = :id")
    fun getWord(id: Int): Flow<WordPair?>

    @Query("SELECT mongolian FROM WordPair")
    fun getMongolianWords(): Flow<List<WordPair>>

    @Query("SELECT english FROM WordPair")
    fun getEnglishWords(): Flow<List<WordPair>>


}