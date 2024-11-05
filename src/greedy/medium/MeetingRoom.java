package greedy.medium;

import java.util.*;

/**
 * There is one meeting room in a firm. You are given two arrays, start and end each of size N.
 * For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i]  will denote
 * the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated
 * if only one meeting can happen in the room at a  particular time. Print the order in which
 * these meetings will be performed.
 *
 * Example:
 *
 * Input:  N = 6,  start[] = {1,3,0,5,8,5}, end[] =  {2,4,5,7,9,9}
 *
 * Output: 1 2 4 5
 *
 * https://www.youtube.com/watch?v=mKfhTotEguk
 */
public class MeetingRoom {
    public static void main(String[] args) {
        MeetingRoomSolution obj = new MeetingRoomSolution();
        int n = 6;
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,5,7,9,9};
        obj.getMaxMeetings(start, end, n);
    }
}

class Meeting{
    int start;
    int end;
    int pos;
    Meeting(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting>{

    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end < o2.end)
            return -1;
        else if (o1.end > o2.end)
            return 1;
        else if(o1.pos < o2.pos)
            return -1;
        return 1;
    }
}

class MeetingRoomSolution{

    public void getMaxMeetings(int[] start, int[] end, int n) {
        List<Meeting> meetingList = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++ ){
            meetingList.add(new Meeting(start[i], end[i], i));
        }
        meetingList.sort(new MeetingComparator());
        answer.add(meetingList.get(0).pos);
        int endTime = meetingList.get(0).end;
        for(int i = 1; i < meetingList.size(); i++){
            Meeting meeting = meetingList.get(i);
            if(meeting.start > endTime){
                endTime = meeting.end;
                answer.add(meeting.pos);
            }
        }
        System.out.println("The order in which the meetings will be performed is ");
        for (Integer integer : answer) {
            System.out.print(integer + 1 + " ");
        }

    }
}
