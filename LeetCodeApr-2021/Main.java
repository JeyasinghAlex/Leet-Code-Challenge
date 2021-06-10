import java.util.*;

public class Main {



    public static void main(String[] args) {
            String name = "alex";
        System.out.println(name.indexOf("alp"));
    }

    public static int reductionOperations(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int preCount = 0;

        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            ++i;--j;
        }

        int count = 0;
        for (i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                preCount = map.get(nums[i - 1]);
                count += preCount;
                map.put(nums[i], map.get(nums[i]) + preCount);
            }
        }
        return count;
    }

    public boolean checkPalindromeFormation(String a, String b) {

        if (isPalindrome(a) || isPalindrome(b)) {
            return true;
        }

        int half = a.length() % 2 == 0 ? a.length() / 2 :a.length() / 2 + 1;
        String s1 = a.substring(0, half);
        String s2 = a.substring(half);
        String s3 = b.substring(0, half);
        String s4 = b.substring(half);


        if (isPalindrome(s1 + s4) || isPalindrome(s3 + s2)) {
            return true;
        }

        return false;

    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for( int i = 0; i < n; i++ ){
            list.add(i+1);
        }

        return eliminate(list, 0, k-1);
    }
    private int eliminate(List<Integer> list, int start, int k){
        if(list.size() == 1)
            return list.get(0);
        start = (start+k) % list.size();
        list.remove(start);
        return eliminate(list, start, k);
    }


    public int compres(char[] chars) {
        int i = 0;
        int j = 0;
        int index = 0;
        while (i < chars.length) {
            char ch = chars[i];
            while (j < chars.length && chars[i] == chars[j]) {
                ++j;
            }
            int freq = j - i;
            chars[index++] = ch;
            if (freq != 1) {
                for (char c : String.valueOf(freq).toCharArray()) {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        return index;
    }

    public int compress(char[] chars) {

        int count = 1;
        int index = 0;

        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] != chars[i - 1]) {
                chars[index++] = chars[i - 1];
                if (count != 1) {
                    for (char ch : String.valueOf(count).toCharArray())  {
                        chars[index++] = ch;
                    }
                    count = 1;
                }
            } else {
                ++count;
            }
        }
        chars[index++] = chars[chars.length - 1];
        if (count != 1) {
            for (char ch : String.valueOf(count).toCharArray()) {
                chars[index++] = ch;
            }
        }
        return index;
    }


    private int reverse(int n) {
        int reverse = 0;
        while (0 < n) {
            reverse = (reverse * 10) + n % 10;
            n = n / 10;
        }
        return reverse;
    }


    public int findLengthOfShortestSubarray(int[] arr) {

        int i = 0;
        int j = arr.length - 1;

        while (i < j && arr[i] <= arr[i + 1]) {
            ++i;
        }

        if (i == j) {
            return 0;
        }

        while (j > 0 && arr[j] >= arr[j - 1]) {
            --j;
        }

        int minLength = Math.min(arr.length - 1 - i, j);

        int k = i;
        i = 0;

        while (i <= k && j < arr.length) {
            if (arr[i] <= arr[j]) {
                minLength = Math.min(minLength, j - i - 1);
                ++i;
            } else {
                ++j;
            }
        }
        return minLength;
    }

    public int maximumPopulation(int[][] logs) {


        int[] score = new int[101];

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();


        for(int[] arr : logs) {
            score[arr[0] - 1950]++;
            score[arr[1] - 1950]--;
        }
        for (int i = 1; i < score.length; ++i) {
            score[i] = score[i] + score[i - 1];
        }
        System.out.println(Arrays.toString(score));

        int max = Integer.MIN_VALUE;
        int res = 0;

        for (int i = 0; i < score.length; ++i) {
            if (score[i] > max) {
                max = score[i];
                res = i + 1950;
            }
        }
        return res;
    }

    public void duplicateZeros(int[] arr) {

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {

                for (int j = arr.length - 1; j > i; --j) {
                    arr[j] = arr[j - 1];
                }
                ++i;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int res = guess(mid);
            if (res == 0)
                return mid;
            else if (res < 0)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private int guess(int num) {
        int pick = 6;
        return Integer.compare(pick, num);
    }

    public int peakIndexInMountainArray(int[] arr) {

        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {

            int mid = lo + hi >>> 1;
            if (arr[mid] > arr[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int lowerBound(int[] nums, int target){
        final int N = nums.length;
        int lo = 0, hi = N;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if (target > nums[mid])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

    public static int minDistance(String word1, String word2) {

        int[] arr = new int[26];

        for (char a : word1.toCharArray()) {
            arr[a - 'a']++;
        }

        for (char a : word2.toCharArray()) {
            arr[a - 'a']--;
        }

        int count = 0;
        for (int i : arr) {
            count += Math.abs(i);
        }

        return count;
    }

    public int[] replaceElements(int[] arr) {
        int[] res = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i > 0; i--){
            max = Math.max(max, arr[i]);
            res[i-1] = max;
        }
        res[arr.length - 1] = -1;
        return res;
    }
}