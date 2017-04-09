def isPrimeNum(i: Int): Boolean = {
  if (i <= 1)
    false
  else if (i == 2)
    true
  else
    !(2 until i).exists(x => i % x == 0)
}
(1 to 10).filter(isPrimeNum)