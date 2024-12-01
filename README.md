# DivyaGupta129
### Overview
This program is designed to find the longest and second longest compounded words from a file containing a list of alphabetically sorted words. A compounded word is a word that can be constructed by concatenating two or more shorter words from the same list. For example, "catsdogcats" is a compounded word formed by combining "cats," "dog," and "cats."

### Approach and Design Decisions
The code is designed to efficiently solve the problem of identifying the longest and second longest compounded words from a large list of words by making use of optimized data structures and algorithms.

1. Input Handling:
   
   - The program reads words from an input file, ensuring they are loaded into memory for processing. It trims unnecessary whitespace for cleaner input.
     
2. Data Structure (Trie):
   
   - A Trie (prefix tree) is used to store all words. This data structure allows fast insertion and lookup operations, which are critical for verifying if a word can be constructed from shorter words.
     
3. Word Sorting:
   
   - Sort words in descending order by length to prioritize longer words.
     
4. Compound Word Verification:
   
   - Use a recursive function to check if a word can be constructed by combining two or more shorter words from the Trie.
     
5. Output Results:
    
   - Identify and output the longest and second longest compounded words, along with the time taken for processing.


     

