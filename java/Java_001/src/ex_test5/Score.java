package ex_test5;

public class Score {

  private String stuName;
  private int korean;
  private int english;
  private int math;
  private int total;
  private double average;
  private String grade;

  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }

  public int getKorean() {
    return korean;
  }

  public void setKorean(int korean) {
    this.korean = korean;
  }

  public int getEnglish() {
    return english;
  }

  public void setEnglish(int english) {
    this.english = english;
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    this.math = math;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal() {
    this.total = this.korean + this.english + this.math;
  }

  public double getAverage() {
    return average;
  }

  public void setAverage() {
    double avg = Math.round((this.total / 3) * 100) / 100.0;
    this.average = avg;
  }

  public String getGrade() {
    return grade;
  }

  public void setGrade() {
    double average = this.average;
    if (average >= 90) {
      this.grade = "A";
    } else if (average >= 80) {
      this.grade = "B";
    } else if (average >= 70) {
      this.grade = "C";
    } else if (average >= 60) {
      this.grade = "D";
    } else {
      this.grade = "F";
    }
  }

  @Override
  public String toString() {
    return stuName + "\t" + korean + "\t" + english + "\t" + math + "\t" + total + "\t" + average
        + "\t" + grade;
  }

  public void cal() {
    setTotal();
    setAverage();
    setGrade();
  }
}
