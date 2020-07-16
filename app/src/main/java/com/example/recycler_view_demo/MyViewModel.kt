package com.example.recycler_view_demo

import android.content.Context
import java.util.*
import kotlin.collections.HashMap

class MyViewModel: DataViewModel {
    val mWordList: LinkedList<String>

    constructor() {
        mWordList = LinkedList<String>()
        initWordList()
    }

    private fun initWordList() {
        for(i in 0 until 20) {
            mWordList.addLast("Word " + i)
        }
    }

    override fun getWordList(): LinkedList<String> = mWordList

    override fun getWordListSize(): Int = mWordList.size

    fun addWordToList(word: String) {
        mWordList.addLast(word)
    }

    fun addNewWord() {
        mWordList.addLast("Word " + sCount)
        sCount++
    }

    override fun update(pos: Int, newWord: String): Boolean {
        if (pos >= getWordListSize())
            return false
        else {
            mWordList.set(pos, newWord)
            return true
        }
    }

    companion object {
        var sCount: Int = 20
        open var binders: MutableMap<String?, MyViewModel> = HashMap<String?, MyViewModel>()

        fun obtainViewModel(context: String?): MyViewModel? {
            if(binders.containsKey(context))
                return binders[context]
            else {
                val vm = MyViewModel()
                binders.put(context, vm)
                return vm
            }
        }
    }
}