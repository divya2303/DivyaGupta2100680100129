# CompoundWordProblem
### Overview
This program is designed to find the longest and second longest compounded words from a file containing a list of alphabetically sorted words. A compounded word is a word that can be constructed by concatenating two or more shorter words from the same list. For example, "catsdogcats" is a compounded word formed by combining "cats," "dog," and "cats."

### Approach and Design Decisions

1. Data structure:
   
   - Trie - Used to store and search for words efficiently. Enables fast prefix matching, essential for validating compound words.
   - List - Words are initially loaded into a list for sorting and processing. Sorting by length ensures longer words are checked first, reducing unnecessary checks.

2. Algorithm:

   - Insertion into Trie - Each word is inserted into the Trie, where each node represents a character and marks word boundaries for quick prefix checks.
   - Sorting - Words are sorted in descending order of length to prioritize processing longer words first. This helps identify the longest compound word early.
   - Compound Word Validation - A recursive function checks if a word can be split into smaller words from the Trie by validating prefixes and recursively checking the remaining portion.
   - Optimization - The program exits early after finding the longest and second longest compound words, using efficient Trie traversal to minimize redundant prefix checks.

### Steps to execute the code

1. Prerequisites:

   - Java Development Kit (JDK) version 8 or later must be installed on your system.

2. Prepare Input File:

   - Ensure the input file (`Input_01.txt` or `Input_02.txt`) is available in the project directory.

3. Compile and Run:

   - Compile the code
     ```properties
     javac CompoundWordSolver.java
     ```
   
   - Execute the program
     ```properties
     java CompoundWordSolver
     ```

4. File Path Configuration:

   - Update the `filePath` variable in the code if your input file is in a different location.

### Output:

The program prints:
  - Longest compound word.
  - Second-longest compound word.
  - Processing time in milliseconds.


     

