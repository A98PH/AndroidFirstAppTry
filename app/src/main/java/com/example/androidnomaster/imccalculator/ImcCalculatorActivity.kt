package com.example.androidnomaster.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.androidnomaster.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = true
    private var isOtherSelected:Boolean = true

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var viewOther:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.btnMan)
        viewFemale = findViewById(R.id.btnWoman)
        viewOther = findViewById(R.id.btnOther)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener{
            setGenderColor()
            changeGender()
        }
        viewFemale.setOnClickListener{
            setGenderColor()
            changeGender()
        }
        viewOther.setOnClickListener{
            setGenderColor()
            changeGender()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
        isOtherSelected = !isOtherSelected
    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
        viewOther.setCardBackgroundColor(getBackgroundColor(isOtherSelected))

    }

    private fun getBackgroundColor(isSelectedComponent:Boolean) : Int {

        val colorReference = if(isSelectedComponent) {
            R.color.background_component_selected
        }else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
    }

}