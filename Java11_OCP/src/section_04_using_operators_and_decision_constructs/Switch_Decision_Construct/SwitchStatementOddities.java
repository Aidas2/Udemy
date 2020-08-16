package section_04_using_operators_and_decision_constructs.Switch_Decision_Construct;
/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 4: Using Operators and Decision Constructs
Topic: Switch Statements
Sub-Topic: Out of Ordinary
*/

public class SwitchStatementOddities {
    public static void main(String[] args) {
        byte[] bytes = {100, 103, 104, 107, 126};
        String caseAssignedValue = "";

        start_for:
        for (var i : bytes) {   // Using LVTI here
            switch (i) {
                case 100:
                case 103:
                case 104:
                    break;
                case 107:
                    caseAssignedValue = "Less than 110";
                    break start_for;
                case 126:
                    caseAssignedValue = "Equal to 126";
                    break;
            }
            System.out.println("Done processing " + i +
                    ", caseAssignedValue = " + caseAssignedValue);
        }
    }
}