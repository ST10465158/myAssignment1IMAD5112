package vcmsa.ci.myassignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Here i have declared all of my variables.
        val editTextTime = findViewById<EditText>(R.id.editTextTime)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textViewSuggestion = findViewById<TextView>(R.id.textViewSuggestion)
        //Author: Zahra Bulbula
        //URL: https://github.com/zb662000/assignmen

        //This button will suggest/show a meal when the user types in any of the following times of the day.
        buttonSuggest.setOnClickListener {
            val timeOfDay = editTextTime.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "morning" -> "Pancakes and Cereal"
                "mid-morning" -> "Scrambled eggs and Toast"
                "afternoon" -> "Avocado toast"
                "mid-afternoon" -> "Macaroni and Cheese"
                "dinner" -> "Chicken Fillet with a side of Mashed Potatoes"
                else -> "Please enter a valid time of day."
            }
            textViewSuggestion.text = suggestion
        }
        //Author: Zahra Bulbula
        //URL: https://github.com/zb662000/assignmen

        //This button will reset the text view and the edit text box
        //Author: Zahra Bulbula
        //URL: https://github.com/zb662000/assignmen
        buttonReset.setOnClickListener {
            editTextTime.text.clear()
            textViewSuggestion.text = ""
        }
    }
}