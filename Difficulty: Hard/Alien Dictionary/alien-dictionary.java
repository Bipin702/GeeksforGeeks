class Solution {
    public String findOrder(String[] words) {
        // code here
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        HashMap<Character,Integer> indegree = new HashMap<>();
        
        for(String word : words){
            for(char ch : word.toCharArray()){
                graph.putIfAbsent(ch,new HashSet<>());
                indegree.putIfAbsent(ch,0);
            }
        }
        
        for(int i = 0; i < words.length-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            
            if(s1.length() > s2.length() && s1.startsWith(s2)){
                return "";
            }
            
            int len = Math.min(s1.length(),s2.length());
            
            for(int j = 0; j < len; j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                
                if(c1 != c2){
                    if(!graph.get(c1).contains(c2)){
                        graph.get(c1).add(c2);
                        indegree.put(c2,indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for(char ch : indegree.keySet()){
            if(indegree.get(ch)==0) q.offer(ch);
        }
        
        StringBuilder result = new StringBuilder();
        
        while(!q.isEmpty()){
            char curr = q.poll();
            result.append(curr);
            
            for(char neighbor : graph.get(curr)){
                indegree.put(neighbor,indegree.get(neighbor)-1);
                if(indegree.get(neighbor) == 0){
                    q.offer(neighbor);
                }
            }
        }
        if(result.length() != indegree.size()) return "";
        return result.toString();
    }
}