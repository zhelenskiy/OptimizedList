@file:Suppress("UNCHECKED_CAST")

class OptimizedList<T> internal constructor(val storage: MutableList<Any?>): AbstractList<T>() {
    override operator fun get(index: Int) = storage[index] as T

    fun asList() = storage as MutableList<T>

    override val size: Int
        get() = storage.size
}

inline fun <T, R> OptimizedList<T>.map(f: (T) -> R): OptimizedList<R> {
    for (i in storage.indices) {
        storage[i] = f(get(i))
    }
    return this as OptimizedList<R>
}

inline fun <T> OptimizedList<T>.filter(f: (T) -> Boolean): OptimizedList<T> {
    var destination = 0
    for (i in storage.indices) {
        if (f(get(i))) {
            storage[destination++] = storage[i]
        }
    }
    return take(destination)
}

fun <T> OptimizedList<T>.take(n: Int): OptimizedList<T> {
    while (size > maxOf(n, 0)) {
        storage.removeLast()
    }
    return this
}

fun <T> OptimizedList<T>.drop(n: Int): OptimizedList<T> {
    if (n <= 0) return this
    val newSize = size - n
    for (i in 0 until newSize) {
        storage[i] = get(i + n)
    }
    return take(newSize)
}

fun <T> OptimizedList<List<T>>.flatten(): OptimizedList<T> {
    val oldSize = size
    for (i in 0 until oldSize) {
        storage.addAll(get(i))
    }
    return drop(oldSize) as OptimizedList<T>
}

inline fun <T, R> OptimizedList<T>.flatMap(f: (T) -> List<R>) = map(f).flatten()

fun <T> List<T>.copyToOptimizedList(): OptimizedList<T> =
    OptimizedList((this as List<Any?>).toMutableList())