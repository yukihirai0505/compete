import com.yukihirai0505.leetcode.dynamic.{ClimbStairs, MaxSubArray}
import org.scalatest.{FlatSpec, Matchers}

class MaxSubArraySpec extends FlatSpec with Matchers {
  "MaxSubArray" should "IF input is [-2,1,-3,4,-1,2,1,-5,4] then 6 Found" in {
    MaxSubArray.maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)) === 6
  }
}
