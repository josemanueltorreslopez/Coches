package com.example.coches

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.add_coche.*
import kotlinx.android.synthetic.main.fragment_principal.*
import java.io.IOException
import java.net.URL

class AddCoches : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.add_coche, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fbutAdd.setOnClickListener {
            if((etxt_Matricula.length()>0) and (etxt_Modelo.length()>0) and (etxt_Marca.length()>0) and (etxt_Precio.length()>0)) {
                try{
                    val url = "http://iesayala.ddns.net/Pruebas/phps/addCoche.php/?Matricula=" + etxt_Matricula.text.toString() + "&Modelo=" + etxt_Modelo.text.toString() + "&Marca=" + etxt_Marca.text.toString() + "&Precio=" + etxt_Precio.text.toString()
                    Principal.leerUrl(url)
                    Toast.makeText(activity,"Se ha creado correctamente.", Toast.LENGTH_SHORT).show()
                    activity?.onBackPressed()
                } catch (ex: NumberFormatException) {
                    Toast.makeText(activity,"Error: Campos incorrectos.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
