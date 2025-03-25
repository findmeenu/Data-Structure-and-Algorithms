
def array():
    try:
        filepath = r"C:\Users\MEGU0007\Desktop\New folder\Seminar 1\Seminar 1 - File with random numbers.txt"
        
        # Open the file and read data
        with open(filepath, "r") as file:
            array = [int(line.strip()) for line in file if line.strip().isdigit()]
            return array      
        # print(array)  # Display the array
    except FileNotFoundError:
        print("File not found. Please check the file path.")
    except ValueError:
        print("File contains non-numeric data.")
        
        
        

