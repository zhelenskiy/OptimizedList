package benchmarks

import copyToOptimizedList
import map
import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@CompilerControl(CompilerControl.Mode.DONT_INLINE)
@State(Scope.Thread)
open class Benchmarks {
    private var intList = listOf<Int>()
    private var objectList = listOf<Any>()
    private var intListPrecalculatedOptimized = intList.copyToOptimizedList()
    private var objectListPrecalculatedOptimized = objectList.copyToOptimizedList()
    
    @Param("1", "10", "100", "1000", "10000")
    var n = 0
    @Param("1", "2", "5", "10")
    var operations = 0
    
    @Setup(Level.Iteration)
    fun initializeList() {
        intList = List(n) { it }
        objectList = List(n) { Any() }
        intListPrecalculatedOptimized = intList.copyToOptimizedList()
        objectListPrecalculatedOptimized = objectList.copyToOptimizedList()
    }
    
    private inline fun <T> T.repeatOperation(times: Int, operation: T.() -> T): T {
        var cur = this
        repeat(times) { cur = operation(cur) }
        return cur
    }
    
    @Benchmark
    fun mapIntSequence(bh: Blackhole) {
        for (i in intList.asSequence().repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun mapIntList(bh: Blackhole) {
        for (i in intList.repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun mapIntOptimizedList(bh: Blackhole) {
        for (i in intList.copyToOptimizedList().repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun mapIntPreparedOptimizedList(bh: Blackhole) {
        for (i in intListPrecalculatedOptimized.repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(i)
        }
    }
    
    @Benchmark
    fun mapObjectSequence(bh: Blackhole) {
        for (o in objectList.asSequence().repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(o)
        }
    }
    
    @Benchmark
    fun mapObjectList(bh: Blackhole) {
        for (o in objectList.repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(o)
        }
    }

    @Benchmark
    fun mapObjectOptimizedList(bh: Blackhole) {
        for (o in objectList.copyToOptimizedList().repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(o)
        }
    }

    @Benchmark
    fun mapObjectPreparedOptimizedList(bh: Blackhole) {
        for (o in objectListPrecalculatedOptimized.repeatOperation(operations) { map { it.also { bh.consume(it) } } }) {
            bh.consume(o)
        }
    }
}