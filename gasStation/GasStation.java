package gasStation;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * @author Mengchao Zhong
 */
public class GasStation {

	/**
	 * Test case.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] gas = {1, 2, 3, 4, 5, 6};
		int[] cost = {3, 4, 5, 6, 1, 2};
		System.out.println(canCompleteCircuit(gas, cost));
	}

	/**
	 * Solution.
	 * @param gas
	 * @param cost
	 * @return
	 */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 1) {
        	return gas[0] >= cost[0] ? 0 : -1;
        }
    	int forward = 0;
        int backward = gas.length - 1;
        int total = 0;
        while(forward <= backward) {
        	total += (gas[forward] - cost[forward]);
        	if(total >= 0) {
        		++forward;
        		continue;
        	}
        	else {
        		while(backward > forward && total < 0) {
        			total += (gas[backward] - cost[backward]);
        			--backward;
        		}
        		++forward;
        	}
        }
		return total >= 0 ? backward + 1 : -1;
    }
}
