package com.example.todolist

@Dao
interface TodoDao {
    @Insert
    suspend fun insert(todo: Todo)

    @Update
    suspend fun update(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)

    @Query("SELECT * FROM todos")
    fun getAllTodos(): LiveData<List<Todo>>
}
