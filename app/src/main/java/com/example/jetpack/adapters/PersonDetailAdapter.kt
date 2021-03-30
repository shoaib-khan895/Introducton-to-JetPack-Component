package com.example.jetpack.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.jetpack.R
import com.example.jetpack.PersonDataClass
import com.example.jetpack.databinding.ItemPersonViewBinding

class PersonDetailAdapter(
    private val personsDataset: ArrayList<PersonDataClass>
): RecyclerView.Adapter<PersonDetailAdapter.ViewHolder>() {

    private val TAG = "PersonDetailAdapter"

    class ViewHolder(binding: ItemPersonViewBinding) : RecyclerView.ViewHolder(binding.root) {
        val personNameTextView: TextView = binding.personNameTV
        val personContactTextView: TextView = binding.personContactTV
        val personAddressTextView: TextView = binding.personAddressTV
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemPersonViewBinding>(inflater, R.layout.item_person_view, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = personsDataset.size

    // Replace the contents of a view (invoked by the layout manager)
    // Used to replace/update views at a specific position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //val personID = personsDataset[position].personId
        val personName = personsDataset[position].personName
        val personContact = personsDataset[position].personContact
        val personAddress = personsDataset[position].personAddress

        holder.personNameTextView.text = personName
        holder.personContactTextView.text = personContact
        holder.personAddressTextView.text = personAddress
    }
}