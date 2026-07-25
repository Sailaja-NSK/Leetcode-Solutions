class Solution {
    public int maxProduct(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            int temp1 = n % 10;
            list.add(temp1);
            n = n / 10;
        }
        Collections.sort(list);
        int m = list.size();
        return list.get(m-1) * list.get(m-2);
    }
}