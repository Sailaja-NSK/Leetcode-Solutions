class DisJointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    DisJointSet(int n) {
        for(int i = 0;i < n;i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if(parent.get(node) == node) {
            return node;
        }

        int up = findParent(parent.get(node));
        parent.set(node,up);
        return parent.get(node);
    }

    public void union(int u,int v) {
        int up_u = findParent(u);
        int up_v = findParent(v);
        if(up_u == up_v) return;
        if(size.get(up_u) < size.get(up_v)) {
            parent.set(up_v,up_u);
            size.set(up_v,size.get(u)+size.get(v));
        } else {
            parent.set(up_u,up_v);
            size.set(up_u,size.get(u)+size.get(v));
        } 
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        Map<String,Integer> mapMailNode = new HashMap<>();
        for(int i = 0;i < n;i++) {
            for(int j = 1;j < accounts.get(i).size();j++) {
                String mail = accounts.get(i).get(j);
                if(mapMailNode.containsKey(mail) == false) {
                    mapMailNode.put(mail,i);
                } else {
                    ds.union(i,mapMailNode.get(mail));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mergedMail.add(new ArrayList<>());
        }

        for (Map.Entry<String, Integer> entry : mapMailNode.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findParent(entry.getValue());
            mergedMail.get(node).add(mail);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMail.get(i).size() == 0) continue;
            Collections.sort(mergedMail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // account name
            temp.addAll(mergedMail.get(i));
            ans.add(temp);
        }
        return ans;
    }
}