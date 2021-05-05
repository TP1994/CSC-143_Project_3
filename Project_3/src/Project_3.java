import com.sun.tools.javac.Main;

import java.util.*;

public class Project_3 {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            // Prompt user to enter the number of computers
            System.out.println("Enter the number of computers to be checked : ");
            int noOfComputers = sc.nextInt();
            if(noOfComputers < 1) { // Validation
                System.out.println("Do not enter 0 !");
            } else {
                for(int computer = 0; computer<noOfComputers; computer++) {
                    System.out.println("Computer Hardware Graphics Quality Recommendation Tool");
                    // Get the GPU clock speed from user
                    System.out.println("Enter the GPU clock speed(800 - 2000 MHz) : ");
                    int gpuClockSpeed = sc.nextInt();
                    if(gpuClockSpeed < 800 || gpuClockSpeed >2000) {
                        System.out.println("Enter GPU Clock Speed between 800 and 2000. ");
                    } else {
                        // Get the CPU clock speed from user
                        System.out.println("Enter the CPU clock speed(1000 - 5500 MHz) : ");
                        int cpuClockSpeed = sc.nextInt();
                        if(cpuClockSpeed < 1000 || cpuClockSpeed >5500) {
                            System.out.println("Enter CPU Clock Speed between 1000 and 5500. ");
                        } else {
                            // Get the number of cores from user
                            System.out.println("Enter the number of cores(1 - 16) : ");
                            int cores = sc.nextInt();
                            if(cores < 1 || cores > 16){
                                System.out.println("Enter the number of cores between 1 and 16 ");
                            } else {
                                // Get the resolution number
                                System.out.println("Enter the Monitor Resolution number. ");
                                System.out.println("1. 1280 X 720 \n 2. 1920 X 1080\n3. 2560 X 1440\n4. 3840 X 2160");
                                int resolutionNo = sc.nextInt();
                                if(resolutionNo <1 || resolutionNo > 4){
                                    System.out.println("Enter the menu number between 1 and 4");
                                } else {
                                    Project_3.displayTitle(); // Display the title
                                    String resolution = Project_3.getResolutionString(resolutionNo); // Get the resolution in String
                                    double multiplierValue = Project_3.getMultiplierValue(resolutionNo); // Get the multiplier value
                                    // calculate the performance score
                                    int performanceScore = Project_3.calculatePerformanceScore(gpuClockSpeed,cpuClockSpeed,cores,multiplierValue);
                                    String quality = Project_3.getRecommendedQuality(performanceScore); // Get the recommended quality
                                    // display the information
                                    Project_3.displayInformation(gpuClockSpeed,cpuClockSpeed,cores,resolution,performanceScore,quality);
                                }}}}}}}
        public static void displayTitle() {
            String title = new String("Computer Hardware Graphics Quality Recommendation Tool");
            System.out.println(title);
        }
        // Return resolution based on the menu number
        public static String getResolutionString(int resolutionNo) {
            if(resolutionNo == 1) {
                return "1280 X 720";
            } else if(resolutionNo == 2){
                return "1920 X 1080";
            } else if(resolutionNo == 3){
                return "2560 X 1440";
            } else {return "3840 X 2160";}
        }
        // Return the multiplier value based on the menu number
        public static double getMultiplierValue(int number) {
            if(number == 1) {
                return 1;
            } else if(number == 2){
                return 0.75;
            } else if(number == 3){
                return 0.55;
            } else {return 0.35;}
        }
        // Calculate the performance score based on the user input
        public static int calculatePerformanceScore(int gpuClockSpeed,int cpuClockSpeed,int cores,double multiplierValue){
            return (int)(((5*gpuClockSpeed)+(cores*cpuClockSpeed))*multiplierValue);
        }
        // Find the recommended quality using the performance score
        public static String getRecommendedQuality(int performanceScore) {
            if(performanceScore > 17000) {
                return "Ultra";
            } else if(performanceScore >15000) {
                return "High";
            } else if(performanceScore > 13000) {
                return "Medium";
            } else if(performanceScore > 11000) {
                return "Low";
            } else {return "Unable to Play";}
        }
        // display the found information
        public static void displayInformation(int gpuClockSpeed, int cpuClockSpeed, int cores,String resolution, int performanceScore,String quality) {
            System.out.println("The GPU clock speed : " + gpuClockSpeed +
                    "\nThe CPU clock Speed : " + cpuClockSpeed +
                    "\nThe number of Cores : " + cores +
                    "\nThe Monitor Resolution : " + resolution +
                    "\nThe PerformanceScore : " + performanceScore +
                    "\nRecommended Graphics Quality : " + quality);   }
}

