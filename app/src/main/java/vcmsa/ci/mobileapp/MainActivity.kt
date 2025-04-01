package vcmsa.ci.mobileapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.ViewCompat.setOnApplyWindowInsetsListener
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        class MainActivity : AppCompatActivity() {

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                val ageInput = findViewById<EditText>(R.id.ageInput)
                val matchButton = findViewById<Button>(R.id.matchButton)
                val resultTextView = findViewById<TextView>(R.id.resultTextView)
                val resetButton = findViewById<Button>(R.id.resetButton)

                val famousPeople = mapOf(
                    52 to "William Shakespeare (Died at 52)",
                    95 to "Nelson Mandela (Died at 95)",
                    56 to "Steve Jobs (Died at 56)",
                    33 to "Alexander the Great (Died at 33)",
                    88 to "Albert Einstein (Died at 88)",
                    76 to "Leonardo da Vinci (Died at 76)",
                    67 to "Winston Churchill (Died at 67)",
                    84 to "Benjamin Franklin (Died at 84)",
                    92 to "Queen Elizabeth I (Died at 92)",
                    90 to "Confucius (Died at 90)"
                )

                matchButton.setOnClickListener {
                    val inputText = ageInput.text.toString()

                    if (inputText.isEmpty()) {
                        showToast("Please enter a valid age.")
                        return@setOnClickListener
                    }

                    val age = inputText.toIntOrNull()
                    if (age == null || age !in 20..100) {
                        showToast("Please enter a valid whole number between 20 and 100.")
                        return@setOnClickListener
                    }

                    val match = famousPeople[age]
                    if (match != null) {
                        resultTextView.text = "At age $age: $match"
                        resultTextView.visibility = TextView.VISIBLE
                    } else {
                        resultTextView.text = "No historical match found for age $age."
                        resultTextView.visibility = TextView.VISIBLE
                    }
                }

                resetButton.setOnClickListener {
                    ageInput.text.clear()
                    resultTextView.text = ""
                    resultTextView.visibility = TextView.GONE
                }
            }

            private fun showToast(message: String) {
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            }
        }
    }
}