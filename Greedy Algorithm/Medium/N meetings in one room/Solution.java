//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        MeetingSchedule ms =new MeetingSchedule(start,end, n);
        return ms.getResult();
    }
}
class Meeting{
	 int id;
	 int startTime;
	 int endTime;
	
	Meeting(int id , int startTime , int endTime){
		this.id = id;
		this.startTime =startTime;	
		this.endTime =  endTime;
	}	

	
}

class MeetingComparator implements Comparator<Meeting>{
public int compare (Meeting meeting1, Meeting meeting2){
	if(meeting1.endTime<meeting2.endTime){
		return -1;
	}
	else if (meeting1.endTime>meeting2.endTime){
		return 1;
	}
	else if (meeting1.id<meeting2.id){
		return -1;
	}

	return 1;
}
}



class MeetingSchedule{
	private int [] start;
	private int[] end;
	private int n;
	private List<Meeting> meetings;
	private int count;
	
	MeetingSchedule(int [] start, int [] end, int n){
		this.start = start;
		this.end = end;	
		this.n = n;
		
		if(isValid()){
			this.meetings = new ArrayList<>();
			this.count = 0;
			init();
			findMeetingSequence();
		}
	}
	
	private boolean isValid(){
		return this.start!=null && this.end!=null && this.n!=0 && this.start.length == this.n && this.end.length == this.start.length;
	}
	
	private void init(){
		for(int i=0;i<this.n;i++){
			Meeting entry = new Meeting(i, this.start[i],this.end[i]);
		
			this.meetings.add(entry);
		}	
	}
	
	private void findMeetingSequence(){
		Collections.sort(this.meetings, new MeetingComparator());
		
		count++;
		int limit = this.meetings.get(0).endTime;
		
		for(int i=1;i<this.n;i++){
			if(this.meetings.get(i).startTime> limit){
			    this.count++;
				limit =  this.meetings.get(i).endTime;
			}
		}
	}
	
	public int getResult(){
		return this.count;
	}
	
}
