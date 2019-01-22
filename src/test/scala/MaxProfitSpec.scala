import com.yukihirai0505.leetcode.dynamic.MaxProfit
import org.scalatest.{FlatSpec, Matchers}

class MaxProfitSpec extends FlatSpec with Matchers {
  "MaxProfit" should "IF input is [7,1,5,3,6,4] then 5 Found" in {
    MaxProfit.maxProfit(Array(7,1,5,3,6,4)) === 5
  }
  "ClimbStairs" should "IF input is [7,6,4,3,1] then 0 Found" in {
    MaxProfit.maxProfit(Array(7,6,4,3,1)) === 0
  }
}
