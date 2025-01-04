/*A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */ 
class Trie {

    // Define a TrieNode class to represent each node in the trie
    private class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        // Constructor for TrieNode
        TrieNode() {
            children = new TrieNode[26]; // One for each lowercase letter
            isEndOfWord = false;
        }
    }

    private TrieNode root; // Root of the Trie

    // Constructor for Trie
    public Trie() {
        root = new TrieNode();
    }
    
    // Insert a word into the trie
    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true; // Mark the end of the word
    }
    
    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEndOfWord;
    }
    
    // Check if a prefix exists in the trie
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
    
    // Helper method to search for a prefix or word in the trie
    private TrieNode searchPrefix(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return null; // Prefix does not exist
            }
            current = current.children[index];
        }
        return current;
    }
}


/*insert(String word):

Traverse the trie for each character in the word.
If a character’s node doesn’t exist, create it.
Mark the last node as the end of the word.
search(String word):

Use the helper method searchPrefix to locate the node corresponding to the word.
If the node exists and is marked as isEndOfWord, return true; otherwise, return false.
startsWith(String prefix):

Use searchPrefix to check if the prefix exists in the trie.
If the node for the prefix exists, return true; otherwise, return false.
searchPrefix(String prefix):

Traverse the trie for the given prefix.
Return the last node reached, or null if the prefix is not found.

Key Points:
Time Complexity:
insert: O(L), where L is the length of the word.
search and startsWith: O(L).
Space Complexity: O(AL), where A is the alphabet size (26 for lowercase letters) and L is the average length of the inserted words. Each node can potentially have 26 children.
This solution meets the constraints of the problem and handles the operations efficiently.
*/