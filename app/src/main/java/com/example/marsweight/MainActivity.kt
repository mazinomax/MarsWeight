package com.example.marsweight

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val marsWeight:Float= 0.38F
    val venusWeight:Float = 0.5F
    val jupiterweight:Float = 0.7F

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        calcWeightButton.setOnClickListener {
            
//            var NewResult = calculateWeight(earthWeight.toString().toDouble())
//            
//           if (enterweightEDt.text.isEmpty()) {
//
//               resultTxt.text = "Please enter weight"
//           } else{
//
//               resultTxt.text = " Your weight in mars is:" + NewResult.toString()
//           }


            
            


        }


        MarscheckBox.setOnClickListener(this)
        JupitercheckBox.setOnClickListener(this)
        VenusCheckBox.setOnClickListener(this)

    }

    fun calculateWeight (weight: Double, checkbox: CheckBox)  {

        //return weight * marsWeight
        var result: Double?
        
        when (checkbox.id) {
            R.id.JupitercheckBox -> {result =weight * jupiterweight
                                       resultTxt.text = "Weight is " + result.format(2) + " in Jupiterrs."}
            R.id.VenusCheckBox -> {result = weight * venusWeight
                                       resultTxt.text = "Weight is " + result.format(2) + " in Venus."}
            R.id.MarscheckBox -> {result = weight * marsWeight
                                       resultTxt.text = "Weight is " + result.format(2) + " in Mars."}
            else -> result = weight * marsWeight
        }

       // resultTxt.text = "Weight is " + result

    }

    override fun onClick(v: View?) {
        v as CheckBox
        var isChecked: Boolean = v.isChecked
        var earthWeight = enterweightEDt.text

        when (v.id) {
            R.id.MarscheckBox -> if (isChecked && !TextUtils.isEmpty(earthWeight)) { calculateWeight(earthWeight.toString().toDouble(), v )
                                                                                     VenusCheckBox.isChecked = false
                                                                                     JupitercheckBox.isChecked = false}

            R.id.VenusCheckBox -> if (isChecked && !TextUtils.isEmpty(earthWeight)) {calculateWeight(earthWeight.toString().toDouble(), v)
                                                                                       MarscheckBox.isChecked = false
                                                                                       JupitercheckBox.isChecked = false}
            R.id.JupitercheckBox -> if (isChecked && !TextUtils.isEmpty(earthWeight)) {calculateWeight(earthWeight.toString().toDouble(), v)
                                                                                       VenusCheckBox.isChecked = false
                                                                                        MarscheckBox.isChecked = false}


        }
    }

    fun Double.format(digits: Int) = "%.${digits}f".format(this)

}