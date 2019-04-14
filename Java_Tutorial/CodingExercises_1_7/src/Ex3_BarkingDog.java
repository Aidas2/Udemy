public class Ex3_BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOFDay) {

        if (hourOFDay < 0 || hourOFDay > 23) {
            return false;
        } else if ((hourOFDay < 8 || hourOFDay > 22) && barking == true) {
            return true;
        } else {
            return false;
        }
    }
}
