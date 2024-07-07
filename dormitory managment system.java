
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

abstract public class DMS {
    String id;
    String fName;
    String lName;
    String gender;
    String phoneNumber;
    int blockNumber;
    final String studFilePath;
    final String newStudFilePath;
    final String proFilePath;
    final int proPassword;
    final String proName;
    final int studPassword;
    final String studName;
    final boolean append_value;


    public void setId(String id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public DMS() {
        this.studFilePath = "STUDDMS.txt";
        this.newStudFilePath = "NEWSTUDDMS.txt";
        this.proFilePath = "PRODMS.txt";
        this.proPassword = 1234;
        this.proName = "pppp";
        this.studPassword = 1234;
        this.studName = "ssss";
        this.append_value = true;
    }

    public static void main(String[] args) throws IOException {

        mainMenu();


    }

    public static void mainMenu() throws IOException{
            Proctor pro1 = new Proctor();
            Student std1 = new Student();
            Scanner scr = new Scanner(System.in);
            int n = 1;



            do {
                System.out.println("****************");
                System.out.println("  a. Proctor");
                System.out.println("  b. Student");
                System.out.println("  c. Exit");
                System.out.println("****************");

                String choice = scr.nextLine();

                switch (choice) {
                    case "a":
                        do {
                            System.out.println("Please enter Username:");//USER NAME:pppp
                            String name = (scr.next());
                            System.out.println("Please enter password:");//PASSWORD:1234
                            int password = (scr.nextInt());

                            if (name.compareTo(pro1.proName) == 0 && password == pro1.proPassword)
                                pro1.proMenu();
                            else {
                                n = 0;
                                System.out.println(" You have inserted Incorrect password or user name!");
                            }
                        }while (n == 0);

                        break;
                    case "b":

                        do {
                            System.out.println("Please enter Username:"); //USER NAME:ssss
                            String name = (scr.next());
                            System.out.println("Please enter password:");//PASSWORD:1234
                            int password = (scr.nextInt());

                            if (name.compareTo(pro1.studName) == 0 && password == pro1.studPassword)
                                std1.stdMenu();
                            else {
                                n = 0;
                                System.out.println("Incorrect password or username!");
                            }
                        }while (n == 0);
                        std1.stdMenu();
                        break;
                    case "c":
                        System.exit(0);
                    default:
                        System.out.println("Invalid entry");
                }
            }while (true);

        }

    }
    class Proctor extends DMS {

    int officeNumber;

    public void setOfficeNumber(int officeNumber) {
        this.officeNumber = officeNumber;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }

    public void proMenu() throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\ta. Get Student Information");
        System.out.println("\tb. Show Student Information");
        System.out.println("\tc. Check particular Student Information");
        System.out.println("\td. Update Student Information");
        System.out.println("\te. Delete Student Information");
        System.out.println("\tf. Enter Proctor Information");
        System.out.println("\tg. Goto Main Menu");
        System.out.println("\to. Exit\n");
        System.out.print(">> ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "a":
                getStudentInfo();
                break;
            case "b":
                showAllStudentInfo();
                break;
            case "c":
                checkParticularStud();
                break;
            case "d":
                updateStudentInfo();
                break;
            case "e":
                deleteStudentInfo();
                break;
            case "f":
                enterProctorInfo();
                break;
            case "g":
                mainMenu();
                break;
            case "o":
                System.exit(0);
                break;
            default:
                System.out.println("Dear Proctor Please enter a valid choice!!!");
        }
    }

    public void getStudentInfo() throws IOException {

        Student std = new Student();
        FileWriter write = new FileWriter(studFilePath, append_value);
        PrintWriter textPrinter = new PrintWriter(write);
        Scanner scr = new Scanner(System.in);

        System.out.println("ID:");
        std.setId(scr.nextLine());

        System.out.println("First name:");
        std.setfName(scr.nextLine());

        System.out.println("Last name:");
        std.setlName(scr.nextLine());

        System.out.println("Gender:");
        std.setGender(scr.nextLine());

        System.out.println("Date of birth:");
        std.setDob(scr.nextLine());

        System.out.println("Department:");
        std.setDepartment(scr.nextLine());

        System.out.println("Phone number:");
        std.setPhoneNumber(scr.nextLine());

        System.out.println("Dorm number:");
        std.setDormNumber(scr.nextInt());

        System.out.println("Block number:");
        std.setBlockNumber( scr.nextInt());

        System.out.println("Batch:");
        std.setBatch(scr.nextInt());

        textPrinter.println(std.getId());
        textPrinter.println(std.getfName());
        textPrinter.println(std.getlName());
        textPrinter.println(std.getGender());
        textPrinter.println(std.getDob());
        textPrinter.println(std.getDepartment());
        textPrinter.println(std.getBatch());
        textPrinter.println(std.getPhoneNumber());
        textPrinter.println(std.getDormNumber());
        textPrinter.println(std.getBlockNumber());

        textPrinter.close();
        System.out.println("press \n1. to add more:\n2. to goto menu:\n0. to leave:");
        int choice = scr.nextInt();
        if (choice == 1)
            getStudentInfo();
        else if (choice == 2)
            proMenu();
        else
            System.exit(0);

    }

    public  void showAllStudentInfo() throws IOException {

        Student std2 = new Student();
        Scanner scr = new Scanner(System.in);
        File file = new File(studFilePath);

        if (!file.exists())
            System.out.println("Error! couldn't open the file.");
        else {
            FileReader read = new FileReader(studFilePath);
            BufferedReader textReader = new BufferedReader(read);

            int numberOfLine = std2.lineCounter(studFilePath);
            String[] arr = new String[numberOfLine];

            for (int i = 0; i < numberOfLine; i++)
                arr[i] = textReader.readLine();

            textReader.close();
            System.out.println("_____________________________________________________________________________________________________________________________");
            System.out.println("ID\t\tFIRST_NAME\t LAST_NAME\t GENDER\t\t\t\tDOB\t\t   DEPARTMENT\t  BATCH\t\t    PHONE\t\t  DORM_NO.\tBLOCK_NO.");
            System.out.println("_____________________________________________________________________________________________________________________________");
            for (int i = 0; i < numberOfLine; i += 10) {
                for (int j = i; j < i + 10; j++) {
                    System.out.print(arr[j] + "\t\t\t");
                }
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
            }

        }

        System.out.println("press \n1. to goto  menu:\n0. to leave:");
        int choice = scr.nextInt();

         if (choice == 1)
            proMenu();
        else
            System.exit(0);

    }

    public  void checkParticularStud() throws IOException {

        Student std3 = new Student();
        Scanner scr = new Scanner(System.in);
        File file = new File(studFilePath);

        if (!file.exists())
            System.out.println("Error! couldn't open the file.");
        else {

            FileReader read = new FileReader(studFilePath);
            BufferedReader text_reader = new BufferedReader(read);

            int numberOfLine = std3.lineCounter(studFilePath);
            String[] arr = new String[numberOfLine];

            for (int i = 0; i < numberOfLine; i++)
                arr[i] = text_reader.readLine();

            text_reader.close();

            System.out.print("Enter ID:");
            std3.setId(scr.nextLine());

            int index = std3.studIdChecker();

            if (index != -1) {

                System.out.println("\nFound!!\n\n\tHere is the detail:");
                System.out.println("_____________________________________________________________________________________________________________________________");
                System.out.println("ID\t\tFIRST_NAME\t LAST_NAME\t GENDER\t\t\t\tDOB\t\t   DEPARTMENT\t  BATCH\t\t    PHONE\t\t  DORM_NO.\tBLOCK_NO.");
                System.out.println("_____________________________________________________________________________________________________________________________");
                for (int i = index; i < index + 10; i++)
                    System.out.print(arr[i] + "\t\t\t");
                System.out.println();
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");

            } else
                System.out.println("Not Found!");

        }

        System.out.println("press \n1. to goto main menu:\n0. to leave:");
        int choice = scr.nextInt();

        if (choice == 1)
            proMenu();
        else
            System.exit(0);

    }

    public  void updateStudentInfo() throws IOException {

        Student std4 = new Student();
        Scanner scr = new Scanner(System.in);
        File file = new File(studFilePath);

        if (!file.exists())
            System.out.println("Error! couldn't open the file.");
        else {

            FileWriter write = new FileWriter(newStudFilePath, append_value);
            PrintWriter textPrinter = new PrintWriter(write);
            FileReader read = new FileReader(studFilePath);
            BufferedReader textReader = new BufferedReader(read);

            int numberOfLine = std4.lineCounter(studFilePath);
            String[] arr = new String[numberOfLine];
            String[] newArr = new String[numberOfLine];

            for (int i = 0; i < numberOfLine; i++)
                arr[i] = textReader.readLine();

            textReader.close();

            System.out.println("Enter ID:");

            std4.setId(scr.nextLine());

            int index = std4.studIdChecker();

            int i = 0;
            if (index == -1)
                System.out.println("Student not found!");
            else {
                while (i < numberOfLine) {
                    if (index != i) {
                        newArr[i] = arr[i];
                        i++;
                    }
                    else {
                        System.out.println("id:");
                        newArr[i] = scr.nextLine();

                        System.out.println("First name:");
                        newArr[i + 1] = scr.nextLine();// we made  it i+1 because we update from the index where the id is found

                        System.out.println("Last name:");
                        newArr[i + 2] = scr.nextLine();

                        System.out.println("Gender:");
                        newArr[i + 3] = scr.nextLine();

                        System.out.println("Date of birth:");
                        newArr[i + 4] = scr.nextLine();

                        System.out.println("Department:");
                        newArr[i + 5] = scr.nextLine();

                        System.out.println("Batch:");
                        newArr[i + 6] = scr.nextLine();

                        System.out.println("Phone number:");
                        newArr[i + 7] = scr.nextLine();

                        System.out.println("Dorm number:");
                        newArr[i + 8] = scr.nextLine();

                        System.out.println("Block number:");
                        newArr[i + 9] = scr.nextLine();
                        i += 10;//to jump to next student file
                    }

                }

                for (i = 0; i < numberOfLine; i++)
                    textPrinter.println(newArr[i]);

                System.out.println("Student information is updated successfully!!!");
            }


            textPrinter.close();

            Path source = Paths.get("NEWSTUDDMS.txt");
            Files.move(source, source.resolveSibling("STUDDMS.txt"), StandardCopyOption.REPLACE_EXISTING);

        }
        System.out.println("press \n1. to goto main menu:\n0. to leave:");
        int choice = scr.nextInt();

        if (choice == 1)
            proMenu();
        else
            System.exit(0);

    }

    public  void deleteStudentInfo() throws IOException {

        Student std5 = new Student();
        Scanner scr = new Scanner(System.in);
        File file = new File(studFilePath);

        if (!file.exists())
            System.out.println("Error! couldn't open the file.");
        else {

            FileWriter write = new FileWriter(newStudFilePath, append_value);
            PrintWriter textPrinter = new PrintWriter(write);
            FileReader read = new FileReader(studFilePath);
            BufferedReader textReader = new BufferedReader(read);

            int numberOfLine = std5.lineCounter(studFilePath);
            String[] arr = new String[numberOfLine];
            String[] newArr = new String[numberOfLine];

            for (int i = 0; i < numberOfLine; i++)
                arr[i] = textReader.readLine();

            textReader.close();

            System.out.println("Enter ID:");

            std5.setId(scr.nextLine());

            int index = std5.studIdChecker();
            int i = 0;
            int j = 0;

            if (index == -1)
                System.out.println("Student not found!");
            else {
                while (i < numberOfLine && j < numberOfLine - 10) {
                    if (index != i) {
                        newArr[j] = arr[i];

                        i++;
                        j++;
                    } else
                        i += 10;
                }
                for (i = 0; i < numberOfLine - 10; i++)
                    textPrinter.println(newArr[i]);

                textPrinter.close();
                textReader.close();
                Path source = Paths.get("NEWSTUDDMS.txt");
                Files.move(source, source.resolveSibling("STUDDMS.txt"), StandardCopyOption.REPLACE_EXISTING);

                System.out.println("Student information is deleted successfully!!!");
            }

        }
        System.out.println("press \n1. to goto main menu:\n0. to leave:");
        int choice = scr.nextInt();

        if (choice == 1)
            proMenu();
        else
            System.exit(0);

    }

    public  void enterProctorInfo() throws IOException {

        Student std = new Student();
        Proctor pro = new Proctor();
        FileWriter write = new FileWriter(proFilePath, append_value);
        PrintWriter textPrinter = new PrintWriter(write);
        Scanner scr = new Scanner(System.in);

        System.out.println("Proctor ID:");
        std.setId(scr.nextLine());

        System.out.println("First name:");
        std.setfName(scr.nextLine());

        System.out.println("Last name:");
        std.setlName(scr.nextLine());

        System.out.println("Gender:");
        std.setGender(scr.nextLine());

        System.out.println("Phone number:");
        std.setPhoneNumber(scr.nextLine());


        System.out.println("Block number:");
        std.setBlockNumber( scr.nextInt());

        System.out.println("Office Number:");
        pro.setOfficeNumber(scr.nextInt());

        textPrinter.println(std.getId());
        textPrinter.println(std.getfName());
        textPrinter.println(std.getlName());
        textPrinter.println(std.getGender());
        textPrinter.println(std.getPhoneNumber());
        textPrinter.println(std.getBlockNumber());
        textPrinter.println(pro.getOfficeNumber());



        textPrinter.close();
        System.out.println("press \n1. to goto main menu:\n0. to leave:");
        int choice = scr.nextInt();

        if (choice == 1)
            proMenu();
        else
            System.exit(0);
    }

    public  int proChecker() throws IOException {

        Student std = new Student();
        FileReader read = new FileReader(proFilePath);
        BufferedReader textReader = new BufferedReader(read);

        int numberOfLine = std.lineCounter(proFilePath);
        String[] arr = new String[numberOfLine];
        int index = -1;//to return -1 if id not found    ,index starts from 0
        for (int i = 0; i < numberOfLine; i++)
            arr[i] = textReader.readLine();

        textReader.close();    //if we dont close our file the file is used by another program     mil error ymetal

        for (int i = 5; i < numberOfLine; i += 7) {// we assigned i as +=10 because we find id every 10th interval
            if ((arr[i]).compareTo(String.valueOf(getBlockNumber())) == 0) {
                index = i;
            }
        }

        return index;
    }
}

class Student extends DMS {

    int dormNumber;
    String dob;
    int batch;
    String department;



    public void setDormNumber(int dormNumber) {
        this.dormNumber = dormNumber;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDormNumber() {
        return dormNumber;
    }

    public String getDob() {
        return dob;
    }

    public int getBatch() {
        return batch;
    }

    public String getDepartment() {
        return department;
    }

    public  int lineCounter(String filePath) throws IOException {

        FileReader read = new FileReader(filePath);
        BufferedReader bfr = new BufferedReader(read);

        int counter = 0;
        while (bfr.readLine() != null)
            counter++;

        bfr.close();
        return counter;
    }

    public  int studIdChecker() throws IOException {

        FileReader read = new FileReader(studFilePath);
        BufferedReader textReader = new BufferedReader(read);

        int index = -1;
        int numberOfLine = lineCounter(studFilePath);
        String[] arr = new String[numberOfLine];

        for (int i = 0; i < numberOfLine; i++)
            arr[i] = textReader.readLine();

        textReader.close();

        for (int i = 0; i < numberOfLine; i += 10) {

            if (getId().compareTo(arr[i]) == 0)
                index = i;
        }

        return index;
    }

    public void displayProctorInformation() throws IOException {

        Proctor pro2 = new Proctor();
        File file = new File(proFilePath);

        if (!file.exists())
            System.out.println("Error! couldn't open the file.");
        else {
            Scanner scr = new Scanner(System.in);
            FileReader read = new FileReader(proFilePath);
            BufferedReader textReader = new BufferedReader(read);

            int numberOfLine = lineCounter(proFilePath);
            String[] arr = new String[numberOfLine];

            for (int i = 0; i < numberOfLine; i++)
                arr[i] = textReader.readLine();

            textReader.close();

            System.out.println("Enter Block No:");
            pro2.setBlockNumber(scr.nextInt());
            int index = pro2.proChecker();

            if (index == -1)
                System.out.println("Not found.");
            else {

                System.out.println("______________________________________________________________________");
                System.out.println("FIRST_NAME\tLAST_NAME  GENDER\t   PHONE\t    BLOCK_NO.\tOFFICE_NO.");
                System.out.println("______________________________________________________________________");
                for (int i = numberOfLine - 1; i >= 0; i--) {
                    if (arr[i].compareTo(String.valueOf(pro2.getBlockNumber())) == 0) {
                        for (int j = i - 4; j < i + 2; j++)
                            System.out.print(arr[j] + "\t\t\t");
                        System.out.println();
                        System.out.println("----------------------------------------------------------------------");
                    }
                }
            }
        }
        stdMenu();
    }

    public void  displayDormmates() throws IOException {

        Student std6 = new Student();
        File file = new File(studFilePath);

        if (!file.exists())
            System.out.println("Error! couldn't open the file.");

        String dormFilePath = "DormFile.txt";
        String newDormFilePath = "NewDormFile.txt";
        Scanner scr = new Scanner(System.in);
        FileWriter write = new FileWriter(dormFilePath, append_value);
        PrintWriter print = new PrintWriter(write);
        FileReader read = new FileReader(studFilePath);
        BufferedReader textReader = new BufferedReader(read);
        FileReader read2 = new FileReader(dormFilePath);
        BufferedReader textReader2 = new BufferedReader(read2);
        FileWriter write2 = new FileWriter(newDormFilePath, append_value);
        PrintWriter print2 = new PrintWriter(write2);

        int numberOfLine = lineCounter(studFilePath);
        String[] arr = new String[numberOfLine];

        for (int i = 0; i < numberOfLine; i++)
            arr[i] = textReader.readLine();

        textReader.close();

        System.out.println("Enter ID:");
        std6.setId(scr.nextLine());

        int index = std6.studIdChecker();// we can know the id of the student to be updated by index
        if (index == -1)
            System.out.println("Student not found!");
        else {
            System.out.println("Enter block_no.:");
            std6.setBlockNumber(scr.nextInt());

            System.out.println("Enter dorm_no.:");
            std6.setDormNumber(scr.nextInt());
            for (int i = 8; i < numberOfLine; i += 10) {
                if (arr[i].compareTo(String.valueOf(std6.getDormNumber())) == 0 && arr[i + 1].compareTo(String.valueOf(std6.getBlockNumber())) == 0) {

                    print.println(arr[i - 7]);
                    print.println(arr[i - 6]);
                    print.println(arr[i - 1]);
                }
            }

            print.close();

            numberOfLine = lineCounter(dormFilePath);

            String[] arr2 = new String[numberOfLine];

            for (int i = 0; i < numberOfLine; i++)
                arr2[i] = textReader2.readLine();

            textReader2.close();
            System.out.println("______________________________________");
            System.out.println("FIRST_NAME\t  LAST_NAME\t     PHONE_NO.");
            System.out.println("______________________________________");
            for (int i = 0; i < numberOfLine; i += 3) {
                for (int j = i; j < i + 3; j++) {
                    System.out.print(arr2[j] + "\t\t\t\t");
                }

                System.out.println();
                System.out.println("--------------------------------------");
            }
            textReader.close();
            print2.close();
            textReader2.close();
            print.close();
            read.close();
            read2.close();
            Path source = Paths.get(newDormFilePath);
            Files.move(source, source.resolveSibling(dormFilePath), StandardCopyOption.REPLACE_EXISTING);
        }
        stdMenu();
    }

    public void stdMenu () throws IOException {

        Scanner scr = new Scanner(System.in);
        System.out.println("\ta.Display Proctor Information");
        System.out.println("\tb.Display Dormmates");
        System.out.println("\tc.Goto Main Menu");
        System.out.println("\to. Exit\n");
        System.out.print(">> ");
        String ch1 = scr.nextLine();
        switch (ch1) {

            case "a":
                displayProctorInformation();
                break;
            case "b":
                displayDormmates();
                break;
            case "c":
                mainMenu();
                break;
            case "o":
                System.exit(0);
                break;
            default:
                System.out.println("Dear Student Please Enter valid choice!!!");
        }
    }
}
