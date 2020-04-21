package pl.adijr.coronatracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_country.view.*
import pl.adijr.coronatracker.R
import pl.adijr.coronatracker.models.Table

class CityAdapter(
    private val listener: (Table) -> Unit
) : ListAdapter<Table, CityAdapter.CitiesViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CitiesViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_country,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) =
        holder.bind(getItem(position), listener)

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Table>() {
            override fun areItemsTheSame(
                oldItem: Table,
                newItem: Table
            ): Boolean =
                oldItem.country == newItem.country

            override fun areContentsTheSame(
                oldItem: Table,
                newItem: Table
            ): Boolean =
                oldItem == newItem
        }
    }

    class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(city: Table, listener: (Table) -> Unit) {
            itemView.apply {
                tvItemCountryName.text = city.country
                if (city.newCases == "+N/A") {
                    tvAllNew.text = "${city.totalCases}"
                } else {
                    tvAllNew.text = "${city.totalCases} (${city.newCases})"
                    setOnClickListener { listener(city) }
                }
            }
        }
    }
}