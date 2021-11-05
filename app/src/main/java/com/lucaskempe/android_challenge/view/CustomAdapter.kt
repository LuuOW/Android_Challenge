import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.data.ActivityList
import com.lucaskempe.android_challenge.entities.ActivityToDo

class CustomAdapter(private val activityList: Array<ActivityList>,var listener: CustomListener ) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface CustomListener {
        fun onClickActivity(queryParameter: String)
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val activityType: TextView = view.findViewById(R.id.activity_name)

        private lateinit var query: String

        init {
            itemView.setOnClickListener {
                listener.onClickActivity(query)
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        //HERE WE NEED TO BIND THE CARDVIEW ITEMS...'0


        viewHolder.activityType.text = activityList[position].toString()
    }

    override fun getItemCount() = activityList.size

}
