package views;

import utils.Input;

public class Main {
    public static void main(String[] args) {
        int options;
        boolean cont = true;
        boolean isSave = false;
        UserView userView = new UserView();
        userView.init();

        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                "1. Create New Student\n" +
                "2. Update Information\n" +
                "3. Display Registered\n" +
                "4. Delete Information\n" +
                "5. Search Student By Name\n" +
                "6. Filter Data By Campus\n" +
                "7. Statistics of Registration Numbers by Location\n" +
                "8. Save Data to File\n" +
                "9. Exit\n"
            );

            options = Input.getInt("Enter option: ");
            switch (options) {
                case 1:
                    if(userView.create()) {
                        System.out.println("Successfully create user");
                    } else {
                        System.out.println("Failed to create user");
                    }
                    Input.promptEnterKey();
                    break;
                case 2:
                    if(userView.update()) {
                        System.out.println("Successfully update user");
                    } else {
                        System.out.println("Failed to update user");
                    }
                    Input.promptEnterKey();
                    break;
                case 3:
                    if(!userView.getAllUser()) {
                        System.out.println("No students have registered yet.");
                    };
                    Input.promptEnterKey();
                    break;
                case 4:
                    if(userView.delete()) {
                        System.out.println("The registration has been successfully deleted.");
                    } else {
                        System.out.println("This student has not registered yet.");
                    }
                    Input.promptEnterKey();
                    break;
                case 5:
                    if(!userView.getUserByName()) {
                        System.out.println("This student has not registered yet");
                    }
                    Input.promptEnterKey();
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    if(userView.saveData()) {
                        System.out.println("Data saved");
                        isSave = true;
                    } else {
                        System.out.println("Failled to save dat");
                    }
                    Input.promptEnterKey();
                    break;
                case 9:
                    if(Input.confirmYesNo(isSave ? "Are you sure you want to exit? (Y/N)" : "Are you sure you want to exit without saving? (Y/N)")) {
                        cont = false;
                    }
                    break;
                default:
                    System.out.println("This function is not available");
                    break;
            }

        } while(cont);
    }
}
