    static int LIS(int[] arr, int n) {


        // add the arr elements into the set to get all unique elements
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // code fixed
        // copy the set elements to the arr and sort it
        int[] arr2 = new int[set.size()];
        int x = 0;
        for (int num : set) {
            arr2[x] = num;
            x++;
        }
        Arrays.sort(arr2);

        //now findout the LCS b/w arr, arr2

        int m = arr2.length;


        int[][] dp = new int[n + 1][m + 1];
        for (int i=1; i<n+1; i++) {
            for(int j=1; j<m+1; j++){
                if(arr[i-1] == arr2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

        }

        return dp[n][m];

    }
