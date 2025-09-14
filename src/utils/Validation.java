package utils;

import controllers.MountainController;

public class Validation {
    private static final String STUDENT_ID = "^(?:SE|HE|DE|QE|CE)\\d{6}$";
    private static final String NAME = "^[A-Za-z].{2,20}$";
    private static final String PHONE_NUMBER = "^(?:0(?:32|33|34|35|36|37|38|39|86|96|97|98|70|76|77|78|79|89|90|93|81|82|83|84|85|88|52|56|58|92|59|99)\\d{7})$";
    private static final String EMAIL = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final MountainController mountainController = new MountainController();


    public static boolean isValid(String arg, String cases) {

        boolean result = false;
        switch (cases) {
            case "student_id":
                arg = arg.toUpperCase();
                result = arg.matches(Validation.STUDENT_ID);
                break;
            case "name":
                result = arg.matches(Validation.NAME);
                break;
            case "phone":
                result = arg.matches(Validation.PHONE_NUMBER);
                break;
            case "email":
                result = arg.matches(Validation.EMAIL);
                break;
            case "mountain_code":
                mountainController.readMountain();
                result = mountainController.getMountainCode(arg);
                break;
        }
        return result;
    }
}
