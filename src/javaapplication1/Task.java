package javaapplication1;

public class Task 
{
 String[] tskName;
    int tskNumber;
    String[] tskDescription;
    String[] developDetails;
    int[] tskDuration;
    String[] tskID;
    String[] tskStatus;
    
    public Task(int numberOfTask)
    {
        tskName = new String[numberOfTask];
        tskNumber = 0;
        tskDescription = new String[numberOfTask];
        developDetails = new String[numberOfTask];
        tskDuration = new int[numberOfTask];
        tskID = new String[numberOfTask];
        tskStatus = new String[numberOfTask];       
    }
    
    public boolean checkTaskDescription(String description)
    {
         return (description.length() <= 50);                
    }
    public String creareTaskID(int taskNumber)
    {
        tskID[taskNumber] = tskName[taskNumber].substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developDetails[taskNumber].substring(developDetails[taskNumber].length() - 3).toUpperCase(); 
        return tskID[taskNumber];
    }
    public void printTaskDeatils(int TotalTasks)
    {
        System.out.print("\n\nTasks saved so far....\n");
        System.out.print("\n\ttaskID\ttaskName\tDuration\tStatus\tDescription\tDeveloper\n");
        for(int a = 0; a < TotalTasks; a++)
        {
            System.out.print("\n" + (a+1) + ".\t" + tskID[a] + "\t" + tskName[a] + "\t" + tskDuration[a] + "\t" + tskStatus[a] + "\t" + tskDescription[a] + "\t" + developDetails[a]);            
        }
        System.out.print("\n\nTotal tasks duration : " + returnTotalhours(TotalTasks) + "\n\n");
    }
    
    public int returnTotalhours(int TotalTasks)
    { 
        int totalHours = 0;
        for(int a = 0; a < TotalTasks;a++)
            totalHours = totalHours + tskDuration[a];        
        return totalHours;
    }
       
}
