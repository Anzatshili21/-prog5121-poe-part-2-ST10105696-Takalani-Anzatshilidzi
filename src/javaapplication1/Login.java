package javaapplication1;
import java.util.Scanner; 
public class Login 
{
  public String UserName = "";
    public String PassWord ="";
    boolean CheckUserName(String UN)
    {
        Scanner scan = new Scanner (System.in);
        String Username;
        System.out.println("Enter user name : ");
        Username = scan.next();
        if (UN.length() <=5 && UN.contains("-"))
        {
            System.out.println("");
            return false;
        }
        else
        {
            System.out.println("");
        return true;
        }
        
    }
    boolean CheckPasswordComplexity(String Pword)
    {
     boolean PassWordPassed;
        PassWordPassed = false;
        boolean Condition1;
        Condition1 = false;
        boolean Condition2;
        Condition2 = false;
        boolean Condition3;
        Condition3 = false;
        boolean Condition4;
        Condition4 = false;
        
        if(Pword.length() <= 8)
        {   
            Condition1 = true;
        }
        char[] alphabets = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for(int a = 0; a < Pword.length(); a++)
        {
            for(int b = 0; b < 26; b++)
            {
                if(Pword.charAt(a) == alphabets[b])
                {
                    Condition2 = true;
                    b=28;
                    a = Pword.length()+2;
                }
            }
        }
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        for(int a = 0; a < Pword.length(); a++)
        {
            for(int b = 0; b < 10; b++)
            {
                if(Pword.charAt(a) == numbers[b])
                {
                   Condition3 = true;
                }
            }
        }
         char[] SpecialChar = {'#','~','!','@','$','%','^','&','*','(',')','_','-','+','{','[','}',']','|','?',',','.','/'};
         for(int a = 0; a < Pword.length(); a++)
         {
             for(int b = 0; b < 23; b++)
             {
                 if(Pword.charAt(a) == SpecialChar[b])
                 {
                     Condition4 = true;
                 }
             }
         }
        if(Condition1==true && Condition2==true && Condition3==true && Condition4==true)
        {
            PassWordPassed = true;
        }
        return PassWordPassed;
    }
    boolean LoginUser()
    {
       boolean LoginSuccess = false;
        
        
        return LoginSuccess; 
    }  
    
        public static void main(String[] args) 
        {
        Scanner scan = new Scanner(System.in);
        int numberOfTasks;
        
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
    String RegisterUser()
    {
        Scanner scan = new Scanner(System.in);
        
        String FirstName;
        String LastName;
        
        System.out.print("\n\n\t\tRegistration\n\n");
          
        System.out.print("Enter your first name : ");
        FirstName = scan.next();
        System.out.print("Enter your last name : ");
        LastName = scan.next();
        
        while(!CheckUserName(UserName))
        {
            System.out.print("Enter user name : ");
            UserName = scan.next();        
        }
        while(!CheckPasswordComplexity(PassWord))
        {
            System.out.print("Enter your desired password : ");
            PassWord = scan.next();        
        }
        
        
        return "\n\n\t\tUser Successfully registered!!\n\n";
    }
    String ReturnLoginStatus(boolean Status)
    {
        String ReturnStatus = "";
        if(true)
        {
            ReturnStatus = "You have successfully logged in to the system!";
        }
        else
        {
            ReturnStatus = "Login failed!!!";
        }
        
        return ReturnStatus;
    }
}
    

