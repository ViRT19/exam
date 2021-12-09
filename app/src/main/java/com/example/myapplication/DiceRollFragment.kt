package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

private const val LAST_ROLLED_IMAGE = "image"
private const val LAST_ROLLED_IMAGE2 = "image"

class DiceRollFragment : Fragment() {

    lateinit var diceImageView: ImageView
    lateinit var diceImageView2: ImageView
    lateinit var rollButton: Button
    private val diceImageList: List<Int> = listOf(
        R.drawable.cube1,
        R.drawable.cube2,
        R.drawable.cube3,
        R.drawable.cube4,
        R.drawable.cube5,
        R.drawable.cube6
    )

    var lastRolledImageRes = 0
    var lastRolledImageRes2 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dice_roll, container, false)

        diceImageView = view.findViewById(R.id.dice_image_view)
        diceImageView2 = view.findViewById(R.id.dice_image_view2)
        rollButton = view.findViewById(R.id.roll_button)

        if (savedInstanceState != null) diceImageView.setImageResource(
            savedInstanceState.getInt(LAST_ROLLED_IMAGE)
        )
        if (savedInstanceState != null) diceImageView2.setImageResource(
            savedInstanceState.getInt(LAST_ROLLED_IMAGE2)
        )

        rollButton.setOnClickListener {
            lastRolledImageRes = diceImageList.random()
            diceImageView.setImageResource(lastRolledImageRes)
            lastRolledImageRes2 = diceImageList.random()
            diceImageView2.setImageResource(lastRolledImageRes2)
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_ROLLED_IMAGE, lastRolledImageRes)
        outState.putInt(LAST_ROLLED_IMAGE2, lastRolledImageRes2)
    }

}