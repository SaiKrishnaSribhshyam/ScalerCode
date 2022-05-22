import java.lang.*;
import java.util.*;

public class Main {
    public static class Trie {
        HashMap<Character,Trie> map;
        boolean isEOW;
        ArrayList<Integer> weight;
        public Trie(){
            this.map=new HashMap();
            this.isEOW=false;
            this.weight=new ArrayList();
        }
    }
    public static class WeightedString implements Comparable<WeightedString>{
        String str;
        int weight;
        public WeightedString(String str1,int weight1){
            str=str1;
            weight=weight1;
        }

        public int compareTo(WeightedString w){
            if(this.weight > w.weight)
                return -1;
            else if(this.weight < w.weight)
                return 1;
            
            return 0;
        }
    }
    public static void buildTrie(Trie root,String[] dict,int[] weights){
        Trie curr=root;
        for(int i=0;i<dict.length;i++){
            curr=root;
            for(int j=0;j<dict[i].length();j++){
                char ch=dict[i].charAt(j);
                if(!curr.map.containsKey(ch))
                    curr.map.put(ch,new Trie());
                curr=curr.map.get(ch);
            }
            curr.isEOW=true;
            curr.weight.add(weights[i]);
        }
    }
    public static void searchPatterns(Trie root,String[] patterns){
        Trie curr=root;
        boolean isMatched=true;
        for(int i=0;i<patterns.length;i++){
            curr=root;
            isMatched=true;
            for(int j=0;j<patterns[i].length();j++){
                char ch=patterns[i].charAt(j);
                if(!curr.map.containsKey(ch)){
                    System.out.println("-1 ");
                    isMatched=false;
                    break;
                }
                curr=curr.map.get(ch);
            }
            if(!isMatched)
                continue;
            PriorityQueue<WeightedString> maxHeap=new PriorityQueue();
            findAllStrings(curr,new StringBuffer(patterns[i]),maxHeap);
            int size=Math.min(5,maxHeap.size());
            for(int k=0;k<size;k++)
                System.out.print(maxHeap.poll().str +" ");
            System.out.println();
        }
    }

    public static void findAllStrings(Trie root,StringBuffer prefix,PriorityQueue<WeightedString> maxHeap){
        if(root.isEOW){
            for(int wt:root.weight)
                maxHeap.offer(new WeightedString(prefix.toString(),wt));
        }
        if(root.map.size()==0)
            return;
        
        for(char key:root.map.keySet()){
            StringBuffer str=new StringBuffer(prefix.toString());
            str.append(key);
            Trie temp=root.map.get(key);
            //System.out.println(prefix + ":" + key);
            findAllStrings(temp,str,maxHeap);
        }

    }

    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner cin=new Scanner(System.in);
        int tests=cin.nextInt();
        while(tests>0){
            int length=cin.nextInt();
            int patternLength=cin.nextInt();
            cin.nextLine();
            String[] dictionary=new String[length];
            int[] weights=new int[length];
            String[] patterns=new String[patternLength];
            StringTokenizer str=new StringTokenizer(cin.nextLine());
            //System.out.println(cin.nextLine());
            for(int i=0;i<length;i++){
                dictionary[i]=str.nextToken();
                //System.out.println(dictionary[i]);
            }
            for(int i=0;i<length;i++)
                weights[i]=cin.nextInt();
            cin.nextLine();
            StringTokenizer str2=new StringTokenizer(cin.nextLine()," ");
            for(int i=0;i<patternLength;i++)
                patterns[i]=str2.nextToken();
            Main m=new Main();
            Main.Trie root=new Trie();
            buildTrie(root,dictionary,weights);
            searchPatterns(root,patterns);
            tests--;
        }
    }
}