package com.example.coches

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView


class Adaptador(var listaCoches: ArrayList<Coche>, var pantallaPrincipal: Principal): RecyclerView.Adapter<Adaptador.MiViewHolder>() {
    class MiViewHolder(view: View, var pantallaPrincipal: Principal): RecyclerView.ViewHolder(view) {
        fun enlazaItems(coche: Coche) {
            val matricula: TextView = itemView.findViewById(R.id.tv_Matricula)
            val modelo: TextView = itemView.findViewById(R.id.tv_Modelo)
            val marca: TextView = itemView.findViewById(R.id.tv_Marca)
            val precio: TextView = itemView.findViewById(R.id.tv_Precio)

            matricula.text = coche.matricula
            modelo.text = coche.modelo
            marca.text = coche.marca
            precio.text = coche.precio

            itemView.setOnClickListener {
                var action = PrincipalDirections.actionPrincipalToModifyCoches(
                    matricula.text.toString(),
                    modelo.text.toString(),
                    marca.text.toString(),
                    precio.text.toString()
                )
                pantallaPrincipal.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view,parent,false)
        return MiViewHolder(view, pantallaPrincipal)
    }

    override fun getItemCount(): Int {
        return listaCoches.size
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.enlazaItems(listaCoches[position])
    }
}