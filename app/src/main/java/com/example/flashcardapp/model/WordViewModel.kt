package com.example.flashcardapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flashcardapp.data.WordPair
import com.example.flashcardapp.data.WordRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel(){


    // **StateFlow** ашиглан UI-д шинэчлэгдсэн өгөгдөл дамжуулах
    private val _words = MutableStateFlow<List<WordPair>>(emptyList())
    val words: StateFlow<List<WordPair>> = _words

    init {
        loadAllWords()
    }

    private fun loadAllWords() {
        viewModelScope.launch {
            repository.getAllWordsStream().collect { wordList ->
                _words.value = wordList
            }
        }
    }


    fun insertWord(WordPair: WordPair) {
        viewModelScope.launch {
            repository.insertWord(WordPair)
            loadAllWords()
        }
    }

    fun updateWord(WordPair: WordPair) {
        viewModelScope.launch {
            repository.insertWord(WordPair)
            loadAllWords()
        }
    }

    fun deleteWord(WordPair: WordPair) {
        viewModelScope.launch {
            repository.deleteWord(WordPair)
            loadAllWords()
        }
    }

    fun getAllWords() {
        viewModelScope.launch {
            repository.getAllWordsStream()
        }
    }

    fun getOneWord(id:Int) {
        viewModelScope.launch {
            repository.getOneWordStream(id)
        }
    }

    fun getEnglishWords() {
        viewModelScope.launch {
            repository.getEnglishWordsStream()
        }
    }

    fun getMongolianWords() {
        viewModelScope.launch {
            repository.getMongolianWordsStream()
        }
    }
}