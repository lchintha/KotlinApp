package com.vrcmicrotech.kotlinprep

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Main {
    companion object{

        @JvmStatic
        fun main(args: Array<String>) {
            //val accounts = arrayOf(arrayOf("Blake", "Alex", "2"))

            print(largestNumber(arrayOf("3", "30", "34", "5", "9")))

        }

        //[4, 2, 3, 2], [2, 1, 2, 1], 4

        /*private fun determineSum(a: Array<Int>, b: Array<Int>, target: Int){
            if(a.isEmpty()) return false
            if(a.size == 1 && a[0] + b[0] >= target) return true

        }*/

        private fun largestNumber(nums: Array<String>){
            val comparator = kotlin.Comparator { str1: String, str2: String ->
                (str2 + str1).toInt() - (str1 + str2).toInt()
            }

            println(nums.sortedWith(comparator))
        }

        private fun longestPalindrome(s: String): String {
            var result = ""
            var length = 0

            for(i in s.indices){
                var x = i
                var y = i
                while (x >= 0 && y < s.length && s[x] == s[y]){
                    if(length < y-x+1){
                        length = y-x+1
                        result = s.substring(x, y+1)
                    }
                    x--
                    y++
                }

                x = i
                y = i+1
                while (x >= 0 && y < s.length && s[x] == s[y]){
                    if(length < y-x+1){
                        length = y-x+1
                        result = s.substring(x, y+1)
                    }
                    x--
                    y++
                }
            }

            return result
        }

        private fun maxRob(nums: IntArray): Int{
            val memory = IntArray(nums.size) {-1}

            fun case(index:Int): Int{
                if(index <= 0) return 0
                return memory[index]
            }

            for(i in nums.indices){
                if(memory[i] == -1)
                    memory[i] = (nums[i] + case(i-2)).coerceAtLeast(case(i-1))
            }
            println(memory.contentToString())
            return memory[nums.size-1]
        }

        private fun factorial(num: Int): Int{
            if(num == 0) return 1
            return num * factorial(num-1)
        }

        private fun fibonacci(num: Int): Int{
            if(num == 0) return 0
            if(num == 1) return 1
            return fibonacci(num-1) + fibonacci(num-2)
        }

        private fun getSmallestNegativeBalanceOwner(transactions: Array<Array<String>>): Array<String>{
            val map = HashMap<String, Int>()

            for(transaction in transactions){
                var amount = map[transaction[0]] ?: 0
                map[transaction[0]] = amount - transaction[2].toInt()

                amount = map[transaction[1]] ?: 0
                map[transaction[1]] = amount + transaction[2].toInt()
            }

            val sortedMap = map.toList().sortedBy { (_, v) -> v }.toMap()
            val listOfNames = ArrayList<String>()

            for((k, v) in sortedMap){
                if(v < 0){
                    listOfNames.add(k)
                }
            }

            listOfNames.sort()

            return listOfNames.toTypedArray()
        }

    }


}