package com.example.coches

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.modify_coches.*

class ModifyCoches: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.modify_coches, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txVMatriculaModify.setText(ModifyCochesArgs.fromBundle(arguments!!).Matricula)
        etxtModeloModify.setText(ModifyCochesArgs.fromBundle(arguments!!).Modelo)
        etxtMarcaModify.setText(ModifyCochesArgs.fromBundle(arguments!!).Marca)
        etxtPrecioModify.setText(ModifyCochesArgs.fromBundle(arguments!!).Precio)

        fbUpdate.setOnClickListener {
            try {
                val url = "http://iesayala.ddns.net/Pruebas/phps/updateCoche.php/?Matricula=" + txVMatriculaModify.text.toString() +"&Modelo=" + etxtModeloModify.text.toString() + "&Marca=" + etxtMarcaModify.text.toString() + "&Precio=" + etxtPrecioModify.text.toString()
                Principal.leerUrl(url)
                Toast.makeText(activity,"Se ha actualizado correctamente.", Toast.LENGTH_SHORT).show()
                activity?.onBackPressed()
            } catch (ex: NumberFormatException) {
                Toast.makeText(activity,"Error: Campos incorrectos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
