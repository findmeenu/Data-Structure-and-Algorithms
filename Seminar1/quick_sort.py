import random


class QuickSort:

    def random_pivot(self, start, end):
        # Selects a random pivot from array & retrun it's index.
        index = random.randint(start, end)
        return index

    def pivot_first_element(self, start):
        # Selects the first element as pivot and return index.
        return start

    def median_of_3_pivot(self, sub_array, start, end):

        first_element = sub_array[start]
        middle_element = sub_array[end // 2]
        last_element = sub_array[end]
        median_array = [first_element, middle_element, last_element]
        median_array.sort()
        median = median_array[1]
        if median == first_element:
            return start
        elif median == middle_element:
            return end // 2
        elif median == last_element:
            return end

    def swap_references(self, sub_array, i, j):
        # Swap the elements at index i and j
        sub_array[i], sub_array[j] = sub_array[j], sub_array[i]

    def pivot_strategy(self, sub_array, pivot_strategy, start, end):
        if pivot_strategy == "random":
            return self.random_pivot(start, end)
        elif pivot_strategy == "median":
            return self.median_of_3_pivot(sub_array, start, end)
        elif pivot_strategy == "first":
            return self.pivot_first_element(start)

    def partition(self, sub_array, pivot_strategy, start, end):

        pivot_index = self.pivot_strategy(sub_array, pivot_strategy, start, end)
        # print(pivot_index)
        pivot = sub_array[pivot_index]
        # print(f"pivot: {pivot}")
        self.swap_references(sub_array, pivot_index, end)
        # print(f"Sub array after swapping the pivot at end {sub_array}")
        i = start - 1
        # Partitition using two pointer approach
        for j in range(start, end):
            if sub_array[j] <= pivot:
                i = i + 1
                self.swap_references(sub_array, i, j)
        self.swap_references(sub_array, i + 1, end)
        return i + 1

    def quick_sort_recursive(self, sub_array, pivot_strategy, start, end):
        if start < end:
            pivot_position = self.partition(sub_array, pivot_strategy, start, end)
            # print(f"pivot_postion: {pivot_position}")
            self.quick_sort_recursive(
                sub_array, pivot_strategy, start, pivot_position - 1
            )
            self.quick_sort_recursive(
                sub_array, pivot_strategy, pivot_position + 1, end
            )

    def quick_sort_iterative(self, sub_array, pivot_strategy):
        stack = [(0, len(sub_array) - 1)]
        while stack:
            start, end = stack.pop()
            if start < end:
                pivot_index = self.partition(sub_array, pivot_strategy, start, end)
                stack.append((start, pivot_index - 1))
                stack.append((pivot_index + 1, end))

    def insertion_sort_iterative(self, sub_array):
        for i in range(1, len(sub_array)):  # Note loop starts from 1
            key = sub_array[i]  # Starts from position 1-----5
            j = i - 1  # Value at position 0   23,5---23
            # 5<23
            while (j >= 0 and key < sub_array[j]):  # while j is +ve or 0 & comparing key with previous value
                sub_array[j + 1] = sub_array[j] # shift the element at index j to index j+1. so element 5 moved to position 0.
                j -= 1
                sub_array[j + 1] = key

    def insertion_sort_recursive(self, sub_array, n):
        # base case
        if n <= 1:
            return
        # Sort first n-1 elements
        self.insertion_sort_recursive(sub_array, n - 1)
        # Insert last element at its correct position in sorted array.
        last = sub_array[n - 1]
        j = n - 2
    
        # Move elements of arr[0..i-1], that are
        # greater than key, to one position ahead
        # of their current position
        while (j >= 0 and sub_array[j] > last):
            sub_array[j + 1] = sub_array[j]
            j = j - 1
        sub_array[j + 1] = last
        
    
    
    # def partition2(self, sub_array, pivot_strategy, start, end):

    #     pivot_index = self.pivot_strategy(sub_array, pivot_strategy, start, end)
    #     pivot = sub_array[pivot_index]
    #     print(f"pi_index: {pivot_index} pivot: {pivot}")
    #     self.swap_references(sub_array, pivot_index, end)
    #     print(f"Sub array after swapping the pivot at end {sub_array}")
    #     i = start
    #     j = end - 1

    #     while True:
    #         # Increment i until sub_array[i] >= pivot
    #         while i < end and sub_array[i] < pivot:
    #             i += 1

    #         # Decrement j until sub_array[j] <= pivot
    #         while j >= start and sub_array[j] > pivot:
    #             j -= 1

    #         # Break when pointers meet or cross
    #         if i >= j:
    #             break

    #         # Swap elements at i and j
    #         self.swap_references(sub_array, i, j)

    #     # Place the pivot at its correct position
    #     self.swap_references(sub_array, i, end)
    #     return i
