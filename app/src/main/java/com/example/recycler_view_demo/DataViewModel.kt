package com.example.recycler_view_demo

import java.util.*

interface DataViewModel {
    fun getWordList(): LinkedList<String>
    fun getWordListSize(): Int
    fun update(pos: Int, newWord: String): Boolean
}