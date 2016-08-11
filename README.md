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

Binary Search: (4)
if the nums is sorted, we could do binary search
(4) divide each array into two parts, and compare A[i-1], B[j] and B[j-1], A[i].

Permutation: (31, 46, 47)
(31) next permutation:

- from right to left, find the longest non-increasing suffix(right most must be at nums.length-1)
- the element on the left of suffix is the pivot
- from right to left in suffix, find the first element that is >= pivot and swap them
- reverse the suffix
- notice: for the step(a), if the suffix is the whole array, just reverse it

(46) do not contain non-duplicates: get a new element; from lists, choose one list and find how many positions can be inserted
(47) contain duplicates: use DFS+backtracking to solve it.

- sort the array
- for each round, iterate the whole array, use used[] to mark which number is visited, and use (i>0 && nums[i] == nums[i-1] && !used[i-1]) to avoid duplicates

Palindrom: