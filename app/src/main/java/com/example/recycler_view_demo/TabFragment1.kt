package com.example.recycler_view_demo

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.fragment_tab1.*
import java.security.AccessController.getContext
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TabFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabFragment1 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //private lateinit var mWordList: LinkedList<String>
    private lateinit var mViewModel: MyViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: WordListAdapter

    private lateinit var fab: FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_tab1, container, false)
        fab = view.findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        //mWordList = (activity as MainActivity).viewModel.getWordList()
        mViewModel = (activity as MainActivity).viewModel!!

        fab.setOnClickListener {
            mViewModel.addNewWord()
            mRecyclerView.adapter?.notifyItemChanged(mViewModel.getWordListSize())
            mRecyclerView.smoothScrollToPosition(mViewModel.getWordListSize())
            Toast.makeText(this.context, "new Word created: " + (MyViewModel.sCount - 1), Toast.LENGTH_SHORT).show()
        }

        mRecyclerView = view.findViewById(R.id.recyclerview)
        mAdapter = WordListAdapter(this.context, mViewModel)
        Toast.makeText(this.context, "SIZE: " + mViewModel.getWordListSize(), Toast.LENGTH_SHORT).show()
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(this.context)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TabFragment1.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TabFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}