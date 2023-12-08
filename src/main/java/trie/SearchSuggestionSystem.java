package trie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Partially working.
 */
public class SearchSuggestionSystem {
    public static void main(String[] args) {
        SearchSuggestionSystem searchSuggestionSystem = new SearchSuggestionSystem();
        List<List<String>> results = searchSuggestionSystem.suggestedProducts(new String[]{
                "mobile", "mouse", "moneypot", "monitor", "mousepad"
        }, "mouse");
        System.out.println(results);
    }

    private Trie getTrieOfProducts(String[] products) {
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        return trie;
    }

    private void updateSuggestedProducts(PriorityQueue<String> pqSearchResults, List<List<String>> suggestedProducts) {
        List<String> searchedProducts = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            String searchedProduct = pqSearchResults.poll();
            if (searchedProduct == null) {
                continue;
            }
            searchedProducts.add(searchedProduct);
        }
        suggestedProducts.add(searchedProducts);
    }

    private PriorityQueue<String> sortSearchedProducts(List<String> searchResults) {
        PriorityQueue<String> pqSearchResults = new PriorityQueue<>();
        pqSearchResults.addAll(searchResults);
        return pqSearchResults;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestedProducts = new ArrayList<>();
        Trie trie = getTrieOfProducts(products);

        int searchWordSize = searchWord.length();
        for (int i = 0; i < searchWordSize; i++) {
            String currentSearchPrefix = searchWord.substring(0, i + 1);
            List<String> searchedProducts = trie.searchWithPrefix(currentSearchPrefix);
            PriorityQueue<String> pqSearchedProducts = sortSearchedProducts(searchedProducts);
            updateSuggestedProducts(pqSearchedProducts, suggestedProducts);
        }
        return suggestedProducts;
    }
}
