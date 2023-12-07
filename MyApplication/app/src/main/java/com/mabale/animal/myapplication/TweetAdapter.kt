import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mabale.animal.myapplication.Tweet
import com.mabale.animal.myapplication.databinding.ItemTweetBinding

class TweetAdapter(private val tweets: List<Tweet>) : RecyclerView.Adapter<TweetAdapter.TweetViewHolder>() {

    class TweetViewHolder(val binding: ItemTweetBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val binding = ItemTweetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TweetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val tweet = tweets[position]

        // Bind tweet data to views
        holder.binding.nameTextView.text = tweet.name
        holder.binding.descriptionTextView.text = tweet.description
        // Assuming timestamp is a Map with "seconds" and "nanoseconds" keys
        holder.binding.timestampTextView.text = "Timestamp: ${tweet.timestamp["seconds"]} seconds"
    }

    override fun getItemCount() = tweets.size
}
