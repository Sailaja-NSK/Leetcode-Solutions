# 2574. Left and Right Sum Differences

## Pattern

* Prefix Sum
* Suffix Sum
* Total Sum Optimization

## Problem Understanding

For each index `i`:

* Left Sum = sum of all elements before index `i`
* Right Sum = sum of all elements after index `i`

We need:

`abs(Left Sum - Right Sum)`

Example:

nums = [10,4,8,3]

| Index | Left Sum | Right Sum | Answer |
| ----- | -------- | --------- | ------ |
| 0     | 0        | 15        | 15     |
| 1     | 10       | 11        | 1      |
| 2     | 14       | 3         | 11     |
| 3     | 22       | 0         | 22     |

Output:

[15,1,11,22]

---

## Approach 1: Brute Force

### Idea

For every index:

1. Calculate left sum by traversing all elements before it.
2. Calculate right sum by traversing all elements after it.
3. Take absolute difference.

### Time Complexity

O(n²)

Reason:

For every index, we are traversing the array again to calculate sums.

### Space Complexity

O(n)

(for answer array)

### Learning

Whenever I calculate the same sum repeatedly inside nested loops, I should think about Prefix/Suffix sums.

---

## Approach 2: Prefix Sum + Suffix Sum

### Idea

Store:

leftSum[i] = sum of all elements before i

rightSum[i] = sum of all elements after i

Then:

answer[i] = abs(leftSum[i] - rightSum[i])

### Building Prefix Array

leftSum[i] = leftSum[i-1] + nums[i-1]

### Building Suffix Array

rightSum[i] = rightSum[i+1] + nums[i+1]

### Time Complexity

O(n)

### Space Complexity

O(n)

because of prefix and suffix arrays.

### Learning

Prefix Sum = Sum Before Index

Suffix Sum = Sum After Index

Whenever a problem asks:

* Sum before index
* Sum after index
* Left vs Right totals

Think of Prefix and Suffix arrays.

---

## Approach 3: Optimal (Total Sum Optimization)

### Key Observation

totalSum = leftSum + nums[i] + rightSum

Therefore:

rightSum = totalSum - leftSum - nums[i]

This means we do not need a suffix array.

We only need:

* totalSum
* leftSum

### Algorithm

1. Calculate totalSum.
2. Initialize leftSum = 0.
3. For every index:

   * rightSum = totalSum - leftSum - nums[i]
   * answer[i] = abs(leftSum - rightSum)
   * leftSum += nums[i]

### Time Complexity

O(n)

### Space Complexity

O(1)

(excluding the answer array)

---

## Pattern Notes For Future Revision

When I see:

* Sum before index
* Sum after index
* Left Sum vs Right Sum
* Range Sum Queries

Think:

1. Prefix Sum
2. Suffix Sum
3. Can one side be derived from total sum?

If yes, try reducing space from O(n) to O(1).
