2Sum: (1, 167, 170)

- from left to right, use hash set to save all element and check if the set contains (target - nums[i])
- two pointer approach, from both sides to middle, if sum > target, right--, otherwise left++

3Sum, 4Sum: (15, 16, 18)

- sort the array
- anchor the first one, and then use the second approach of 2Sum
- notices that you could compare x1 + x2 + x3 with target to truncate useless calculation; to avoid duplicates, you need to use if(i>0 && nums[i] == nums[i-1]) continue;

Combination Sum: (39, 40, 216, 377)
(39, 40, 216) DFS and Backtracking

- in the DFS function, there is a for loop which is from pos to nums.length
- if result cannnot contain duplicates, we need to add if(i>pos && nums[i] == nums[i-1]) continue. i>pos means nums[i-1] is not added

(377) DP approach

Find Missing/Duplicated Number: (41, 268, 287)
(41, 268) put each number in its right position, like 1, 2, 3, 4, 5, …; and then iterate the whole array to find the first element which is not at the right position
(287) use slow and fast pointer to find whether there is a cycle, and reset slow to the head, and find the first same element which is the answer.

Rotate Image: (48, 59)
(48, 59) top-left: matrix[row][col]; top-right: matrix[col][n-1-row]; bottom-right: matrix[n-1-row][n-1-col]; bottom-left: matrix[n-1-col][row]

Trapping Water and Largest Rectangle in Histogram: (11, 42, 84, 85)
formula: (min(height[right], height[left]) - height[bottom]) * (right - left - 1)
(11) use two pointer from both sides to the middle, always anchor the highest bar and move the other one
(42) use one stack which saves all index in decreasing order

- when height is decreasing, push into the stack and increase the index
- when height is increasing, pop out an index as the bottom index, and peek an index as the left-most bar, and then do the calculation

(84, 85) use one stack which saves all index in increasing order

- when height is increasing, push into the stack and increase the index
- when height is increasing, pop out an index as the top index, and peek an index as the left bar to calculate the width, and then do the calculation; after calculation, do not increase the i, because we need to compare this i with the previous ones to do the calculation iteratively.

Two Pointers: (26, 27， 209, 3, 76, 349, 350)
(26) in sorted array: use two pointers from left to right, if they are the same, right++, otherwise, change the value of slow to the value of right, and then right++
(27) in unsorted array: we want to let all element whose value is ‘val’ on the left, and ’non-val’ on the right; use two pointers from both sides; first do while loop when meet the requirement, otherwise, swap them.
(209) in unsorted array

- set left and right to 0, create a localSum
- for each num in nums, localSum is the sum from left to right
- if localSum >= target, calculate the length of (right - left), and then substract the nums[left] from localSum, increase the left
- notes: this question could also be solved using binary search for sums array.

Binary Search and Search in Rotated Array: (4, 153, 154, 33, 81, 34, 278, 35, 209, 315, 287, 162, 209)
article: https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation
if the nums is sorted, we could do binary search
(4) divide each array into two parts, and compare A[i-1], B[j] and B[j-1], A[i].
(153, 154) Find Rotated Point in Rotated Sorted Array:

- while loop condition: while(left < right)
- middle = left + (right - left) / 2
- if condition(1): (nums[middle] > nums[right]) left = middle + 1, rotated point is on the right part and left part is sorted
- if condition(2): (nums[middle] < nums[left]) right = middle, rotated point is on the left part and right part is sorted
- if condition(3)(if contains duplicates): (nums[middle] == nums[left] == nums[right]), right--, cannot decide
- return nums[left]

(33, 81) Search Target in Rotated Sorted Array:

- while loop condition: while(left < right)
- middle = left + (right - left) / 2
- check nums[middle] == target
- if condition(1): (nums[middle] > nums[right]) means pivot point is on the right part and left part is sorted, but we need to check whether target is on the right. So there are two conditions: (nums[left] <= target < nums[middle]), right = middle; else left = middle + 1
- if condition(2): (nums[middle] < nums[right]) means pivot point is on the left part and right part is sorted, do the similar work mentioned above
- if condition(3)(if contains duplicates): (nums[middle] == nums[left] == nums[right]), right—, cannot decide
- return nums[left] == target

(34, 278) Search for a range, two binary search: one for left-round middle, and the other for right-round middle, and they are symmetrical
(35, 209, 315) Search Insert Position: different conditions

- while loop condition: while(left <= right)
- middle = left + (right - left) / 2
- if condition(1): (nums[middle] < target) left = middle + 1
- if condition(2): (nums[middle] > target) right = middle - 1

(287) Search for duplicates

- left = 1, right = nums.length - 1
- while loop condition: while(left < right)
- middle = left + (right - left) / 2
- count the number which is <= middle
- if condition(1): if(count <= middle) left = middle + 1
- if condition(2): if(count > middle) right = middle

(162) Find Peak

- left = 0, right = nums.length - 1
- while loop condition: while(left < right)
- middle = left + (right - left) / 2
- if condition(1): if(nums[middle] < nums[middle + 1]) left = middle + 1
- if condition(2): if(nums[middle] >= nums[middle + 1]) right = middle

Permutation: (31, 46, 47, 60)
(31) next permutation:

- from right to left, find the longest non-increasing suffix(right most must be at nums.length-1)
- the element on the left of suffix is the pivot
- from right to left in suffix, find the first element that is >= pivot and swap them
- reverse the suffix
- notice: for the step(a), if the suffix is the whole array, just reverse it

(46) do not contain non-duplicates: get a new element; from lists, choose one list and find how many positions can be inserted
(47) contain duplicates: use DFS+backtracking to solve it.

- sort the array
- for each round, iterate the whole array, use used[] to mark which number is visited, and use ((i>0 && nums[i] == nums[i-1] && !used[i-1]) || used[i]) to avoid duplicates

(60) if n=4, the factorial is 1, 2, 6, 24, and each group has 6, 2, 1 element; use k/factorial to decide which element to add, and use k%factorial to decide the next round’s position

Palindrome: (266, 267, 9, 125, 5, 131, 214, 132, 336)
(266) use int[] to save the number of occurrence for each character, and check the number of odd value; use oddCount += ++letters[c] % 2 != 0 ? 1 : -1 to get the number of odd
(267) first get the middle character, put half of letters into a list; and then do the same work as prob67; don’t forget to form the other side of string at the end; notice: use char curr = (char)i to restore the character from int[]
(9) write a function to get the ith digit
(5) pick a pivot from 0 to n; for this pivot, extend to both sides to check if it is a palindrome; don’t forget to consider odd and even conditions
(214) make the anchor from n to 0, and check whether [0, anchor] is a palindrome
(131) from 0 to n do the DFS and backtracking, need to write a checkPalindrome function
(132) palindrome partitioning

- create two 2-d array to represents cut[i,j] and palindrome[i,j]
- two loops: outer loop is end which is from 0 to n-1, innter loop is start which is from 0 to end
- for inner loop: from both sides to middle, check whether it is palindrome: if it is, localMin = min(localMin, 1 + cut[start-1]); otherwise continue
- for outer loop: initialize localMin = max at the beginning; set the cut[end] = localMin

(336) palindrome pairs

- use hash map to save all strings and its position
- divide each string into two parts, the delimiter is from 0 to n-1. if the part1 is palindrome, check if map contains the reverse of part2; if the part2 is palindrome, check if map contains the reverse of part1

Sliding Window: (76, 30, 3, 159, 340)
(76) the element is character, could use int[] to substitute hash set or hash map

- save all character’s count into charSet
- create a sliding window which has two ends: begin and end
- move end from 0 to n-1: if meet a valid character, count--; when the count reach 0, which means all valid characters are included in the window, record the window size and substring, and then move left bound until count greater than 0, which means one valid characters is out of window; And then you move end to find this character

(30) the element is words, cannot use int[], have to use hash map; in the window, you cannot include invalid word

- save all words’ count into map
- there are words[0].length rounds, each round is like (76), but the length of index increasing is words[0].length
- because you cannot include invalid word in window, so if the current target is invalid, you immediately move left bound to the right bound, clear all variables and search again
- if(currMap.get(target) <= map.get(target)) count++, which means you includes one valid word in window; otherwise, you includes a duplicate in window, you need to shrink the left bound until this duplicate removed
- when count == size, you output the result and move left bound to the right bound

Word Pattern: (205, 290)
(205) two solutions

- use hash map and hash set: if map contains the key, we check if values are the same; otherwise, we put the (key, value) pair into map, and then check if the set contains value already, if so, return false, because this value is mapped before
- use int[]: create an array whose length is 256 * 2, the first part is for string1, the second is for string2; positions[tempS] and positions[tempT + 256] should be equal

Read4: (157, 158)
the difference between call once and call multiple times is: before call read4(), we should check if indexTmpBuf is 0, if so we have to call read4(), otherwise we do not need to, we just copy from tmpBuf to buf

Matrix in-place changing: (73, 289)
(73) Set Matrix Zeroes

- use the first row/col to mark if element on the below/right has 0; and use two more boolean var to mark if the first row/col has 0.
- First pass setup the marker
- second pass use if(matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0; to set the whole matrix
- third pass use boolean var to set the first rol/col

(289) dead->dead: 0; live->live: 1; dead->live: 2; live->dead: 3

Search in 2D Array: (74, 240)
(74) Regard it as a 1D array: matrix[index / matrix[0].length][index % matrix[0].length]
(240) From right-top, if it is too large, move left; if it is too small, move down, O(m+n)

Maximum Square/ Rectangle: (221, 85)
(221) dp[i, j] = Min(dp[i-1, j], dp[i-1, j-1], dp[i, j-1]) + 1
(85) Maximum Rectangle

- 3 1d array: left, right, height; from top to down, row by row searching
- form right to left, if the cell is 1, currRight = Min(currRight, right[j]); otherwise currRight = j-1, and right[j] = n-1
- from left to right, if the cell is 1, currLeft = Max(currLeft, left[j]); otherwise currLeft = j+1, and left[j] = 0
- from left to right, if the cell is 1, height[j]++
- for each row, res = max(res, height * (right[j] - left[j] + 1))

Subsets: (78, 90)
Iterative

- add a empty list
- for each num in nums, add it to every list in res
- notes: if nums contains duplicates, we can only add the duplicates from the previous res.size() rather than 0

Recursive: backtracking. if nums contains duplicates, use (i>pos && nums[i] == nums[i-1]) continue to avoid duplicates

Best Time to Buy and Sell Stock: (121, 122, 123, 188)
(121, 123, 188) at most K transactions, DP Solution

- dp[i][j] represents the max profit ending at transaction i and day j
- outer loop is for transactions, inner loop is for days; the first row and first col are all 0s.
- condition(1): no transaction at day j: dp[i][j-1]
- condition(2): sell at day j: (prices[j] - prices[m]) + dp[i-1][m] = prices[j] + (dp[i-1][m] - prices[m]) = prices[j] + diffMax (where m is from 0 to j-1)
- notice: if K >= prices.length / 2, it means we can make as many transactions as we want, use Greedy approach.

(122) as many transactions as you want, Greedy Solution

- Solution(1): iterate prices from 0 to prices.length-1, if the current price larger than the previous one, add this difference to the result
- Solution(2): in the while loop, first find the first bottom point which is buy-day, and then find the first peak point which is sell-day, and then calculate the difference which is the profit. Keep searching and calculating until the end.

Word Ladder: (126, 127)

- Two Ends BFS Approach
- create begin/end set and put begin/end word in it respectively; create a hash map to save the path
- if begin.size() > end.size(), flip these two sets; always search words from begin set
- remove begin/end word from dictionary(similar to visited feature), to avoid cycle
- for each words in begin set, change every position and check if the new words is in the end set or dictionary: if it is, put the pair into map.
- notes: if words in the begin set occurs in the end set also, return immediately

Contiguous/Consecutive Subarray: (128, 53, 152)
(128) unsorted array. use hash set to save all nums. For each num in nums, search if the hash set contains num-- or num++, record the local max.
(53, 152) Maximum Sum/Product Subarray
create 1-D DP Matrix, dp[i] represents the max-value ending at i-1; dp[i] = Math.max(dp[i-1] + nums[i-1], dp[i])
notes: because there could be negative integer in the array, we should save both local max and local min for Maximum Product Subarray

Moore’s Voting Algorithm: (169, 229)

- make candidate equals to nums[0], it’s count 0
- search from 0, if count reach 0, change candidate to the current index, and increase the count; otherwise if the current is candidate, increase the count, otherwise decrease it.
- if you want the count > n/2, use one candidate; if you want the count > n/3, use two candidates

Reverse Array: (151, 186, 189)
(151, 186) reverse the whole string and then reverse each word
(189) reverse the whole array; reverse the first k element; reverse the rest

Contain Duplicates: (217, 219, 220)
(217) use hash set to check if the new element is in the set
(219) use hash set to save up to k elements and check if the new element is in the set
(220) use tree set to save up to k elements, and use floor()/celing() to check if the tree set has an element whose difference between this one is up to t. floor() is the greatest number less than or equals to the given one; ceiling() is the smallest number greater than or equals to the given one.

Shortest Word Distance: (243, 244, 245)
(244) use hash map to save all words and their position
(243, 245)

- two pointers represent two words’ index
- when word1 is found: if two words are not the same, distance is (i-index2), otherwise distance is (i-index1)
- when word2 is found and two words are not the same, distance is (i-index1)

Wiggle Sort: (280, 324)
(280) allow adjacent numbers to be the same: one pass solution, from left to right, based on the property at position odd/even, swap with the one on its right.
(324) don’t allow adjacent number to be the same: sort it; choose one from the middle and another from the end; and then choose one from the middle-1, and another from the end-1, and on and on

Soduku: (36, 37)
(36) for i from 0 to 9, for j from 0 to 9: row: board[i][j], col: board[j][i], cube: board[3*(i/3)+j/3][3*(i%3)+j%3]
(37) check the given row and col’s validation: for i from 0 to 9: row: board[row][i], col: board[i][col], cube: board[3*(row/3)+i/3][3*(col/3)+i%3]

Merge Sort Linkedlist: (21, 148, 23)
(21) Merge two sorted linkedlist:
Recursive: always return the smaller one, and its next is recursive function’s return
Iterative: create a dummy node, and the next of this node is always linked to the smaller one
(148) Merge Sort for LinkedList
use slow and fast node to find the middle point: if the total is odd, the second part is one larger than the first part
cut the linkedlist from the middle
use (21)’s approach to merge this two linked list
(23) use PriorityQueue to do the sorting

Sorting LinkedList: (147, 148)

Reverse Nodes in K-Group: (24, 25)
(25) begin is the node which is on the left of reverse list, end is the node which is on the right of reverse list; use insertion approach to insert target between ‘begin’ and ’head'

Covert sorted array to BST: (108, 109)
(108) for array: like binary search, find the middle, and new TreeNode(nums[middle]), and then root.left = func(), root.right = func()
(109) for linkedlist: because we cannot anchor the middle, so we call recursive func first, and then build the new root, and then call another recursive func

Dynamic Programming: (44, 10, 72, 91)
(44) Wildcard Matching

- replace multiple * with single *
- create DP matrix whose dimension is one larger than the length of s and p respectively
- deal with top-left cell: dp[0][0] = true
- deal with the first row: if p[0] == ‘*’, dp[0][1] = true; otherwise, dp[0][j] = false
- deal with the first col: dp[i][0] = false
- iterate the rest: if s[i-1] == p[j-1] or p[j-1] == ‘?’, dp[i][j] = dp[i-1][j-1]; else if p[j-1] == ‘*’, which means this j could be removed(matches 0 character), or this i could be removed(matches any sequences), dp[i][j] = dp[i][j-1] || dp[i-1][j]

(10) Regular Expression Matching

- create DP matrix whose dimension is one larger than the length of s and p respectively
- deal with the top-left cell: dp[0][0] = true
- deal with the first row: if p[0] == ‘*’, return false
- deal with the first col: dp[i][0] = false
- iterate the rest: if s[i-1] == p[j-1] or p[j-1] == ‘.’, dp[i][j] = dp[i-1][j-1]; else if p[j-1] == ‘*’: (1) dp[i][j] |= dp[i][j-2], which means * matches 0 of preceding character, these two characters can be removed, (2) if s[i-1] == p[j-2] || p[j-2] == ‘.’, dp[i][j] |= dp[i-1][j], which means * matches >= 1 of preceding characters, this i can be removed

(72) Edit Distance

- create the dp matrix
- setup the first row: dp[0][j] = j
- setup the first col: dp[i][0] = i
- condition 1: if w1[i-1] == w2[j-1], dp[i][j] = dp[i-1][j-1]
- condition 2: if w1[i-1] != w2[j-1], dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1

(91): Decode Ways: from n-1 to 0: check s.substring(i, i+2) <= 26, if so, dp[i] = dp[i+1] + dp[i+2], otherwise, dp[i] = dp[i+1]

Calculator: (227, 224, General)
(227) contains + - * /

- create stack<Integer>, char sign, and int num; use stack to save unit like “+5”, “+4*5*6”, “-6/3"
- if the current character is digit: cumulatively add it to the num
- if the current character is “sign” or it is the last position in the string(now, nothing to do with the current “sign”): if the previous sign is “+” or “-“, push this sign and current num into stack, update the res; otherwise, pop out from stack, subtract this value from res, and push this sign, value which is poped out and the current num into stack, update the res;
- notes: when you meet a sign, you update the stack and res, and nothing to do with the current sign; you always think there is no * and / in the string, if you are wrong, you subtract the previous value, update the res, and then re-calculate the value using right previous sign.

(224) contains + - ( )

- create Stack<Integer> ops which represents the previous sign
- if it is digit: cumulatively add it to the num
- if it is + or -: update res += prevSign * num, and then update prevSign based on the stack.peek(), and clear the num
- if it is (: push prevSign
- if it is ): pop out
- notes: if there is some - before (, we need to change all signs in the ()

(General) contains + - * / ( ) negative integer

- create stack<Integer> nums and Stack<Character> ops
- if it is digit: use while loop to get the complete num; and then if the previous sign is * or /, do one calculation, otherwise push this new number into nums
- if it is + or -: it is safe to do one calculation, so do it and push new sign into ops
- if it is * or /: push it into ops
- if it is (: push it into ops
- if it si ): do as many calculations as possible until the previous sign is ( and pop out (
- finally, pop out two stacks and do the rest of calculation, and then pop out the last num which is the result

Recursive DP: (95, 241)

- create a new ‘res’ each round
- for each i from 0 to n, divide the whole array into two part, each part is the result of recursive call, and use permutation to combine them together.

TreeSet: (220, 363)
(220) use tree set to save up to k elements, and use floor()/celing() to check if the tree set has an element whose difference between this one is up to t. floor() is the greatest number less than or equals to the given one; ceiling() is the smallest number greater than or equals to the given one.
(363) ceiling is the least number which is greater than or equals to (currSum - k), so ceiling >= currSum - k  ==>  currSum - ceiling <= k

Subarray and Subsequence: (209, 354, 300)
(209) use Kadane Algorithm => O(n)
(354, 300) use Russian Doll/ LIS => O(n^2) or O(nlogn) using binary search

- Subarray, Substring(contiguous array), Subsequence(could delete some characters)
- use hash map or hash set to save Point Class: (1) override equals() and hashcode() methods in Point Class (2) define MyPoint Class to composite Point Class and define equals() and hashcode() (3) inheritate Point using ‘class MyPoint extends Point {}’ and define equals() and hashcode()
- TreeMap: lastKey() -> get the highest key value
- LinkedList: poll()/peek() is the oldest one, pollLast()/peekLast() is the newest one
- PriorityQueue: the default is min heap, queue.peek()/poll() is the smallest value; if use PriorityQueue as a sliding window, it always keep the k largest numbers
- offer()/pollLast()/peekLast() [---> queue --->] poll()/peek()
- offerLast()/peekLast() [---> deque --->] pollFirst()/peekFirst()

Interface, implements, composition
Class, extends, inheritance