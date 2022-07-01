import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ListTests {
    private val list = listOf(1, 2, 3)
    
    @Test
    fun testToFromList() {
        assertContentEquals(list, list.copyToOptimizedList().asList())
    }
    
    @Test
    fun testMap() {
        assertContentEquals(listOf(2, 4, 6), list.copyToOptimizedList().map { it * 2 }.asList())
    }
    
    @Test
    fun testFilter() {
        assertContentEquals(listOf(1, 3), list.copyToOptimizedList().filter { it != 2 }.asList())
    }
    
    @Test
    fun testTake() {
        assertContentEquals(listOf(1, 2), list.copyToOptimizedList().take(2).asList())
        assertContentEquals(listOf(1, 2, 3), list.copyToOptimizedList().take(100).asList())
        assertContentEquals(listOf(), list.copyToOptimizedList().take(0).asList())
        assertContentEquals(listOf(), list.copyToOptimizedList().take(-10).asList())
    }
    
    @Test
    fun testDrop() {
        assertContentEquals(listOf(2, 3), list.copyToOptimizedList().drop(1).asList())
        assertContentEquals(listOf(1, 2, 3), list.copyToOptimizedList().drop(0).asList())
        assertContentEquals(listOf(1, 2, 3), list.copyToOptimizedList().drop(-10).asList())
        assertContentEquals(listOf(), list.copyToOptimizedList().drop(10).asList())
    }
    
    @Test
    fun testFlatten() {
        assertContentEquals(
            listOf(1, 2, 3, 4), 
            listOf(listOf(1), listOf(2, 3), listOf(4)).copyToOptimizedList().flatten().asList()
        )
    }
    
    @Test
    fun testFlatMap() {
        assertContentEquals(
            listOf(1, -1, 2, -2), 
            listOf(1, 2).copyToOptimizedList().flatMap { listOf(it, -it) }.asList()
        )
    }
}