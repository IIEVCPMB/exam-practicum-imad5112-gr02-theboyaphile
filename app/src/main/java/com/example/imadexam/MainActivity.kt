package com.example.imadexam

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity :
    ComponentActivity() {

    //Mark data storage in parallel arrays
    private val itemNames =mutableListOf("Tent", "Marshmallows", "Flashlight")
    private val itemCategory =mutableListOf("Sheter", "Food", "Safety")
    private val itemQuantity =mutableSetOf("1","2","3")
    private val itemComments =mutableListOf("4-person waterproof", "For S'mores (Mega Size)","Check batteries(AA)")

    //UI(user interface view elements
    private lateinit var splashLayout: LinearLayout
    private lateinit var mainLayout: LinearLayout
    private lateinit var detailsLayout: LinearLayout
    private lateinit var addLayout: LinearLayout

    private lateinit var txtTotalCount: TextView
    private lateinit var txtGearDisplay: TextView
    private lateinit var editItemName: EditText
    private lateinit var editCategory: EditText
    private lateinit var editQuantity: EditText
    private lateinit var editComments : EditText

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_screen)

        // Initialize the user interfaces screens (UI)
        splashLayout = findViewById(R.id.mainLayout)
        mainLayout = findViewById(R.id.mainLayout)
        detailsLayout = findViewById(R.id.mainLayout)
        addLayout = findViewById(R.id.mainLayout)

        // Splash Screen Navigation
        btnStart.setOnClickListener {
            splashLayout.visibility = View.GONE
            mainLayout.visibility = View.VISIBLE
        }
        btnExitSplash.setOnClickListener {
            finish()
        }
// Save Data
        btnSave.setOnClickListener {
            if (editMin.text.isEmpty() ||
                editMax.text.isEmpty() ||
                editCondition.text.isEmpty())
            {
                Toast.makeText(
                    this,
                    "Please fill all fields",
                    Toast.LENGTH_LONG
                ).show()
            }else {
                val index = spinnerDays.selectedItemPosition
                minTemps[index] = editMin.text.toString().toInt()
                maxTemps[index] = editMax.text.toString().toInt()
                conditions[index] = editCondition.text.toString()
                Toast.makeText(
                    this,
                    "Data Saved Successfully",
                    Toast.LENGTH_LONG
                ).show()
                editMin.text.clear()
                editMax.text.clear()
                editCondition.text.clear()
            }
        }
// Calculate Total Items Packed
        btn.setOnClickListener {
            var total = 0
            for (i in maxTemps.indices){
                total +=maxTemps[i]
            }
            val average = total/maxTemps.size
            txtAverage.text = "Average Weekly Temperature: $average°C"
        }
// View Details
        btnDetails.setOnClickListener {
            var display = ""
            for (i in days.indices) {
                display += "${days[i]}\n"
                display += "Min Temp: ${minTemps[i]}°C\n"
                display += "Max Temp: ${maxTemps[i]}°C\n"
                display += "Condition: ${conditions[i]}\n\n"
            }
            txtDetails.text = display
            mainLayout.visibility = View.GONE
            detailsLayout.visibility = View.VISIBLE
        }
// Back Button
        btnBack.setOnClickListener {
            detailsLayout.visibility = View.GONE
            mainLayout.visibility = View.VISIBLE
        }
// Clear Data
        btnClear.setOnClickListener {
            for (i in minTemps.indices) {
                minTemps[i] = 0
                maxTemps[i] = 0
                conditions[i] = ""
            }
            txtAverage.text = "Average Weekly Temperature"
            Toast.makeText(
                this,
                "Data Cleared",
                Toast.LENGTH_LONG
            ).show()
        }
// Exit App
        btnExit.setOnClickListener {
            finish()
        }
    }

}
}
