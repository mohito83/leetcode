package src.main.java;

class DetectCapitals {
    public static boolean detectCapitalUse(String word) {
        boolean isCorrectUsage = false;
        int upperCaseCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                upperCaseCount++;
            }
        }
        
        if (upperCaseCount == 0 || upperCaseCount == word.length() || (upperCaseCount == 1 && Character.isUpperCase(word.charAt(0)))) {
            isCorrectUsage = true;
        }
        
        
        return isCorrectUsage;
    }

    public static void main(String[] args) {
        System.out.println("Is capital usage correct? " + detectCapitalUse("floG"));
    }

}
