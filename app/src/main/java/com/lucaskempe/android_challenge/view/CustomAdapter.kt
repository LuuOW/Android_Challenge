import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucaskempe.android_challenge.R
import com.lucaskempe.android_challenge.data.ActivityList
import com.lucaskempe.android_challenge.entities.ActivityToDo
import com.lucaskempe.android_challenge.service.BoredService

class CustomAdapter(private val activityList: Array<ActivityList>,var listener: CustomListener ) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    interface CustomListener {
        fun onClickActivity()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val activityType: TextView = view.findViewById(R.id.activity_name)
        
        init {
            itemView.setOnClickListener {
                listener.onClickActivity()
            }
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_view, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.activityType.text = activityList[position].toString()
    }

    override fun getItemCount() = activityList.size

}
