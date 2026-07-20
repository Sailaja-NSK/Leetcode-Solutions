class Node {
    Node links[] = new Node[2];

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind,Node node) {
        links[ind] = node;
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    public static void insert(int num) {
        Node node = root;
        for(int i = 31;i >= 0;i--) {
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)) {
                node.put(bit,new Node());
            }
            node = node.get(bit);
        }
    }


    public int getMax(int num) {
        Node node = root;
        int max = 0;
        for(int i = 31;i >= 0;i--) {
            int bit = (num >> i) & 1;
            if(node.containsKey(1- bit)) {
                max = max | (1<<i);
                node = node.get(1-bit);
            } else {
                node = node.get(bit);
            }
        }
        return max;
    }
}


class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> oQ = new ArrayList<ArrayList<Integer>>();
        int m = queries.length;

        for(int i = 0;i < m;i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(queries[i][1]);
            temp.add(queries[i][0]);
            temp.add(i);
            oQ.add(temp);
        }

        Collections.sort(oQ, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });

        int ind = 0;
        int n = nums.length;
        Trie trie = new Trie();
        int[] ans = new int[m];
        Arrays.fill(ans,-1);
        for(int i = 0;i < m;i++) {
            while(ind < n && nums[ind] <= oQ.get(i).get(0)) {
                trie.insert(nums[ind]);
                ind++;
            }
            int qIndex = oQ.get(i).get(2);
            if(ind != 0) ans[qIndex] = trie.getMax(oQ.get(i).get(1));

        }
        return ans;
    }
}