import com.sun.org.apache.xpath.internal.operations.Bool;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws XPathExpressionException, ParserConfigurationException, IOException, TransformerException, SAXException {

        String s = "1234567";
        System.out.println(s.substring(2));
    }

    public static void xmlWritter() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, TransformerException {

        String inputFile = "/home/jeya-zt501/AlexSparrow/security-api.xml";
        String outputFile = "/home/jeya-zt501/AlexSparrow/test_1-api.xml";

// 1- Build the doc from the XML file
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(inputFile);

// 2- Locate the node(s) with xpath
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList nodes = (NodeList)xpath.evaluate("//*[contains(@org-oauthscope, 'crmapi')]",
                doc, XPathConstants.NODESET);

// 3- Make the change on the selected nodes
        System.out.println(nodes.getLength());
        for (int idx = 0; idx < nodes.getLength(); idx++) {
            Node org_oauthscope = nodes.item(idx).getAttributes().getNamedItem("org-oauthscope");
            Node oauthscope = nodes.item(idx).getAttributes().getNamedItem("oauthscope");
            if (org_oauthscope != null && oauthscope != null) {
                String org_oauthscope_val = org_oauthscope.getNodeValue();
                String oauthscope_val = oauthscope.getNodeValue();
                System.out.println(org_oauthscope_val + " ->" + oauthscope_val);
                org_oauthscope.setNodeValue(org_oauthscope_val.replaceAll("crmapi", org_oauthscope_val + "," + oauthscope_val));
            }
        }

// 4- Save the result to a new XML doc
        Transformer xformer = TransformerFactory.newInstance().newTransformer();
        xformer.transform(new DOMSource(doc), new StreamResult(new File(outputFile)));
    }
    public static void xmlParser()
    {
        try
        {
            File file = new File("/home/jeya-zt501/AlexSparrow/security-api_1.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
//            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("url");
            for (int itr = 0; itr < nodeList.getLength(); itr++)
            {
                Node node = nodeList.item(itr);
//                System.out.println("\nNode Name :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    if (!eElement.getAttribute("org-oauthscope").isEmpty() && !eElement.getAttribute("oauthscope").isEmpty()) {
                        String argOauthScope = eElement.getAttribute("org-oauthscope");
                        String userOauthScope = eElement.getAttribute("oauthscope");
                        eElement.setAttribute("org-oauthscope", argOauthScope + "," + userOauthScope);
                        System.out.println(eElement.getAttribute("org-oauthscope") + " -> " + eElement.getAttribute("oauthscope"));;
                    }
                }
            }
//            Transformer transformer = TransformerFactory.newInstance().newTransformer();
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
////            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
////            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
//            DOMSource source = new DOMSource(doc);
//            StreamResult result = new StreamResult("/home/jeya-zt501/AlexSparrow/security-api_1.xml");
//            transformer.transform(source, result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void save(Document doc) throws TransformerException {
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
//            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult("/home/jeya-zt501/AlexSparrow/security-api_1.xml");
        transformer.transform(source, result);
    }

    public static int countPrimes(int n) {

        int[] prime = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            prime[i] = i;
        }

        for (int i = 2; i <= n; ++i) {

            for (int j = i << 1; j <= n; j += i) {
                prime[j] = i;
            }
        }

        int count = 0;
        for (int i = 2; i <= n; ++i) {
            if (prime[i] == i) {
                ++count;
            }
        }
        return count;
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i<= nums.length; ++i) {
            list.add(i);
        }

        for (int i = 0; i < nums.length; ++i) {
            int index = list.indexOf(nums[i]);
            list.remove(index);
        }

        return list;
    }

    public static boolean isLongPressedName(String name, String typed) {
        Stack<Character> st = new Stack<>();

        for (char ch : typed.toCharArray()) {
            st.push(ch);
        }

        for (int i = name.length() - 1; i >= 0; --i) {
            char ch = name.charAt(i);
            if (ch != st.peek()) {
                return false;
            }

            while (!st.isEmpty() && ch == st.peek()) {
                st.pop();
            }
        }
        return true;
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int[] cnt = new int[101];
        for (int i = 0; i < nums.length; ++i) {
            cnt[nums[i]]++;
        }

        int sum = 0;
        for (int i = 0; i < 101; ++i) {
            if (cnt[i] != 0) {
                int temp = cnt[i];
                cnt[i] = sum;
                sum += temp;
            }
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            res[i] = cnt[nums[i]];
        }

        return res;
    }

    public static int heightChecker(int[] heights) {
        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }
        int result = 0;
        int curHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }
        return result;
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        List<Integer> list = new ArrayList<>();
        for (int a : arr1) {
            list.add(a);
        }
        int idx = 0;
        for (int a : arr2) {
            while (list.contains(a)) {
                int index = list.indexOf(a);
                arr1[idx++] = list.remove(index);
            }
        }
        while (!list.isEmpty()) {
            arr1[idx++] = list.remove(0);
        }
        return arr1;
    }

    public static char slowestKey(int[] releaseTimes, String keysPressed) {

        int len = releaseTimes.length;
        int[] time = new int[26];
        int max = Integer.MIN_VALUE;
        int prevTime = 0;
        char ch = 'A';
        for (int i = 0; i < len; ++i) {
            int t = releaseTimes[i] - prevTime;
            prevTime = releaseTimes[i];
            if(t > time[keysPressed.charAt(i) - 'a']) {
                time[keysPressed.charAt(i) - 'a'] = t;
            }

            max = Math.max(t, max);
            if (t > max || t == max && keysPressed.charAt(i) > ch) {
                ch = keysPressed.charAt(i);
            }
        }

        return ch;
    }

    public static int specialArray(int[] nums) {
        int[] count = new int[1001];
        for (int num : nums) {
            count[num]++;
        }
        int number = nums.length;
        // the size of nums array is 100 at most
        for (int i = 0; i <= 100; i++) {
            if (number == i) {
                return i;
            }
            number -= count[i];
        }
        return -1;
    }

    public static int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum() - x;
        if(sum < 0) return -1;
        if(sum == 0) return nums.length;
        int start = 0, cur = 0, len = -1;
        for(int end = 0; end < nums.length; end++)
        {
            cur += nums[end];
            while (cur >= sum)
            {
                if (cur == sum)
                    len = Math.max(len, end - start + 1);
                cur -= nums[start++];
            }
        }

        return len == -1 ? -1 : nums.length - len;
    }

    public static int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (prefix + a % K + K) % K;
            res += count.getOrDefault(prefix, 0);
            count.put(prefix, count.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
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