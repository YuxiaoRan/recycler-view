package com.example.recycler_view_demo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.wordlist_item.view.*
import java.util.*

class WordListAdapter: RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    //private val mWordList: LinkedList<String>
    private val mViewMoedl: DataViewModel
    private var mInflater: LayoutInflater

    constructor(context: Context?, viewModel: DataViewModel) {
        mInflater = LayoutInflater.from(context)
        this.mViewMoedl = viewModel
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordListAdapter.WordViewHolder {
        val mItemView: View = mInflater.inflate(R.layout.wordlist_item,
            parent, false)
        return WordViewHolder(mItemView, this)
    }

    override fun getItemCount(): Int {
        return mViewMoedl.getWordListSize()
    }

    override fun onBindViewHolder(holder: WordListAdapter.WordViewHolder, position: Int) {
        val mCurrent: String = mViewMoedl.getWordList().get(position)
        holder.wordItemView.text = mCurrent
    }

    inner class WordViewHolder: RecyclerView.ViewHolder, View.OnClickListener {
        public val wordItemView: TextView
        val mAdapter: WordListAdapter

        constructor(itemView: View, adapter: WordListAdapter): super(itemView) {
            wordItemView = itemView.word
            mAdapter = adapter
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val mPosition: Int = layoutPosition
            val element: String = mViewMoedl.getWordList().get(mPosition)
            mViewMoedl.update(mPosition, "Clicked! " + element)
            mAdapter.notifyDataSetChanged()
        }
    }

}