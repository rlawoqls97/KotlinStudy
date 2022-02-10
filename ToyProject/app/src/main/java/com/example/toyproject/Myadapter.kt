import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toyproject.R
import kotlinx.android.synthetic.main.game_card.view.*

class MyAdapter(): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    var titles = arrayOf("one", "two", "three", "four")
    var details = arrayOf("밸런스 게임", "이구동성", "O/X 퀴즈", "상식게임")

//    var images = intArrayOf(R.drawable.ic_launcher_foreground,
//        R.drawable.ic_launcher_foreground,
//        R.drawable.ic_launcher_foreground,
//        R.drawable.ic_launcher_foreground,
//        R.drawable.ic_launcher_foreground)


    class MyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
//        public var itemimage: ImageView = itemview.item_image
//        public var itemtitle: TextView = itemview.item_title
        public var itemdetail: TextView = itemview.item_detail
    }

    override fun onCreateViewHolder(viewgroup: ViewGroup, position: Int): MyViewHolder {
        var v: View = LayoutInflater.from(viewgroup.context).inflate(R.layout.game_card, viewgroup, false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.itemtitle.text = titles[position]
//        holder.itemimage.setImageResource(images.get(position))
        holder.itemdetail.text = details[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }
}


