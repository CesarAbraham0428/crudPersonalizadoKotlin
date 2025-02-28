package mx.edu.utng.crudpersonalizado.ui.form

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import mx.edu.utng.crudpersonalizado.R
import mx.edu.utng.crudpersonalizado.data.db.DatabaseHelper
import mx.edu.utng.crudpersonalizado.data.model.Item

class FormActivity : AppCompatActivity() {

    private lateinit var databaseHelper: DatabaseHelper
    private var itemId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        databaseHelper = DatabaseHelper.getInstance(this)

        val nameInput = findViewById<EditText>(R.id.editTextName)
        val descriptionInput = findViewById<EditText>(R.id.editTextDescription)
        val priceInput = findViewById<EditText>(R.id.editTextPrice)
        val categoryInput = findViewById<EditText>(R.id.editTextCategory)
        val stockInput = findViewById<EditText>(R.id.editTextStock)
        val imageInput = findViewById<EditText>(R.id.editTextImageUrl)
        val saveButton = findViewById<Button>(R.id.saveButton)

        // Verificar si estamos editando un elemento
        itemId = intent.getIntExtra("ITEM_ID", -1)
        if (itemId != -1) {
            nameInput.setText(intent.getStringExtra("ITEM_NAME"))
            descriptionInput.setText(intent.getStringExtra("ITEM_DESCRIPTION"))
            priceInput.setText(intent.getDoubleExtra("ITEM_PRICE", 0.0).toString())
            categoryInput.setText(intent.getStringExtra("ITEM_CATEGORY"))
            stockInput.setText(intent.getIntExtra("ITEM_STOCK", 0).toString())
            imageInput.setText(intent.getStringExtra("ITEM_IMAGE_URL"))
        }

        saveButton.setOnClickListener {
            val name = nameInput.text.toString()
            val description = descriptionInput.text.toString()
            val price = priceInput.text.toString().toDoubleOrNull() ?: 0.0
            val category = categoryInput.text.toString()
            val stock = stockInput.text.toString().toIntOrNull() ?: 0
            val imageUrl = imageInput.text.toString()

            if (name.isNotEmpty() && description.isNotEmpty()) {
                val item = Item(itemId, name, description, price, category, stock, imageUrl)

                if (itemId == -1) {
                    databaseHelper.insertItem(item)
                    Toast.makeText(this, "Elemento agregado", Toast.LENGTH_SHORT).show()
                } else {
                    databaseHelper.updateItem(item)
                    Toast.makeText(this, "Elemento actualizado", Toast.LENGTH_SHORT).show()
                }
                finish()
            } else {
                Toast.makeText(this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show()
            }
        }
    }
}