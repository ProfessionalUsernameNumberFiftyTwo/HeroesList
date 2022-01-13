package com.example.heroeslist

import android.widget.Toast


class HeroAdapter(var dataSet: List<Hero>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<com.example.heroeslist.HeroAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: android.view.View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        val textViewRanking: android.widget.TextView
        val textViewName: android.widget.TextView
        val textViewDesc: android.widget.TextView
        val layout: androidx.constraintlayout.widget.ConstraintLayout

        init {
            textViewRanking = view.findViewById(R.id.textView_heroItem_ranking)
            textViewName = view.findViewById(R.id.textView_heroItem_name)
            textViewDesc = view.findViewById(R.id.textView_heroItem_description)
            layout = view.findViewById(R.id.layout_heroItem)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: android.view.ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = android.view.LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_hero, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val hero = dataSet[position]
        viewHolder.textViewRanking.text = hero.ranking.toString()
        viewHolder.textViewName.text = hero.name
        viewHolder.textViewDesc.text = hero.description
        viewHolder.layout.setOnClickListener {
            Toast.makeText(it.context , "Hi, you clicked on ${hero.name}", Toast.LENGTH_SHORT).show()
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
