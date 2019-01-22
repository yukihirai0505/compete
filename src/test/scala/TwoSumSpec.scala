import com.yukihirai0505.leetcode.TwoSum
import org.scalatest.{FlatSpec, Matchers}

class TwoSumSpec extends FlatSpec with Matchers {
  "TwoSum" should "IF target == 9 then (0, 1) Found" in {
    TwoSum.twoSum(Array(2, 7, 11, 15), 9) === Array(0, 1)
  }
}
