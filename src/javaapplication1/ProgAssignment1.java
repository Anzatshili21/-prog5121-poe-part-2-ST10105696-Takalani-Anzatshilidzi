/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;
import java.util.Scanner;
public class ProgAssignment1 
{

    public static void main(String[] args) 
    {
        String UserName;
        String PassWord;
        String FirstName;
        String LastName;
        int numberOfTasks;
        boolean LoginStatus = false;
        
        
        Login log = new Login();
        System.out.print(log.RegisterUser());
        
        LoginStatus = log.LoginUser();
        log.ReturnLoginStatus(LoginStatus);
        
        Scanner scan = new Scanner(System.in);
        
        
        System.out.print("Welcome to EasyKanban");
        System.out.print("\n\nHow many tasks do you wish to enter : ");
        numberOfTasks = scan.nextInt();
        if(numberOfTasks > 0)
        {
            Task task1 = new Task(numberOfTasks);
        
            System.out.print("\n\nThank you, You may now start capturing the tasks,\n should you wish to Quit just press 3..");
            for(int a = 0; a < numberOfTasks; a++)
            {
                System.out.print("\n\n1). Add tasks");
                System.out.print("\n2). Show report");
                System.out.print("\n3). Quit\n\nPick and option : ");
            
                int option = scan.nextInt();
                if(option == 1)
                {                  
                    task1.tskNumber = a;
                    System.out.print("Enter this task's name : ");
                    task1.tskName[a] = scan.next();
                    System.out.print("Enter this task's description : ");
                    task1.tskDescription[a] = scan.next();
                    while(!task1.checkTaskDescription(task1.tskDescription[a]))
                    {
                        System.out.print("Description shouldn't be more than 50 characters, Please try again : ");
                        task1.tskDescription[a] = scan.next();                    
                    }                 
                    
                    System.out.print("Enter this task's developer details : ");
                    task1.developDetails[a] = scan.next();
                    System.out.print("Enter this task's duration (in hours) : ");
                    task1.tskDuration[a] = scan.nextInt();
                    System.out.print("Enter this task status, Choose one from the below \n");
                    System.out.print("\n1. To Do");
                    System.out.print("\n2. Done");
                    System.out.print("\n3. Doing");
                    System.out.print("\nenter number before the option of your choice : ");
                    int choice = scan.nextInt();
                    while(choice < 1 || choice > 3)
                    {
                        System.out.print("\nRange is between 1 and 3, please try again : ");
                        choice = scan.nextInt();                    
                    }
                    if(choice == 1)
                        task1.tskStatus[a] = "To Do";
                    if(choice == 2)
                        task1.tskStatus[a] = "Done";
                    if(choice == 3)
                        task1.tskStatus[a] = "Doing";
                    
                    task1.creareTaskID(a);                        
                }
                if(option == 2)
                {
                    task1.printTaskDeatils(a);
                    a--;
                }
                if(option == 3)
                {
                    a = numberOfTasks;
                }            
            }    
        }
         // TODO code application logic here
    }
}