# recursion-basics

Implementt basic recursion procedures

- 3 recursive methods for the ArrayRecursion class.

1 - reverseRecurse - reverse the order of the values stored in the array, using the following algorithm:

Swap the first element value with the last. Then remove the first and last element and recursively reverse the shortened array.

2 - recursiveIndexOfLargest 

return the index (position) of largest value stored in the array using the following algorithim:

Find the index of the largest value in that portion of the array containing all but the last element. Compare the value stored at that inde to the value in the last element and return the index of the larger of the two. Then, remove the last element and repeat the process for the shortened array.

3 - recursiveSort - sort the array in ascending order, using the selection sort algorithm and the recursiveGetLargest method

Find the largest value in the array and 'swap' it with the last element. Then remove the last element and repeat the process for the shortened array.


