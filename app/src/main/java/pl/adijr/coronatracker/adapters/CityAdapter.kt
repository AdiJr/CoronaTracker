package pl.adijr.coronatracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_country.view.*
import pl.adijr.coronatracker.R
import pl.adijr.coronatracker.models.CityModel

class CityAdapter(
    private val listener: (CityModel) -> Unit
) : ListAdapter<CityModel, CityAdapter.CitiesViewHolder>(DIFF_CALLBACK) {

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
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<CityModel>() {
            override fun areItemsTheSame(
                oldItem: CityModel,
                newItem: CityModel
            ): Boolean =
                oldItem.country == newItem.country

            override fun areContentsTheSame(
                oldItem: CityModel,
                newItem: CityModel
            ): Boolean =
                oldItem == newItem
        }
    }

    class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(city: CityModel, listener: (CityModel) -> Unit) {
            itemView.apply {
                tvItemCountryName.text = city.country
                setOnClickListener { listener(city) }
            }
        }
    }
}