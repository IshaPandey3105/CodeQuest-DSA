class J02_MinProdSubset {
    public static void main(String[] args) {
        int[] arr = { -1, -1, -2, 4, 3 };
        int[] arr2 = { -1, 0, 1, 2, 3 };
        int[] arr3 = { 0, 0, 0 };
        System.out.println(minProductSubset(arr));
        System.out.println(minProductSubset(arr2));
        System.out.println(minProductSubset(arr3));
    }

    static int minProductSubset(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;
        int countNeg = 0;
        int countZero = 0;
        int product = 1;

        for (int num : arr) {
            if (num < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, num);
            } else if (num > 0) {
                minPos = Math.min(minPos, num);
            } else {
                countZero++;
            }
            if (num != 0) {
                product *= num;
            }
        }

        if (countZero == arr.length) {
            return 0;
        }

        if (countNeg % 2 == 0 && countNeg > 0) { // If there are even number of negative numbers, remove the largest negative number to minimize the product
            product /= maxNeg;
        } else if (countNeg == 0 && countZero > 0) {
            return 0;
        }

        return product;
    }
}