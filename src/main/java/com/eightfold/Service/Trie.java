package com.eightfold.Service;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        if (!node.containsKey(currentChar)) {
          node.put(currentChar, new TrieNode());
        }
        node = node.get(currentChar);
      }
      node.setEnd();
    }

    public List<String> search(String word) {
      TrieNode node  = root;
      List<String> res = new ArrayList<>();
      searchNode(word,0,node,res);
      return res;
    }
    public void searchNode(String word , int k , TrieNode node,List<String> res) {
      if(node.isEnd()) {
        res.add(word);
      }
      for ( char i='a';i<'z';i++) {
        if(node.containsKey(i) && i==word.charAt(k))  {
           searchNode(word , k+1 ,node, res); // word = tarun
        } else {
          searchNode( word , k, node.get(i), res); // word = arun
        }
      }
    }
  public List<String> searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char curLetter = word.charAt(i);
      if (node.containsKey(curLetter)) {
        node = node.get(curLetter);
      } else {
        return null;
      }
    }
    List<String> searchResult = new ArrayList<>();
    StringBuilder builder = new StringBuilder(word);
    searchQuery(node, searchResult, builder);
    return searchResult;
  }

/*  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }*/

  private void searchQuery(TrieNode  node , List<String> results , StringBuilder word) {
      if(node.isEnd()) {
        results.add(word.toString());
      }
      if(node!=null) {
        for ( char i='a';i<'z';i++) {
          if(node.containsKey(i)) {
            word.append(i);
            searchQuery(node.get(i) ,results , word);
          }
        }

      }

  }
}
