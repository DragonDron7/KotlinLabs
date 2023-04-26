class Stack<T> {
    private val stack = mutableListOf<T>()
    fun pop(): T? {// Извлекаем элемент, находящийся в верхней части стэка, удаляя его в процессе. Если пустой стек, то null.
        return stack.removeLastOrNull()
    }

    fun push(item: T) {//добавляем элемент в стек
        stack.add(item)
    }

    fun isEmpty(): Boolean {//проверка стека на наличие элементов
        return stack.isEmpty()
    }

    fun count(): Int {//проверка стека на наличие элементов
        return stack.count()
    }
}

