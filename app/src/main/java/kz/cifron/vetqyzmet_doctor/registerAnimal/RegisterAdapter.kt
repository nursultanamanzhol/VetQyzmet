package kz.cifron.vetqyzmet_doctor.registerAnimal
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kz.cifron.vetqyzmet_doctor.databinding.AutoitemBinding

class RegisterAdapter : RecyclerView.Adapter<RegisterAdapter.TaskViewHolder>() {


    inner class TaskViewHolder(val binding: AutoitemBinding) : RecyclerView.ViewHolder(binding.root)


    private val differCallBack = object : DiffUtil.ItemCallback<Tasks>(){
        override fun areItemsTheSame(oldItem: Tasks, newItem: Tasks): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Tasks, newItem: Tasks): Boolean {
            return  oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this,differCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AutoitemBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = differ.currentList[position]
        holder.itemView.apply {
            holder.binding.textViewTitle.text = task.ADDR
            holder.binding.numsView.text = task.TYPE_ORDER.toString()
            setOnClickListener {
                onItemClickListener?.invoke(task)
            }
        }
    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Tasks) -> Unit)? = null

    fun setOnItemClickListener(listener: (Tasks) -> Unit) {
        onItemClickListener = listener
    }


}
