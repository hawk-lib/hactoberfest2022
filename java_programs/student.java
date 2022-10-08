package OOPS.interfaces;

public class student {

    int credits;
String name;
String course;

      student(){
        this.credits=180;
        this.name="rohit";
        this.course="dsa";

    }


     student(int credits,String name,String course){
        this.credits=credits;
        this.name=name;
        this.course=course;

     
    }

    void printcourse(){
     
    
    
    }
    
    public static void main(String[] args){

     String[] course= {"dsa","dms","gtla","rty","tyyu"};
     for(int i=0;i<course.length;i++){

        System.out.println(course[i]);
     }

      student c = new student(22,"ers","dsa");
      System.out.println(c.credits+ " "+ c.name+" "+ c.course);

     
    }
}
