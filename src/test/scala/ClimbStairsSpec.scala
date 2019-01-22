import com.yukihirai0505.leetcode.dynamic.ClimbStairs
import org.scalatest.{FlatSpec, Matchers}

class ClimbStairsSpec extends FlatSpec with Matchers {
  "ClimbStairs" should "IF input is 2 then 2 Found" in {
    ClimbStairs.climbStairs(2) == 2
  }
  "ClimbStairs" should "IF input is 3 then 3 Found" in {
    ClimbStairs.climbStairs(3) == 3
  }
}
