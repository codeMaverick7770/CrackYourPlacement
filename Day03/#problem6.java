// Print all the duplicate characters in a string
// Given a string S, the task is to print all the duplicate characters with their occurrences in the given string.
// Time Comp: O(n), space: O(n)Print all the duplicate characters in a string
static void printDups(String str)
  {
    Map<Character, Integer> count = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if(count.containsKey(str.charAt(i)))
        count.put(str.charAt(i) , count.get(str.charAt(i))+1); 
      else count.put(str.charAt(i),1);
      //increase the count of characters by 1 
    }
