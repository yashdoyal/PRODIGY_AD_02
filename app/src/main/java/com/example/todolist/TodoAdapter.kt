package com.example.todolist

class TodoAdapter(private val onItemClick: (Todo) -> Unit) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    private var todos = emptyList<Todo>()

    class TodoViewHolder(itemView: View, val onItemClick: (Todo) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val taskTextView: TextView = itemView.findViewById(R.id.taskTextView)

        fun bind(todo: Todo) {
            taskTextView.text = todo.task
            itemView.setOnClickListener { onItemClick(todo) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount(): Int = todos.size

    fun setTodos(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }
}
