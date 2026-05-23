class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            String key = getKey(s);

            System.out.println(key);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String s) {
        int[] hashing = new int[26];

        for(char c : s.toCharArray()) {
            hashing[c - 'a']++;
        }

        String key = Arrays.toString(hashing);
        return key;
    }
}
