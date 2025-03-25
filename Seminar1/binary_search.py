import time
import random

# Binary Search Recursive Function
def binary_search_recursive(arr, target, low, high):
    if low > high:
        return False  # Element not found

    mid = (low + high) // 2
    if arr[mid] == target:
        return True  # Element found
    elif arr[mid] > target:
        return binary_search_recursive(arr, target, low, mid - 1)  # Search in the left half
    else:
        return binary_search_recursive(arr, target, mid + 1, high)  # Search in the right half

# Function to generate the array and perform binary search
def run_search(array, target):
    start_time = time.perf_counter()  # Start time
    result = binary_search_recursive(array, target, 0, len(array) - 1)  # Perform binary search
    end_time = time.perf_counter()  # End time
    return result, ((end_time - start_time)*1000000)  # Return result and time taken

# Main method to test binary search with various input sizes
def main():
    input_sizes = [100, 1000, 10000, 100000, 1000000]
    # Generate a sorted array for the binary search to work properly
    for n in input_sizes:
        print(f"Input size: {n}")
        # Create a sorted array of numbers from 1 to n
        array = list(range(1, n + 1))
        
        # Test for a number that exists in the array (example: n//2)
        target = n // 2

        # Run the binary search
        result, time_taken = run_search(array, target)
        print(f"Searching for {target} - Found: {result}, Time Taken: {time_taken:.6f} seconds")

        # Test for a number that doesn't exist in the array (example: n+1)
        target = n + 1

        # Run the binary search
        result, time_taken = run_search(array, target)
        print(f"Searching for {target} - Found: {result}, Time Taken: {time_taken:.6f} seconds")
        print("-" * 50)

if __name__ == "__main__":
    main()
