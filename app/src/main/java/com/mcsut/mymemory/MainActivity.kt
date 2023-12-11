package com.mcsut.mymemory

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcsut.mymemory.models.BoardSize
import com.mcsut.mymemory.models.MemoryCard
import com.mcsut.mymemory.models.MemoryGame
import com.mcsut.mymemory.utils.DEFAULT_ICONS

//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private lateinit var rvBoard: RecyclerView
    private lateinit var tvNumMoves: TextView
    private lateinit var tvNumPairs: TextView

    private var boardSize: BoardSize = BoardSize.EASY

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBoard = findViewById(R.id.rvBoard)
        tvNumMoves = findViewById(R.id.tvNumMoves)
        tvNumPairs = findViewById(R.id.tvNumPairs)

        val memoryGame = MemoryGame(boardSize)

        rvBoard.adapter = MemoryBoardAdapter(this, boardSize, memoryGame.cards, object: MemoryBoardAdapter.CardClickListener {
            override fun onCardClicked(position: Int) {
                Log.i(TAG, "Card clicked $position")
            }

        })
        rvBoard.setHasFixedSize(true)
        rvBoard.layoutManager = GridLayoutManager(this,boardSize.getWidth())
    }
}

