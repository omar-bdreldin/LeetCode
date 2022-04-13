package problems

fun main() {
    println(
        canSubset2(
            nums = intArrayOf(1,1,1,1,2,2,2,2),
            k = 4
        )
    )
}

/**
 * k: number of subsets
 */
fun canSubset(nums: IntArray, k: Int): Boolean {
    val sumOfInputArray: Int = nums.sum()
    if (sumOfInputArray.rem(k) != 0) return false
    val limitSumPerSet: Int = sumOfInputArray.div(k)
    val sets: List<LockableList> = (0 until k).map { LockableList() }
    for ((index, num) in nums.withIndex()) {
        for (set in sets) {
            if (set.isLocked) continue
            if (set.currentSum + num > limitSumPerSet) continue
            set.indices.add(index)
            set.currentSum += num
            if (set.currentSum == limitSumPerSet) set.isLocked = true
            break
        }
    }
    return sets.all { it.currentSum == limitSumPerSet }
}

data class LockableList(
    var isLocked: Boolean = false,
    val indices: MutableList<Int> = mutableListOf(),
    var currentSum: Int = indices.sum()
)

fun canSubset2(nums: IntArray, k: Int): Boolean {
    val sumOfInputArray: Int = nums.sum()
    if (sumOfInputArray.rem(k) != 0) return false
    val limitSumPerSet: Int = sumOfInputArray.div(k)
    return backTrack(
        nums = nums,
        limitSumPerSet = limitSumPerSet,
        startIndex = 0,
        remainingNumberOfSubsets = k,
        sumOfSubset = 0
    )
}


fun backTrack(
    nums: IntArray,
    limitSumPerSet: Int,
    usedIndices: BooleanArray = BooleanArray(nums.size) { false },
    startIndex: Int,
    remainingNumberOfSubsets: Int,
    sumOfSubset: Int
): Boolean {
    println("used: ${usedIndices.contentToString()}")
    println("startIndex: $startIndex, currentSum: $sumOfSubset, rem: $remainingNumberOfSubsets")
    return when {
        remainingNumberOfSubsets == 0 -> true
        sumOfSubset == limitSumPerSet -> backTrack(
            nums = nums,
            limitSumPerSet = limitSumPerSet,
            usedIndices = usedIndices,
            startIndex = 0,
            remainingNumberOfSubsets = remainingNumberOfSubsets - 1,
            sumOfSubset = 0
        )
        else -> {
            for (index in startIndex until nums.size) {
                val num  = nums[index]
                println("startIndex: $startIndex, currentSum: $sumOfSubset, rem: $remainingNumberOfSubsets, index: $index, num: $num")
                val isUsed = usedIndices[index]
                val isSumLargerThanLimit = sumOfSubset + num > limitSumPerSet
                if (isUsed || isSumLargerThanLimit) {
                    println("continue: ${if (isUsed) "isUsed" else "isSumLargerThanLimit"}")
                    continue
                }
                usedIndices[index] = true
                val backTracked = backTrack(
                    nums = nums,
                    limitSumPerSet = limitSumPerSet,
                    usedIndices = usedIndices,
                    startIndex = index + 1,
                    remainingNumberOfSubsets = remainingNumberOfSubsets,
                    sumOfSubset = sumOfSubset + num
                )
                if (backTracked)
                    return true
                else usedIndices[index] = false
            }
            false
        }
    }
}
