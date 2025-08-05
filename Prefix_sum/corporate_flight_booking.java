class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {


        int []res=new int[n];
        for(int[]curr:bookings){
            int start=curr[0]-1;
            int end=curr[1];
            int val=curr[2];
            res[start]+=val;
            if(end < n){
                res[end]-=val;
            }
        }
        for(int i=1;i<n;i++){
            res[i]+=res[i-1];
        }
        return res;

        
    }
}
// This problem is about efficiently processing **range updates** on an array. The logic used in your code is based on the **difference array** (or prefix sum trick), which allows you to perform multiple range updates in **O(1)** time per query, and get the final values using a prefix sum.

// ---

// ### 🔍 Problem Summary:

// You are given:

// * `bookings[i] = [first_i, last_i, seats_i]` meaning seats are booked from `first_i` to `last_i` (both inclusive).
// * Your goal: For `n` flights (1 to n), return the **total number of seats booked** for each flight.

// ---

// ### ✅ Step-by-step Explanation:

// Let’s walk through the key parts of the code:

// ```java
// int[] res = new int[n];
// ```

// * `res[i]` will store the number of seats booked on flight `i+1`.
// * Initially all values are 0.

// ---

// ### 🧠 Range Update Using Difference Array:

// ```java
// for(int[] curr : bookings){
//     int start = curr[0]-1; // Convert to 0-based index
//     int end = curr[1];     // one index after end
//     int val = curr[2];     // number of seats

//     res[start] += val;     // Add `val` at start
//     if(end < n){
//         res[end] -= val;   // Subtract `val` after end
//     }
// }
// ```

// * Instead of updating all indices from `start` to `end`, we just:

//   * Add `val` at index `start`
//   * Subtract `val` at index `end` (only if it's within bounds)
// * This sets up a difference array.

// ---

// ### 📈 Convert Difference Array to Result:

// ```java
// for(int i = 1 ; i < n ; i++){
//     res[i] += res[i-1];
// }
// ```

// * This prefix sum loop turns the difference array into the final result.
// * Each index accumulates all previous changes.

// ---

// ### 🧪 Example:

// Let’s say:

// ```java
// bookings = [[1, 2, 10], [2, 3, 20], [2, 5, 25]], n = 5
// ```

// Initial `res = [0, 0, 0, 0, 0]`

// After processing bookings:

// 1. `[1,2,10]` → `res[0] += 10`, `res[2] -= 10` → `[10, 0, -10, 0, 0]`
// 2. `[2,3,20]` → `res[1] += 20`, `res[3] -= 20` → `[10, 20, -10, -20, 0]`
// 3. `[2,5,25]` → `res[1] += 25`, (no subtract as end=5) → `[10, 45, -10, -20, 0]`

// Now apply prefix sum:

// ```
// [10, 55, 45, 25, 25]
// ```

// ### 🧾 Final Answer:

// This means:

// * Flight 1 → 10 seats
// * Flight 2 → 55 seats
// * Flight 3 → 45 seats
// * Flight 4 → 25 seats
// * Flight 5 → 25 seats

// ---

// ### 🚀 Time Complexity:

// * `O(m + n)` where:

//   * `m` is the number of bookings
//   * `n` is the number of flights

// Much more efficient than a naive O(m×n) approach!

// Let me know if you want a dry run with a custom input.
