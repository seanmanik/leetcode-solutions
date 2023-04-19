class Trie {
    Node headNode; 

    public Trie() {
        //Head node represented by ! | 28
        //End node represented by $ | 27
        this.headNode = new Node('!');
    }
    
    public void insert(String word) {
        int counter = 0;
        Node curr = headNode;
        while (counter < word.length()) {
            if (curr.next[word.charAt(counter) - 'a'] == null) {
                curr.next[word.charAt(counter) - 'a'] = new Node(word.charAt(counter));
            }
            curr = curr.next[word.charAt(counter) - 'a'];
            counter++;
        }
        curr.next[26] = new Node('$');
    }
    
    public boolean search(String word) {
        int counter = 0;
        Node curr = headNode;
        while (counter < word.length()) {
            curr = curr.next[word.charAt(counter) - 'a'];
            if (curr == null) {
                return false;
            }
            counter++;
        }
        if (curr.next[26] == null) {
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        int counter = 0;
        Node curr = headNode;
        while (counter < prefix.length()) {
            curr = curr.next[prefix.charAt(counter) - 'a'];
            if (curr == null) {
                return false;
            }
            counter++;
        }
        for (int i = 0; i < 27; i++) {
            if (curr.next[i] != null) {
                return true;
            }
        }
        return false;
    }
}

class Node {
    Node[] next;
    char c;

    public Node(char k) {
        next = new Node[28];
        c = k;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */