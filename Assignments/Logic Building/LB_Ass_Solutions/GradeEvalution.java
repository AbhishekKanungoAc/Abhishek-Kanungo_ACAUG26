class GradeEvalution{
    public static void main(String[] args) {
        int Maths = 20;
        int Science = 85;
        int History = 10;
        int AvgMarks = (Maths+Science+History)/3;
        System.out.println(AvgMarks);
        if (AvgMarks>= 90) {
            System.out.println("Grade A");
        } else if (89 <= AvgMarks && AvgMarks >= 70) {
            System.out.println("Grade B");
        } else if (69 <= AvgMarks && AvgMarks >= 50) {
            System.out.println("Grade C");
        } else if (49 <= AvgMarks && AvgMarks >= 30) {
            System.out.println("Grade D");
        } else{
            System.out.println("Fail");
        }

        
    }
}