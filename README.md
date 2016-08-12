2Sum: (1, 167, 170)

- from left to right, use hash set to save all element and check if the set contains (target - nums[i])
- two pointer approach, from both sides to middle, if sum > target, right--, otherwise left++

3Sum, 4Sum: (15, 16, 18)

- sort the array
- anchor the first one, and then use the second approach of 2Sum
- notices that you could compare x1 + x2 + x3 with target to truncate useless calculation; to avoid duplicates, you need to use if(i>0 && nums[i] == nums[i-1]) continue;

Trapping Water: (11, 42)
formula: (min(height[right], height[left]) - height[bottom]) * (right - left - 1)
(11) use two pointer from both sides to the middle, always anchor the highest bar and move the other one
(42) use one stack which saves all indeces in decreasing order

- when height is decreasing, push into the stack and increase the index
- when height is increasing, pop out an index as the bottom index, and peek an index as the left-most bar, and then do the calculation

Two Pointers: (26, 27)
(26) in sorted array: use two pointers from left to right, if they are the same, right++, otherwise, change the value of slow to the value of right, and then right++
(27) in unsorted array: we want to let all element whose value is ‘val’ on the left, and ’non-val’ on the right; use two pointers from both sides; first do while loop when meet the requirement, otherwise, swap them.

Binary Search and Search in Rotated Array: (4, 153, 154, 33, 81)
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
- if condition(3): (nums[middle] == nums[left] == nums[right]), right—, cannot decide
- return nums[left] == target

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

Read4: (157, 158)
the difference between call once and call multiple times is: before call read4(), we should check if indexTmpBuf is 0, if so we have to call read4(), otherwise we do not need to, we just copy from tmpBuf to buf