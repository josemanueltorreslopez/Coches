package com.example.coches

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.StrictMode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_principal.*
import java.io.IOException
import java.net.URL

class Principal : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_principal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fbt_Annadir.setOnClickListener {
            findNavController().navigate(R.id.action_principal_to_addCoches)
        }

        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        try {
            val gson = Gson()
            val json = leerUrl("http://iesayala.ddns.net/Pruebas/phps/selectCoches.php")
            val coches = gson.fromJson(json, ArrayCoches::class.java)

            lista_Coches.layoutManager = LinearLayoutManager(activity)
            val adaptador = Adaptador(coches.coches, this)
            lista_Coches.adapter = adaptador
        } catch (ex: Exception){
            "Error with ${ex.message}."
        }
    }

    companion object {
        fun leerUrl(urlString: String): String {
            val response = try {
                URL(urlString).openStream().bufferedReader().use { it.readText() }
            } catch (ex: IOException) {
                "Error with ${ex.message}."
            }

            return response
        }
    }
}
