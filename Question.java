 
public class Question {
   private String question;
   private String firstAnswer;
   private String secondAnswer;
   private String thirdAnswer;
   private String fourthAnswer;
   private String correctAnswer;
   
   public Question(String question, String firstAnswer, String secondAnswer, String thirdAnswer, String fourthAnswer,
           String correctAnswer) {
       super(); 
       this.question = question;
       this.firstAnswer = firstAnswer;
       this.secondAnswer = secondAnswer;
       this.thirdAnswer = thirdAnswer;
       this.fourthAnswer = fourthAnswer;
       this.correctAnswer = correctAnswer;
   }

   // getter and setter
   public String getQuestion() {
       return question;
   }

   public void setQuestion(String question) {
       this.question = question;
   }

   public String getFirstAnswer() {
       return firstAnswer;
   }

   public void setFirstAnswer(String firstAnswer) {
       this.firstAnswer = firstAnswer;
   }

   public String getSecondAnswer() {
       return secondAnswer;
   }

   public void setSecondAnswer(String secondAnswer) {
       this.secondAnswer = secondAnswer;
   }

   public String getThirdAnswer() {
       return thirdAnswer;
   }

   public void setThirdAnswer(String thirdAnswer) {
       this.thirdAnswer = thirdAnswer;
   }

   public String getFourthAnswer() {
       return fourthAnswer;
   }

   public void setFourthAnswer(String fourthAnswer) {
       this.fourthAnswer = fourthAnswer;
   }

   public String getCorrectAnswer() {
       return correctAnswer;
   }

   public void setCorrectAnswer(String correctAnswer) {
       this.correctAnswer = correctAnswer;
   }

   // toString method for print the question
   @Override
   public String toString() {
       return question + "\n" + firstAnswer + "\n" + secondAnswer + "\n" + thirdAnswer + "\n" + fourthAnswer;
   }
}
