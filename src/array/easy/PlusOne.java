package array.easy;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    if (digits == null) {
      return digits;
    }
    int carry = 0;
    int sum = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      sum = i == digits.length - 1 ? (digits[i] + 1 + carry) % 10 : (digits[i] + carry) % 10;
      carry = i == digits.length - 1 ? (digits[i] + 1 + carry) / 10 : (digits[i] + carry) / 10;
      digits[i] = sum;
    }
    if (carry > 0) {
      int[] ret = new int[digits.length + 1];
      ret[0] = carry;
      System.arraycopy(digits, 0, ret, 1, digits.length);
      return ret;
    }
    return digits;
  }

  public static void main(String[] args) {
    PlusOne obj = new PlusOne();
    int[] test = {1, 2, 9};
    int[] ret = obj.plusOne(test);
    for (int i : ret) {
      System.out.printf("%3d", i);
    }
  }
}
