import data
import quick_sort
import time
import copy
from tabulate import tabulate
import sys



def run_sort(method):
        if method == "quickSort_recursive_median" or method == "quickSort_iterative_median":
            return "median"
        elif method == "quickSort_recursive_random" or method == "quickSort_iterative_random":
            return "random"
        elif method == "quickSort_recursive_first" or method == "quickSort_iterative_first":
            return "first"
            
            
def main():  
    sys.setrecursionlimit(2000000)  # Increase the limit to 2000 or higher
    array = data.array()
    qs = quick_sort.QuickSort()
    # print(array)
    methods = [
        # "quickSort_recursive_median",
        # "quickSort_recursive_random",
        # "quickSort_recursive_first",
        # "quickSort_iterative_median",
        # "quickSort_iterative_random",
        # "quickSort_iterative_first",
        # "insertionSort_recursive",
        "insertionSort_iterative",
     ]
    input_size = [1000000]
    # input_size = [10, 100, 10000]
    table_data = []  # To store results for tabular output
    
    for method in methods:
        row = [method]
        #print(f"Method : {method}")
        for n in input_size:
            sub_array = copy.deepcopy(array[:n]) # to create an independent copy of array.
         #   print(f"INPUT {sub_array}")
            start_time = time.perf_counter()
            if method in ("quickSort_recursive_median", "quickSort_recursive_random", "quickSort_recursive_first"):
                pivot_strategy = run_sort(method)
                qs.quick_sort_recursive(sub_array, pivot_strategy, 0, len(sub_array)-1)
            if method in ("quickSort_iterative_median", "quickSort_iterative_random", "quickSort_iterative_first"):
                pivot_strategy = run_sort(method)
                qs.quick_sort_iterative(sub_array, pivot_strategy)
            if method in ("insertionSort_recursive"):
                qs.insertion_sort_recursive(sub_array, len(sub_array)) 
            if method in ("insertionSort_iterative"):   
                qs.insertion_sort_iterative(sub_array)        
            end_time = time.perf_counter()
            #result = sub_array
            #print(f"Method : {method}, Time Taken {end_time - start_time}")
            #print()
            #print (f"Sorted Array {result}")
            #print()
            
            time_taken = (end_time - start_time)
            row.append(f"{time_taken:.6f}s")  # Add time taken for this input size
        table_data.append(row)  # Add the row for this method
            
            # Define table headers
    headers = ["Method / Input"] + [str(size) for size in input_size]
    
    # Print the table
    print(tabulate(table_data, headers=headers, tablefmt="grid"))

    
if __name__ == "__main__":
    main()        
    
    
