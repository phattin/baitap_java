import java.util.Scanner;
import java.util.Vector;

class Date{
    protected int day;
    protected int year;
    protected int month;
    public Date(){
        day = 0;
        month = 0;
        year = 0;
    }
    public Date(int day, int year, int month){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setDate(int day, int year, int month){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public void setDay(int day){
        this.day = day;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getDay(){
        return day;
    }
    public int getMonth(){
        return month;
    }
    public int getYear(){
        return year;
    }
    public void display(){
        System.out.printf("%d/%d/%d\n",day,month,year);
    }
}
class EnhancedDate extends Date{
    public EnhancedDate() {
        super();
    }
    public EnhancedDate(int day, int month, int year) {
        super(day, month, year);
    }
    public boolean isLeapYear(){
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    public boolean isValidDate(){
        if(year < 1 || year > 9999)
            return false;
        if(month < 1 || month > 12)
            return false;
        int daysInMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(day >= 1 && day <= daysInMonth[month-1] && month!=2)
            return true;
        if (month == 2) {
            if (isLeapYear())
                return day >= 1 && day <= 29;
            else
                return day >= 1 && day <= 28;
        }
        return false; 
    }
    public Date prevDate(){
        int d,m,y;
        d = day-1;
        m = month;
        y = year;
        if(d < 1){
            m--;
            if(m < 1){
                y--;
                m = 12;
            }
            int daysInMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
            if(m == 2 && isLeapYear())
                d = 29;
            else if(m == 2 && !isLeapYear())
                d = 28;
            else 
                d = daysInMonth[m-1];
        }
        return new Date(d,m,y);
    }
    public Date nextDate(){
        int d,m,y;
        d = day+1;
        m = month;
        y = year;
        int daysInMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(d > daysInMonth[m-1]){
            m++;
            d=1;
            if(m > 12){
                y++;
                m = 1;
            }
        }
        return new EnhancedDate(d,m,y);
    }
    public int compareTo(Date d){
        if(this.year < d.getYear())
            return -1;
        else if(this.year > d.getYear())
            return 1;
        else {
            if(this.month < d.getMonth())
                return -1;
            else if(this.month > d.getMonth())
                return 1;
            else {
                if(this.day < d.getDay())
                    return -1;
                else if(this.day > d.getDay())
                    return 1;
                else 
                    return 0;
            }
        }
    }
}
public class bai1_10 {
    public static void main(String[] args) {
        Vector<Date> dateList = new Vector<>();
        
    }
}
