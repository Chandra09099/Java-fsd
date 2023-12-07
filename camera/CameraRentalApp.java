package com.camera;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CameraRentalApp {
			
		    private List<camera> cameraList;
		    private double walletAmount;
		    private Scanner scanner;
		    private String username;
		    private String password;

		    public static void main(String[] args) {
		        CameraRentalApp application = new CameraRentalApp();
		        application.setupLogin();
		        application.start();
		    }

		    public CameraRentalApp() {
		        cameraList = new ArrayList<>();
		        walletAmount = 1500.0;
		        scanner = new Scanner(System.in);
		        cameraList.add(new camera("Canon", "EOS 5D Mark IV", 750.0));
		        cameraList.add(new camera("Nikon", "D850", 800.0));
		        cameraList.add(new camera("Sony", "Alpha A7 III", 1000.0));
		        cameraList.add(new camera("Fujifilm", "X-T3", 680.0));
		        cameraList.add(new camera("Panasonic", "Lumix GH5", 1000.0));
		        cameraList.add(new camera("Canon", "EOS 5D Mark IV", 650.0));
		        cameraList.add(new camera("Nikon", "D900", 1100.0));
		        cameraList.add(new camera("Sony", "Alpha A8 II", 1200.0));
		        cameraList.add(new camera("Fujifilm", "X-T3 Red", 680.0));
		        cameraList.add(new camera("Panasonic", "Lumix GH3", 950.0));
		        username = "admin"; // Replace with your desired username
		        password = "password"; // Replace with your desired password
		    }

		    private void updateCameraStatus(int cameraIndex, boolean rented) {
		        if (cameraIndex >= 0 && cameraIndex < cameraList.size()) {
		            camera camera = cameraList.get(cameraIndex);
		            camera.setRented(rented);
		        }
		    }

		    public void setupLogin() {
		        boolean loggedIn = false;
		        int attempts = 3;

		        System.out.println("=========================================");
		        System.out.println("Welcome Camera Rental App");
		        System.out.println("=========================================");

		        while (!loggedIn && attempts > 0) {
		            System.out.println("Login");

		            System.out.print("Enter your username: ");
		            String enteredUsername = scanner.nextLine();

		            System.out.print("Enter your password: ");
		            String enteredPassword = scanner.nextLine();

		            if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
		                loggedIn = true;
		                System.out.println("Login successful!");
		            } else {
		                System.out.println("Login failed. Please try again.");
		                attempts--;
		            }
		        }

		        if (!loggedIn) {
		            System.out.println("Too many login attempts. Exiting the application.");
		            System.exit(1);
		        }
		    }

		    public void start() {
		        boolean exit = false;

		        while (!exit) {
		            displayMainMenu();
		            int choice = scanner.nextInt();
		            scanner.nextLine(); // Consume newline character

		            switch (choice) {
		                case 1:
		                    MyCameras();
		                    break;
		                case 2:
		                    rentCamera();
		                    break;
		                case 3:
		                    ViewAllCameras();
		                    break;
		                case 4:
		                    myWallet();
		                    break;
		                case 5:
		                    exit = true;
		                    break;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }

		        scanner.close();
		        System.out.println("Application closed.");
		    }

			private void displayMainMenu() {
		        System.out.println("Main Menu:");
		        System.out.println("1. My Cameras");
		        System.out.println("2. Rent a Camera");
		        System.out.println("3.View All Cameras");
		        System.out.println("4. My Wallet");
		        System.out.println("5. Exit");
		        System.out.print("Enter your choice: ");
		      }
		        private void MyCameras() {
		    	    while (true) {
		    	        System.out.println("My Cameras:");
		    	        System.out.println("1. Add Camera");
		    	        System.out.println("2. Remove Camera");
		    	        System.out.println("3. View My Cameras");
		    	        System.out.println("4. Go back to the main menu");
		    	        System.out.print("Enter your choice: ");

		    	        String subChoice = scanner.nextLine();

		    	        switch (subChoice) {
		    	            case "1":
		    	                addCamera();
		    	                break;
		    	            case "2":
		    	                removeCamera();
		    	                break;
		    	            case "3":
		    	                viewMyCameras();
		    	                break;
		    	            case "4":
		    	                return; // Go back to the main menu
		    	            default:
		    	                System.out.println("Invalid choice. Please try again.");
		    	                break;
		    	        }
		    	    }
		    	}

		    private void addCamera() {
		        System.out.print("Enter the brand of the camera: ");
		        String brand = scanner.nextLine();
		        System.out.print("Enter the model of the camera: ");
		        String model = scanner.nextLine();
		        System.out.print("Enter the rental amount per day: ");
		        double rentalAmount = scanner.nextDouble();
		        scanner.nextLine(); // Consume newline c-haracter

		        camera camera = new camera(brand, model, rentalAmount);
		        cameraList.add(camera);
		        System.out.println("Camera added successfully!");
		    }

		    private void removeCamera() {
		    	 System.out.println("=============================================================");
		    	 System.out.println("ID   | Brand      | Model           | Rent Per Day  | Status");
		         System.out.println("=============================================================");

		         for (int i = 0; i < cameraList.size(); i++) {
		             camera camera = cameraList.get(i);
		             String status = camera.isRented() ? "Rented" : "Available";
		             System.out.printf("%-4d || %-10s || %-15s || %-16.2f || %s%n", i + 1, camera.getBrand(), camera.getModel(),
		                     camera.getRentalAmountPerDay(), status);
		         }
		        System.out.print("Enter the camera number you want to remove: ");
		        int cameraNumber = scanner.nextInt();
		        scanner.nextLine(); // Consume newline character

		        if (cameraNumber < 1 || cameraNumber > cameraList.size()) {
		            System.out.println("Invalid camera number. Please try again.");
		        } else {
		            camera removedCamera = cameraList.remove(cameraNumber - 1);
		            System.out.println("Camera removed successfully: " + removedCamera.getBrand() + " " + removedCamera.getModel());
		        }
		    }

		   
		    	private void viewMyCameras() {
		    	    System.out.println("My Rented Cameras:");
		    	    System.out.println("==================================================");
		    	    System.out.println("ID   | Brand      | Model           | Rent Per Day");
		    	    System.out.println("==================================================");

		    	    int rentedCameraCount = 0; // Counter for rented cameras

		    	    for (int i = 0; i < cameraList.size(); i++) {
		    	        camera camera = cameraList.get(i);
		    	        if (camera.isRented()) {
		    	            System.out.printf("%-4d || %-10s || %-15s || %-16.2f%n", rentedCameraCount + 1, camera.getBrand(), camera.getModel(), camera.getRentalAmountPerDay());
		    	            rentedCameraCount++;
		    	        }
		    	    }

		    	    if (rentedCameraCount == 0) {
		    	        System.out.println("You haven't rented any cameras.");
		    	    }
		    	    System.out.println();
		    	}

		    private void rentCamera() {
		    	 System.out.println("============================================================");
		    	 System.out.println("ID   | Brand      | Model           | Rent Per Day  | Status");
		         System.out.println("============================================================");

		         for (int i = 0; i < cameraList.size(); i++) {
		             camera camera = cameraList.get(i);
		             String status = camera.isRented() ? "Rented" : "Available";
		             System.out.printf("%-4d || %-10s || %-15s || %-16.2f || %s%n", i + 1, camera.getBrand(), camera.getModel(),
		                     camera.getRentalAmountPerDay(), status);
		         }
		       
		        System.out.print("Enter the camera ID you want to rent: ");
		        int cameraID = scanner.nextInt();
		        scanner.nextLine(); // Consume newline character

		        if (cameraID < 1 || cameraID > cameraList.size()) {
		            System.out.println("Invalid camera ID. Please try again.");
		            return;
		        }

		        camera selectedCamera = cameraList.get(cameraID - 1);

		        if (selectedCamera.isRented()) {
		            System.out.println("This camera is already rented.");
		        } else {
		            if (walletAmount < selectedCamera.getRentalAmountPerDay()) {
		                System.out.println("ERROR:TRANSACTION FAILED DUE TO  INSUFFICIENT AMOUNT.PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET");
		            } else {
		                walletAmount -= selectedCamera.getRentalAmountPerDay();
		                selectedCamera.setRented(true); // Mark the camera as rented

		                // Display the transaction success message
		                System.out.println("Camera rented successfully!");
		                System.out.println(selectedCamera.getBrand() + " " + selectedCamera.getModel() +
		                        " (ID: " + cameraID + ") is now rented.");
		            }
		        }
		        System.out.println();
		    }

		    private void ViewAllCameras() {
				// TODO Auto-generated method stub
		    	System.out.println("View Cameras:");
		    	System.out.println("=============================================================");
		        System.out.println("ID   | Brand      | Model           | Rent Per Day  | Status");
		        System.out.println("=============================================================");

		        for (int i = 0; i < cameraList.size(); i++) {
		            camera camera = cameraList.get(i);
		            String status = camera.isRented() ? "Rented" : "Available";
		            System.out.printf("%-4d || %-10s || %-15s || %-16.2f || %s%n", i + 1, camera.getBrand(), camera.getModel(),
		                    camera.getRentalAmountPerDay(), status);
		        }

		    }
			
		    private void myWallet() {
		    	
		    	    while (true) {
		    	        System.out.println("Wallet Menu:");
		    	        System.out.println("1. Check Wallet Balance");
		    	        System.out.println("2. Deposit Money");
		    	        System.out.println("3. Go back to the previous menu");
		    	        System.out.print("Enter your choice: ");

		    	        int choice = scanner.nextInt();
		    	        scanner.nextLine(); // Consume newline character

		    	        switch (choice) {
		    	            case 1:
		    	                // Display wallet balance
		    	                System.out.println("Wallet Balance: " + walletAmount);
		    	                break;
		    	            case 2:
		    	                // Deposit money
		    	                System.out.print("Enter the amount to deposit: ");
		    	                double depositAmount = scanner.nextDouble();
		    	                scanner.nextLine(); // Consume newline character
		    	                if (depositAmount >= 0) {
		    	                    walletAmount += depositAmount;
		    	                    System.out.println("Deposited " + depositAmount + " into your wallet.");
		    	                } else {
		    	                    System.out.println("Invalid deposit amount. Please enter a non-negative value.");
		    	                }
		    	                break;
		    	            case 3:
		    	                // Go back to the previous menu
		    	                return;
		    	            default:
		    	                System.out.println("Invalid choice. Please try again.");
		    	                break;
		    	        }
		    	    }
		    
		

	}

}
