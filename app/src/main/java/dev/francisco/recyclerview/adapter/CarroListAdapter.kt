package dev.francisco.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.francisco.recyclerview.R
import dev.francisco.recyclerview.model.Carro

                                                         // chamando func do Btn
class CarroListAdapter(val listaCarros: ArrayList<Carro>, val onClickListener: OnClickListener) :
    RecyclerView.Adapter<CarroListAdapter.CarroViewHolder>() {

    var contadorOnCreate = 0
    var contadorOnBind = 0

    class CarroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text_modelo)

    }

    class OnClickListener(val clickListener: (carro: Carro) -> Unit) {
        fun onClick(carro: Carro) = clickListener(carro)
    }

    // Instanciar o Layout

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarroViewHolder {
        contadorOnCreate++
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_carro_list, parent,false)

        return CarroViewHolder(view)
    }

    // Quantidade de carros

    override fun getItemCount(): Int {
        return listaCarros.size
    }

    override fun onBindViewHolder(holder: CarroViewHolder, position: Int) {
        contadorOnBind++
        val carro = listaCarros[position]
        holder.textView.setText(carro.modelo)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(carro)
        }
    }
}