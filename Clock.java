import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;  //used for formatting of date and time
import java.util.Calendar;  //provides classes for working with date and time
public class Clock extends JFrame {
    //Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;
    Clock(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //to close the window when pressed on "X"
        this.setTitle("CLOCK");
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setSize(350,210);
        this.setResizable(false);   //user cannot resize the clock window

        //refer https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
        //for SimpleDateFormat
        timeFormat= new SimpleDateFormat("hh:mm:ss a");
        dayFormat= new SimpleDateFormat("EEEE");
        dateFormat= new SimpleDateFormat("dd MMMMM yyyy");

        timeLabel= new JLabel();
        timeLabel.setFont(new Font("Verdana",Font.PLAIN,50));
        timeLabel.setForeground(new Color(0xAAF0D1));
        timeLabel.setBackground(new Color(0x2D383A));
        timeLabel.setOpaque(true);  //necessary for bg color

        dayLabel= new JLabel();
        dayLabel.setFont(new Font("Times New Roman",Font.BOLD,50));
        dayLabel.setForeground(new Color(0x2D383A));
        dayLabel.setBackground(new Color(0xAAF0D1));
        dayLabel.setOpaque(true);   //necessary for bg color
        dayLabel.setPreferredSize(new Dimension(this.getWidth(),45));

        dateLabel= new JLabel();
        dateLabel.setFont(new Font("Verdana",Font.PLAIN,30));
        dateLabel.setForeground(new Color(0xAAF0D1));
        dateLabel.setBackground(new Color(0x2D383A));
        dateLabel.setOpaque(true);  //necessary for bg color
        dateLabel.setPreferredSize(new Dimension(this.getWidth(), 45));

        //setting all Labels to CENTER
        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        dayLabel.setHorizontalAlignment(JLabel.CENTER);
        dateLabel.setHorizontalAlignment(JLabel.CENTER);

        //add all components to the window
        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);  //makes CLOCK window visible
        updateTime();
    }
    public void updateTime(){
        while(true) {   //infinite loop to update the clock time every second
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
        }
    }
}